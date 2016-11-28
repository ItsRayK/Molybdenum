package entities;

import java.util.Random;

public class Letter {
	 String letterString;
	 int value;

	public Letter(String contents, int points) {
		letterString = contents;
		value = points;
	}
	
/*public static void main(String[] args) {
	String test = "";
	for (int i = 0; i <=36; i++){
		test = randomLetter();
		System.out.print(test);
	}
	
}*/

	public Letter setLetter(Letter l){
		letterString = l.letterString;
		value = l.value;
		return this;
	}
	/*
	 * Using the letter distribution values, these numbers are the probability out of 1 that these letters 
	 * will occur.  The random letter generated will be between 0.0 and 1.0 and given the random number the correct
	 * letter and point value will be assigned 
	 */
	public Letter randomLetter() {
		Random r = new Random();
		double randomValue = r.nextDouble();

		if (randomValue >= 0.0 && randomValue < 0.12702) {
			letterString = "E";
			value = 1;
		}
		if (randomValue >= 0.12702 && randomValue < 0.21758) {
			letterString = "T";
			value = 1;
		}
		if (randomValue >= 0.21758 && randomValue < 0.29925) {
			letterString = "A";
			value = 2;
		}
		if (randomValue >= 0.29925 && randomValue < 0.37432) {
			letterString = "O";
			value = 2;
		}
		if (randomValue >= 0.37432 && randomValue < 0.44398) {
			letterString = "I";
			value = 2;
		}
		if (randomValue >= 0.44398 && randomValue < 0.51147) {
			letterString = "N";
			value = 2;
		}
		if (randomValue >= 0.51147 && randomValue < 0.57474) {
			letterString = "S";
			value = 2;
		}
		if (randomValue >= 0.57474 && randomValue < 0.63568) {
			letterString = "H";
			value = 2;
		}
		if (randomValue >= 0.63568 && randomValue < 0.69555) {
			letterString = "R";
			value = 2;
		}
		if (randomValue >= 0.69555 && randomValue < 0.73808) {
			letterString = "D";
			value = 3;
		}
		if (randomValue >= 0.73808 && randomValue < 0.77833) {
			letterString = "L";
			value = 3;
		}
		if (randomValue >= 0.77833 && randomValue < 0.80615) {
			letterString = "C";
			value = 3;
		}
		if (randomValue >= 0.80615 && randomValue < 0.83373) {
			letterString = "U";
			value = 3;
		}
		if (randomValue >= 0.83373 && randomValue < 0.85779) {
			letterString = "M";
			value = 3;
		}
		if (randomValue >= 0.85779 && randomValue < 0.88139) {
			letterString = "W";
			value = 3;
		}
		if (randomValue >= 0.88139 && randomValue < 0.90367) {
			letterString = "F";
			value = 4;
		}
		if (randomValue >= 0.90367 && randomValue < 0.92382) {
			letterString = "G";
			value = 4;
		}
		if (randomValue >= 0.92382 && randomValue < 0.94356) {
			letterString = "Y";
			value = 4;
		}
		if (randomValue >= 0.94356 && randomValue < 0.96285) {
			letterString = "P";
			value = 4;
		}
		if (randomValue >= 0.96285 && randomValue < 0.97777) {
			letterString = "B";
			value = 4;
		}
		if (randomValue >= 0.97777 && randomValue < 0.98755) {
			letterString = "V";
			value = 5;
		}
		if (randomValue >= 0.98755 && randomValue < 0.99527) {
			letterString = "K";
			value = 5;
		}
		if (randomValue >= 0.99527 && randomValue < 0.9968) {
			letterString = "J";
			value = 7;
		}
		if (randomValue >= 0.9968 && randomValue < 0.9983) {
			letterString = "X";
			value = 7;
		}
		if (randomValue >= 0.9983 && randomValue < 0.99925) {
			letterString = "QU";
			value = 8;
		}
		if (randomValue >= 0.99925 && randomValue < 1.0) {
			letterString = "Z";
			value = 8;
		}
		return this;

	}

}
