package com.code.challenge.palindrome.util;

public class PalindromeUtil {

	private static final String PALINDROME_STR = "Entered String is a Palindrome";

	private static final String NOT_PALINDROME = "Entered String is NOT a Palindrome";

	/**
	 * Method to retrieve next highest palindrome
	 * 
	 * @param number
	 * @return
	 */
	public static String getNextPalindrome(int number) {
		if (isSizeEven(number)) {
			return getNextPalindromeForEvenLengthNumbers(number);
		} else {
			return getNextPalindromeForOddLengthNumbers(number);
		}
	}

	/**
	 * Method to check if entered number is odd or even
	 * 
	 * @param number
	 * @return
	 */
	private static boolean isSizeEven(int number) {
		if (String.valueOf(number).length() % 2 == 0)
			return true;
		return false;
	}

	/**
	 * Method to determine highest palindrome for even numbers
	 * 
	 * @param number
	 * @return
	 */
	private static String getNextPalindromeForEvenLengthNumbers(int number) {
		StringBuilder testPalindromeString = new StringBuilder();
		testPalindromeString.append(number);

		StringBuilder convertTopalindrome = new StringBuilder();
		// String length divided by 2
		convertTopalindrome.append(testPalindromeString.substring(0, testPalindromeString.length() / 2));
		System.out.println("==convertTopalindrome==step1" + convertTopalindrome);

		convertTopalindrome.append(testPalindromeString
				.delete(testPalindromeString.length() / 2, testPalindromeString.length()).reverse());
		System.out.println("==convertTopalindrome==step2" + convertTopalindrome);

		// if the palindrome is greater than the original number
		if (Integer.parseInt(convertTopalindrome.toString()) > number) {
			System.out.println(" the next palindrome is " + convertTopalindrome);
			return convertTopalindrome.toString();
		} else {
			// get the middle elements in case of even numbers
			String middleElements = convertTopalindrome.substring(convertTopalindrome.length() / 2 - 1,
					convertTopalindrome.length() / 2 + 1);
			int middleElementsInt = Integer.valueOf(middleElements);
			// Increment the middle elements by 1 so check if after this the value is not
			// greater than 99
			if (middleElementsInt + 11 < 99) {
				convertTopalindrome.replace(convertTopalindrome.length() / 2 - 1, convertTopalindrome.length() / 2 + 1,
						String.valueOf(middleElementsInt + 11));
				System.out.println(" the next palindrome is " + convertTopalindrome);
				return convertTopalindrome.toString();
			} else {
				String numberTillMiddleElement = convertTopalindrome.substring(0, convertTopalindrome.length() / 2 + 1);
				int numberTillMiddleElementInt = Integer.valueOf(numberTillMiddleElement);
				convertTopalindrome.replace(0, convertTopalindrome.length() / 2 + 1,
						String.valueOf(numberTillMiddleElementInt + 1));
				return getNextPalindrome(Integer.valueOf(convertTopalindrome.toString()));
			}
		}
	}

	/**
	 * Method to determine highest palindrome for odd numbers
	 * 
	 * @param number
	 * @return
	 */
	private static String getNextPalindromeForOddLengthNumbers(int number) {

		StringBuilder testPalindromeString = new StringBuilder();
		testPalindromeString.append(number);

		StringBuilder convertTopalindrome = new StringBuilder();
		convertTopalindrome.append(testPalindromeString.substring(0, testPalindromeString.length() / 2 + 1));

		convertTopalindrome.append(testPalindromeString
				.delete(testPalindromeString.length() / 2, testPalindromeString.length()).reverse());

		// if the palindrome is greater than the original number
		if (Integer.parseInt(convertTopalindrome.toString()) > number) {
			return convertTopalindrome.toString();
		} else {

			char middleElement = convertTopalindrome.charAt(convertTopalindrome.length() / 2);
			int middleElementInt = Character.getNumericValue(middleElement);
			// Increment the middle element by 1 and check if incremented value is not
			// greater than 9
			if (middleElementInt < 9) {
				convertTopalindrome.replace(convertTopalindrome.length() / 2, convertTopalindrome.length() / 2 + 1,
						String.valueOf(middleElementInt + 1));
				return convertTopalindrome.toString();
			} else {
				String numberTillMiddleElement = convertTopalindrome.substring(0, convertTopalindrome.length() / 2 + 1);
				int numberTillMiddleElementInt = Integer.valueOf(numberTillMiddleElement);
				convertTopalindrome.replace(0, convertTopalindrome.length() / 2 + 1,
						String.valueOf(numberTillMiddleElementInt + 1));
				return getNextPalindrome(Integer.valueOf(convertTopalindrome.toString()));
			}
		}
	}

	/**
	 * Method to determine palindrome for the input string
	 * 
	 * @param inputString
	 * @return
	 */
	public static String getPalindromeForString(String inputString) {
		StringBuffer newStr = new StringBuffer();
		for (int i = inputString.length() - 1; i >= 0; i--) {
			newStr = newStr.append(inputString.charAt(i));
		}
		if (inputString.equalsIgnoreCase(newStr.toString())) {
			return PALINDROME_STR;
		} else {
			return NOT_PALINDROME;
		}
	}
}
