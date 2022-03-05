package learn.javed.algorithms.strings;

/**
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 * 
 * @author javedattar
 *
 */
public class RotationalCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 String rotationalCipher(String input, int rotationFactor) {
		    // Write your code here
		    return "";
		  }
	
	public void run() {
	    String input_1 = "All-convoYs-9-be:Alert1.";
	    int rotationFactor_1 = 4;
	    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
	    String output_1 = rotationalCipher(input_1, rotationFactor_1);
//	    check(expected_1, output_1);

	    String input_2 = "abcdZXYzxy-999.@";
	    int rotationFactor_2 = 200;
	    String expected_2 = "stuvRPQrpq-999.@";
	    String output_2 = rotationalCipher(input_2, rotationFactor_2);
//	    check(expected_2, output_2);

	    // Add your own test cases here
	    
	  }

}
