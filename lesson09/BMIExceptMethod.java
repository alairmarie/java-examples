/*BMI Calculator with error-checking
using exception-handling constructs along with methods*/

import java.util.Scanner;

public class BMIExceptMethod{
	public static int getWeight(Scanner scnr) throws Exception{
		//Get user data
		System.out.println("Enter weight (in pounds):");
		int weightVal = scnr.nextInt();

		//Error checking, non-negative weight
		if(weightVal < 0){
			throw new Exception("Invalid weight.");
		}
		return weightVal;
	}

	public static int getHeight(Scanner scnr) throws Exception{
		//Get user data
		System.out.println("Enter height (in inches):");
		int heightVal = scnr.nextInt();

		//Error checking, non-negative height
		if(heightVal < 0){
			throw new Exception("Invalid height.");
		}
		return heightVal;
	}

	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int weightVal;	//User defined weight (lbs)
		int heightVal;	//User defined height (in)
		float bmiCalc;	//Resulting BMI
		char quitCmd;	//Indicated quit/continue

		weightVal = 0;
		heightVal = 0;
		quitCmd = 'a';

		while(quitCmd != 'q'){
			try{
				//Get user data
				weightVal = getWeight(scnr);
				heightVal = getHeight(scnr);

				//Calculate BMI and print user health info if no input error
				bmiCalc = ((float)weightVal/(heightVal*heightVal))*703.0f;
				//Source: http://www.cdc.gov/
				System.out.println("BMI: "+bmiCalc);
				System.out.println("(CDC: 18.6 - 24.9 normal)");
			}
			catch(Exception excpt){
				//Prints the error message passed by throw statement
				System.out.println(excpt.getMessage());
				System.out.println("Cannot compute health info.");
			}

			//Prompt user to continue/exit
			System.out.println("\nEnter any key ('q' to quit):");
			quitCmd = scnr.next().charAt(0);
		}
	}
}
