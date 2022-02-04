# grp-coding-challenge
This repository contains code for coding challenge. Changes to find next highest palindrome for a given input.

1. Download the zip project and extract. 
2. Import gradle project to workspace and add required dependencies.
3. Local end point to retrieve the next highest palindrome for given number (can be either odd or even)
   http://localhost:8080/highest-palindrome/151
   a. If given input number is < 0, then Invalid Input Exception with 400 Bad request is returned
   b. If given input number is contains decimal point, then Invalid Input Exception with 400 Bad request is returned
4. End point to check if entered string is palindrome or not
   http://localhost:8080/highest-palindrome/string-input/abba
