package test.enumtest;
/**
 * 
 * @author Hiyond
 *
 */
public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.test();
	}
	
	
	public void test(){
		EnumTest enumTest = EnumTest.blue;
		System.out.println(enumTest.getEnumIndex(enumTest));
//		System.out.println(enumTest.getEnumName(enumTest));
	}
}
