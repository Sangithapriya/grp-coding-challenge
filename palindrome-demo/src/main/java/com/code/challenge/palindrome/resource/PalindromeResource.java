package com.code.challenge.palindrome.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.challenge.palindrome.exception.InvalidInputException;
import com.code.challenge.palindrome.util.PalindromeUtil;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@RequestMapping(path = "/highest-palindrome")
public class PalindromeResource {

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<String> retrieveNextHighestPalindrome(@PathVariable String id) throws InvalidInputException {
		if (id.isBlank() || id.contains(".")) {
			throw new InvalidInputException();
		} else if (Integer.parseInt(id) < 0) {
			throw new InvalidInputException();
		}
		return ResponseEntity.ok(PalindromeUtil.getNextPalindrome(Integer.parseInt(id)));
	}

	@GetMapping("/string-input/{id}")
	@ResponseBody
	public ResponseEntity<String> retrievePalindromeForString(@PathVariable String id) throws InvalidInputException {
		if(id.isBlank() || id==null) {
			throw new InvalidInputException();
		}
		return ResponseEntity.ok(PalindromeUtil.getPalindromeForString(id));
	}
}
