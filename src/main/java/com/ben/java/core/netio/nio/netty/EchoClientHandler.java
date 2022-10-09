package com.ben.java.core.netio.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Sharable // 1.@Sharable标记这个类的实例可以在 channel里共享
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {  //接收的是ByteBuf类型存放的数据

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", // 2.与服务器建立连接且是活动状态时,就发送消息
				CharsetUtil.UTF_8));
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, // 这个方法会在接收到数据时被调用,注意，由服务器所发送的消息可以以块的形式被接收。即，当服务器发送 5
														// 个字节是不是保证所有的 5 个字节会立刻收到 - 即使是只有 5 个字节，channelRead0()
														// 方法可被调用两次，第一次用一个ByteBuf（Netty的字节容器）装载3个字节和第二次一个 ByteBuf 装载 2
														// 个字节。唯一要保证的是，该字节将按照它们发送的顺序分别被接收。 （注意，这是真实的，只有面向流的协议如TCP）。
			ByteBuf in) {
		System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8)); // 3.打印接收到的消息
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // 4.记录日志错误并关闭 channel
		cause.printStackTrace();
		ctx.close();
	}
}
