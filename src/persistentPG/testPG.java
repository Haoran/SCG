package persistentPG;

import java.io.FileReader;


import edu.neu.ccs.demeterf.lib.List;



public class testPG {

	public static void main(String[] argArr)throws Exception{
		
		//List<RefutationEvent> re = List.create();
		//System.out.println(re.toString());
		
		PersistentPlayground pp = PersistentPlayground.parse(new FileReader("PG.txt"));
		System.out.println(pp.toString());
		System.out.println(pp.enrolledPlayers.lookup(0).toString());
		System.out.println(pp.persistentClaims.lookup(0).toString());
		for(int i=0; i<pp.persistentClaims.length();i++){
			System.out.println(pp.persistentClaims.lookup(i).refutationEvents.length());
		}
		String filename = pp.getConfig().getScgCfg().getDomain().toString()+"PersistentPlayground.txt";
		System.out.println(filename);
	}
}
