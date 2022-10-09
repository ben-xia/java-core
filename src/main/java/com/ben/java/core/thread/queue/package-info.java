/**
 * 阻塞队列LinkedBlockingQueue与ArrayBlockingQueue;
 * [添加都是从尾部开始,删除都是从头部开始]
 * 
 * 1.阻塞队列与我们平常接触的普通队列(LinkedList或ArrayList等)的最大不同点，在于阻塞队列支持:阻塞添加和阻塞删除方法。
 * 		阻塞添加 :所谓的阻塞添加是指当阻塞队列元素已满时，队列会阻塞加入元素的线程，直队列元素不满时才重新唤醒线程执行元素加入操作。
 *		阻塞删除 :阻塞删除是指在队列元素为空时，删除队列元素的线程将被阻塞，直到队列不为空再执行删除操作(一般都会返回被删除的元素)
 * 
 * 2.阻塞队列方法简要总结
 * 
 * 插入方法：
 *		add(E e) : 添加成功返回true，失败抛IllegalStateException异常
 *		offer(E e) : 成功返回 true，如果此队列已满，则返回 false。
 *		put(E e) :将元素插入此队列的尾部，如果该队列已满，则一直阻塞
 * 删除方法:
 *		remove(Object o) :移除指定元素,成功返回true，失败返回false
 *		poll() : 获取并移除此队列的头元素，若队列为空，则返回 null
 *		take()：获取并移除此队列头元素，若没有元素则一直阻塞。
 * 检查方法:
 *		element() ：获取但不移除此队列的头元素，没有元素则抛异常
 *		peek() :获取但不移除此队列的头；若队列为空，则返回 null。
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
 * 
 * 
 * 
 */
/**
 * @author Administrator
 *
 */
package com.ben.java.core.thread.queue;