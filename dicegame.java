package miscellaneous;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dicegame {
	
	//function for checking if its a Quad
	//takes array as parameter
	//array contains all the 4 values rolled on the dice
	public static boolean quad(int a[]) {
		//check if all values are equal
		//return true if all equal
		if(a[0]==a[1] && a[0]==a[2] && a[0]==a[3]) {
			return true;
		}
		//return false otherwise
		return false;
	}
	
	//function for checking if its a triple
	//takes array as argument
	public static boolean triple(int a[]) {
		//for i in a
		for(int i:a) {
			//count will keep track of the
			//number of times an element is 
			//repeated in the array
			int count=0;
			
			//for j in array 'a'
			for(int j:a) {
				//if there is a duplicate element
				//then increase the count by 1
				if(i==j) {
					count+=1;
				}
			}
			//if a specific element occured 3 times
			//then its a triple, so return true
			if(count==3) {
				return true;
			}
		}
		//return false otherwise
		return false;
	}
	
	//function for checking if its a two-pair
	//takes array as argument
	public static boolean two_pair(int a[]) {
		//for counting the number of pairs
		int pairs=0;
		//creating an empty list of integer type
		List<Integer> num= new ArrayList<Integer>();
		//for i in a
		for(int i:a) {
			//count for counting the number of repetitions
			int count=0;
			//for j in a
			for(int j:a){
				if(i==j) {
					count+=1;
				}
			}
			//if count is 2 this means that its a pair
			//but if this element has already been counted as 
			//a pair then we dont need to count it agani
			if(count==2){
				//num list basically contains the different
				//elements with count 2
				if(num.contains(i)) {
					//if the element has already been counted as a pair
					//then dont increase the pair count
					continue;
				}
				//otherwise add that element to the list for further use
				//and increase pair count by 1
				else{
					num.add(i);
					pairs+=1;
				}
				  
			}
		}
		//if the pair count is 2
		//then return true
		if(pairs==2) {
			return true;
		}
		//return false otherwise
		return false;
	}

	public static void main(String[] args) {
		//scanner object for taking input
		Scanner sc = new Scanner(System.in);
		//variables that will store the values rolled on
		//different die
		int d1,d2,d3,d4;
		
		System.out.println("   Welcome to Computer Dice");
		System.out.println("--------------------------------");
		System.out.println("You will first roll your dice.");
		System.out.println("\nYou then are allowed to re-roll upto\n"
							+"two of your dice\n");
		System.out.println("Finally the outcome of your roll is\n"
							+"determined: \n");
		System.out.println("any Quad and you receive 108 Wins\n"
						  +"any Triple and you receive 6 Wins\n"
						  +"any Two-Pair and you receive 4 wins\n"
						  +"anything else and you receive 1 Lose\n");
		System.out.println("--------------------------------");
		//variable for counting number of rounds
		int round=0;
		//total number of wins will be stores in win
		int wins=0;
		//total loses will be stored in loses
		int loses=0;
		//an infinite loop
		//which can be broken by break
		//statement
		while(true) {
			//a new round
			round+=1;
			//initializing a new array of size 4
			//as this array will contain values rolled
			//on the dice
			int []ar = new int[4];
			
			//henerating 4 random value for 4 different dice
			//math.random() generates a real number between
			//0 and 1
			//but we need to generate values from 1 -6
			//so multiply it by 6 and add one as the generated
			//value will always be less than 6
			//for getting values till 6 we need to add 1
			//and then consider only the integer part
			d1=(int)(Math.random()*6)+1;
			d2=(int)(Math.random()*6)+1;
			d3=(int)(Math.random()*6)+1;
			d4=(int)(Math.random()*6)+1;
			
			//inserting all 4 values in the array
			ar[0]=d1;
			ar[1]=d2;
			ar[2]=d3;
			ar[3]=d4;
			System.out.println("   Player");
			System.out.println("------------");
			System.out.println(" "+ar[0]+"  "+ar[1]+"  "+ar[2]+"  "+ar[3]);
			
			//variable for storing user input
			int n=0;
			//this loop keeps asking the user for input until
			//valid input is entered
			while(true) {
				//ask user for input
				System.out.println("Please enter the number of dice to re-roll [0,2]: ");
				n = sc.nextInt();
				//validating input as a player can't roll more than
				//2 die in a round
				//if the input is 0,1 or 2 then its valid
				if(n>=0 && n<=2) {
					break;
				}
				//ask for input again
				else {
					System.out.println("Invalid Input!");
					continue;
				}
			}
			
			//if user chooses to roll some number of dice
			//then those dice need to be re - rolled and their
			//values need to be updated in the array
			for(int i=0;i<n;i++) {
				//ask the user for die number and validate it
				int dice_num=0;
				while(true) {
					System.out.println("Please enter the number of the die to re-roll [1,4]: ");
					dice_num = sc.nextInt();
					//as there are 4 dice so only die
					//number 1,2,3,4 are valid
					if(dice_num>=1 && dice_num<=4) {
						//rolling the selected die number again
						int d= (int)(Math.random()*6)+1;
						//updating the value of that die in the array
						ar[dice_num-1]=d;
						break;
					}
					else {
						//continue to run the loop again
						System.out.println("Invalid Input!");
						continue;
					}
				}
			}
			
			
			System.out.println("   Player");
			System.out.println("------------");
			System.out.println(" "+ar[0]+"  "+ar[1]+"  "+ar[2]+"  "+ar[3]);
			
			//calling method for checking if its a Quad condition
			if(quad(ar)) {
				//if function returns true then player gets 108 wins
				wins+=108;
				System.out.println("\nQuad - Congrats, you win!");
			}
			//calling triple function for checking triple condition
			else if(triple(ar)) {
				///if true then player gets  wins
				wins+=6;
				System.out.println("\nTriple - Congrats, you win!");
			}
			//checking two-pair condition
			else if(two_pair(ar)){
				//if true then 4 wins
				wins+=4;
				System.out.println("\nTwo-Pair - Congrats, you win!");
			}
			//otherwise its a lose and user gets one lose point
			else {
				loses+=1;
				System.out.println("\nJunker - Sorry, you lose!");
			}
			
			//ask if the user wants to continue playing
			System.out.println("\nDo you wish to play again[y,n] : ");
			String choice = sc.next();
			//if the choice is yes then continue the loop for next round
			if(choice.equals("y")) {
				continue;
			}
			//break the loop otherwise
			//and print final analysis
			else {
				break;
			}
			
		}
		
		//display the final results.
		System.out.println("Computer Dice Results");
		System.out.println("---------------------");
		System.out.println("You played "+round+" rounds");
		System.out.println("\nWins : "+wins);
		System.out.println("Loses : "+loses);
		System.out.println("----------------------");
	}

}
