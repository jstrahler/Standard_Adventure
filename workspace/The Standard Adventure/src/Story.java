import java.io.*;

import static java.lang.System.*;

import java.lang.String;
import java.util.Scanner;

public class Story{
	
	public static void story_Part2_Intro() {
		 Scanner scan = new Scanner(System.in);
		 String input = "";
		   System.out.println("With the defeat of the enemies and the safety of the townspeople ensured, you return to your humble adobe");
		   System.out.println("The following days pass slowly, as you wander mindlessly about the town");
		   System.out.println("You remember your glory days from earlier that week and start to become bored with your present life");
		   System.out.println("Is there nothing left to do in life??");
		   String j = scan.nextLine().toLowerCase();
		   System.out.println("");
		   System.out.println("One day, probably a thursday, you decide to take a stroll through the town market");
		   System.out.println("Business is bustling, but you are bored as usual, so you continue on your way");
		   System.out.println("Behind you, you notice a strange old man that you have never seen before");
		   System.out.println("You quickly forget about him though and your growling stomach reminds you that it is time for dinner");
		   System.out.println("You start heading home, but notice the old man still following");
		   System.out.println("Still you think little of it, because your immense popularity in the town always attracts some stragglers");
		   System.out.println("You nearly reach your doorstep when the old man speaks");
		   System.out.println("\n");
		   System.out.println("Old Man: 'Knock Knock'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("You: 'What?'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("Old Man: 'Knock Knock'"); 
		   j = scan.nextLine().toLowerCase();
		   System.out.println("You: 'Who are you? And why are you following me?'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("Old Man: 'Knock Knock'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("You: 'Fine.. who's there?'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("Old Man: 'A broken pencil'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("You: 'A broken pencil who?'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("Old Man: 'Never mind.. It's pointless'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("You stare at the old man with a confused look on your face");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("Old Man: 'So I've finally got your attention then. I have a great opportunity for you.'");
		   System.out.println("Old Man: 'Is your life full of boredom and misery, have you ever felt like you needed a change?'");
		   System.out.println("Old Man: 'Then I am the guy for you. I'll make your dreams come true. I just need some gold, like 42'");
		   j = scan.nextLine().toLowerCase();
		   System.out.println("You: 'Uhh.. ok?'");
		   j = scan.nextLine().toLowerCase();
		   Main.stat[0] = 1;
		   while (true){
			   System.out.println("Would you like to pay the 42 gold? (y/n)");
			   input = scan.nextLine().toLowerCase();
			   if (input.equals("y")){
				   Main.stat[1] -= 42;
				   System.out.println("old Man: Ok here we go.");
				   input = scan.nextLine();
				   System.out.println("BANG");
				   input = scan.nextLine();
				   Main.asgard();
			   } else if (input.equals("n")){
				   System.out.println("Old Man: huh too cheap? Fine I don't want you here.");
				   input = scan.nextLine();
				   System.out.println("BANG");
				   input = scan.nextLine();
				   Main.asgard();
			   } else {
				   System.out.println("Old Man: What was that I couldn't understand you?");
				   System.out.println("Old Man: People like you need to learn.");
				   input = scan.nextLine();
				   System.out.println("BANG");
				   input = scan.nextLine();
				   Main.asgard();
			   }
		   }
		   
		}

	public static void book() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("You pick up the book and open it to its first page.");
			System.out.println("");
			System.out.println("Just hit enter to continue reading");
			System.out.println("         Book        ");
			System.out.println("---------------------");
			input = scan.nextLine().toLowerCase();
			System.out.println("You have come a long way adventurer.");
			System.out.println("You have trained, upgraded and battled huge beasts.");
			input = scan.nextLine().toLowerCase();
			System.out.println("All for a small book. Was it worth it?");
			System.out.println("Is your thirst for adventure satisfied?");
			input = scan.nextLine().toLowerCase();
			System.out.println("Or will you move on to the next town that needs protecting.");
			System.out.println("Leaving this one defenseless to an even more terrifying monster.");
			input = scan.nextLine().toLowerCase();
			System.out.println("Are you happy now? Knowing the truth?");
			System.out.println("That all your work was for nothing? That there is an even bigger monster that hovers over Cerulean City.");
			input = scan.nextLine().toLowerCase();
			System.out.println("One that could wipe it out with a flick of its hand.");
			System.out.println("One where nightmares seem tame. One that is not from our world.");
			input = scan.nextLine().toLowerCase();
			System.out.println("One that can forge worlds?");
			System.out.println("They call him the guardian.");
			input = scan.nextLine().toLowerCase();
			System.out.println("Long have the people feared that word. For if said in the Cerulean City center.");
			System.out.println("The beast is summoned.");
			input = scan.nextLine().toLowerCase();
			System.out.println("Are you happy now? Or will you face this monster head on?");
			System.out.println("Few have challenged it, none have survived.");
			input = scan.nextLine().toLowerCase();
			System.out.println("");
			System.out.println("Will you be the one?");
			System.out.println("Will you be the one to stop Cerulean City's eternal suffering?");
			input = scan.nextLine().toLowerCase();
			System.out.println("Only time will tell.");
			System.out.println("");
			System.out.println("------------------");
			System.out.println("     Book End     ");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("The book combusts making you drop it.");
			System.out.println("The ashes blow away in the wind.");
			return;
	}
	
	public static void treeBoss() {
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("Halfway up the tree you hear something moving.");
	 	System.out.println("All of a sudden you are pulled into the tree by an invisible force.");
	 	input = scan.nextLine().toLowerCase();
	 	System.out.println("You realize the tree just ate you!");
	 	System.out.println("You suddenly appear in a large room inside the tree.");
	 	input = scan.nextLine().toLowerCase();
	 	System.out.println("In the center there seems to be a smaller tree.");
	 	System.out.println("All of a sudden that smaller tree moves! It turns towards you and you notice that it is alive and can move around.");
	 	input = scan.nextLine().toLowerCase();
	 	System.out.println("As you two stare at each other you can feel a fight about to happen.");
	 	System.out.println("You can see a small opening in the bark of the tree. It looks like you can escape through there.");
	 	input = scan.nextLine().toLowerCase();
	}

	public static void startDialog(){
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("Council: Welcome to Cerulean city. We hope you will have a plesent visit. Be warned that there are monsters in the woods.");
		System.out.println("Council: Maybe you can do something about the thing in the great tree. We also hear noises coming from the cave.");
		input = scan.nextLine();
		System.out.println("Council: Could you look at that for us?");
		input = scan.nextLine();
		System.out.println("Council: You are incredible weak right now. Maybe you should go into the grass in the woods and train on small monsters.");
		System.out.println("Council: Before head out and fight the big ones of course. Remeber to upgrade your weapons and such at our forge!");
		input = scan.nextLine();
		return;
	}
	
	public static void tutorial(){
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("");
		System.out.println("You start out in the town of Cerulean city. You get to select your race and class. Each class has unique attacks and stats.");
		System.out.println("Each of those attacks have a different chance of hitting, you should experiment with each to see which attacks are the best.");
		input = scan.nextLine();
		System.out.println("Your base stats are based on your class and race. When you level up your base stats also increase, each is based on class and race.");
		input = scan.nextLine();
		System.out.println("You can buy new weapons and armor at the local forges. To re-equip old weapons and armor head to your house in cerulean city.");
		input = scan.nextLine();
		System.out.println("When you start out you should go and train in the woods in the grass, this is to gain levels and to get money.");
		System.out.println("Make sure before you go to the bosses that you get upgraded armor and weapons based on your class.");
		input = scan.nextLine();
		Main.selectClass();
	}
	
	public static void vigrid(){
		Scanner scan = new Scanner(System.in);
		String input = "";
		System.out.println("The area around you was on fire.");
		input = scan.nextLine();
		System.out.println("Two great armies clash on the great plain.");
		System.out.println("Loki commanding his undead and trolls against odin and the other gods with there heroic soldiers.");
		input = scan.nextLine();
		System.out.println("Loki was winning.");
		input = scan.nextLine();
		System.out.println("You rush your way through the battle. Your armor taking hits that you could not dodge.");
		System.out.println("You reach Loki...");
		input = scan.nextLine();
		System.out.println("Loki: I see the gods have picked their champion.");
		System.out.println("Loki: I wonder if they were right.");
		input = scan.nextLine();
		System.out.println("A magical field shoots up around you two.");
		System.out.println("Loki raises his staff.");
		System.out.println("");
		input = scan.nextLine();
		int [] enemy = {9999, 1000, 43123};
		fightSequence.fight(enemy, "dragon");
		System.out.println("");
		System.out.println("Loki roars as he is torn apart, his army disintegrating.");
		System.out.print("You see Loki go down. Ragnarok has ended a little differently this time.");
		input = scan.nextLine();
		System.out.print("You have done it.");
		System.out.print("As you turn to leave you hear a noise.");
		input = scan.nextLine();
		System.out.println("");
		System.out.print("A rift appears below you and Loki pulls you in.");
		input = scan.nextLine();
		System.out.print("The valient hero saves the world but falls himself.");
		input = scan.nextLine();
		System.out.println("\n\n\n");
		System.out.println(" ------------------------- ");
		System.out.println("|         THE END         |");
		System.out.println(" ------------------------- ");
		input = scan.nextLine();
		System.exit(0);
	}
}