package CTCI.Chapter17;

/**
 * 一些参数列表
 * <p>
 *
 * @see 类名
 * @see 完整类名
 * @see 完整类名#方法
 * @see java.util.HashMap#entrySet()
 *
 * @param 参数名
 *            说明
 * @return 说明
 * @exception 完整类名
 *                说明
 * @//deprecated
 * 
 * @version 版本信息
 * @author 作者名
 */
public class Q17_1 {

	/** 域注释 */
	public int i;

	/** 方法注释 */
	public void javadocTest() {
		
	}
	public static int addWithoutOperator(int a, int b) {
		if (b == 0)
			return a;
		/** 0001 ^ 0011 = 0010 */
		/** 0001 | 0011 = 0011 */
		/** 0001 & 0011 = 0001 */
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return addWithoutOperator(sum, carry);
	}
	
	public static void main(String[] args) {
		//(100,200) ->addWithoutOperator;
		//addWithoutOperator(100,200)->System.out.println();;
		System.out.println(addWithoutOperator(100,200));
	}

}
