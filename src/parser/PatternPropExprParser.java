package parser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternPropExprParser implements IPropExprParser {

	final static Pattern p1 = Pattern.compile("([a-zA-Z]+[a-zA-Z0-9_]*)");
	
	final static Pattern p2 = Pattern.compile("([a-zA-Z]+[a-zA-Z0-9_]*)\\[([1-9]+[0-9]*)\\]");
	
	private void split(String prop) {
		System.out.println("split " + prop);
		Matcher m = p2.matcher(prop);
		if(m.find()) {
			System.out.println(m.group(0));
			System.out.println(m.group(1));
		} else {
			Matcher m2 = p1.matcher(prop) ;
			if(m2.find()) {
				System.out.println(m2.group(0));
			} else {
				System.out.println("error 1");
			}
		} 
	}
	
	public void parse(String expr) {
		if(expr.contains(".")) {
			String[] props = expr.split(".");
			for(String prop : props) { 
				if(prop == null || prop.length() == 0) {
					continue;
				} else {
					System.out.println("->"+prop+"<-");
					split(prop);
				}
				
			}
		} else {
			split(expr);
		}
	}
	
	public static void main(String[] args) {
		new PatternPropExprParser().parse("a.b");
	}
}
