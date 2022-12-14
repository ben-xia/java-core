package com.ben.java.core.netio.nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> { // 1
	private final ChannelGroup group;

	public TextWebSocketFrameHandler(ChannelGroup group) {
		this.group = group;
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception { // 2.覆盖userEventTriggered()
																								// 方法来处理自定义事件
		if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {

			ctx.pipeline().remove(HttpRequestHandler.class); // 3.如果接收的事件表明握手成功,就从 ChannelPipeline
																// 中删除HttpRequestHandler ，因为接下来不会接受 HTTP 消息了

			group.writeAndFlush(new TextWebSocketFrame("Client " + ctx.channel() + " joined"));// 4.写一条消息给所有的已连接
																								// WebSocket
																								// 客户端，通知它们建立了一个新的
																								// Channel 连接

			group.add(ctx.channel()); // 5.添加新连接的 WebSocket Channel 到 ChannelGroup 中，这样它就能收到所有的信息
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		group.writeAndFlush(msg.retain()); // 6
	}
}
