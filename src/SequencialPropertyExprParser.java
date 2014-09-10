
public class SequencialPropertyExprParser implements IPropertyExprParser{
	
	public void parse(String expr) {
		char[] chars = expr.toCharArray();
		char[] cache = new char[100] ;
		int pos = 0;
		int error = 0;
		for(char c: chars) {
			if(isEgalChar(c)) {
				if(isAlpahNumberic(c) || isLeftBarket(c) || isRightBarket(c)) {
					cache[pos++] = c;
				} else if(isDot(c)) {
					// evaluate
					error = eval(cache, pos);
					if(error < 0) {
						System.out.println("error " + error);
						break;
					}
					cache = new char[100];
					pos = 0;
				}
				
			} else {
				cache[pos++] = c;
				error = -1;
				break;
			}
		}
		
		if(pos>0 && error >= 0) {
			error = eval(cache, pos);
			if(error < 0) {
				System.out.println("error " + error);
			}
		}
		
	}
	
	private boolean isEgalChar(char c) {
		return isAlpahNumberic(c) || isLeftBarket(c) || isRightBarket(c) || isDot(c);
	}
	
	private boolean isAlpahNumberic(char c) {
		return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<= '9');
	}
	
	private boolean isLeftBarket(char c) {
		return c == '[';
	}
	
	private boolean isRightBarket(char c) {
		return c == ']';
	}
	
	private boolean isDot(char c) {
		return c == '.';
	}
	
	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
//	private boolean isAlpha(char c) {
//		return (c >= 'a' && c <= 'z') 
//			|| (c >= 'A' && c <= 'Z');
//	}
	
	private int eval(char[] cache, int pos) {
		int i = 0;
		char[] tmp = new char[100];
		while(i<pos && isAlpahNumberic(cache[i])) {
			tmp[i] = cache[i];
			i++;
		}
		if(i==pos) {
			// OK
			visitProp(new String(tmp).trim());
		} else if(!isLeftBarket(cache[i])) {
		
			return -11;
		} else {
			if(!isRightBarket(cache[pos-1])) {
				return -12;
			}
			char[] n = new char[10];
			// x x [ 1 2 3 ]
			//     ^ ^     ^
			//     | |     |
			//     i |     |
			// 		 j    POS-1
			int j = i+1;
			while(j<pos-1) {
				if(!isDigit(cache[j])) {
					return -13;
				} else {
					n[j-i-1] = cache[j];
				}

				j++;
			}
			visitArray(new String(tmp).trim(), Integer.valueOf(new String(n).trim()));
		}
		
		return 0;
	}
	
	public void visitProp(String p) {
		System.out.println("visit property " + p);
	}
	
	public void visitArray(String arrName, int p) {
		System.out.println("visit array: " + arrName + " with offset: " + p);
	}
	
	public static void main(String[] args) {
		new SequencialPropertyExprParser().parse("a.d9.x[0].xy.b[10].c[0].d000000000000000");
	}
	
}
