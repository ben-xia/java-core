package com.ben.java.core.netio.heartbeat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 维持连接的消息对象
 * 
 * @author ben xia
 * @date 2018年8月18日
 *
 */
public class KeepAlive implements Serializable {

	private static final long serialVersionUID = -1732629674113307012L;
	/**
	 * 覆盖该方法,仅用于测试使用
	 */
	@Override
	public String toString() {

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t维持连接包";
	}

}
