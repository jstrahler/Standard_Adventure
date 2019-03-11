/*
Current Version      2.3.0
Changes:
-Beta Testing Build

AP Computer Science Final          By: Jason Strahler	

Playing this game will take a while to beat fully. 
*/

import java.io.*;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math; 
import java.util.Arrays;
import java.lang.String;

/**
 * @author Nightt Fury
 *
 */
class Main{
  
	//STAT VARIABLES
	public static int attackPower = 0;
	public static int baseAttackPower = 0;
	public static int health = 0;
	public static int totalHealth = 0;
	public static int magicPower = 0;
	public static int baseMagicPower = 0;
	public static int defensePower = 0;
	public static int baseDefensePower = 0;
	public static String playerClass = "";
	public static String playerRace = "";
	public static int rangePower = 0;
	public static int baseRangePower = 0;
	public static String currentWeaponRanged = "Bow";
	public static String currentWeaponMelee = "Sword";
	public static String currentArmor = "Nothing";
	public static int lvl = 1;
	public static String eleMelee = "normal";
	public static int eleMeleeDmg = 0;
	public static String eleRanged = "normal";
	public static int eleRangeDmg = 0;
	
	public static int stat [] = {0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0};
    //stat[0] asgard unlock
    //stat[1] gold
    //stat[2] attack
    //stat[3] armor
    //stat[4] normal potion
    //stat[5] regen potion
    //stat[6] pedastol stone (1 = on, 0 = off)
    //stat[7] pedistool staff (1 = on, 0 = off)
    //stat[8] EXP
    //stat[9] toggle volcano boss
    //stat[10] OP ability active
	//stat[11] summoned summit boss
	//stat[12] toggle summit boss
	//stat[13] summoning count
	//stat[14] arena count
	//stat[15] current town
	//stat[16] boss counter
	
	//Your Items
		public static ArrayList<String> yourMelee = new ArrayList<String>();
		public static ArrayList<String> yourRanged = new ArrayList<String>();
		public static ArrayList<String> yourArmor = new ArrayList<String>();
	
	//Melee Weapons
		public static String [] meleeWeaponsList = {"Steel Sword", "Excalibur", "The Compensator", "Abyssal Shard", "The Overhype", "Mace", "Zweihander", "Sabre", "Angurvadal", "Skofnung", "No Melee", "Sword", "Lightning"};
		public static int [] meleeWeaponsDmg = {20 , 30, 55, 100, 2, 25 , 35, 65, 130, 200, 5, 10, 100000};
		public static int [] meleeWeaponsPrice = {50, 200, 800, 1600, 10000, 150, 350, 1200, 2000, 3500, 0, 10, 10000000};
		public static String [] meleeWeaponsEle = {"normal", "light", "normal", "fire", "normal", "normal", "posion", "ice", "wind", "lightning", "normal", "normal", "dragon"};
		public static int [] meleeWeaponsEleDmg = {0, 5, 0, 10, 0, 0, 15, 15, 10, 30, 0, 0, 5000};
		
	//Ranged Weapons
		public static String [] rangedWeaponsList = {"Wooden Bow", "Long Bow", "Cross Bow", "Compound Bow", "Flail", "Ballista", "Recurve Bow", "Hand Canon", "Yew Bow", "Ash Bow", "No Ranged", "Bow"};
		public static int [] rangedWeaponsDmg = {20 , 30, 55, 100, 2, 45 , 55, 75, 60 , 85, 5, 10};
	  	public static int [] rangedWeaponPrice = {50, 200, 800, 1600, 10000, 450, 800, 1200, 700, 1400, 0, 10};
	  	public static String [] rangedWeaponsEle = {"normal", "light", "normal", "fire", "normal", "normal", "posion", "ice", "wind", "lightning", "normal", "normal"};
		public static int [] rangedWeaponsEleDmg = {0, 10, 0, 15, 0, 0, 20, 25, 30, 35, 0, 0};
		
	//Heavy Armor
	 	public static String [] heavyArmorList = {"Leather Armor", "Iron Armor", "Steel Armor", "Obsidian Plate", "Mithril Armor", "Runic Armor", "Dragon Bone Armor", "Lamellar", "Byrnie Armor", "Nothing", "Electro Armor"};	
	  	public static int [] heavyArmorDefense = {10 , 30, 60, 120, 40 , 70, 160, 80 , 200, 5, 400};
	  	public static int [] heavyArmorPrice = {150 , 500, 800, 1400, 650 , 950, 1800, 950 , 2100, 0, 100000};
	  
	//Light Armo
	  	public static String [] lightArmorList = {"Leather Armor", "Chain Mail", "Scale Armor", "Dragon Scale Armor", "Hardened Leather Armor", "Elven Armor", "Glass Armor", "Linen Armor", "Nothing"};
	  	public static int [] lightArmorDefense = {10 , 25, 40, 80, 15, 45, 100, 1, 5};
	  	public static int [] lightArmorPrice = {100 , 400, 650, 1000, 200 , 550, 1200, 10, 0};
	  
	//SHOP ITEMS AND PRICES AND DAMAGE
		
		//Cerulean City Forge
		
		public static String [] ceruleanCityMeleeWeapons = {meleeWeaponsList[0], meleeWeaponsList[1], meleeWeaponsList[2], meleeWeaponsList[3], meleeWeaponsList[4]};
	  	public static int [] ceruleanCityMeleeWeaponsPrice = {meleeWeaponsPrice[0], meleeWeaponsPrice[1], meleeWeaponsPrice[2], meleeWeaponsPrice[3], meleeWeaponsPrice[4]};
	  	public static int [] ceruleanCityMeleeWeaponsDmg = {meleeWeaponsDmg[0], meleeWeaponsDmg[1], meleeWeaponsDmg[2], meleeWeaponsDmg[3], meleeWeaponsDmg[4]};
	    public static String [] ceruleanCityRangedWeapons = {rangedWeaponsList[0], rangedWeaponsList[1], rangedWeaponsList[2], rangedWeaponsList[3], rangedWeaponsList[4]};
		public static int [] ceruleanCityRangedWeaponsPrice = {rangedWeaponPrice[0], rangedWeaponPrice[1], rangedWeaponPrice[2], rangedWeaponPrice[3], rangedWeaponPrice[4]};
		public static int [] ceruleanCityRangedWeaponsDmg = {rangedWeaponsDmg[0] , rangedWeaponsDmg[1], rangedWeaponsDmg[2], rangedWeaponsDmg[3], rangedWeaponsDmg[4]};
		public static String [] ceruleanCityHeavyArmor = {heavyArmorList[0], heavyArmorList[1], heavyArmorList[2], heavyArmorList[3]};
		public static int [] ceruleanCityHeavyArmorPrice = {heavyArmorPrice[0], heavyArmorPrice[1], heavyArmorPrice[2], heavyArmorPrice[3]};
		public static int [] ceruleanCityHeavyArmorDefense = {heavyArmorDefense[0], heavyArmorDefense[1], heavyArmorDefense[2], heavyArmorDefense[3]};
		public static String [] ceruleanCityLightArmor = {lightArmorList[0], lightArmorList[1], lightArmorList[2], lightArmorList[3]};
		public static int [] ceruleanCityLightArmorPrice = {lightArmorPrice[0], lightArmorPrice[1], lightArmorPrice[2], lightArmorPrice[3]};
		public static int [] ceruleanCityLightArmorDefense = {lightArmorDefense[0], lightArmorDefense[1], lightArmorDefense[2], lightArmorDefense[3]};
		
		
		//Winterfell Forge
		public static String [] winterfellMeleeWeapons = {meleeWeaponsList[5], meleeWeaponsList[6], meleeWeaponsList[7]};
		public static int [] winterfellMeleeWeaponsPrice = {meleeWeaponsPrice[5], meleeWeaponsPrice[6], meleeWeaponsPrice[7]};
		public static int [] winterfellMeleeWeaponsDmg = {meleeWeaponsDmg[5], meleeWeaponsDmg[6], meleeWeaponsDmg[7]};
		public static String [] winterfellRangedWeapons = {rangedWeaponsList[5], rangedWeaponsList[6], rangedWeaponsList[7]};
		public static int [] winterfellRangedWeaponsPrice = {rangedWeaponPrice[5], rangedWeaponPrice[6], rangedWeaponPrice[7]};
		public static int [] winterfellRangedWeaponsDmg = {rangedWeaponsDmg[5] , rangedWeaponsDmg[6], rangedWeaponsDmg[7]};
		public static String [] winterfellHeavyArmor = {heavyArmorList[4], heavyArmorList[5], heavyArmorList[6]};
		public static int [] winterfellHeavyArmorPrice = {heavyArmorPrice[4], heavyArmorPrice[5], heavyArmorPrice[6]};
		public static int [] winterfellHeavyArmorDefense = {heavyArmorDefense[4], heavyArmorDefense[5], heavyArmorDefense[6]};
		public static String [] winterfellLightArmor = {lightArmorList[4], lightArmorList[5], lightArmorList[6]};
		public static int [] winterfellLightArmorPrice = {lightArmorPrice[4], lightArmorPrice[5], lightArmorPrice[6]};
		public static int [] winterfellLightArmorDefense = {lightArmorDefense[4], lightArmorDefense[5], lightArmorDefense[6]};
		
		
		//Asgard Forge
		public static String [] asgardMeleeWeapons = {meleeWeaponsList[8], meleeWeaponsList[9]};
		public static int []asgardMeleeWeaponsPrice = {meleeWeaponsPrice[8], meleeWeaponsPrice[9]};
		public static int [] asgardMeleeWeaponsDmg = {meleeWeaponsDmg[8], meleeWeaponsDmg[9]};
		public static String [] asgardRangedWeapons = {rangedWeaponsList[8], rangedWeaponsList[9]};
		public static int [] asgardRangedWeaponsPrice = {rangedWeaponPrice[8], rangedWeaponPrice[9]};
		public static int [] asgardRangedWeaponsDmg = {rangedWeaponsDmg[8] , rangedWeaponsDmg[9]};
		public static String [] asgardHeavyArmor = {heavyArmorList[7], heavyArmorList[8]};
		public static int [] asgardHeavyArmorPrice = {heavyArmorPrice[7], heavyArmorPrice[8]};
		public static int [] asgardHeavyArmorDefense = {heavyArmorDefense[7], heavyArmorDefense[8]};
		public static String [] asgardLightArmor = {lightArmorList[7]};
		public static int [] asgardLightArmorPrice = {lightArmorPrice[7]};
		public static int [] asgardLightArmorDefense = {lightArmorDefense[7]};
	
	
	
		public static String [] inv = {"", "", ""};

 /**
 * @param str
 * @throws IOException
 */
public static void main (String str[]) throws IOException {
      Scanner scan = new Scanner(System.in);
      String pausevari = "";
      String input = "";
      start(pausevari);
      System.out.println("");
      System.out.println("To navigate around, just say the location you want to go.");
      System.out.println("To continue the text for things in this game just hit enter.");
      System.out.println("You will be promtped when you can enter your command.");
      System.out.println("Hit enter to continue");
      pausevari = scan.nextLine().toLowerCase();
      while(true){
      System.out.println("Would you like the tutorial on how to play? (y/n)");
      input = scan.nextLine().toLowerCase();
      if (input.equals("y")){
    	  Story.tutorial();
      } else if (input.equals("n")){
      selectClass();
      break;
      } else {
    	  System.out.println("Please try entering someting else.");
      }
      }
   }
   
 /**
 * @param pausevari
 * @throws IOException
 */
public static void start(String pausevari) throws IOException{
      Scanner scan = new Scanner(System.in);
      int out = 0;
      
      System.out.println("---------------------------------------");
      System.out.println("        The Standard Adventure         ");
      System.out.println("---------------------------------------");
      System.out.println("");
      System.out.println("");
      pausevari = scan.nextLine().toLowerCase();
      System.out.println("You will start out with a wooden sword and can buy new weapons at the forge.");
      System.out.println("You can also buy armor and potions to help with your health when fighting.");
      System.out.println("You can sleep at the inn for a small fee to regain all of your health.");
      pausevari = scan.nextLine().toLowerCase();
      System.out.println("Do you have a previous save? (y/n)?");
      while (out == 0){
      String ready = scan.nextLine().toLowerCase();
      if (ready.equals("n")){
         out = 1;
         return;
      } else if (ready.equals("y")){
         out = 0;
         try {
			save.load();
		} catch (FileNotFoundException e) {
			System.out.println("No save found");
			e.printStackTrace();
			return;
		}
         ceruleanCity();
      } else {
         System.out.println("Please put in a y for yes or a n for no.");
      }
      }
   }
   
 public static int[] ceruleanCity(){
      Scanner scan = new Scanner(System.in);
      Random rand = new Random();
      stat[15] = 0;
      String input = "";
 	 System.out.println("   Welcome to Cerulean City   ");
 	 System.out.println("------------------------------");
      System.out.println("You are in the center of Cerulean City. To view your stats just head to the board.");
      input = scan.nextLine().toLowerCase();
      System.out.println("Where would you like to go?");
      System.out.println("forge    woods    inn   house    stats   winterfell");
      input = scan.nextLine().toLowerCase();
      if (input.equals("woods")){
         System.out.println("You head into the woods.");
         input = scan.nextLine().toLowerCase();
         woods();
      }else if(input.equals("house")){
    	 System.out.println("You head to your house.");
    	 input = scan.nextLine();
    	 home();  
      }else if(input.equals("forge")){
         System.out.println("You head into the forge.");
         input = scan.nextLine().toLowerCase();
         System.out.println("Blacksmith: Eh, who's there? Just buy something and get out.");
         System.out.println("");
         ceruleanCityWeaponMenu();
      }else if(input.equals("winterfell")){   
         System.out.println("You hit the road to Winterfell.");
         road("Winterfell");
      }else if(input.equals("inn")){
         System.out.println("You head into the inn.");
         input = scan.nextLine().toLowerCase();
         inn();
         ceruleanCity();
      } else if (input.equals("guardian") && inv[2].equals("book")) {  
    	  System.out.println("The sky turned to red and the ground shaked.");
    	  System.out.println("A deep voiced boomed from the sky, \"WHO SUMMONS ME?\"");
    	  input = scan.nextLine().toLowerCase();
    	  System.out.println("A bright light appears in the sky and starts falling towards the ground.");
    	  System.out.println("It smashes the ground causing the ground to fissure.");
    	  input = scan.nextLine().toLowerCase();
    	  System.out.println("When the dust clears all that is left is a small white rabbit.");
    	  System.out.println("Confused, one of the towns people walks up to it.");
    	  input = scan.nextLine().toLowerCase();
    	  System.out.println("He is immediately ripped to shreds with body parts flying everywhere.");
    	  System.out.println("You ready yourself for battle.");
    	  input = scan.nextLine().toLowerCase();
    	  int [] enemy = {1500, 120, 9999};
    	  //enemy[0] = health
    	  //enemy[1] = attack
    	  //enemy[2] = level of monster
    	  fightSequence.fight(enemy, "fire");
    	  System.out.println("The Guardian fell with a loud scream.");
    	  System.out.println("As it fell you see it starting to glow, then all of a sudden it explodes.");
    	  input = scan.nextLine().toLowerCase();
    	  Story.story_Part2_Intro();
    	  try { 
	 Thread.sleep(5000); 
	 } catch(InterruptedException e) { 
	 } 
	 System.exit(0);
    	  
      } else if (input.equals("stats")){
    	  showStats();
    	  ceruleanCity();
      }else{
         System.out.println("Please try inputting something else.");
         ceruleanCity();
      }
   
  return(stat);
  }
  
 public static void home(){
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 while (true){
		 System.out.println("");
		 System.out.println("   Home   ");
		 System.out.println("----------");
		 System.out.println("\nWhat would you like to do?");
		 System.out.println("--------------------------------");
		 System.out.println("  Equip   Rest   Cerulean City    Save");
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("rest")){
			 System.out.println("You lay down for a nap after your long day.");
			 health = totalHealth;
			 input = scan.nextLine().toLowerCase();
			 home();
		 } else if (input.equals("equip")){
			 while (true){
				 System.out.println("");
				 System.out.println("Which would you like to view?");
				 System.out.println("-----------------------------");
				 System.out.println("   Weapons    Armor   Back   ");
				 System.out.println("-----------------------------");
				 input = scan.nextLine().toLowerCase();
				 if (input.equals("weapons")){
					 System.out.println("");
					 System.out.println("-----------");
					 System.out.println("   Melee   ");
					 System.out.println("-----------");
					 for (int i = 0; i < yourMelee.size(); i++){
						 System.out.println(yourMelee.get(i));
					 }
					 System.out.println("");
					 System.out.println("------------");
					 System.out.println("   Ranged   ");
					 System.out.println("------------");
					 for (int i = 0; i < yourRanged.size(); i++){
						 System.out.println(yourRanged.get(i));
					 }
					 System.out.println("");
					 System.out.println("Main House Menu:   Back");
					 
					 //Equiping an item
					 while (true){
						 System.out.println("");
						 System.out.println("Which would you like to equip?");
						 input = scan.nextLine().toLowerCase();
						 if (input.equals("back")){
							 home();
						 }
						 //equiping melee
						 for (int i = 0; i < yourMelee.size(); i++){
								if (yourMelee.get(i).toLowerCase().equals(input)){
										 yourMelee.add(currentWeaponMelee);
										 currentWeaponMelee = yourMelee.get(i);
										 yourMelee.remove(i);
										 for (int q = 0; q < meleeWeaponsList.length; q++){
											 if (currentWeaponMelee.equals(meleeWeaponsList[q])){
												 attackPower = meleeWeaponsDmg[q];
												 eleMelee = meleeWeaponsEle[q];
												 eleMeleeDmg = meleeWeaponsEleDmg[q];
												 System.out.println("");
												 System.out.println("You equiped " + currentWeaponMelee);
												 input = scan.nextLine();
												 home();
											 }
										 }
										 home();
										 break;
									 }else if (input.equals("back")){
									 home();
								 }
						 }
						 
						 //equiping ranged
						 for (int i = 0; i < yourRanged.size(); i++){
								if (yourRanged.get(i).toLowerCase().equals(input)){
									yourRanged.add(currentWeaponRanged);
										 currentWeaponRanged = yourRanged.get(i);
										 yourRanged.remove(i);
										 for (int q = 0; q < rangedWeaponsList.length; q++){
											 if (currentWeaponRanged.equals(rangedWeaponsList[q])){
												 rangePower = rangedWeaponsDmg[q];
												 eleRanged = rangedWeaponsEle[q];
												 eleRangeDmg = rangedWeaponsEleDmg[q];
												 System.out.println("");
												 System.out.println("You equiped " + currentWeaponRanged);
												 input = scan.nextLine();
												 home();
											 }
										 }
										 home();
										 break;
									 }else if (input.equals("back")){
									 home();
								 }
						 }
						System.out.println("Please enter something else.");
					} 
					 
				 } else if (input.equals("armor")){
					 System.out.println("");
					 System.out.println("-----------");
					 System.out.println("   Armor   ");
					 System.out.println("-----------");
					 for (int i = 0; i < yourArmor.size(); i++){
						 System.out.println(yourArmor.get(i));
					 }
					 System.out.println("");
					
					 System.out.println("");
					 System.out.println("Main House Menu:   Back");

					 //Equiping an item
					 while (true){
						 System.out.println("");
						 System.out.println("Which would you like to equip?");
						 input = scan.nextLine().toLowerCase();
						 if (input.equals("back")){
							 home();
						 }
						 //equiping armor heavy
						 for (int i = 0; i < yourArmor.size(); i++){
								if (yourArmor.get(i).toLowerCase().equals(input)){
										 yourArmor.add(currentArmor);
										 currentArmor = yourArmor.get(i);
										 yourArmor.remove(i);
										 for (int q = 0; q < heavyArmorList.length; q++){
											 if (currentArmor.equals(heavyArmorList[q])){
												 defensePower = heavyArmorDefense[q];
												 System.out.println("");
												 System.out.println("You equiped " + currentArmor);
												 input = scan.nextLine();
												 home();
											 }
										 }
										 //equiping armor light
										 for (int q = 0; q < lightArmorList.length; q++){
											 if (currentArmor.equals(lightArmorList[q])){
												 defensePower = lightArmorDefense[q];
												 System.out.println("");
												 System.out.println("You equiped " + currentArmor);
												 input = scan.nextLine();
												 home();
											 }
										 }
										 home();
										 break;
									 }else if (input.equals("back")){
									 home();
								 }
						 }
					} 
					 
				 } else {
					 System.out.println("Please enter something else.");
				 }
			 }
		 } else if (input.equals("cerulean city")){
			 System.out.println("you head back out into the world.");
			 System.out.println("");
			 input = scan.nextLine();
			 ceruleanCity();
			 
			 
		 } else if (input.equals("save")){
			 try {
				save.writeToFile();
			} catch (IOException e) {
				System.out.println("Error saving");
			}
			 input = scan.nextLine().toLowerCase();
			 home();
		 } else {
			 System.out.println("");
			 System.out.println("Please enter something else.");
		 }
	 } 
 }

 public static int[] woods(){
      Scanner scan = new Scanner(System.in);
      System.out.println("You head into a clearing.");
      String input = scan.nextLine().toLowerCase();
      System.out.println("Where would you like to go?");
      System.out.println("grass    cave     Cerulean City     big tree");
      input = scan.nextLine().toLowerCase();
      if (input.equals("grass")){
         System.out.println("You head into the tall grass.");
         grass();
      }else if(input.equals("cerulean city")){
         System.out.println("You head back into Cerulean City.");
         ceruleanCity();
      }else if(input.equals("big tree")){
         System.out.println("You head to the big tree.");
         tree();
      }else if(input.equals("cave")){
         System.out.println("You head into the cave.");
         cave();
      }else{
         System.out.println("Please try inputting something else.");
         woods();
      }
      
   return (stat);
   }
   
 public static void inn(){
   Scanner scan = new Scanner(System.in);
   String pausevari = "";
   int out = 0;
   System.out.println("Innkeeper: Welcome to the inn. Would you like a room for 20 gold to heal your wounds? (y/n)");
   while (out == 0){
      String ready = scan.nextLine().toLowerCase();
      if (ready.equals("y") && stat[1] >= 20){
         System.out.println("Innkeeper: Here is your room key. Have a good rest.");
         System.out.println("You sleep all night and your health is replenished.");
         pausevari = scan.nextLine().toLowerCase();
         out = 1;
         stat[1] -= 20;
         health = totalHealth;
         return;
         
      } else if (ready.equals("n")){
         out = 0;
         System.out.println("Innkeeper: Ok, bye!");
         pausevari = scan.nextLine().toLowerCase();
         return;
      }else if(ready.equals("y") && stat[1] < 20){
       System.out.println("Innkeeper: Sorry it appears you do not have enough gold to pay for it.");
      } else {
         System.out.println("Please try inputting something else.");
         
      }
      }
      return;
   }

 public static int[] ceruleanCityWeaponMenu(){
      Scanner scan = new Scanner(System.in);
      String input = "";
      
      String [] ceruleanCityMeleeWeapons = {meleeWeaponsList[0], meleeWeaponsList[1], meleeWeaponsList[2], meleeWeaponsList[3], meleeWeaponsList[4]};
  	 int [] ceruleanCityMeleeWeaponsPrice = {meleeWeaponsPrice[0], meleeWeaponsPrice[1], meleeWeaponsPrice[2], meleeWeaponsPrice[3], meleeWeaponsPrice[4]};
  	 int [] ceruleanCityMeleeWeaponsDmg = {meleeWeaponsDmg[0], meleeWeaponsDmg[1], meleeWeaponsDmg[2], meleeWeaponsDmg[3], meleeWeaponsDmg[4]};
      
         System.out.println("     Buy     ");
         System.out.println("-------------                      Gold: " + stat[1]);
         System.out.println("Melee Weapons");
         System.out.println("Ranged Weapons");
         System.out.println("Light Armor");
         System.out.println("Heavy Armor");
         System.out.println("Potion");
         System.out.println("Leave");
         System.out.println("");
         System.out.println("What would you like to do?");
         
         //Weapons menu
         while (true){
             String ready = scan.nextLine().toLowerCase();
            if (ready.equals("melee weapons") || ready.equals("melee")){
               meleeWeapons(ceruleanCityMeleeWeapons, ceruleanCityMeleeWeaponsPrice, ceruleanCityMeleeWeaponsDmg);
               ceruleanCityWeaponMenu();
            } else if (ready.equals("ranged weapons") || ready.equals("ranged")){
            	rangedWeapons(ceruleanCityRangedWeapons, ceruleanCityRangedWeaponsPrice, ceruleanCityRangedWeaponsDmg);
            	ceruleanCityWeaponMenu();
            } else if (ready.equals("heavy armor") || ready.equals("heavy")){
            	heavyArmorMenu(ceruleanCityHeavyArmor, ceruleanCityHeavyArmorPrice, ceruleanCityHeavyArmorDefense);
            	ceruleanCityWeaponMenu();
            } else if (ready.equals("light armor") || ready.equals("light")){
            	lightArmorMenu(ceruleanCityLightArmor, ceruleanCityLightArmorPrice, ceruleanCityLightArmorDefense);
            	ceruleanCityWeaponMenu();
            } else if (ready.equals("potion")){
            	potion();
            	ceruleanCityWeaponMenu();
            } else if (ready.equals("dev nightt fury")){
            	Cheats_Dev_Items.nightt_fury();
            	break;
            } else if (ready.equals("leave")){
            	System.out.println("Blacksmith: Get out of here!");
            	input = scan.nextLine().toLowerCase();
                System.out.println("");
                System.out.println("");
                ceruleanCity();
   
            } else {
               System.out.println("Please try inputting something else.");
            }
         }
         return stat; 
      }  
        
 public static void potion(){
	Scanner scan = new Scanner(System.in);
     int out = 0;
     System.out.println("     Potions     ");
     System.out.println("-----------------                      Gold: " + stat[1]);
     System.out.println("Normal Potion     10 gold     10 health"); 
     System.out.println("Regen Potion      80 gold     full heal");
     System.out.println("Leave");

              while (out == 0){
                 String ready = scan.nextLine().toLowerCase();
                 if (ready.equals("normal potion")){
                    if (stat[1] >= 20){
                       System.out.println("You have purchased a normal potion.");
                       stat[1] -= 20;
                       stat[4] += 1;
                       System.out.println("You have " + stat[4] + " normal potions.");
                       out = 1;
                       return;
                    }else{
                       System.out.println("You do not have enough gold for this item.");
                       potion();
                    }   
                 } else if (ready.equals("regen potion")){
                    if (stat[1] >= 100){
                       System.out.println("You have purchased a regen potion.");
                       stat[1] -= 100;
                       stat[5] += 1;
                       System.out.println("You have " + stat[5] + " regen potions.");
                       out = 1;
                       return;
                    }else{
                       System.out.println("You do not have enough gold for this item.");
                       potion();
                    }
                 }else if (ready.equals("leave")){
                	 out = 1;
               	  return;
                 } else {
                     System.out.println("Please try inputting something else.");
                  }
              }
	 
	 return;
 }
  
 public static void rangedWeapons(String [] item, int [] price, int [] dmg){
	 Scanner scan = new Scanner(System.in);
     String input = "";
     int x;
     System.out.println("     Ranged Weapons     ");
     System.out.println("------------------------	Gold: " + stat[1]);
     for (int i = 0; i < item.length; i++){
    	 System.out.println(item[i] + "         " + price[i] + " gold" + "          " + dmg[i] + " ranged attack");
      }
     System.out.println("Leave");
      while (true){
    	  input = scan.nextLine().toLowerCase(); 
          for (int i = 0; i < item.length; i++){
        	  if (input.equals(item[i].toLowerCase()) && stat[1] >= price[i]){
        	  	System.out.println("Your old weapon is returned to your house and you purchase the " + item[i].toLowerCase() + ". Your ranged attack is now " + dmg[i] + ".");
          	        stat[1] -= price[i];
          	        rangePower = dmg[i];
          	        yourRanged.add(currentWeaponRanged);
          	        currentWeaponRanged = item[i];
          	      for (int q = 0; q < rangedWeaponsList.length; q++){
    				  if (rangedWeaponsList[q].equals(currentWeaponRanged)){
    					  eleRanged = rangedWeaponsEle[q];
    					  eleRangeDmg = rangedWeaponsEleDmg[q];
    				  }
    			  }
          	        
          	        
          	        return;
          	} 
          	} 
          	if (input.equals("leave")){
          		return;
         	} else if (input.equals("lightning and death")){
       	  		attackPower = 10000;
       	  		return;  
         	} else {
         		System.out.println("Please try inputting something else.");
         }
    }
 }
 
 public static void meleeWeapons(String [] item, int [] price, int [] dmg){
      Scanner scan = new Scanner(System.in);
      String input = "";
      int x;
      System.out.println("     Melee Weapons     ");
      System.out.println("-----------------------	Gold: " + stat[1]);
      for (int i = 0; i < item.length; i++){
    	  System.out.println(item[i] + "          " + price[i] + " gold" + "         " + dmg[i] + " attack");
      }
      System.out.println("Leave");
      while (true){
    	  input = scan.nextLine().toLowerCase(); 
    	  for (int i = 0; i < item.length; i++){
    		  if (input.equals(item[i].toLowerCase()) && stat[1] >= price[i]){
    			  System.out.println("Your old weapon is returned to your house and you purchase the " + item[i].toLowerCase() + ". Your attack is now " + dmg[i] + ".");
    			  stat[1] -= price[i];
    			  yourMelee.add(currentWeaponMelee);
    			  currentWeaponMelee = item[i];
    			  attackPower  = dmg[i];
    			  for (int q = 0; q < meleeWeaponsList.length; q++){
    				  if (meleeWeaponsList[q].equals(currentWeaponMelee)){
    					  eleMelee = meleeWeaponsEle[q];
    					  eleMeleeDmg = meleeWeaponsEleDmg[q];
    				  }
    			  }
    			  
    			  return;
    		  } 
    	  } 
    	  if (input.equals("leave")){
    		  return;
    	  } else if (input.equals("night fury blade")){
    		  attackPower = 10000;
    		  return;
    	  } else {
    		  System.out.println("Please try again.");
    	  }
      } 
  }       
   
 public static void heavyArmorMenu(String [] item, int [] price, int [] def){
	 Scanner scan = new Scanner(System.in);
  	 String input = "";
  	 int x;
  	 System.out.println("     Heavy Armor     ");
	 System.out.println("---------------------	    Gold: " + stat[1]);
  	 for (int i = 0; i < item.length; i++){
  	 System.out.println(item[i] + "          " + price[i] + " gold" + "         " + def[i] + " Defense");
  	 }
  	System.out.println("Leave");
  	 while (true){
  		 input = scan.nextLine().toLowerCase(); 
  		 for (int i = 0; i < item.length; i++){
  			 if (input.equals(item[i].toLowerCase()) && stat[1] >= price[i]){
  				 System.out.println("Your old armor is returned to your house and you purchase the " + item[i].toLowerCase() + ". Your defense has increased by " + def[i] + ".");
  				 stat[1] -= price[i];
  				 yourArmor.add(currentArmor);
  				 currentArmor = item[i];
  				 defensePower = def[i];
  				 return;
  			 } 
  		 } 
  		 if (input.equals("leave")){
  			 return;
         } else if (input.equals("night fury scale")){
        	 	 defensePower = 10000;
        	 	 return;
         } else {
             System.out.println("Please try inputting something else.");
          }
         
     }
 }

 public static void lightArmorMenu(String [] item, int [] price, int [] def){
	 Scanner scan = new Scanner(System.in);
  	 String input = "";
  	 int x;
  	 System.out.println("     Light Armor     ");
	 System.out.println("---------------------	    Gold: " + stat[1]);
  	 for (int i = 0; i < item.length; i++){
  	 System.out.println(item[i] + "          " + price[i] + " gold" + "         " + def[i] + " Defense");
  	 }
  	 System.out.println("Leave");
  	 while (true){
  		 input = scan.nextLine().toLowerCase(); 
  		 for (int i = 0; i < item.length; i++){
  			 if (input.equals(item[i].toLowerCase()) && stat[1] >= price[i]){
  				 System.out.println("Your old armor is returned to your house and you purchase the " + item[i].toLowerCase() + ". Your defense has increased by " + def[i] + ".");
  	             stat[1] -= price[i];
  	             yourArmor.add(currentArmor);
  	             currentArmor = item[i];
  	             defensePower = def[i];
  	             return;
  			 } 
  		 } 
  		 if (input.equals("leave")){
  			 return;
         }  else if (input.equals("night fury scale")){
        	 	 defensePower = 10000;
        	 	 return;
         } else {
             System.out.println("Please try inputting something else.");
          }
         
     }
 }
 
 public static int[] grass(){
	 Scanner scan = new Scanner(System.in);
	 Random rand = new Random();
	 int [] exp = {25, 35, 50, 75};
	 String [] animal = {"fox", "wolf", "large snake", "bear"};
	 int out = 1;
	 
	 int animalOut = rand.nextInt((3 + 1) + 0);
	 
	 while(out == 1){
		 System.out.println("You notice a " + animal[animalOut] + ". Would you like to fight it? (y/n)");
		 String input = scan.nextLine().toLowerCase();
		 if (input.equals("y")){
			 if (animalOut == 0){
				 int [] enemy = {10, 1, 1};
				 fightSequence.fight(enemy, "light");
				 System.out.println("In the carcass of the " + animal[animalOut] + " you find 20 gold.");
				 stat[1] += 20;
				 System.out.println("You gained " + exp[0] + " EXP.");
				 stat[8] += exp[0];
				 levelCheck();
				 System.out.println("Your total Exp is now " + stat[8]);
				 input = scan.nextLine().toLowerCase();
				 System.out.println("You head back to the opening in the woods.");
				 input = scan.nextLine().toLowerCase();
				 woods();
			 }else if (animalOut == 1){
				 int [] enemy = {13, 2, 2};
				 fightSequence.fight(enemy, "fire");
				 System.out.println("In the carcass of the " + animal[animalOut] + " you find 30 gold.");
				 stat[1] += 30;
				 System.out.println("You gained " + exp[1] + " EXP.");
				 stat[8] += exp[1];
				 levelCheck();
				 System.out.println("Your total Exp is now " + stat[8]);
				 input = scan.nextLine().toLowerCase();
				 System.out.println("You head back to the opening in the woods.");
				 input = scan.nextLine().toLowerCase();
				 woods();
			 }else if (animalOut == 2){
				 int [] enemy = {15, 3, 3};
				 fightSequence.fight(enemy, "fire");
				 System.out.println("In the carcass of the " + animal[animalOut] + " you find 50 gold.");
				 stat[1] += 50;
				 System.out.println("You gained " + exp[2] + " EXP.");
				 stat[8] += exp[2];
				 levelCheck();
				 System.out.println("Your total Exp is now " + stat[8]);
				 input = scan.nextLine().toLowerCase();
				 System.out.println("You head back to the opening in the woods.");
				 input = scan.nextLine().toLowerCase();
				 woods();
			 }else if (animalOut == 3){
				 int [] enemy = {25, 5, 4};
				 fightSequence.fight(enemy, "light");
				 System.out.println("In the carcass of the " + animal[animalOut] + " you find 80 gold.");
				 stat[1] += 80;
				 System.out.println("You gained " + exp[3] + " EXP.");
				 stat[8] += exp[3];
				 levelCheck();
				 System.out.println("Your total Exp is now " + stat[8]);
				 input = scan.nextLine().toLowerCase();
				 System.out.println("You head back to the opening in the woods.");
				 input = scan.nextLine().toLowerCase();
				 woods();
			 }
		 } else if (input.equals("n")){
			 System.out.println("You head back to the opening in the woods.");
			 out = 0;
			 woods();
		 } else {
			 System.out.println("Please try inputting something else.");
		 }
	 }
	 return (stat);
 }
  
 public static int[] tree(){
	 Scanner scan = new Scanner(System.in);
	 int out = 1;
	 String input;
	 System.out.println("You walk into a clearing with a huge tree in the center of it. It looks like you can climb the tree.");
	 System.out.println("What would you like to do?");
	 System.out.println( "Climb    Stare    Leave ");
	 while (out == 1){
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("climb")){
		 System.out.println("You start to climb the tree.");
		 upTree();
		 out = 0;
		 } else if (input.equals("stare")){
			 System.out.println("You just stand there and stare at the huge tree in front of you.");
			 System.out.println("Man....Humans are easily distracted.....");
			 System.out.println("What else would you like to do.");
			 System.out.println( "Climb    Stare    Leave ");
		 } else if (input.equals("leave")){
			 out = 0;
			 woods();
		 } else {
			 System.out.println("Please try inputting something else."); 
		 }
	 }
	 return (stat);
 }
 
 public static int[] upTree(){
	Scanner scan = new Scanner(System.in);
	int out = 1;
	int outStick = 1;
	String input;
	if (stat[7] == 1 || inv[0].equals("stick")){
	 	System.out.println("You climb to the top with out any problem.");
	 	System.out.println("The view from up here is remarkable.");
	 	input = scan.nextLine().toLowerCase();
	 	System.out.println("You start heading back down the tree.");
	 	input = scan.nextLine().toLowerCase();
	 	tree();
	}else{
	 	Story.treeBoss();
	 	while (out == 1){
	 		System.out.println("What would you like to do?");
	 		System.out.println("--------------------------");
			System.out.println("     Fight      Leave     ");
			System.out.println("--------------------------");
	 		input = scan.nextLine().toLowerCase();
	 	if (input.equals("fight")){
	 		System.out.println("The tree spirit screeches and you brace yourself for battle.");
	 		int [] enemy = {700, 70, 15};
	 		//enemy[0] = health
	 		//enemy[1] = attack
	 		//enemy[2] = level of monster
	 		fightSequence.fight(enemy, "fire");
	 		stat[1] += 1000;
	 		System.out.println("You gained 200 EXP.");
	 		stat[8] += 200;
	 		levelCheck();
	 		System.out.println("Your total EXp is now " + stat[8]);
	 		input = scan.nextLine().toLowerCase();
	 		System.out.println("");
	 		System.out.println("The tree spirit screeches that familiar sound.");
	 		System.out.println("He starts to disinwgrate in a bright flash of light.");
	 		input = scan.nextLine().toLowerCase();
	 		System.out.println("When the light dies down you notice that all is left is a stick.");
	 		System.out.println("Do you want to pick it up? (y/n)");
	 		while (outStick == 1){
	 			input = scan.nextLine().toLowerCase();
	 			if (input.equals("y")){
	 				stat[16] += 1;
	 				System.out.println("You walk up and pick up the stick and place it in your inventory.");
	 				inv[0] = "stick";
	 				outStick = 0;
	 				System.out.println("You head out and start climbing down the tree.");
	 				input = scan.nextLine().toLowerCase();
	 				tree();
	 			} else if (input.equals("n")){
	 				System.out.println("As you begin to leave you notice the stick begin to shake.");
	 				System.out.println("All of a sudden a new tree spirit grows from it.");
	 				input = scan.nextLine().toLowerCase();
	 				System.out.println("You climb down the tree as fast as you can.");
	 				input = scan.nextLine().toLowerCase();
	 				tree();
	 	 
	 			} else {
	 				System.out.println("Please try inputting something else."); 
	 			}
	 		} 
	 	} else if (input.equals("leave")){
	 		System.out.println("You run and scurry down the tree as fast as you can.");
	 		input = scan.nextLine().toLowerCase();
	 		tree();
	 	} else {
	 		System.out.println("Please try inputting something else."); 

	 	}
	 }
	}
	 return (stat);
 }
 
 public static int[] cave(){
	 Scanner scan = new Scanner(System.in);
	 int out = 1;
	 int outStone = 1;
	 int stonePed = 1;
	 int stickPed = 1;
	 String input = "";
	 //Room state 1: Quest Completed
	 if (inv[2].equals("book")){
		 System.out.println("You enter the cave and see the empty pedistal where the book used to be.");
		 System.out.println("You turn and leave.");
		 input = scan.nextLine().toLowerCase();
		 woods();
	 } else if (stat[6] != 1 && stat[7] != 1) {
		 System.out.println("You enter the cave and notice a book on a stand. It is surrounded by some type of magical field.");
		 System.out.println("There are two pedistals infront of the magical field, one marked with star and the other marked with a long stick.");
		 input = scan.nextLine().toLowerCase();
	 }
	 //Room state 2: need to kill the demon
	 if (inv[1].equals("") && stat[6] != 1){
		 System.out.println("These things are both guarded by a large demon. The demon looks at you but does not seem to want to fight you.");
		 System.out.println("What would you like to do?");
		 System.out.println("--------------------------");
		 System.out.println("     Fight      Leave     ");
		 System.out.println("--------------------------");
		 while (out == 1){
			 input = scan.nextLine().toLowerCase();
			 if (input.equals("fight")){
				 System.out.println("The demon roars and causes the whole cave to shake. There is no going back from this fight....");
				 out = 0;
				 int [] enemy = {300, 50, 10};
				 //enemy[0] = health
				 //enemy[1] = attack
				 //enemy[2] = level of monster
				 fightSequence.fight(enemy, "ice");
				 stat[1] += 500;
				 System.out.println("You gained 150 EXP.");
				 stat[8] += 150;
				 levelCheck();
				 System.out.println("Your total EXp is now " + stat[8]);
				 input = scan.nextLine().toLowerCase();
				 System.out.println("The demon erupts into flame while making an earth shattering roar.");
				 System.out.println("As the fire subsides you see a glowing star. On closer inspection you can see a fire burning inside of it.");
				 input = scan.nextLine().toLowerCase();
				 System.out.println("Do you want to pick it up? (y/n)");
				 while(outStone == 1){
					 input = scan.nextLine().toLowerCase();
					 if (input.equals("y")){
						 stat[16] += 1;
						 System.out.println("You pick up the stone and add it to your inventory.");
						 inv[1] = "stone";
						 outStone = 0;
						 System.out.println("You look around the cave again.");
						 cave();
	 
					 } else if (input.equals("n")){
						 System.out.println("You leave it, as you stare at it, it slowly fads and disappears.");
						 input = scan.nextLine().toLowerCase();
						 System.out.println("A fire sweeps the cave, when your eyes focus again another demon is there.");
						 System.out.println("The demon nocks you out of the cave with one sweep of his hands.");
						 input = scan.nextLine().toLowerCase();
						 woods();
					 } else {
						 System.out.println("Please try inputting something else."); 
					 }
				 } 
	 
	 
			 } else if (input.equals("leave")){
				 woods();
				 out = 0;
			 } else {
				 System.out.println("Please try inputting something else.");
			 }
	
		 }
	 //Room state 3: Demon killed but stone not on pedistool yet
	 	} else if (inv[1].equals("stone") && stat[6] == 0){
	 			while (stonePed == 1){
	 				System.out.println("Would you like to place the stone on the pedistal? (y/n)");
	 				input = scan.nextLine().toLowerCase();
	 				if (input.equals("y")){
	 					System.out.println("You place the stone on the pedistal with the star symbol on it.");
	 					System.out.println("As soon as it touchs the stool, the cave shakes and you can see the magical shield weakening.");
	 					input = scan.nextLine().toLowerCase();
	 					inv[1] = "";
	 					stat[6] = 1;
	 					stonePed = 0;
	 					cave();
	 				} else if (input.equals("n")){
	 					System.out.println("You turn around and leave the cave because there is nothing else in there for you to do.");
	 					input = scan.nextLine().toLowerCase();
	 					woods();
	 					stonePed = 0;
	 				} else {
	 					System.out.println("Please try inputting something else.");
	 				}
	 			}
	 
	 	} else if (inv[0].equals("stick") && stat[7] == 0){
	 		while (stickPed == 1){
	 			System.out.println("Would you like to place the stick on the pedistal? (y/n)");
	 			input = scan.nextLine().toLowerCase();
	 			if (input.equals("y")){
	 				System.out.println("You place the stick on the pedistool with the stick symbol on it.");
	 				System.out.println("As soon as it touchs the pedistal, the cave shakes and you can see the magical shield weakening.");
	 				input = scan.nextLine().toLowerCase();
	 				inv[0] = "";
	 				stat[7] = 1;
	 				stickPed = 0;
	 				cave();
	 			} else if (input.equals("n")){
	 				System.out.println("You turn around and leave the cave because there is nothing else in there for you to do.");
	 				input = scan.nextLine().toLowerCase();
	 				woods();
	 				stickPed = 0;
	 			} else {
	 				System.out.println("Please try inputting something else.");
	 			}
	 		}
	 	} else if (stat[6] == 1 && stat[7] == 1){
	 		System.out.println("The barrier around the pedistal is gone.");
	 		while (out == 1){
	 			System.out.println("Would you like to take the book? (y/n)");
	 			input = scan.nextLine().toLowerCase();
	 			if (input.equals("y")){
	 				Story.book();
	 				inv[2] = "book";
	 				out = 0;
	 				woods();
	 			} else if (input.equals("n")){
	 				System.out.println("You turn around and leave the cave because there is nothing else in there for you to do.");
	 				woods();
	 				stickPed = 0;
	 			} else {
	 				System.out.println("Please try inputting something else.");
	 			}
	 		}
	 	} else if (stat[6] == 1 && stat[7] == 0){
	 		System.out.println("There is still one pedistal that is empty.\nYou should try and find what to put there.\nYou turn around and head out of the cave.");
	 		input = scan.nextLine().toLowerCase();
	 		woods();
	 	}
	 
	 return (stat);
 }
 
 public static int[] selectClass(){
	 Scanner scan = new Scanner(System.in);
	 String output = "";
	 while(true){
		 System.out.println("Class Selection");
		 System.out.println("---------------");
		 System.out.println("Warrior");	//Stats Health 40	Base Att 10	Base Magic 0	Base Defense 15	Base Range = 0
		 System.out.println("Mage");	//Stats	Health 25	Base Att 5	Base Magic 10	Base Defense 5	Base Range = 0
		 System.out.println("Archer");	//Stats	Health 30	Base Att 5	Base Magic 5	Base Defense 8	Base Range = 10
		 //System.out.println("Rogue");	  Stats	Health 35	Base Att 8	Base Magic 3	Base Defense 10	Base Range = 5
		 System.out.println("");
		 System.out.println("Please Choose...");
		 output = scan.nextLine().toLowerCase();
		 if (output.equals("warrior")){
			 System.out.println("You have selected Warrior.");
			 System.out.println("Your base stats are: Health 40    Attack 10	Range 0    Magic 0    Defense 15");
			 attackPower = 10;
			 health = 40;
			 defensePower = 15;
			 magicPower = 0;
			 playerClass = "warrior";
			 break;
		 }else if (output.equals("mage")){
			 System.out.println("You have selected Mage.");
			 System.out.println("Your base stats are: Health 25    Attack 	Range 0    Magic 10    Defense 5");
			 attackPower = 5;
			 health = 25;
			 defensePower = 5;
			 magicPower = 10;
			 playerClass = "mage";
			 break;
		 }else if (output.equals("archer")){
			 System.out.println("You have selected Archer.");
			 System.out.println("Your base stats are: Health 30    Attack 5    Range 10    Magic 5    Defense 8");
			 attackPower = 10;
			 health = 30;
			 defensePower = 8;
			 magicPower = 5;
			 rangePower = 10;
			 playerClass = "archer";
			 break;
		 }else if (output.equals("rogue dev")){
			 System.out.println("You have selected Rogue.");
			 System.out.println("Your base stats are: Health 35    Attack 8 	Range 5    Magic 3    Defense 10");
			 attackPower = 8;
			 health = 35;
			 defensePower = 10;
			 magicPower = 3;
			 rangePower = 5;
			 playerClass = "rogue";
		break;
		 }else if (output.equals("dev nightt fury") || output.equals("dev crimsicle")){
			 Cheats_Dev_Items.dev();
		 }else{
			 System.out.println("Please try selecting your class again.");
			 System.out.println("");
		 }
	 }
	 output = "";
	 while(true){
		 System.out.println("");
		 System.out.println("Now it is time to pick your race.");
		 System.out.println("");
		 System.out.println("Race Selection");
		 System.out.println("--------------");
		 System.out.println("Human");
		 System.out.println("Dwarf");
		 System.out.println("High Elven");
		 System.out.println("Dark Elven");
		 System.out.println("");
		 System.out.println("Please choose...");
		 output = scan.nextLine().toLowerCase();
		 if (output.equals("human")){
			 System.out.println("You have selected Human.");
			 System.out.println("You have increased health and attack.");
			 attackPower += 5;
			 health += 5;
			 playerRace = "human";
			 break;
		 }else if (output.equals("high elven")){
			 System.out.println("You have selected High Eleven.");
			 System.out.println("You have increased range and health.");
			 health += 5;
			 rangePower += 10;
			 playerRace = "highelven";
			 break;
		 }else if (output.equals("dark elven")){
			 System.out.println("You have selected Dark Elven.");
			 System.out.println("You have increased magic and defense.");
			 magicPower += 5;
			 defensePower += 10;
			 playerRace = "darkelven";
			 break;
		 }else if (output.equals("dwarf")){
			 System.out.println("You have selected Dwarf.");
			 System.out.println("You have increased health and defense.");
			 health += 15;
			 defensePower += 10;
			 playerRace = "dwarf";
			 break;
		 }else if (output.equals("dragonic")){
			 System.out.println("You have selected Dragonic");
			 System.out.println("You have increased health, magic, attack and defense.");
			 health += 20;
			 attackPower += 20;
			 defensePower += 20;
			 magicPower += 20;
			 rangePower += 20;
			 playerRace = "dragonic";
			 break;	 
		 }else{
			 System.out.println("Please try selecting your class again.");
			 System.out.println("");
		 }
	 }
	 System.out.println("");
	 System.out.println("You are a " + playerRace + " playing as a " + playerClass +".");
	 System.out.println("Your adventure starts now...");
	 output = scan.nextLine().toLowerCase();
	 totalHealth = health;
	 baseAttackPower = attackPower;
	 baseDefensePower = defensePower;
	 baseRangePower = rangePower;
	 baseMagicPower = magicPower;
	 attackPower = 0;
	 defensePower = 0;
	 rangePower = 0;
	 magicPower = 0;
	 Story.startDialog();
	 try {
		 yourMelee.add("No Melee");
	    yourRanged.add("No Ranged");
	    yourArmor.add("No Armor");
		save.writeToFile();
	} catch (IOException e) {
		System.out.println("Error saving.");
	}
	 ceruleanCity();
	 
	 return (stat);
 }
 
 public static void levelCheck(){
	 int attackIncrease = 10;
	 int healthIncrease = 10;
	 int defenseIncrease = 10;
	 int magicIncrease = 10;
	 int rangeIncrease = 10;
	 
	 
	 if (lvl * 100 < stat[8]){
		 lvl += 1;
		 System.out.println("");
		 System.out.println("You have leveled up!");
		 System.out.println("");
		 if (playerClass.equals("warrior")){
			 totalHealth += healthIncrease * .8;
			 baseDefensePower += defenseIncrease * .4;
			 baseAttackPower += attackIncrease * .4;
			 baseMagicPower += magicIncrease * .1;
			 baseRangePower += rangeIncrease * .1;
		 } else if (playerClass.equals("mage")){
			 totalHealth += healthIncrease * .4;
			 baseDefensePower += defenseIncrease * .2;
			 baseAttackPower += attackIncrease * .2;
			 baseMagicPower += magicIncrease * .8;
			 baseRangePower += rangeIncrease * .1;
		 } else if (playerClass.equals("archer")){
			 totalHealth += healthIncrease * .5;
			 baseDefensePower += defenseIncrease * .2;
			 baseAttackPower += attackIncrease * .2;
			 baseMagicPower += magicIncrease * .2;
			 baseRangePower += rangeIncrease * .8;
		 } else if (playerClass.equals("rogue")){
			 totalHealth += healthIncrease * .6;
			 baseDefensePower += defenseIncrease * .4;
			 baseAttackPower += attackIncrease * .4;
			 baseMagicPower += magicIncrease * .2;
			 baseRangePower += rangeIncrease * .2;
		 }
	 
		 if (playerRace.equals("human")){
			 totalHealth += healthIncrease * .4;
			 baseAttackPower += attackIncrease * .4;
		 } else if (playerRace.equals("dwarf")){
			 totalHealth += healthIncrease * .4;
			 baseDefensePower += defenseIncrease * .4;
		 } else if (playerRace.equals("highelven")){
			 totalHealth += healthIncrease * .4;
			 baseRangePower += rangeIncrease * .4;
		 } else if (playerRace.equals("darkelven")){
			 baseDefensePower += defenseIncrease * .4;
			 baseMagicPower += magicIncrease * .4;
		 } else if (playerRace.equals("dragonic")){
			 totalHealth += healthIncrease * .4;
			 baseDefensePower += defenseIncrease * .4;
			 baseAttackPower += attackIncrease * .4;
			 baseMagicPower += magicIncrease * .4;
			 baseRangePower += rangeIncrease * .4;
		 }
	 	}
	 return;
 }
 
 //Base Code, Just a test method
 public static void shopBaseCode(String [] items, int [] price, int [] dmg){

	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 int x;
	 System.out.println("   " + items[0] + "   ");
	 System.out.println("----------------------");
	 for (int i = 1; i < items.length; i++){
	 System.out.println(items[i] + "   " + price[i] + "   " + dmg[i]);
	 }
	 while (true){
	input = scan.nextLine().toLowerCase(); 
	for (int i = 1; i < items.length; i++){
	if (input.equals(items[i].toLowerCase()) && stat[1] >= price[i]){
	System.out.println("You give the blacksmith your old weapon and purchase the " + items[i].toLowerCase() + ". Your attack is now " + dmg[i] + ".");
	               stat[1] -= price[i];
	               attackPower = baseAttackPower + dmg[i];
	               ceruleanCityWeaponMenu();
	               break;
	}
	}
	 }
	 
	 
 }

 public static void winterfell(){
	Scanner scan = new Scanner(System.in);
	String input = "";
	stat[15] = 1;
	System.out.println("");
	System.out.println("    Welcome to Winterfell    ");
	System.out.println("-----------------------------");
	while (true){
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("---------------------------");
		System.out.print("arena   forge   stats  volcano   inn   Cerulean City");
		if (stat[0] == 1){
			System.out.print("   Asgard");
		}
		System.out.println("");
		input = scan.nextLine().toLowerCase();
		if (input.equals("arena")){
			System.out.println("You head to the arena.");
			winterfellArena();
		}else if (input.equals("forge")){
			System.out.println("You head to the forge.");
	        input = scan.nextLine().toLowerCase();
			winterfellWeaponsMenu();
		}else if (input.equals("volcano")){
			volcano();
			winterfell();
		}else if (input.equals("inn")){
			inn();
			winterfell();
		}else if (input.equals("cerulean city")){
			System.out.println("You hit the road to Cerulean City");
			road("Cerulean City");
		} else if (input.equals("asgard") && stat[0] == 1){
			System.out.println("You hit the mountainous road to Asgard, not knowing what you will find.");
			input = scan.nextLine();
			road("Asgard");
		} else if (input.equals("stats")){
	    	  showStats();
	    	  winterfell();
		} else {
			System.out.println("Please try entering someting else.");
			
		}
	
	}
}

 public static void road(String dest){
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	String input = "";
	int x = rand.nextInt(100) + 10;
	int y = rand.nextInt(30) + 5;
	int ex = rand.nextInt(50) + 10;
	int [] monster = {x, y, 1};
	System.out.println("");
	System.out.println("As you travel to " + dest + ", you run into some monsters.");
	input = scan.nextLine().toLowerCase();
	fightSequence.fight(monster, "normal");
	 System.out.println("You gained " + ex + " EXP.");
	 stat[8] += ex;
	 levelCheck();
	 System.out.println("Your total Exp is now " + stat[8]);
	 input = scan.nextLine().toLowerCase();
	 System.out.println("You continue your travels for several days and end up in " + dest);
	 if (dest.equals("Winterfell")){
		 winterfell();
	 } else if (dest.equals("Cerulean City")){
		 ceruleanCity();
	 } else if (dest.equals("Asgard")){
		 asgard();
	 }
	 
}

 public static void winterfellArena(){
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 
	 
	 int [] enemy1 = {50 * stat[14], 10 * stat[14], 1};
	 int [] enemy2 = {80 * stat[14], 20 * stat[14], 1};
	 int [] enemy3 = {130 * stat[14], 35 * stat[14], 1};
	 int [] enemy4 = {180 * stat[14], 50 * stat[14], 1};
	 int [] enemy5 = {800 * stat[14], 300 * stat[14], 1};
	 

	 int [] enemy = {0, 0, 0};
	 System.out.println("");
	 System.out.println("Welcome to the Arena");
	 System.out.println("--------------------");
	 System.out.println("Announcer: The rules are simple... Fight as many as you can without dying.");
	 System.out.println("Announcer: If you die you are returned to your home town... minus some money.");
	 
	 while (true){
		 System.out.println("Announcer: Do you want to participate? (y/n)");
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("y")){
			 break;
		 } else if (input.equals("n")){
			 System.out.println("Announcer: Too bad. We hoped to see you fight.");
			 winterfell();
		 } else {
			 System.out.println("Please enter something else.");
		 }
	 }
	 System.out.println("Announcer: Great! lets get you started!");
	 health = totalHealth;
	 System.out.println("...");
	 input = scan.nextLine();
	 System.out.println("You have been fully healed.");
	 System.out.println("");
	 input = scan.nextLine();
	 System.out.println("You walk into the arena feeling good and ready.");
	 System.out.println("Announcer: Your first opponent is Andrew.");
	 System.out.println("Epicnessofme: 'With my podracing skillz you will never beat me!'");
	 input = scan.nextLine();
	 fightSequence.fight(enemy1, "normal");
	 System.out.println("Epicnessofme: 'It's not working...'");
	 System.out.println("");
	 input = scan.nextLine();
	 System.out.println("Announcer: Good job, but that was easy. Try your hand at the next guy.");
	 System.out.println("Tobi49ful: You won't be able to beat me and my waifu.");
	 input = scan.nextLine();
	 fightSequence.fight(enemy2, "fire");
	 System.out.println("Tobi49ful: WHAT HAVE YOU DONE TO MY WAIFU!!!!!");
	 System.out.println("");
	 System.out.println("Announcer: Ok my bad that was a little weird.");
	 System.out.println("Announcer: Ok now it is a real fight. Good luck...");
	 input = scan.nextLine();
	 System.out.println("Kam: Darius is objectively the best champion in the game.");
	 input = scan.nextLine();
	 fightSequence.fight(enemy3, "ice");
	 System.out.println("Kam: Broken, thanks rito.");
	 System.out.println("Announcer: Can we please get someone that is serious out here.");
	 System.out.println("Headcrabhunter: I am better at GTA V than you.");
	 input = scan.nextLine();
	 System.out.println("Announcer: ...");
	 input = scan.nextLine();
	 fightSequence.fight(enemy4, "posion");
	 System.out.println("Headcrabhunter: asdjkfhajkhdcfgahdf");
	 System.out.println("What the actual heck was that. I am done, I don't care who is next, just kill them already.");
	 System.out.println("Nightt fury: Lets go.");
	 fightSequence.fight(enemy5, "lightning");
	 System.out.println("Nightt fury: Ok...");
	 System.out.println("Announcer: Ok that was good but I am seriously done with this. Just take your winnings.");
	 input = scan.nextLine();
	 System.out.println("You gained 1200 gold.");
	 stat[1] += 1200;
	 System.out.println("Announcer: You are always welcome back. At least someone in this town is good.");
	 input = scan.nextLine();
	 stat[14]++;
	 winterfell();
}

 public static void volcano(){
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 System.out.println("");
	 System.out.println("You are at the base of the volcano.");
	 System.out.println("You can see the path to the rim ahead. To your side is a small cave.");
	 
	 while (true){
		 System.out.println("");
		 System.out.println("What would you like to do?");
		 System.out.println("--------------------------");
		 System.out.println("cave    rim    Winterfell");
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("cave")){
			 System.out.println("You head into the cave.");
			 volcanoCave();
		 } else if (input.equals("rim")){
			 System.out.println("You continue up the rocky path to the rim of the volcano.");
			 rim();
		 } else if (input.equals("winterfell")){
			 System.out.println("You head back down the path to Winterfell.");
			 winterfell();
		 } else {
			 System.out.println("Please try entering something else.");
		 }
	 }
 }
 
 public static void winterfellWeaponsMenu(){
	 Scanner scan = new Scanner(System.in);
     String input = "";
     
        System.out.println("     Buy     ");
        System.out.println("-------------                      Gold: " + stat[1]);
        System.out.println("Melee Weapons");
        System.out.println("Ranged Weapons");
        System.out.println("Light Armor");
        System.out.println("Heavy Armor");
        System.out.println("Potion");
        System.out.println("Leave");
        System.out.println("");
        System.out.println("What would you like to do?");
        
        //Weapons menu
        while (true){
            String ready = scan.nextLine().toLowerCase();
           if (ready.equals("melee weapons") || ready.equals("melee")){
        	   meleeWeapons(winterfellMeleeWeapons, winterfellMeleeWeaponsPrice, winterfellMeleeWeaponsDmg);
              winterfellWeaponsMenu();
           } else if (ready.equals("ranged weapons") || ready.equals("ranged")){
        	   rangedWeapons(winterfellRangedWeapons, winterfellRangedWeaponsPrice, winterfellRangedWeaponsDmg);
           	winterfellWeaponsMenu();
           } else if (ready.equals("heavy armor") || ready.equals("heavy")){
           	heavyArmorMenu(winterfellHeavyArmor, winterfellHeavyArmorPrice, winterfellHeavyArmorDefense);
           	winterfellWeaponsMenu();
           } else if (ready.equals("light armor") || ready.equals("light")){
        	   lightArmorMenu(winterfellLightArmor, winterfellLightArmorPrice, winterfellLightArmorDefense);
           	winterfellWeaponsMenu();
           } else if (ready.equals("potion")){
           	potion();
           	winterfellWeaponsMenu();
           } else if (ready.equals("leave")){
           	System.out.println("Blacksmith: You will be back.");
           	input = scan.nextLine().toLowerCase();
               System.out.println("");
               System.out.println("");
               winterfell();
  
           } else {
              System.out.println("Please try inputting something else.");
           }
        }
        
 }

 public static void volcanoCave(){
	 Scanner scan = new Scanner(System.in);
	 Random rand = new Random();
	 String input = "";
	 String [] monsters = {"sanic", "bear", "giant bat"};
	 int [] mHP = {80, 70, 60};
	 int [] mAtt = {20, 18, 15};
	 int [] mLvl = {1, 1, 1};
	 String monster = "";
	 int i = rand.nextInt((monsters.length - 1)) + 0;
	 monster = monsters[i];
	 int exper = rand.nextInt(40) + 20;
	 int gold = rand.nextInt(80) + 10;
	 System.out.println("As you enter the cave you can hear things moving around you.");
	 System.out.println("All of a sudden a " + monster + " jumps out and lunges at you, you dodge just in time.");
	 
	 while (true){
		 System.out.println("Do you want to fight the " + monster + "?");
		 System.out.println("-------------------------");
		 System.out.println("     Fight      Leave    ");
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("fight")){
			 int [] enemy = {mHP[i], mAtt[i], mLvl[i]};
			 fightSequence.fight(enemy, "ice");
			 System.out.println("In the carcass of the " + monster + " you find " + gold + " gold.");
			 stat[1] += gold;
			 System.out.println("You gained " + exper + " EXP.");
			 stat[8] += exper;
			 levelCheck();
			 System.out.println("Your total Exp is now " + stat[8]);
			 input = scan.nextLine().toLowerCase();
			 System.out.println("You head back to the base of the volcano.");
			 volcano();
		 } else if (input.equals("leave")){
			 System.out.println("You head back to the base of the volcano.");
			 System.out.println("");
			 volcano();
		 } else {
			 System.out.println("Please try entering something else.");
		 }
	 
		 
	 }
	 
 }
 
 public static void rim(){
	Scanner scan = new Scanner(System.in);
	String input = "";
	System.out.println("");
	System.out.println("You approach the rim of the volcano. you can feel the intense heat as you approach.");
	System.out.println("You come over the edge and see a great lava lake.");
	System.out.println("");
	input = scan.nextLine();

	if (stat[9] == 0){
		System.out.println("All of a sudden the lake erupts. In the center of the lake now rests an Brachydios.");
		System.out.println("A small obsidian bridge now connects the 2 of you.");
		while (true){
			System.out.println("What would you like to do?");
			System.out.println("--------------------------");
			System.out.println("     Fight      Leave     ");
			System.out.println("--------------------------");
			input = scan.nextLine().toLowerCase();
			if (input.equals("fight")){
				System.out.println("You ready your weapon and rush towards the center of the lava lake.");
				System.out.println("The Brachydios roars and you brace for the fight.");
				int [] brachydios = {2200, 150, 43};
				fightSequence.fight(brachydios, "ice");
				stat[9] = 1;
				stat[10] = 1;
				System.out.println("The Brachydios roars in pain as it falls. You its slayer.");
				System.out.println("It smashes into the lava lake. Lava flying every where you notice something.");
				System.out.println("Where it fell you see a small glowing stone.");
				stat[8] += 500;
				levelCheck();
				stat[16] += 1;
				System.out.println("You go up and take the stone. As your hand touches it you can feel power surge through you.");
				System.out.println("You can feel the knowledge of an ancient technique.");
				System.out.println("You may use this ability in a fight once, all you need to say is 'overpower' in the main fight menu.");
				input = scan.nextLine();
				System.out.println("With this new knowledge you leave the rim.");
				input = scan.nextLine();
				volcano();
			} else if (input.equals("leave")){
				System.out.println("You head back down to the base of the volcano.");
				volcano();
			} else {
			System.out.println("Please try entering something else.");
			}
		}
	
	} else {
		System.out.println("You can see the remains of the great battle you had against the Brachydios.");
		System.out.println("You turn around and head back down the volcano.");
		input = scan.nextLine();
		volcano();
	}
 }
 
 public static void asgard(){
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 try {
		bossFinal();
	} catch (IOException e) {
		e.printStackTrace();
	}
	 stat[15] = 2;
	 System.out.println("");
	 System.out.println("   Welcome to Asgard   ");
	 System.out.println("-----------------------");
	 System.out.println("The city of the Gods");
	 System.out.println("");
	 System.out.println("You are surrounded by snowey mountains.");
	 input = scan.nextLine();
	 while (true){
		 System.out.println("");
		 System.out.println("What would you like to do?");
		 System.out.println("----------------------------------");
		 System.out.println("  forge   inn   stats   peaks   Winterfell");
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("peaks")){
			 System.out.println("you head up the trail to the peaks.");
			 input = scan.nextLine();
			 peaks();
		 } else if (input.equals("forge")){
			 System.out.println("You head to the local forge to see their wares.");
			 input = scan.nextLine();
			 asgardWeaponsMenu();
		 } else if (input.equals("inn")){
			 System.out.println("you head over to the local inn.");
			 input = scan.nextLine();
			 inn();
			 asgard();
		 } else if (input.equals("winterfell")){
			 System.out.println("You hit the road back to Winterfell.");
			 input = scan.nextLine();
			 road("Winterfell");
		 } else if (input.equals("stats")){
	    	  showStats();
	    	  asgard();
		 } else {
			 System.out.println("Please enter something different.");
		 }
	 }
 }
 
 public static void asgardWeaponsMenu(){
	 Scanner scan = new Scanner(System.in);
     String input = "";
        System.out.println("     Buy     ");
        System.out.println("-------------                      Gold: " + stat[1]);
        System.out.println("Melee Weapons");
        System.out.println("Ranged Weapons");
        System.out.println("Light Armor");
        System.out.println("Heavy Armor");
        System.out.println("Potion");
        System.out.println("Leave");
        System.out.println("");
        System.out.println("What would you like to do?");
        
        //Weapons menu
        while (true){
            String ready = scan.nextLine().toLowerCase();
           if (ready.equals("melee weapons") || ready.equals("melee")){
        	   meleeWeapons(asgardMeleeWeapons, asgardMeleeWeaponsPrice, asgardMeleeWeaponsDmg);
        	   asgardWeaponsMenu();
           } else if (ready.equals("ranged weapons") || ready.equals("ranged")){
        	   rangedWeapons(asgardRangedWeapons, asgardRangedWeaponsPrice, asgardRangedWeaponsDmg);
        	   asgardWeaponsMenu();
           } else if (ready.equals("heavy armor") || ready.equals("heavy")){
           	heavyArmorMenu(asgardHeavyArmor, asgardHeavyArmorPrice, asgardHeavyArmorDefense);
           	asgardWeaponsMenu();
           } else if (ready.equals("light armor") || ready.equals("light")){
        	   lightArmorMenu(asgardLightArmor, asgardLightArmorPrice, asgardLightArmorDefense);
        	   asgardWeaponsMenu();
           } else if (ready.equals("potion")){
           	potion();
           	asgardWeaponsMenu();
           } else if (ready.equals("leave")){
           	System.out.println("Blacksmith: Prasie Odin.");
           	input = scan.nextLine().toLowerCase();
               System.out.println("");
               System.out.println("");
               asgard();
  
           } else {
              System.out.println("Please try inputting something else.");
           }
        }
 }
 
 public static void peaks(){
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 System.out.println("");
	 System.out.println("You come to a small pass near the peak.");
	 System.out.println("You can see the worn wooden sign pointing you to the ritual stones.");
	 System.out.println("And many other signs warning you of the dangers at the summit.");
	 if (stat[16] == 5){
		 System.out.println("There is a rift in the snow pack wall. A rip in time and space.");
	 }
	 
	 
	 while (true){
		 System.out.println("");
		 System.out.println("What would you like to do?");
		 System.out.println("--------------------------");
		 System.out.print("ritual stones    summit    Asgard");
		 if (stat[16] == 6){
			 System.out.println("   Ragnarok");
		 }
		 input = scan.nextLine().toLowerCase();
		 if (input.equals("ritual stones") || input.equals("ritual") || input.equals("stones")){
			 System.out.println("You head down the path to the ritual stones.");
			 ritualStones();
		 } else if (input.equals("summit")){
			 System.out.println("You ignore the warning signs and head to the summit.");
			 summit();
		 } else if (input.equals("asgard")){
			 System.out.println("You head back down the path to Asgard.");
			 asgard();
		 } else if (input.equals("ragnarok") && stat[16] == 6){	 
			 System.out.println("You step up to the tear, you can feel something very bad on the other side.");
			 System.out.println("You step through...");
			 input = scan.nextLine().toLowerCase();
			 System.out.println("...");
			 input = scan.nextLine().toLowerCase();
			 ragnarok();
		 } else {
			 System.out.println("Please try entering something else.");
		 }
	 }
	 
 }
 
 public static void summit(){
	Scanner scan = new Scanner(System.in);
	String input = "";	 
	if (stat[12] == 1){
		System.out.println("The corpse of Raiju still lay where you have slain him.");
		if (!currentArmor.equals("Electro Plate")){
			System.out.println("A suit of Electro plate Armor rests in the center.");
			while (true){
				System.out.println("Would you like to equip it? (y/n)");
				input = scan.nextLine().toLowerCase();
				if (input.equals("y")){
					System.out.println("You shed your old armor and don the Electro Armor.");
					System.out.println("If you ever lose this armor, it will always be summoned here.");
					currentArmor = "Electro Armor";
					defensePower = 400;
					input = scan.nextLine();
					System.out.println("You leave the summit and head back down.");
					input = scan.nextLine();
					peaks();
				} else if (input.equals("n")){
					System.out.println("You leave it at the peak waiting for your return.");
					input = scan.nextLine();
					peaks();
				} else {
					System.out.println("Please try entering something else.");
				}
			}
		}
	} else if (stat[11] == 1){
		System.out.println("As you approach the summit you can see storm clouds forming.");
		System.out.println("You arrive at the summit and notice the ritual ring glowing.");
		input = scan.nextLine();
		System.out.println("Lightning strikes the center of the ring. The stone mounts around the edge ignite.");
		System.out.println("More lightning hits the center. Then there was a flash.");
		input = scan.nextLine();
		System.out.println("By the time you come to your senses you are being rushed by Raiju.");
		System.out.println("You barely have enough time to dodge his attack.");
		input = scan.nextLine().toLowerCase();
		int [] raiju = {6000, 500, 65};
		fightSequence.fight(raiju, "wind");
		stat[12] = 1;
		stat[8] += 1200;
		stat[1] += 300;
		levelCheck();
		stat[16] += 1;
		System.out.println("As the storm clouds part and the weather subsides you notice something in the center of the ritual ring.");
		System.out.println("It is a suit of armor embued with the power of lightning.");
		while (true){
			System.out.println("Would you like to equip it? (y/n)");
			input = scan.nextLine().toLowerCase();
			if (input.equals("y")){
				System.out.println("You shed your old armor and don the Electro Armor.");
				System.out.println("If you ever lose this armor, it will always be summoned here.");
				currentArmor = "Electro Armor";
				defensePower = 220;
				input = scan.nextLine();
				System.out.println("You leave the summit and head back down.");
				input = scan.nextLine();
				peaks();
			} else if (input.equals("n")){
				System.out.println("You leave it at the peak waiting for your return.");
				input = scan.nextLine();
				peaks();
			} else {
				System.out.println("Please try entering something else.");
			}
		}
	} else {
		System.out.println("on the summit you notice some strange engravings in the center.");
		System.out.println("It appears to be some kind of ritual ring. The edge of the summit is marked with stone mounts.");
		System.out.println("Wondering what it is for you head down from the summit.");
		input = scan.nextLine();
		peaks();
	}
 }
 
 public static void ritualStones(){
	Scanner scan = new Scanner(System.in);
	String input = "";
	
	System.out.println("You see a ring of stones.");
	System.out.println("You approach the ritual stones. There are " + (stat[13] - 1) + " lit.");
	if (stat[13] == 8){
		System.out.println("All of the stones are lit. The one has been summoned.");
		input = scan.nextLine();
		stat[11] = 1;
		peaks();
	} else {
		while (true){
			int [] enemy = {200 * stat[13], 100 * stat[13], 1};
			if (stat[13] == 8){
				System.out.println("All of the stones are lit. The one has been summoned.");
				stat[11] = 1;
				break;
			}
			System.out.println("All of a sudden a wraith erupts in the center of the stones.");
			input = scan.nextLine();
			System.out.println("Wraith: " + stat[13] + " of 7 I am. Defeat me and you will move on.");
			while (true){
				System.out.println("");
				System.out.println("What would you like to do?");
				System.out.println("--------------------------");
				System.out.println("     Fight      Leave     ");
				System.out.println("--------------------------");
				input = scan.nextLine().toLowerCase();
				if (input.equals("fight")){
					break;
				} else if (input.equals("leave")){
					System.out.println("You turn and leave, you can here the Wraith disingrate as you leave.");
					input = scan.nextLine();
					peaks();
				} else {
					System.out.println("Please try entering something else.");
					System.out.println("");
				}
			}
			System.out.println("");
			fightSequence.fight(enemy, "fire");
			System.out.println("");
			stat[13]++;
			System.out.println("The Wraith withers away and you notice one of the stones lights up.");
			input = scan.nextLine();
		}
		System.out.println("You turn around and leave.");
		input = scan.nextLine();
		peaks();
	}
	
	
 }
 
 public static void townSelect(){
	 if (stat[15] == 0){
		 ceruleanCity();
	 } else if (stat[15] == 1){
		 winterfell();
	 } else if (stat[15] == 2){
		 asgard();
	 }
 }

 public static void bossFinal() throws IOException{
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 if (stat[16] == 5){
		 System.out.println("");
		 System.out.println("As you walk into the center of Asgard you hear a voice.");
		 input = scan.nextLine();
		 System.out.println("Voice: The gods have noticed...");
		 input = scan.nextLine();
		 System.out.println("Voice: You might just stand a chance...");
		 System.out.println("Voice: The Ragnarok is approaching...");
		 input = scan.nextLine();
		 System.out.println("Voice: Are you the one to save the world...");
		 input = scan.nextLine();
		 System.out.println("Voice: When you are ready, a path has opened in the Asgard Peaks.");
		 input = scan.nextLine();
		 stat[16] += 1;
		 stat[15] = 2;
		 System.out.println("Auto Save.....");
		 save.writeToFile();
		 input = scan.nextLine();
		 return;
	 } else {
		 return;
	 }
 }
 
 public static void ragnarok(){
	 Scanner scan = new Scanner(System.in);
	 String input = "";
	 System.out.println("Welcome to the Vigrid");
	 input = scan.nextLine();
	 Story.vigrid();
	 
 }
 
 public static void showStats(){
	 String input = "";
	 Scanner scan = new Scanner(System.in);
	 System.out.println("    Stats    ");
	  System.out.println("-------------");
	  System.out.println("Lvl:     " + lvl);
	  System.out.println("");
	  System.out.println("Health:  " + (health) + "/" + totalHealth);
	  System.out.println("Gold:    " + stat[1]);
	  System.out.println("Attack:  " + (attackPower + baseAttackPower));
	  System.out.println("Defense: " + (defensePower  + baseDefensePower));
	  System.out.println("Magic:   " + (magicPower  + baseMagicPower));
	  System.out.println("Range:   " + (rangePower + baseRangePower));
	  System.out.println("Exp:     " + stat[8]);
	  System.out.println("");
	  System.out.println("Current Melee: " + currentWeaponMelee + "     Element: " + eleMelee + "  " + eleMeleeDmg);
	  System.out.println("Current Ranged: " + currentWeaponRanged + "     Element: " + eleRanged + "  " + eleRangeDmg);
	  System.out.println("Current Armor: " + currentArmor);
	  System.out.println("");
	  System.out.println("Class: " + playerClass);
	  System.out.println("Race: " + playerRace);
	  System.out.println("");
	  System.out.println("Hit enter to go back");
	  input = scan.nextLine().toLowerCase();
	 return;
 }
 
}