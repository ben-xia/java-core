package com.ben.java.core.netio.nio.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 回声服务器
 * 
 * @author ben xia
 * @date 2018年11月12日上午8:10:13
 */
public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
			return;
		}
		int port = Integer.parseInt(args[0]); // 1.端口号
		new EchoServer(port).start(); // 2.呼叫服务器的start()方法
	}

	public void start() throws Exception {
		NioEventLoopGroup group = new NioEventLoopGroup(); // 3
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group) // 4
					.channel(NioServerSocketChannel.class) // 5.指定使用 NIO的传输 Channel
					.localAddress(new InetSocketAddress(port)) // 6.设置 socket 地址使用所选的端口
																// InetSocketAddress[入口地址],服务器将绑定到此地址来监听新的连接请求。
					//Initializer:初始化器   	ChannelInitializer:信道初始化器
					.childHandler(new ChannelInitializer<SocketChannel>() { // 7.添加 EchoServerHandler 到 Channel 的ChannelPipeline
								 										
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new EchoServerHandler());
						}
					});

			ChannelFuture f = b.bind().sync(); // 8.等待绑定服务器完成,（调用 sync()的原因是使当前线程阻塞）
			System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
			f.channel().closeFuture().sync(); // 9.应用程序将等待服务器 Channel关闭(因为我们 在 Channel的 CloseFuture上调用 sync())
		} finally {
			group.shutdownGracefully().sync(); // 10.关闭 EventLoopGroup并释放所有资源，包括所有创建的线程;
		}
	}

}
