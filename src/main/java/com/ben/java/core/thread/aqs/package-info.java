/**
 *
 * 一.Lock接口
 * 		1.synchronized属于隐式锁，即锁的持有与释放都是隐式的，我们无需干预，而本篇我们要讲解的Lock是显式锁，
 * 				即锁的持有和释放都必须由我们手动编写。
 * 		2.当前线程使用lock()方法与unlock()对临界区进行包围，其他线程由于无法持有锁将无法进入临界区直到当前线程释放锁，
 * 			   注意unlock()操作必须在finally代码块中,这样可以确保即使临界区执行抛出异常，线程最终也能正常释放锁;
 *
 * 		3.重入锁ReetrantLock[使用很简单,重入锁:可以重复嵌套加锁]:实现了Lock接口，作用与synchronized关键字相当，但比synchronized更加灵活。
 * 	    	ReetrantLock本身也是一种支持重进入的锁，即该锁可以支持一个线程对资源重复加锁，同时也支持公平锁与非公平锁。
 * 	    	所谓的公平与非公平指的是在请求先后顺序上，先对锁进行请求的就一定先获取到锁，那么这就是公平锁，反之，
 * 		    如果对于锁的获取并没有时间上的先后顺序，如后请求的线程可能先获取到锁，这就是非公平锁，一般而言非，
 * 		    非公平锁机制的效率往往会胜过公平锁的机制，但在某些场景下，可能更注重时间先后顺序，那么公平锁自然是很好的选择。
 * 		   需要注意的是ReetrantLock支持对同一线程重复加锁，但是加锁多少次，就必须解锁多少次，这样才可以成功释放锁。
 *
 * 		4.ReetrantLock是基于AQS并发框架实现的
 * 			AQS:AbstractQueuedSynchronizer又称为队列同步器;它是用来构建锁或其他同步组件的基础框架，
 * 		内部通过一个int类型的成员变量state来控制同步状态,当state=0时，则说明没有任何线程占有共享资源的锁，
 * 		当state=1时，则说明有线程目前正在使用共享变量，其他线程必须加入同步队列进行等待，AQS内部通过内部类Node
 * 		构成FIFO的同步队列来完成线程获取锁的排队工作，同时利用内部类ConditionObject构建等待队列，当Condition调用wait()方法后，
 * 		线程将会加入等待队列中，而当Condition调用signal()方法后，线程将从等待队列转移到同步队列中进行锁竞争。注意这里涉及到两种队列，
 * 		一种是同步队列，当线程请求锁而等待的将加入同步队列等待，而另一种则是等待队列(可有多个)，通过Condition调用await()方法释放锁后，将加入等待队列。
 *
 *
 * 		5.AQS作为基础组件，对于锁的实现存在两种不同的模式:所谓共享模式是一个锁允许多条线程同时操作，
 * 			如信号量Semaphore采用的就是基于AQS的共享模式实现的，Semaphore也可以实现独占模式,
 * 			而独占模式则是同一个时间段只能有一个线程对共享资源进行操作，多余的请求线程需要排队等待，如ReentranLock。
 *
 * 		6.Node是AQS的内部类
 * 			变量waitStatus则表示当前被封装成Node结点的等待状态，共有4种取值
 * 			CANCELLED[cancelled]:结束状态;
 * 			SIGNAL[signal]:唤醒状态,只要前继结点释放锁，就会通知标识为SIGNAL状态的后继结点的线程执行。
			CONDITION[condition]:与Condition相关，该标识的结点处于等待队列中，结点的线程等待在Condition上，
 			当其他线程调用了Condition的signal()方法后,CONDITION状态的结点将从等待队列转移到同步队列中，等待获取同步锁。
			PROPAGATE[propagate]:与共享模式相关，在共享模式中，该状态标识结点的线程处于可运行状态;
 *
 * 		7.基于ReetrantLock分析AQS独占模式实现过程[park:挂起]
 *
 * 		8.等待唤醒机制的多个条件变量(Condition),与synchronized的等待唤醒机制相比Condition具有更多的灵活性以及精确性，
 * 		这是因为notify()在唤醒线程时是随机(同一个锁)，而Condition则可通过多个Condition实例对象建立更加精细的线程控制，也就带来了更多灵活性了;
 *
 *
 * 		9.Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用，
 * 		    为每个对象提供多个等待 set（wait-set）。其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。
 *		   条件（也称为条件队列 或条件变量）为线程提供了一个含义，以便在某个状态条件现在可能为 true 的另一个线程通知它之前，一直挂起该线程（即让其“等待”）。
 *		   因为访问此共享状态信息发生在不同的线程中，所以它必须受保护，因此要将某种形式的锁与该条件相关联。等待提供一个条件的主要属性是：以原子方式 释放相关的锁，并挂起当前线程，
 *		   就像 Object.wait 做的那样。 Condition 实例实质上被绑定到一个锁上。要从特定 Lock 实例获得 Condition 实例，请使用其 newCondition() 方法。
 *
 *		10.每个Condition都对应着一个等待队列，也就是说如果一个锁上创建了多个Condition对象，那么也就存在多个等待队列。
 *			等待队列是一个FIFO的队列，在队列中每一个节点都包含了一个线程的引用，而该线程就是Condition对象上等待的线程。
 *			当一个线程调用了await()相关的方法，那么该线程将会释放锁，并构建一个Node节点封装当前线程的相关信息加入到等待队列中进行等待，
 *		    直到被唤醒、中断、超时才从队列中移出。
 *
 *
 *
 * 		11.Condition的主要作用: 通过Conditon能够精细的控制多线程的休眠与唤醒; 对于一个锁,我们可以为多个线程间建立不同的Conditon;
 *            对于同一个锁,synchronized关键字只能有一组等待唤醒队列,而不然像Condition一样,同一个锁拥有多个等待队列;
 *
 * 			[同步队列:因竞争锁失败封装进入等待获取锁的队列;  等待队列:一个Conidtion一个等待队列]
 *
 *      12.condition.signal():此方法做了两件事,一是判断当前线程是否持有独占锁,没有就抛出异常,从这点也可以看出只有独占模式是采用等待队列,
 *			                  而共享模式下是没有等待队列的,也就没法使用Condiion;   二是唤醒等待队列的第一个结点,即执行doSignal(first);
 *
 *      13.Condition的具体实现类是AQS的内部类ConditionObject，前面我们分析过AQS中存在两种队列，一种是同步队列，一种是等待队列，
 *      	而等待队列就相对于Condition而言的。注意在使用Condition前必须获得锁，同时在Condition的等待队列上的结点与前面同步队列的
 *		    结点是同一个类即Node，其结点的waitStatus的值为CONDITION。在实现类ConditionObject中有两个结点分别是firstWaiter和lastWaiter，
 *		    firstWaiter代表等待队列第一个等待结点，lastWaiter代表等待队列最后一个等待结点;
 *
 *		14.firstWaiter指向等待队列的头结点，lastWaiter指向等待队列的尾结点，等待队列中结点的状态只有两种即CANCELLED和CONDITION，
 *			前者表示线程已结束需要从等待队列中移除， 后者表示条件结点等待被唤醒。
 *
 *
 *		15.只有独占模式先采用等待队列，而共享模式下是没有等待队列的，也就没法使用Condition;
 *
 *		16.java语言中实现线程协作的方式: 1.Object.wait(),Object.notify(),Object.notifyall() -->和Synchronized配合使用;
 *							2.Condition -->和Lock配合使用
 *							[上述对象方法的调用,前提是调用线程必须已经获取到了锁: Lock,Synchronized ]
 *
 *							唤醒某个线程,并不表示该线程一定能够得到资源锁;
 *
 *
 *							所有调用object.wait()的线程都会放到同一个等待队列中;
 *							所有调用condition.await()的线程会分别放入对应的condition等待队列中;
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
package com.ben.java.core.thread.aqs;