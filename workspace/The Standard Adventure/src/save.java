
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class save {
	public static String path = System.getProperty("user.dir") + "\\save.txt";
	
	public static void writeToFile() throws IOException {
		File file = new File("filename.txt");
		File file2 = new File("stringfilename.txt");
		File yourMeleeSave = new File("yourMeleeSave.txt");
		File yourRangedSave = new File ("yourRangedSave.txt");
		File yourArmorSave = new File ("yourArmorSave.txt");
		File inv = new File ("inv.txt");
		
		
		//Delete old file
		file.delete();
		file2.delete();
		yourMeleeSave.delete();
		yourRangedSave.delete();
		yourArmorSave.delete();
		inv.delete();
		
		//Create new file
		PrintWriter out = new PrintWriter("filename.txt");
		PrintWriter out2 = new PrintWriter("stringfilename.txt");
		PrintWriter out3 = new PrintWriter("yourMeleeSave.txt");
		PrintWriter out4 = new PrintWriter("yourRangedSave.txt");
		PrintWriter out5 = new PrintWriter("yourArmorSave.txt");
		PrintWriter out6 = new PrintWriter("inv.txt");
		
		
		//Save int stats
		out.println(Main.attackPower);
		out.println(Main.health);
		out.println(Main.magicPower);
		out.println(Main.defensePower);
		out.println(Main.rangePower);
		out.println(Main.totalHealth);
		out.println(Main.baseAttackPower);
		out.println(Main.baseDefensePower);
		out.println(Main.baseRangePower);
		out.println(Main.baseMagicPower);
		out.println(Main.lvl);
		out.println(Main.eleMeleeDmg);
		out.println(Main.eleRangeDmg);
		
		out.println(Main.stat[0]);
		out.println(Main.stat[1]);
		out.println(Main.stat[2]);
		out.println(Main.stat[3]);
		out.println(Main.stat[4]);
		out.println(Main.stat[5]);
		out.println(Main.stat[6]);
		out.println(Main.stat[7]);
		out.println(Main.stat[8]);
		out.println(Main.stat[9]);
		out.println(Main.stat[10]);
		out.println(Main.stat[11]);
		out.println(Main.stat[12]);
		out.println(Main.stat[13]);
		out.println(Main.stat[14]);
		out.println(Main.stat[15]);
		out.println(Main.stat[16]);
		out.close();
		
		
		//save string stats
		out2.print(Main.playerClass);
		out2.print("%");
		out2.print(Main.playerRace);
		out2.print("%");
		out2.print(Main.currentWeaponRanged);
		out2.print("%");
		out2.print(Main.currentWeaponMelee);
		out2.print("%");
		out2.print(Main.currentArmor);
		out2.print("%");
		out2.print(Main.eleMelee);
		out2.print("%");
		out2.print(Main.eleRanged);
		out2.close();
		
		
		
		//save yourMelee
		out3.print(Main.yourMelee.get(0));
		for (int i = 1; i < Main.yourMelee.size(); i++){
			String x = Main.yourMelee.get(i);
			out3.print("%");
			out3.print(x);
		}
		out3.close();
		
		
		//save yourRanged
		out4.print(Main.yourRanged.get(0));
		for (int i = 1; i < Main.yourRanged.size(); i++){
			String x = Main.yourRanged.get(i);
			out4.print("%");
			out4.print(x);
			
		}
		out4.close();
		
		
		//save yourArmor
		out5.print(Main.yourArmor.get(0));
		for (int i = 1; i < Main.yourArmor.size(); i++){
			String x = Main.yourArmor.get(i);
			out5.print("%");
			out5.print(x);
		}
		out5.close();
		
		
		
		//save inv
		out6.print(Main.inv[0]);
		out6.print("%");
		out6.print(Main.inv[1]);
		out6.print("%");
		out6.print(Main.inv[2]);
		out6.close();
		
	}
	
	public static void load() throws IOException{
		Scanner scan = new Scanner(System.in);
		try {
		Scanner scanner = new Scanner(new File("filename.txt"));
		
		int [] tall = new int [30];
		int i = 0;
		while(scanner.hasNextInt())
		{
		     tall[i++] = scanner.nextInt();
		}
		//System.out.println(Arrays.toString(tall));
		
		//load the numbers
		Main.attackPower = tall[0];
		Main.health = tall[1];
		Main.magicPower = tall[2];
		Main.defensePower = tall[3];
		Main.rangePower = tall[4];
		Main.totalHealth = tall[5];
		Main.baseAttackPower = tall[6];
		Main.baseDefensePower = tall[7];
		Main.baseRangePower = tall[8];
		Main.baseMagicPower = tall[9];
		Main.lvl = tall[10];
		Main.eleMeleeDmg = tall[11];
		Main.eleRangeDmg = tall[12];
		
		//load into stat array
		int p = 0;
		for (int q = 13; q < tall.length; q++){
			Main.stat[p] = tall[q];
			p++;
		}
		

		
		BufferedReader br = new BufferedReader(new FileReader("stringfilename.txt"));
		StringBuilder sb = new StringBuilder();
		try {
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            sb.append("%");
	            line = br.readLine();
	        }

	        
	    } finally {
	        br.close();
	    }
	
		//String stats load
		Main.playerClass = sb.substring(0, sb.indexOf("%"));
		String txt = sb.substring(sb.indexOf("%") + 1);
		Main.playerRace = txt.substring(0, txt.indexOf("%"));
		txt = txt.substring(txt.indexOf("%") + 1);
		Main.currentWeaponRanged = txt.substring(0, txt.indexOf("%"));
		txt = txt.substring(txt.indexOf("%") + 1);
		Main.currentWeaponMelee = txt.substring(0, txt.indexOf("%"));		
		txt = txt.substring(txt.indexOf("%") + 1);
		Main.currentArmor = txt.substring(0, txt.indexOf("%"));		
		txt = txt.substring(txt.indexOf("%") + 1);
		Main.eleMelee = txt.substring(0, txt.indexOf("%"));		
		txt = txt.substring(txt.indexOf("%") + 1);
		Main.eleRanged = txt.substring(0, txt.indexOf("%"));
		

		
		//scan melee file
		BufferedReader mr = new BufferedReader(new FileReader("yourMeleeSave.txt"));
		StringBuilder ml = new StringBuilder();
		try {
	        String line = mr.readLine();
	        while (line != null) {
	            ml.append(line);
	            ml.append("%");
	            line = mr.readLine();
	        }

	        
	    } finally {
	        mr.close();
	    }
		
		//yourMelee Load
		String x = ml.toString();
		for (int q = 1; q < x.length(); q++){
			Main.yourMelee.add(x.substring(0, x.indexOf("%")));
			try{
				x = x.substring(x.indexOf("%") + 1);
			} finally {
				
			}
		}
		//scan ranged file
		BufferedReader rr = new BufferedReader(new FileReader("yourRangedSave.txt"));
		StringBuilder rl = new StringBuilder();
		try {
	        String line = rr.readLine();
	        while (line != null) {
	            rl.append(line);
	            rl.append("%");
	            line = rr.readLine();
	        }

	        
	    } finally {
	        rr.close();
	    }
		
		//yourRanged Load
				String z = rl.toString();
				for (int q = 1; q < z.length(); q++){
					Main.yourRanged.add(z.substring(0, z.indexOf("%")));
					try{
						z = z.substring(z.indexOf("%") + 1);
					} finally {
						
					}
				}
		
				
				//scan armor file
				BufferedReader ar = new BufferedReader(new FileReader("yourArmorSave.txt"));
				StringBuilder al = new StringBuilder();
				try {
			        String line = ar.readLine();
			        while (line != null) {
			            al.append(line);
			            al.append("%");
			            line = ar.readLine();
			        }

			        
			    } finally {
			        ar.close();
			    }
					
				//yourArmor Load
				String y = al.toString();
				for (int q = 1; q < y.length(); q++){
					Main.yourArmor.add(y.substring(0, y.indexOf("%")));
					try{
						y = y.substring(y.indexOf("%") + 1);
					} finally {
						
					}
				}
				
				
		//load inv
				BufferedReader inv = new BufferedReader(new FileReader("inv.txt"));
				StringBuilder invv = new StringBuilder();
				try {
			        String line = inv.readLine();
			        while (line != null) {
			            invv.append(line);
			            invv.append("%");
			            line = inv.readLine();
			        }

			        
			    } finally {
			        br.close();
			    }
				
				Main.inv[0] = invv.substring(0, invv.indexOf("%"));
				String txt1 = invv.substring(invv.indexOf("%") + 1);
				Main.inv[1] = txt1.substring(0, txt1.indexOf("%"));
				txt1 = txt1.substring(txt1.indexOf("%") + 1);
				Main.inv[2] = txt1.substring(0, txt1.indexOf("%"));
				
				Main.townSelect();
				
		} catch (FileNotFoundException e){
			System.out.println("There is no previous data.");
			String input = scan.nextLine().toLowerCase();
			while(true){
			      System.out.println("Would you like the tutorial on how to play? (y/n)");
			      input = scan.nextLine().toLowerCase();
			      if (input.equals("y")){
			    	  Story.tutorial();
			      } else if (input.equals("n")){
			    	  Main.selectClass();
			    	  break;
			      } else {
			    	  System.out.println("Please try entering someting else.");
			      }
			      }
		}

	}
}
