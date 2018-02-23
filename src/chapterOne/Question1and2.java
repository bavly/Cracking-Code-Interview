package chapterOne;
import java.util.*;


public class Question1and2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(isUniqueChars("ssas"));
		//System.out.println(permutation2("dog","god"));
		System.out.println(test("islamaa"));
		
	}
	 /*	
	 * Is Unique: Implement an algorithm to determine if a string has all unique characters. 
	 * What if you cannot use additional data structures?
	
	*/
	/*
	 * Answer 
	 * One solution is to create an array of boolean values, 
	 * where the flag at index i indicates whether character i in the alphabet 
	 * is contained in the string. The second time you see this character you can immediately return false.
	 * We can also immediately return false if the string length exceeds the number of unique characters in the alphabet. 
	 * After all, you can't form a string of 280 unique characters out of a 128-character alphabet.
	 * */
	static boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;

		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {// Already found this char in string
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	boolean isUniqueChars2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker = (1 << val);
		}
		return true;
	}
	
	/*
	 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
	 */
	
	
	/*
	 * Like in many questions, we should confirm some details with our
	 * interviewer. We should understand if the permutation comparison is case
	 * sensitive. That is: is God a permutation of dog? Additionally, we should
	 * ask if whitespace is significant. We will assume for this problem that
	 * the comparison is case sensitive and whitespace is significant. So,
	 * "god " is different from "dog".
	 * 
	 * Observe first that strings of different lengths cannot be permutations of
	 * each other. There are two easy ways to solve this problem, both of which
	 * use this optimization. Solution #1: Sort the strings. If two strings are
	 * permutations, then we know they have the same characters, but in
	 * different orders. Therefore, sorting the strings will put the characters
	 * from two permutations in the same order. We just need to compare the
	 * sorted versions of the strings. 
	 * */

	String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	/*
	 * More efficient
	 * Solution #2: Check if the two strings have identical character counts. We
	 * can also use the definition of a permutation-two words with the same
	 * character counts-to implement this algorithm. We simply iterate through
	 * this code, counting how many times each character appears. Then,
	 * afterwards, we compare the two arrays.
	 */
	static boolean permutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] letters = new int[128]; // II Assumption
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // II count number of each char in s.
			System.out.println(letters[c]++);
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			System.out.println(letters[c]--);
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

	static String test (String S)
	{
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }
		
		
	
	
}
	

