package scg.tournament;

import scg.Config;
import scg.game.GamePlayer;
import scg.tournament.Tournament;
import scg.exception.AddTournamentException;
import scg.net.PlayerSpec;
import scg.net.admin.RemotePlayerProxy;
import scg.tournament.TournamentSetup.Status;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import edu.neu.ccs.demeterf.lib.List;

public class TournamentManager implements Runnable {
	private static final String USER_STATE_FILE = "TournamentStates.dat";
	private volatile Hashtable<Integer, TournamentSetup> tournaments;
	private volatile int maxTournamentId;
	private volatile boolean running = false;
	private volatile boolean stopRequested = false;

	/**
	 * Constructor, initializes the touranament manager with no tournaments, then tries to load state
	 * information from disk.
	 */
	public TournamentManager() {
		// Try to read state of tournaments on disk
		maxTournamentId = 0;
		tournaments = new Hashtable<Integer, TournamentSetup>();
		loadTournamentState();
	}

	/**
	 * Run method simply spins every 5 seconds, checking all tournaments in the system to 
	 * see if their status needs to be updated.
	 * @see Runnable
	 * @see Thread
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			running = true;

			// Don't kill the thread while a stop is requested, wait...
			// But also when a stop is requested, stop doing the running stuff,
			// we're in shutdown mode...
			while (running) {
				while (!stopRequested) {
					// Lets see if any tournament states need to be updated.
					for (int tournamentId : tournaments.keySet()) {
						TournamentSetup.Status currentStatus = tournaments.get(
								tournamentId).getStatus();
						if (tournaments.get(tournamentId).updateStatus()) {
							System.out.println("Tournament " + tournamentId + " status changed from "
											+ currentStatus + " to " + tournaments.get(tournamentId).getStatus());
							
							saveTournamentState();
						}
					}

					// Sleep for a minute
					Thread.sleep(5000);
				}
				Thread.sleep(5000);
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
			running = false;
		}
	}

	/**
	 * Add a new tournament to the system given a name, runtime, and config string.
	 * @param name The name of the tournament to create
	 * @param config The config string for the tournament
	 * @param runTime The Date the tournament should start
	 * @return The newly created tournament id
	 * @throws AddTournamentException
	 * @throws scg.ParseException
	 */
	public synchronized int addTournament(String name, String config, Date runTime) 
	        throws AddTournamentException, scg.ParseException {
		Config cfg = Config.parse(config);
		return addTournament(name, cfg, runTime);
	}

	/**
	 * Add a new tournament to the system given a name, runtime, and config object.
	 * @param name The name of the tournament to create
	 * @param config The fully parsed configuration file object
	 * @param runTime The Date the tournament should start
	 * @return The newly created tournament id
	 * @throws AddTournamentException
	 */
	public synchronized int addTournament(String name, Config config, Date runTime)
	        throws AddTournamentException {
		System.out.format(
				"Addding a new tournament - Name: %s (%s) running at %s\n",
				name, config.getScgCfg().getDomain(), DateFormat
						.getDateTimeInstance().format(runTime));
		tournaments.put((maxTournamentId + 1), new TournamentSetup(
				(maxTournamentId + 1), name, config, runTime,
				new Hashtable<String, String>()));
		maxTournamentId++;
		System.out.println("Tournament " + name + " added as id "
				+ maxTournamentId);
		saveTournamentState();
		return maxTournamentId;
	}
	
	/**
	 * Used to set the runtime of a given tournament, can be used by update methods
	 * to change the runtime of a tournament that has already been created.  Should
	 * be deprecated in the future and moved to an updateTournament method.
	 * @param tournamentId The id of the tournament to update the runtime of
	 * @param runTime The new start time for the tournament
	 */
	public synchronized void setTournamentRuntime(int tournamentId, Date runTime){
		tournaments.get(tournamentId).setRunTime(runTime);
	}

	/**
	 * Delete a tournament from the system entirely, this erases the tournament
	 * from save state files as well.
	 * @param tournamentId
	 * @return True if the tournament was successfully deleted.
	 */
	public synchronized boolean deleteTournament(int tournamentId) {
		if (!tournaments.containsKey(tournamentId)) {
			System.err
					.println("Tried to delete a tournament that doesn't exist - "
							+ tournamentId);
			return false;
		}

		if (tournaments.get(tournamentId).getStatus() != Status.RUNNING) {

			tournaments.remove(tournamentId);
			saveTournamentState();
			return true;
		}

		System.err
				.println("Tried to delete a tournament that was running");

		return false;
	}

	/**
	 * Enroll a player in a tournament with the given username and password
	 * @param tournamentId Tournament to enroll in
	 * @param name 
	 * @param password 
	 * @return True if the player was successfully enrolled.
	 */
	public synchronized boolean enrollPlayer(int tournamentId, String name,
			String password) {
		if (!tournaments.containsKey(tournamentId)) {
			System.err.println(tournamentId + " isn't a known tournament id");
			return false;
		} else {
			boolean result = tournaments.get(tournamentId).enrollPlayer(name,
					password);
			saveTournamentState();
			return result;
		}
	}

	/**
	 * Unenroll a player in a given tournament (if they are currently enrolled)
	 * @param tournamentId Tournament to unenroll from
	 * @param name User to unenroll
	 * @return True if the user was unenrolled from the system
	 */
	public synchronized boolean unEnrollPlayer(int tournamentId, String name) {
		if (!tournaments.containsKey(tournamentId)) {
			System.err.println(tournamentId + " isn't a known tournament id");
			return false;
		} else {
			boolean result = tournaments.get(tournamentId).unEnrollPlayer(name);
			saveTournamentState();
			return result;
		}
	}

	/**
	 * Method which saves out the current state of all tournaments to disk, so they can be
	 * re-instantiated should the system crash.
	 * 
	 * TournamentSetup objects get serialized to SerializedTournamentSetup objects in a list
	 * and then written to disk.
	 * @see Serializable
	 */
	private synchronized void saveTournamentState() {
		System.out.println("Saving tournament state...");
		ArrayList<SerializedTournamentSetup> states = new ArrayList<SerializedTournamentSetup>();
		for (int key : tournaments.keySet()) {
			TournamentSetup t = tournaments.get(key);
			states.add(t.getSerializedSetup());
		}

		OutputStream file = null;
		OutputStream buffer = null;
		ObjectOutput output = null;

		try {
			file = new FileOutputStream(USER_STATE_FILE);
			buffer = new BufferedOutputStream(file);
			output = new ObjectOutputStream(buffer);

			output.writeObject(states);

			System.out.println("Save successful");
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
			try {
				if (output != null) {
					output.close();
				}
				if (buffer != null) {
					buffer.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception ex) {
			}
		}

	}

	/**
	 * See if a serialized tournament state object exist on disk, and load that
	 * information back into the TournamentManager object.
	 * @see Serializable
	 */
	private synchronized void loadTournamentState() {
		System.out.println("Attempting to load tournament state...");
		InputStream file = null;
		InputStream buffer = null;
		ObjectInput input = null;

		try {
			file = new FileInputStream(USER_STATE_FILE);
			buffer = new BufferedInputStream(file);
			input = new ObjectInputStream(buffer);

			ArrayList<SerializedTournamentSetup> savedTournaments = (ArrayList<SerializedTournamentSetup>) input.readObject();

			for (SerializedTournamentSetup t : savedTournaments) {
				System.out.println("Loading tournament " + t.getName() + " ("
						+ t.getId() + ") into memory");
				TournamentSetup recreatedTournament = new TournamentSetup(
						t.getId(), t.getName(), t.getConfig(), t.getRunTime(),
						t.getPlayers(), t.getStatus(), t.getFinalTournamentScores());
				tournaments.put(t.getId(), recreatedTournament);
				maxTournamentId = (maxTournamentId < t.getId()) ? t.getId()
						: maxTournamentId;
			}
		} catch (FileNotFoundException fof) {
			System.out.println("No file to load tournament state from");
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (buffer != null) {
					buffer.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception ex) {
			}
		}

	}

	/**
	 * Print the current state of the system to System.out
	 */
	public synchronized void printState() {
		for (int key : tournaments.keySet()) {
			TournamentSetup t = tournaments.get(key);
			System.out.println("Tournament (" + key + ")");
			t.printState();
			System.out.println("");
		}
	}

	/**
	 * Given a tournament id, get that tournament from the tournaments list
	 * @param id ID of the tournament to return
	 * @return The TournamentSetup object with tournament data
	 */
	public synchronized TournamentSetup getTournament(int id) {
		return tournaments.get(id);
	}
	
	/**
	 * Given a tournament id, get the current status of the running tournament
	 * @param id ID of the tournament to return
	 * @return The TournamentStatus object with running tournament data
	 */
	public synchronized TournamentStatus getTournamentStatus(int id) {
		return tournaments.get(id).getTournament().getTournamentStatus();
	}

	/**
	 * Get the set of serializable tournament objects
	 * @return Set of serialized tournament objects
	 * @see Serializable
	 */
	public synchronized Set<SerializedTournamentSetup> getState() {
		Set<Entry<Integer, TournamentSetup>> entrys = tournaments.entrySet();
		Set<SerializedTournamentSetup> states = new HashSet<SerializedTournamentSetup>(
				entrys.size());
		for (Entry<Integer, TournamentSetup> e : entrys) {
			states.add(e.getValue().getSerializedSetup());
		}
		return states;
	}

	/**
	 * Stop the current TournamentManager thread
	 */
	public void stop() {
		stopRequested = true;

		running = false;
	}
}
