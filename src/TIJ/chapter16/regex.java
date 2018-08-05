package TIJ.chapter16;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

	public static String knights = "";
	
	public static void split (String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));;
	}
	
	public static void main(String[] args) {
		split(" ");
		split("\\W+");
		split("n\\W+");
		Pattern p = Pattern.compile("abc");
		Matcher m = p.matcher( knights);
		
	}
}
