package test.enumtest;
/**
 * 
 * @author Hiyond
 *
 */
public enum EnumTest {

	red("红",1),
	blue("绿",2),
	yellow("黄",3);
	
	private EnumTest(String name,int index) {
		this.name = name;
		this.index = index;
	}

	private int index;
	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}

	private String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getEnumIndex(EnumTest enumTest){
		return enumTest.ordinal();
	}
	
	public String getEnumName(EnumTest enumTest){
		return enumTest.getName();
	}
	
	public String getEnumName(int index){
		return "";
	}
}
