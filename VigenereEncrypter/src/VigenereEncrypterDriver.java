/* @AUTHOR: John Russell, j362r647@ku.edu
 * @DATE: 25 September 2016
 * @FILENAME: VigenereEncrypterDriver.java
 * @PURPOSE: Gathers user input, sanitizes it, and passes it to the VigenereEncrypterHelper
 */
import java.util.Scanner;
public class VigenereEncrypterDriver 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String plaintextInput;
		String keyInput;
		
		System.out.println("Please enter the plain-text without any symbols");
		plaintextInput = input.nextLine();
		System.out.println("Please enter the key without any symbols");
		keyInput = input.nextLine();
		
		//regex edit removes all spaces, credit to StackOverflow user
		//nitro2k01, http://stackoverflow.com/a/5455828
		plaintextInput=plaintextInput.replaceAll("\\s","");
		plaintextInput=plaintextInput.toUpperCase();
		System.out.println("you entered: " + plaintextInput);
		
		keyInput = keyInput.replaceAll("//s", "");
		keyInput = keyInput.toUpperCase();
		System.out.println("With key: "+keyInput);
		
		VigenereEncrypterHelper encrypter = new VigenereEncrypterHelper(plaintextInput.toCharArray(), keyInput.toCharArray());
		
		char[] encryptedText = encrypter.encrypt();
		
		String result = new String(encryptedText);
		System.out.println("the encrypted text is: "+result);
		input.close();
		
	}

}
