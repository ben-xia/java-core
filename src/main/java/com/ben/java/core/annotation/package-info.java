/**
 *  注解: @annotation
 *	
 *一.元注解: @Target  @Retention
 *	1.@Target用来约束注解可以应用的地方（如方法、类或字段）,当注解未指定@Target值时,则此注解可以用于任何元素之上,多个值使用{}包含并用逗号隔开;
 *		@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
 *	2.@Retention用来约束注解的生命周期，分别有三个值，源码级别（source），类文件级别（class）或者运行时级别（runtime），其含有如下：
 *		SOURCE：注解将被编译器丢弃（该类型的注解信息只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里）
 *		CLASS：注解在class文件中可用，但会被VM丢弃（该类型的注解信息会保留在源码里和class文件里，在执行的时候，不会加载到虚拟机中），
 *			      请注意，当注解未定义Retention值时，默认值是CLASS，如Java内置注解，@Override、@Deprecated、@SuppressWarnning等
 *		RUNTIME：注解信息将在运行期(JVM)也保留，因此可以通过反射机制读取注解的信息（源码、class文件和执行的时候都有注解的信息），
 *				如SpringMvc中的@Controller、@Autowired、@RequestMapping等。
 *	3.@Repeatable[JDK8新增的,它表示在同一个位置重复相同的注解]
 *	4.@Inherited:允许子类继承父类中的注解;
 *	5.@Documented:将此注解包含在Javadoc中;
 *
 *二.注解支持的元素数据类型:
 *	所有基本类型（int,float,boolean,byte,double,char,long,short）,String,Class,enum,Annotation,上述类型的数组
 *	倘若使用了其他数据类型，编译器将会丢出一个编译错误，注意，声明注解元素时可以使用基本类型但不允许使用任何包装类型，同时还应该注意到注解也可以作为元素的类型，也就是嵌套注解;
 *
 *三.编译器对默认值的限制
 *	编译器对元素的默认值有些过分挑剔。首先，元素不能有不确定的值。也就是说，元素必须要么具有默认值，要么在使用注解时提供元素的值。
 *  其次，对于非基本类型的元素，无论是在源代码中声明，还是在注解接口中定义默认值，都不能以null作为值，这就是限制，没有什么利用可言，
 *  但造成一个元素的存在或缺失状态，因为每个注解的声明中，所有的元素都存在，并且都具有相应的值，为了绕开这个限制，只能定义一些特殊的值，例如空字符串或负数，表示某个元素不存在。
 *
 *
 *四.注解不支持继承
 *	注解是不支持继承的，因此不能使用关键字extends来继承某个@interface，但注解在编译后，编译器会自动继承java.lang.annotation.Annotation接口;
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
/**
 * @author Administrator
 * @date   2019年2月28日
 */
package com.ben.java.core.annotation;