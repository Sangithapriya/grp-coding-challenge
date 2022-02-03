package com.code.challenge.palindrome.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.code.challenge.palindrome.exception.InvalidInputException;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeResourceTest {

	@Autowired
	PalindromeResource resource;

	@Before
	public void setUp() {
		resource = new PalindromeResource();
	}

	/**
	 * Test method to test palindrome for empty string
	 */
	@Test(expected = InvalidInputException.class)
	public void testPalindromeWithBlankStr() {
		ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Invalid Input Exception",
				HttpStatus.BAD_REQUEST);
		ResponseEntity<String> actualResponse = resource.retrieveNextHighestPalindrome("");
		assertEquals("Expected and actual response are same when input is empty string", expectedResponse,
				actualResponse);

	}

	/**
	 * Test method to test palindrome for input with decimal
	 */
	@Test(expected = InvalidInputException.class)
	public void testPalindromeWithDecimal() {
		ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Invalid Input Exception",
				HttpStatus.BAD_REQUEST);
		ResponseEntity<String> actualResponse = resource.retrieveNextHighestPalindrome("0.0");
		assertEquals("Expected and actual response are same when input contains decimal", expectedResponse,
				actualResponse);

	}

	/**
	 * Test method that takes negative number
	 */
	@Test(expected = InvalidInputException.class)
	public void testPalindromeWithNegativeNumber() {
		ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Invalid Input Exception",
				HttpStatus.BAD_REQUEST);
		ResponseEntity<String> actualResponse = resource.retrieveNextHighestPalindrome("0.0");
		assertEquals("Expected and actual response are same when input is negative number", expectedResponse,
				actualResponse);

	}

	/**
	 * Test method to test palindrome for single digit number
	 */
	@Test
	public void testPalindromeWithSingleDigit() {
		ResponseEntity<String> actualResponse = resource.retrieveNextHighestPalindrome("1");
		assertEquals("Expected and actual response are same for single digit", ResponseEntity.ok("2"), actualResponse);

	}

	/**
	 * Test method to test palindrome for two digit number
	 */
	@Test
	public void testPalindromeWithTwoDigits() {
		ResponseEntity<String> actualResponse = resource.retrieveNextHighestPalindrome("11");
		assertEquals("Expected and actual response are same for 2 digits", ResponseEntity.ok("22"), actualResponse);

	}

	/**
	 * Test method to test palindrome for empty string
	 */
	@Test(expected = InvalidInputException.class)
	public void testPalindromeForEmptyString() {
		ResponseEntity<String> expectedResponse = new ResponseEntity<String>("Invalid Input Exception",
				HttpStatus.BAD_REQUEST);
		ResponseEntity<String> actualResponse = resource.retrievePalindromeForString("");
		assertEquals("Expected and actual response are same for empty string", expectedResponse, actualResponse);

	}

	/**
	 * Test method for palindrome string
	 */
	@Test
	public void testPalindromeString() {
		ResponseEntity<String> actualResponse = resource.retrievePalindromeForString("abba");
		assertEquals("Entered String is a Palindrome", ResponseEntity.ok("Entered String is a Palindrome"),
				actualResponse);

	}

	/**
	 * Test method for non palindrome string
	 */
	@Test
	public void testPalindrome() {
		ResponseEntity<String> actualResponse = resource.retrievePalindromeForString("abcd");
		assertEquals("Entered String is NOT a Palindrome", ResponseEntity.ok("Entered String is NOT a Palindrome"),
				actualResponse);

	}
}
