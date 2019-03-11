import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class fightSequence {
	
	public static int humanAttack;
	public static String weakness;
	
	/**
	 * @param enemy
	 * @param weak
	 * @return
	 */
	public static int [] fight(int enemy[], String weak){
		//the enemy input goes as following
		 //enemy[0]   health
		 //enemy[1]   attack
		 //enemy[2]   level
		 //weakness
		 Scanner scan = new Scanner(System.in);
		 Random rand = new Random();
		 int out = 1;
		 int used = 1;
		 int comAttack;
		 weakness = weak;
		 System.out.println("You ready yourself for a fight.");
		 
		 while (out == 1){
			 int outhuman = 1;
			 	System.out.println("You have " + Main.health + " / " + Main.totalHealth + " health.");
			 	System.out.println("The enemy has " + enemy[0] + " health.");
			 	System.out.println("");
			 	while (outhuman == 1){
			 		//Human Turn
			 		System.out.println("What would you like to do?");
			 		System.out.println(" -------------------------");
			 		System.out.println("|  Attack    Heal    Run  |");
			 		if (Main.stat[10] == 1){
			 			System.out.println("|        Overpower        |");
			 		}
			 		System.out.println(" -------------------------");
			 		String input = scan.nextLine().toLowerCase();
			 		if (input.equals("attack")){
			 			humanAttack = attacks();
			 			System.out.println("");
			 			//base attack
			 			System.out.println("You did " + humanAttack + " damage.");
			 			int eleDmg = elemental();
			 			//elemental damage
			 			System.out.println("You did " + eleDmg + " elemental damage.");
			 			humanAttack += eleDmg;
			 			enemy[0] -= humanAttack;
			 			outhuman = 0;
		 
			 			if (enemy[0] <= 0){
			 				return (Main.stat);
			 			} 
		 
			 		} else if (input.equals("heal") && (Main.stat[4] > 0 || Main.stat[5] > 0)){
			 			int outpotion = 1;
			 			while (outpotion == 1){
			 				System.out.println("Which one do you want to use?");
			 				System.out.println(" ------------------------------------");
			 				System.out.println("| Normal Potion    Quantity: " + Main.stat[4]);
			 				System.out.println("| Regen Potion     Quantity: " + Main.stat[5]);
			 				System.out.println(" ------------------------------------");
			 				System.out.println("Leave");
			 				input = scan.nextLine().toLowerCase();
			 				if (input.equals("normal potion") && Main.stat[4] > 0){
			 					if ((Main.health + 50) >= Main.totalHealth){
			 						Main.health = Main.totalHealth;
			 						Main.stat[4] -= 1;
			 						outpotion = 0;
			 						outhuman = 0;
			 					} else {
			 						Main.health += 50;
			 						Main.stat[4] -= 1;
			 						outpotion = 0;
			 						outhuman = 0;
			 					}
			 				} else if (input.equals("regen potion") && Main.stat[5] > 0){
			 					Main.health = Main.totalHealth;
			 					Main.stat[5] -= 1;
			 					outpotion = 0;
			 					outhuman = 0;
			 				} else if (input.equals("leave")){
			 					outpotion = 0;
		 
			 				} else {
			 					System.out.println("Please try inputting something else.");
			 				}
			 			}
			 			//Cant frun from bosses
			 		} else if (input.equals("run")){
			 			if (enemy[2] == 10){
			 				System.out.println("The demon puts up a magical barrier behind you, preventing you from escaping.");
			 				outhuman = 0;
			 			} else if (enemy[2] == 15) {
			 				System.out.println("The tree spirit puts up a magical barrier behind you, preventing you from escaping.");
			 				outhuman = 0;
			 			} else if(enemy[2] == 9999) {
			 				System.out.println("The Guardian puts up a magical barrier around the battle, preventing you from escaping.");
			 				outhuman = 0;
			 			} else if (enemy[2] >= 10){
			 				System.out.println("There is a magical barrier preventing you from escaping.");
			 				break;
			 			} else {
			 				System.out.println("You run away.");
			 				Main.townSelect();
			 			}
			 			//unlockable stat
			 		} else if (input.equals("overpower") && Main.stat[10] == 1 && used == 1){
			 			System.out.println("You feel the knowledge coming forth and you lash out in a powerful attack.");
			 			System.out.println("Everything you have learned and trained comes forth in an undodgeable attack.");
			 			used--;
			 			humanAttack = ((Main.baseAttackPower + Main.attackPower + Main.baseMagicPower + Main.magicPower + Main.baseRangePower + Main.rangePower) * 2);
			 			enemy[0] -= humanAttack;
			 			System.out.println("You did " + humanAttack + " damage.");
			 			if (enemy[0] <= 0){
			 				return (Main.stat);
			 			} 
			 		} else if(input.equals("suicide")){
			 			Main.health = 0;
			 			outhuman = 0;
			 		} else {
			 			System.out.println("");
			 			System.out.println("Please try inputting something else."); 
			 			System.out.println("");
			 		}
			 	} 
			 	//Monster Turn
			 	comAttack = rand.nextInt((enemy[1]) + 1) + 0;
			 	comAttack -= (int)((Main.defensePower + Main.baseDefensePower) * .4);
		 
			 	if (comAttack > 0){
			 		Main.health -= comAttack;
			 	} else {
			 		comAttack = 0;
			 	}
			 	System.out.println("The monster did " + comAttack + " damage.");
			 	System.out.println("");
			 	if (Main.health <= 0 && enemy[2] != 43123){
			 		System.out.println("You have died....");
			 		System.out.println("You lose half of your gold and only get 50% of your health back.");
			 		Main.health = (Main.totalHealth/2);
			 		Main.stat[1] /= 2;
			 		Main.townSelect();
			 	} else if ((Main.health <= 0) &&  enemy[2] == 43123){
			 		System.out.println("You have fallen when it all counted...");
			 		System.out.println("The world has been consumed in water. Life is gone.");
			 		String input = scan.nextLine().toLowerCase();
			 		System.out.println("Loading last save...");
			 		try {
						save.load();
					} catch (IOException e) {
						e.printStackTrace();
					}
			 		Main.asgard();
			 	}
		 	} 
	   
		 return (Main.stat);
	}
	
	 /**
	 * @return
	 */
	public static int attacks(){
		 Scanner scan = new Scanner(System.in);
		 Random rand = new Random();
		 String input = "";
		 int dmg = 0;
		 int chance = 0;
		 System.out.println("");
		 if (Main.playerClass.equals("warrior")){
			 //WARRIOR
			 while (true){
				 System.out.println("Choose an attack.");
				 System.out.println(" ----------------");
				 System.out.println("|  stab   lunge  |");
				 System.out.println("|                |");
				 System.out.println("| counter  leap  |");
				 System.out.println(" ----------------");
				 input = scan.nextLine().toLowerCase();
				 if (input.equals("stab")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) * .8);
					 chance = 8;
					 break;
				 } else if (input.equals("lunge")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) * .6);
					 chance = 12;
					 break;
				 } else if (input.equals("counter")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) * .4);
					 chance = 10;
					 break;
				 }else if (input.equals("leap")){
					 chance = 5;
					 dmg = (int)((Main.attackPower + Main.baseAttackPower));
					 break;
				 } else {
					 System.out.println("Please try inputting something else.");
					 System.out.println("");
				 }
			 }
		 } else if (Main.playerClass.equals("archer")){
			 //ARCHER
			 while (true){
				 System.out.println("Choose an attack.");
				 System.out.println(" ------------------------");
				 System.out.println("|  quick shot    stab    |");
				 System.out.println("|                        |");
				 System.out.println("|  tri shot   flame shot |");
				 System.out.println(" ------------------------");
				 input = scan.nextLine().toLowerCase();
				 if (input.equals("quick shot")){
					 dmg = (int)((Main.rangePower + Main.baseRangePower) * .6);
					 chance = 10;
					 break;
				 } else if (input.equals("stab")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) * .3);
					 chance = 15;
					 break;
				 } else if (input.equals("tri shot")){
					 dmg = (int)((Main.rangePower + Main.baseRangePower));
					 chance = 7;
					 break;
				 }else if (input.equals("flame shot")){
					 chance = 5;
					 dmg = (int)((((Main.rangePower + Main.baseRangePower)) + (Main.baseMagicPower + Main.magicPower)));
					 break;
				 } else {
					 System.out.println("Please try inputting something else.");
					 System.out.println("");
				 }
			 }
		 } else if (Main.playerClass.equals("mage")){
			 //MAGE
			 while (true){
				 System.out.println("Choose an attack.");
				 System.out.println(" ------------------------");
				 System.out.println("|     fire       stab    |");
				 System.out.println("|                        |");
				 System.out.println("|  lightning   star fall |");
				 System.out.println(" ------------------------");
				 input = scan.nextLine().toLowerCase();
				 if (input.equals("fire")){
					 dmg = (int)((Main.magicPower + Main.baseMagicPower) * .8);
					 chance = 10;
					 break;
				 } else if (input.equals("stab")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) * .3);
					 chance = 13;
					 break;
				 } else if (input.equals("lightning")){
					 dmg = (int)((Main.magicPower + Main.baseMagicPower));
					 chance = 7;
					 break;
				 }else if (input.equals("star fall")){
					 chance = 5;
					 dmg = (int)((Main.baseMagicPower + Main.magicPower) * 1.5);
					 break;
				 } else {
					 System.out.println("Please try inputting something else.");
					 System.out.println("");
				 }
			 }
		 } else if (Main.playerClass.equals("rogue")){
			 //ROGUE
			 while (true){
				 System.out.println("Choose an attack.");
				 System.out.println(" -----------------------------");
				 System.out.println("| assassins blade     blitz   |");
				 System.out.println("|                             |");
				 System.out.println("|  night shift   silver slash |");
				 System.out.println(" -----------------------------");
				 input = scan.nextLine().toLowerCase();
				 if (input.equals("assassins blade") || input.equals("ass")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) * .8);
					 chance = 7;
					 break;
				 } else if (input.equals("blitz")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) + (Main.magicPower + Main.baseMagicPower) + (Main.baseRangePower + Main.rangePower));
					 chance = 50;
					 break;
				 } else if (input.equals("night shift") || input.equals("night")){
					 dmg = (int)((Main.attackPower + Main.baseAttackPower) + (Main.magicPower + Main.baseMagicPower));;
					 chance = 5;
					 break;
				 }else if (input.equals("silver slash") || input.equals("slash")){
					 chance = 3;
					 dmg = (int)((Main.baseAttackPower + Main.attackPower) * 1.5);
					 break;
				 } else {
					 System.out.println("Please try inputting something else.");
					 System.out.println("");
				 }
			 }
		 }
		 
		 if ((rand.nextInt(chance) + 0) == 0){
			 System.out.println("You missed your attack.");
		 	 return 0;
		 } else {
			 return rand.nextInt(dmg) + 1;
		 }
	 }
	 //Elemental Damage Calculator
	 /**
	 * @return
	 */
	public static int elemental(){
		 int dmg = 0;
		 if (weakness.equals(Main.eleMelee) || weakness.equals(Main.eleRanged)){
			 if (Main.playerClass.equals("warrior") || Main.playerClass.equals("rogue")){
				 dmg = Main.eleMeleeDmg;
			 } else if (Main.playerClass.equals("archer")){
				 dmg =  Main.eleRangeDmg;
			 }
		 } else {
			 if (Main.playerClass.equals("warrior") || Main.playerClass.equals("rogue")){
				 dmg = (int)(Main.eleMeleeDmg * .2);
			 } else if (Main.playerClass.equals("archer")){
				 dmg =  (int)(Main.eleRangeDmg * .2);
			 }
		 }
		 if (Main.eleMelee.equals("dragon")){
			 dmg = Main.eleMeleeDmg;
		 }
		 return dmg;
	 }

}