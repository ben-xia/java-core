/**
 * 网络编程
 * JAVA NIO
 *
 * https://1028826685.iteye.com/blog/2330760
 * https://www.jianshu.com/p/451cc865d413
 * https://www.xttblog.com/?p=2714
 * https://ifeve.com/buffers/
 *
 *
 *直接与 非直接缓冲区
 *
 * 而且一般在实际过程中，我们一般是先将文件读入内存，再从内存写出到别的地方
 *
 * 在Java NIO中，缓冲区的作用也是用来临时存储数据，可以理解为是I/O操作中数据的中转站。缓冲区直接为通道(Channel)服务，写入数据到通道或从通道读取数据，
 * 这样的操利用缓冲区数据来传递就可以达到对数据高效处理的目的。在NIO中主要有八种缓冲区类(其中MappedByteBuffer是专门用于内存映射的一种ByteBuffer)
 *
 *
 *
 * 所有缓冲区都有4个属性：capacity、limit、position、mark，并遵循：mark <= position <= limit <= capacity，下表格是对着4个属性的解释：
 * 属性 描述
 * Capacity
 * 容量，即可以容纳的最大数据量；在缓冲区创建时被设定并且不能改变
 * Limit
 * 表示缓冲区的当前终点，不能对缓冲区超过极限的位置进行读写操作。且极限是可以修改的
 * Position
 * 位置，下一个要被读或写的元素的索引，每次读写缓冲区数据时都会改变改值，为下次读写作准备
 * Mark
 * 标记，调用mark()来设置mark=position，再调用reset()可以让position恢复到标记的位置
 *
 *
 *
 *
 *
 * ByteBuffer分配内存:
 * allocate(int capacity)
 * 从堆空间中分配一个容量大小为capacity的byte数组作为缓冲区的byte数据存储器
 * allocateDirect(int capacity)
 * 是不使用JVM堆栈而是通过操作系统来创建内存块用作缓冲区，它与当前操作系统能够更好的耦合，因此能进一步提高I/O操作速度。但是分配直接缓冲区的系统开销很大，因此只有在缓冲区较大并长期存在，或者需要经常重用时，才使用这种缓冲区
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
 * @author ben xia
 * @date   2019年07月04日
 */
package com.ben.java.core.netio.nio;