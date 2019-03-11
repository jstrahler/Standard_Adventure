import java.util.Scanner;


public class Cheats_Dev_Items {
	
	public static void nightt_fury(){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		@SuppressWarnings("unused")
		String input = "";
		Main.stat[1] = 1000000;
		Main.baseAttackPower = 10000;
		Main.baseDefensePower = 10000;
		Main.yourMelee.add("Lightning");
		Main.totalHealth += 10000;
		Main.stat[4] = 50;
		Main.stat[5] = 50;
		Main.stat[8] = 10000;
		Main.stat[10] = 1;
		Main.rangePower = 10000;
		Main.magicPower = 10000;
		Main.lvl += 30;
    	//System.out.println("You put on the armor of the night fury and wield the blade of one. You can feel the power of the offspring of lightning and earth itself course through your viens.");
    	input = scan.nextLine().toLowerCase();
    	Main.levelCheck();
    	Main.ceruleanCity();
	}
	
	public static void dev(){
		Main.yourMelee.add("No Melee");
	    Main.yourRanged.add("No Ranged");
	    Main.yourArmor.add("No Armor");
		Main.attackPower = 10;
		Main.health = 35;
		Main.defensePower = 10;
		Main.magicPower = 10;
		Main.rangePower = 10;
		Main.playerClass = "rogue";
		Main.health += 20;
		Main.attackPower += 20;
		Main.defensePower += 20;
		Main.magicPower += 20;
		Main.rangePower += 20;
		Main.playerRace = "dragonic";
		Main.totalHealth = Main.health;
		Main.baseAttackPower = Main.attackPower;
		Main.baseDefensePower = Main.defensePower;
		Main.baseRangePower = Main.rangePower;
		Main.baseMagicPower = Main.magicPower;
		Main.attackPower = 0;
		Main.defensePower = 0;
		Main.rangePower = 0;
		Main.magicPower = 0;
		Main.stat[0] = 1;	 	//stat[0] asgard unlock
		Main.stat[1] = 100;		//stat[1] gold
		Main.stat[2] = 0;		//stat[2] attack
		Main.stat[3] = 0;		//stat[3] armor
		Main.stat[4] = 0;		//stat[4] normal potion
		Main.stat[5] = 0;		//stat[5] regen potion
		Main.stat[6] = 0;		//stat[6] pedastol stone (1 = on, 0 = off)
		Main.stat[7] = 0;		//stat[7] pedistool staff (1 = on, 0 = off)
		Main.stat[8] = 0;		//stat[8] EXP
		Main.stat[9] = 0;		//stat[9] toggle volcano boss
		Main.stat[10] = 0;		//stat[10] OP ability active
		Main.stat[11] = 0;		//stat[11] summoned summit boss
		Main.stat[12] = 0;		//stat[12] toggle summit boss
		Main.stat[13] = 1;		//stat[13] summoning count
		Main.stat[14] = 1;		//stat[14] arena count
		Main.stat[15] = 0;		//stat[15] current town
		Main.stat[16] = 5;		//stat[16] bossCounter
		
		Main.inv[0] = "";		//inv[0] stick
		Main.inv[1] = "";		//inv[1] stone
		Main.inv[2] = "";		//inv[2] book
		nightt_fury();
	}
}
