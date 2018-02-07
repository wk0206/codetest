package TIJ.chapter16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exercise10 {
	
	public static String s = "Java now has regular expressions";
	public static String[] regs = {"^java","\\Breg.*","n.W\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}.","s{0,3}"};
	
	public static void main(String[] args) {
		
		
		for(String reg:regs) {
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(s);
			
			System.out.println(m);
			while(m.find()) {
				System.out.println("Match \"" + m.group() + "\" at positions" +
						m.start() + "-" + (m.end()-1));
			}
		}
				
		// TODO Auto-generated method stub

	}

}
