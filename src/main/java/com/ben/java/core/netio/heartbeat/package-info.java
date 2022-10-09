/**
 * 长连接的维持，是要客户端程序，定时向服务端程序，发送一个维持连接包的。
如果，长时间未发送维持连接包，服务端程序将断开连接。

客户端：
通过持有Client对象，可以随时（使用sendObject方法）发送Object给服务端。
如果keepAliveDelay毫秒（程序中是2秒）内未发送任何数据，则，自动发送一个KeepAlive对象给服务端，
用于维持连接。
由于，我们向服务端，可以发送很多不同的对象，服务端也可以返回不同的对象。
所以，对于返回对象的处理，要编写具体的ObjectAction实现类进行处理。
通过Client.addActionMap方法进行添加。这样，程序会回调处理。

服务端：
由于客户端会定时（keepAliveDelay毫秒）发送维持连接的信息过来，所以，服务端要有一个检测机制。
即当服务端receiveTimeDelay毫秒（程序中是3秒）内未接收任何数据，则，自动断开与客户端的连接。
ActionMapping的原理与客户端相似（相同）。
通过添加相应的ObjectAction实现类，可以实现不同对象的响应、应答过程。
 */
/**
 * @author ben xia
 * @date 2018年8月18日
 * 
 */
package com.ben.java.core.netio.heartbeat;