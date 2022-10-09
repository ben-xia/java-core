package com.ben.java.core.netio.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.nio.charset.Charset;

public class ByteBufTest01 {
	@Test
	public  void test() {
		Charset utf8 = Charset.forName("UTF-8");
		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
		System.out.println((char)buf.readByte());                    //2

		int readerIndex = buf.readerIndex();                        //3
		int writerIndex = buf.writerIndex();                        //4

		buf.writeByte((byte)'?');                            //5
		System.err.println(buf.writerIndex());
		assert readerIndex == buf.readerIndex();
		assert writerIndex != buf.writerIndex();

	}
}
