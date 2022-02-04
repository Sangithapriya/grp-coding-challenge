package com.code.challenge.palindrome.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeUtilTest {

	/**
	 * Test method where next highest palindrome is returned directly for a given
	 * odd number ex.45312
	 */
	@Test
	public void testDirectNextHighPalindromeForOddNumber() {
		String actualResult = PalindromeUtil.getNextPalindrome(45312);
		assertEquals("Expected and actual response are same for given odd number", "45354", actualResult);
	}

	/**
	 * Test method where next highest palindrome returned is < original number Ex.
	 * 12345 -> Palindrome is 12321 which is < 12345. Increment middle digit (<9) by
	 * 1 logic will be executed So next highest palindrome would be 12421
	 */
	@Test
	public void testNextHighPalindromeWithMidDigitLessThan9() {
		String actualResult = PalindromeUtil.getNextPalindrome(12345);
		assertEquals("Expected and actual response are same for odd number middle digit less than 9", "12421",
				actualResult);
	}

	/**
	 * Test method where next highest palindrome returned is < original number and
	 * middle digit is 9 Ex. 12967 -> Palindrome is 12921 which is < 12967.
	 * Increment digits upto middle number (>9) by 1 logic will be executed
	 * Incremented number would be 13067. So next highest palindrome would be 13031
	 */
	@Test
	public void testNextHighPalindromeWithMidDigitGreaterThan9() {
		String actualResult = PalindromeUtil.getNextPalindrome(12967);
		assertEquals("Expected and actual response are same for odd number middle digit greater than 9", "13031",
				actualResult);
	}

	/**
	 * Test method where next highest palindrome is returned directly for a given
	 * even number ex.4531
	 */
	@Test
	public void testDirectNextHighPalindromeForEvenNumber() {
		String actualResult = PalindromeUtil.getNextPalindrome(4531);
		assertEquals("Expected and actual response are same for given even number", "4554", actualResult);
	}

	/**
	 * Test method where next highest palindrome returned is < original number Ex.
	 * 24567823 -> Palindrome is 24566542 which is < 24567823. Increment middle
	 * digits (<99) by 1 logic will be executed 24578823 and for this next highest
	 * palindrome would be 24577542
	 */
	@Test
	public void testPalindromeEvenNumberWithMidDigitLessThan99() {
		String actualResult = PalindromeUtil.getNextPalindrome(24567823);
		assertEquals("Expected and actual response are same for even number middle digits less than 99", "24577542",
				actualResult);
	}

	/**
	 * Test method where next highest palindrome returned is < original number and
	 * middle digit is 99 Ex. 129978 -> Palindrome is 129921 which is < 129978.
	 * Increment digits upto middle number (>99) by 1 logic will be executed
	 * Incremented number would be 130978. So next highest palindrome would be
	 * 130031
	 */
	@Test
	public void testNextHighPalindromeWithMidDigitGreaterThan99() {
		String actualResult = PalindromeUtil.getNextPalindrome(129978);
		assertEquals("Expected and actual response are same for even number middle digits greater than 99", "130031",
				actualResult);
	}

	/**
	 * Checks whether entered string is palindrome or not. If palindrome, "Entered
	 * String is a Palindrome" would be returned
	 */
	@Test
	public void testPalindromeString() {
		String actualResult = PalindromeUtil.getPalindromeForString("abba");
		assertEquals("Palindrome Success", "Entered String is a Palindrome", actualResult);
	}

	/**
	 * Checks whether entered string is palindrome or not. If not palindrome,
	 * "Entered String is a Palindrome" would be returned
	 */
	@Test
	public void testNotPalindromeString() {
		String actualResult = PalindromeUtil.getPalindromeForString("abcd");
		assertEquals("NOT Palindrome Success", "Entered String is NOT a Palindrome", actualResult);
	}
}
