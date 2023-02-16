package com.ben.java.core.exception;
/**
 * 方法结束的三种类型: 3.代码中手动的抛出了异常:throw exception;如果方法中没有声明throws exception,调用者将将无法获知异常的信息;
 *				 	 2.方法执行完毕;
 *				 	 1.return
 * @author Administrator
 *
 */
public class ExceptionTest01 {

	public static void main(String[] args) {
		try {
			testException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int testException() throws Exception { // throws Exception

		int i = 0;
		try { //可能发生异常的语句块
			i = 10 / 0;
		} catch (Exception e) { //捕获异常,并对异常处理[1.在当前方法处理,方法继续往下走;2.将异常抛给它的调用者,方法结束]
			e.printStackTrace();
//			throw e; //意味着此方法的结束[3]
		}
		System.out.println(">>>>>i=" + i);
		return i;

	}

	public int testFinally() {
		int i = 0;
		try {
			i = 10;
			return i;
		} catch (Exception e) {
			i = 20;
			return i;
		} finally {
			i = 30;  //返回10;
//			return i; //返回30
		}
	}

}
