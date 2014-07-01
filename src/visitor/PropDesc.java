package visitor;

import java.io.Serializable;

/**
 * defines a property 
 * @author huhaonan@gmail.com
 *
 */
public class PropDesc implements Serializable {

	private static final long serialVersionUID = -4222012778448808390L;

	/**
	 * property name
	 */
	private String name;
	
	/**
	 * offset if this property is one of the elements of an array 
	 */
	private int offset = -1;
	
	/**
	 * class (type) for this property
	 */
	private Class<?> type;
	
	/*
	 * the contained value for this property
	 */
	private Object value;

	public PropDesc(String name) {
		setName(name);
	}
	
	public PropDesc(String name, int index) {
		setName(name);
		setOffset(index);
	}
	
	public PropDesc(String name, int index, Class<?> type, Object value) {
		setName(name);
		setOffset(index);
		setType(type);
		setValue(value);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
