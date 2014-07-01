package visitor;

public interface PropVisitor {
	
	Object getProp(String key, int offset, Object source);
	
}
