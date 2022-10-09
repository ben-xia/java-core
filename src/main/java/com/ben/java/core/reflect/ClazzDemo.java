package com.ben.java.core.reflect;

/**
 * 在Java SE5引入泛型后，我们可以利用泛型来表示Class对象更具体的类型， 即使在运行期间会被擦除，但编译期足以确保我们使用正确的对象类型。
 * 通过泛型声明指明类型的Class对象，编译器在编译期将对带泛型的类进行额外的类型检查，确保在编译期就能保证类型的正确性;
 * 应该时刻记住向Class引用添加泛型约束仅仅是为了提供编译期类型的检查从而避免将错误延续到运行时期。
 * 毕竟通配符指明所有类型都适用
 * 
 * @author Administrator
 *
 */
public class ClazzDemo {

	public static void main(String[] args) {
		// 没有泛型
		Class intClass = int.class;

		// 带泛型的Class对象
		Class<Integer> integerClass = int.class;

		integerClass = Integer.class;

		// 没有泛型的约束,可以随意赋值
		intClass = double.class;

		// 编译期错误,无法编译通过
		// integerClass = double.class
		
		//编译无法通过
		//我们或许会想Integer不就是Number的子类吗？然而事实并非这般简单，毕竟Integer的Class对象并非Number的Class对象的子类，
		//前面提到过，所有的Class对象都只来源于Class类，看来事实确实如此
		//Class<Number> numberClass=Integer.class;
		
		//这样的语句并没有什么问题，毕竟通配符指明所有类型都适用，那么为什么不直接使用Class还要使用Class<?>呢？这样做的好处是告诉编译器，
		//我们是确实是采用任意类型的泛型，而非忘记使用泛型约束，因此Class<?>总是优于直接使用Class，至少前者在编译器检查时不会产生警告信息
		Class<?> intClass1 = int.class;
		intClass1 = double.class;
		
		
		//当然我们还可以使用extends关键字告诉编译器接收某个类型的子类，如解决前面Number与Integer的问题：
		//编译通过！
		Class<? extends Number> clazz = Integer.class;
		//赋予其他类型
		clazz = double.class;
		clazz = Number.class;
		
		
	}
}
