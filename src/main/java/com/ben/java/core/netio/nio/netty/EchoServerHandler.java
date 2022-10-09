package com.ben.java.core.netio.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 服务器处理器:实现服务器的处理逻辑
 * @author ben xia
 * @date   2018年11月7日上午8:14:00
 */
@Sharable // @Sharable 1.标识这类的实例之间可以在channel里面共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf in = (ByteBuf) msg;
		System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8)); // 2
		ctx.write(in); // 3.将所接受到的消息返回给发送者.注意,这还没有冲刷数据
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)// 4.冲刷所有待审消息到远程节点,关闭通道后,操作完成;
				.addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace(); // 5
		ctx.close(); // 6.关闭通道
	}
}