package scg.tournament;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import mmg.MMGConfig;

import persistentPG.PersistentClaim;
import persistentPG.PersistentPlayground;
import scg.logging.Logger;
import scg.net.PlayerSpec;
import scg.net.admin.RemotePlayerProxy;

import edu.neu.ccs.demeterf.lib.List;
import edu.neu.ccs.demeterf.lib.Set;
import scg.Claim;
import scg.Config;
import scg.ProtocolRequest;
import scg.game.ActiveGame;
import scg.game.BinaryGame;
import scg.game.GamePlayer;
import scg.history.HistoryFile;

public class Tournament implements Runnable, Serializable {

	int tournamentId;
	transient Config config;
	java.util.List<GamePlayer> gamePlayers;
	transient TournamentStatus tournamentStatus;
	List<PlayerStatus> playerStatusList;
	transient HistoryFile tournamentHistory = null;
	transient private static scg.logging.Logger log;
	transient private PersistentPlayground pg;
	
	Tournament(int tournamentId, Config config, java.util.List<GamePlayer> gamePlayers) {
		this.config = config;
		this.gamePlayers = gamePlayers;
		List<PlayerStatus> playerStatusList = getListOfPlayerStatus(gamePlayers);
		this.tournamentStatus = new TournamentStatus(playerStatusList, List.<ActiveGame>create());
		this.playerStatusList = playerStatusList;
		this.tournamentId = tournamentId;

	}
	
	private List<PlayerStatus> getListOfPlayerStatus(java.util.List<GamePlayer> gamePlayers) {
		List<PlayerStatus> playerStatus  = List.<PlayerStatus>create();
		for(Iterator<GamePlayer> it = gamePlayers.iterator(); it.hasNext();) {
			GamePlayer gamePlayer = it.next();
			playerStatus = playerStatus.append(new PlayerStatus(gamePlayer.getSpec().getName(), 0));
		}
		return playerStatus;
	}
	
	public TournamentStatus getTournamentStatus() {
		return this.tournamentStatus;
	}
	
	public void setHistoryFile(HistoryFile tournamentHistory){
		this.tournamentHistory = tournamentHistory;
	}
	
		
	public void run() {
		
		try {
			log = Logger.text(System.out, scg.Util.logFileName("TournamentException"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			log.error("IOException: " + e1.getMessage());
		}
		
		initPG();
	  	  
        for (int playerIndex1 = 0; playerIndex1 < gamePlayers.size(); playerIndex1++) {
            for (int playerIndex2 = playerIndex1 + 1; playerIndex2 < gamePlayers.size(); playerIndex2++) {
                try {
					startGame(tournamentHistory, gamePlayers.get(playerIndex1), playerStatusList.lookup(playerIndex1), gamePlayers.get(playerIndex2), playerStatusList.lookup(playerIndex2));
                }
                catch (Exception e) {
					e.printStackTrace();
					log.notify("Tournament IOException Game1: " + e.getMessage());
					log.notify("check the console: debug using stacktrace");
				}
                try
                {
					startGame(tournamentHistory, gamePlayers.get(playerIndex2), playerStatusList.lookup(playerIndex2), gamePlayers.get(playerIndex1), playerStatusList.lookup(playerIndex1));
				} 
                catch (Exception e) {
					e.printStackTrace();
					log.notify("Tournament IOException Game2: " + e.getMessage());
					log.notify("check the console: debug using stacktrace");
				}
            }
        }
        
        Outputwelfareclaims();
		System.out.print("Printing welfareclaim after tournament");
	}
	
    private void startGame(HistoryFile tournamentHistory, GamePlayer player1, PlayerStatus player1Status, GamePlayer player2, PlayerStatus player2Status) throws Exception{	
    	BinaryGame currentGame;

		currentGame = new BinaryGame(tournamentId, player1.getRemotePlayerProxy(), player2.getRemotePlayerProxy(), config, pg);    	
		
		tournamentStatus.getActiveGames().add(currentGame.getActiveGame());

		currentGame.start();
        //Karan/Haoran: Scoring fix after kick out.
        player1.getRemotePlayerProxy().setKicked(false);
        player2.getRemotePlayerProxy().setKicked(false);
        
        player1Status.setScore(player1.getRemotePlayerProxy().getPlayerScore());
        player2Status.setScore(player2.getRemotePlayerProxy().getPlayerScore());
        tournamentStatus.getActiveGames().remove(currentGame.getActiveGame()); 
        
        //load the saved pg to tournament object
        loadPG();
    }
        
    private void initPG(){
	  	 Boolean isPg = isPersistentPlayground();	
	  	 pg = null;
	  	 if(isPg){
	  		 loadPG();
	  		 if(pg==null){
	  			 	generatePersistentPlaygroundObject();
	  		 }else{
	  			if(!pg.checkPlayground(config)){
	  				pg = null;
	  			}
	  		}
	  	 }
    }
    
    private void generatePersistentPlaygroundObject(){
    		List<PersistentClaim> pc = List.<PersistentClaim> create();
			java.util.List<PlayerSpec> s = new ArrayList<PlayerSpec>();
			for(int i = 0; i <gamePlayers.size(); i++){
				s.add(getPlayerProxy(i).getSpec());
			}
			List<PlayerSpec> enrolledPlayers = List.<PlayerSpec> create(s);
			pg = new PersistentPlayground(config,enrolledPlayers,pc);
    }
    
    private RemotePlayerProxy getPlayerProxy(int i){
    	return gamePlayers.get(i).getRemotePlayerProxy();
    }
    
    private boolean isPersistentPlayground(){
    	return config.getScgCfg().getIsPersistentPlayground();
    }
    
    private synchronized void loadPG(){
		try{
			String persistentPlaygroundFileName = this.config.getScgCfg().getDomain().toString()+"PersistentPlayground.txt";
			File persistentPlaygroundFile = new File(persistentPlaygroundFileName);
			if (!persistentPlaygroundFile.exists()) {
			    persistentPlaygroundFile.createNewFile();
			}
			long size = persistentPlaygroundFile.length();
			if(size != 0){
			FileReader fr = new FileReader(persistentPlaygroundFile);
			System.out.print("parsing PersistentPlayground");
			pg = PersistentPlayground.parse(fr);
			}
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
    
	private void Outputwelfareclaims() {
		List<Claim> welfare = PersistentPlayground.getwelfareSet(pg);
		System.out.print("out put welfareclaims");
		try{
			String welfareclaims = this.config.getScgCfg().getDomain().toString()+"welfareclaim.txt"; 
			File welfareclaimsfile = new File(welfareclaims);
			
			FileWriter writer = new FileWriter(welfareclaimsfile);
			writer.write(welfare.toString());
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}