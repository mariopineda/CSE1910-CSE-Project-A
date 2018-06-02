//Virtual Bartender
//26/05/2018
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Bartender
{
	public static void main(String args[]) throws IOException
	{
		//TO DO: ADD LIMIT TO MIXER CAPACITY
	
		//SWEETS
		double syrup = 0;
		double sugar = 0;
		double grenadine = 0;
		
		//SPIRITS
		double gin = 0;
		double vodka = 0;
		double rum = 0;
		double liquer = 0;
		double vermouth = 0;
		double tequila = 0;
		
		//SOURS
		double lime = 0;
		double lemon = 0;
		double pineapple = 0;
		
		double water = 0;
		
		//RECIPE BOOK TEXT FILE
		BufferedReader lr1 = new BufferedReader(new FileReader("guide.txt"));
		int gLines = 0;
		while (lr1.readLine() != null) gLines++; //reads number of lines to allocate memory to array
		lr1.close();
		BufferedReader gr = new BufferedReader(new FileReader("guide.txt"));
		String[] guide = new String[gLines];
		for(int i = 0; i < gLines; i++) guide[i] = gr.readLine(); //assigns each line of text in guide.text to array
		gr.close();
		
		//DRINK DESCRIPTIONS TEXT FILE
		BufferedReader lr2 = new BufferedReader(new FileReader("desc.txt"));
		int dLines = 0;
		while (lr2.readLine() != null) dLines++; //reads number of lines to allocate memory to array
		lr2.close();
		BufferedReader dr = new BufferedReader(new FileReader("desc.txt"));
		String[] desc = new String[dLines];
		for (int i = 0; i < dLines; i++) desc[i] = dr.readLine(); //assigns each line of text in desc.text to a string in an array
		dr.close();

		//DRINK CODE TEXT FILE
		BufferedReader lr3 = new BufferedReader(new FileReader("info.txt"));
		int iLines = 0;
		while (lr3.readLine() != null) iLines++; //reads number of liens to allocate memory to array
		lr3.close();
		BufferedReader ir = new BufferedReader(new FileReader("info.txt"));
		String[] info = new String[iLines];
		for (int i = 0; i < iLines; i++) info[i] = ir.readLine(); //assigns each line of text in info.txt to a string in array

		//PROGRAM ACTUALLY STARTS HERE
		Scanner kbReader = new Scanner(System.in);
		System.out.println("-----------------------");
		System.out.println("VIRTUAL BARTENDER 4000");
		System.out.println("-----------------------");

		boolean isMixed = false; //program will end once set to true
		boolean addingStuff = false; //used to prevent errors from resetting program
		while (!isMixed) {
		System.out.println("Enter a value to add an ingredient:");
		System.out.println("1. Simple syrup | 2. Sugar | 3. Grenadine");
		System.out.println("4. Gin | 5. Vodka | 6. Rum | 7. Liquer | 8. Vermouth | 9. Tequila");
		System.out.println("10. Lime juice | 11. Lemon juice | 12. Pineapple juice | 13. Water");
		System.out.println("14. Recipe book | 15. Check mixer | 16. Empty mixer | 17. Mix contents");
		System.out.println();
			if (kbReader.hasNextInt()) { //user input must be an integer and be between 1 and 14
				int input = kbReader.nextInt();
				if (input >= 0 && input <= 17) { //checks if input is within valid range
					if (input <= 13) { //user adds an ingredient
						addingStuff = true; //loops until an ingredient is added, will go back to ingredient select screen after
						System.out.print("Enter an amount (oz.): ");
						while (addingStuff) {
							if (kbReader.hasNextDouble()) { //checks if input is a valid number
								double oz = kbReader.nextDouble();
								if (oz <= 0) {
									System.out.println("Please enter a valid number.");
									kbReader.next();
								}
								else if (oz + syrup + sugar + grenadine + gin + vodka + rum + liquer + vermouth + tequila + lime + lemon + pineapple + water > 16) {
									//checks if sum of all ingredients is less than 16
									System.out.println("Error: shaker cannot exceed 16 oz.");
									System.out.println();
								}
								else {
									switch (input) {
										case 1: syrup += oz;
											break;
										case 2: sugar += oz;
											break;
										case 3: grenadine += oz;
											break;
										case 4: gin += oz;
											break;
										case 5: vodka += oz;
											break;
										case 6: rum += oz;
											break;
										case 7: liquer += oz;
											break;
										case 8: vermouth += oz;
											break;
										case 9: tequila += oz;
											break;
										case 10: lime += oz;
											break;
										case 11: lemon += oz;
											break;
										case 12: pineapple += oz;
											break;
										case 13: water += oz;
											break;
									}
								}
								addingStuff = false;
							}
							else {
								System.out.println("Please enter a valid number.");
								kbReader.next();
							}
						}
					}
					else { //if the user picks one of the non-ingredients
						switch(input) {
							case 14: for (int i = 0; i <= guide[i].length(); i++) System.out.println(guide[i]); //prints out recipe book
							System.out.println(); //java will not read empty lines
							break;
							case 15: if(syrup != 0) System.out.println("Syrup: " + syrup + " oz.");
								 if(sugar != 0) System.out.println("Sugar: " + sugar + " oz.");
								 if(grenadine != 0) System.out.println("Grenadine: " + grenadine + " oz.");
								 if(gin != 0) System.out.println("Gin: " + gin + " oz.");
								 if(vodka != 0) System.out.println("Vodka: " + vodka + " oz.");
								 if(rum != 0) System.out.println("Rum: " + rum + " oz.");
								 if(liquer != 0) System.out.println("Liquer: " + liquer + " oz.");
								 if(vermouth != 0) System.out.println("Vermouth: " + vermouth + " oz.");
								 if(tequila != 0) System.out.println("Tequila: " + tequila + " oz.");
								 if(lime != 0) System.out.println("Lime juice: " + lime + " oz.");
								 if(lemon != 0) System.out.println("Lemon juice: " + lemon + " oz.");
								 if(pineapple != 0) System.out.println("Pineapple juice: " + pineapple + " oz.");
								 if(water != 0) System.out.println("Water: " + water + " oz.");
								 System.out.println();
							break;
							case 16: syrup = 0;
							sugar = 0;
							grenadine = 0;
							gin = 0;
							vodka = 0;
							rum = 0;
							liquer = 0;
							vermouth = 0;
							tequila = 0;
							lime = 0;
							lemon = 0;
							pineapple = 0;
							water = 0;
							System.out.println("Mixer cleared.");
							break;
							case 17: isMixed = true;
							break;
						}
					}
				}
				else System.out.println("Please enter an integer between 1 and 17.");
			}
			else {
				System.out.println("Please enter an integer between 1 and 17.");
				kbReader.next();
			}
		}
	}
}


