package TIJ.chapter16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exercise11 {

	public static String s = "Arline ate eight apples and one orange while Anita hadn't any";
	//(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
	public static Matcher m  = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b").matcher(s);
	public static void main(String[] args) {
		
		while(m.find()) {
			System.out.println(m.group()+ "  ");
		}
	}
}
