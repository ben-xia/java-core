package com.ben.java.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.xml.XMLSerializer;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.Map;

/**
 * JSON工具类: XML-String-JSON-Map-POJO-List-Array
 *
 * @author ben xia
 * @date 2018年9月22日上午10:08:34
 */
public class JsonUtils {

	private volatile static JsonUtils instance;

	private static JsonUtils getInstance() {
		if (instance == null) {
			synchronized (JsonUtils.class) {
				if (instance == null) {
					instance = new JsonUtils();
				}
			}
		}
		return instance;
	}



	/**
	 * 使用JSON-JAVA将XML转JSON[效率高]
	 *
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("unused")
	public String xml2json_jsonjava(String xml) throws IOException {
		// 将xml转为json
		JSONObject xmlJSONObj = XML.toJSONObject(xml);
		// 设置缩进
		String jsonStr = xmlJSONObj.toString(4);
		// 输出格式化后的json
		System.out.println(jsonStr);
		ObjectMapper objectMapper = new ObjectMapper();
		Map gsonMap = objectMapper.readValue(jsonStr, Map.class);
		System.out.println("map>>" + gsonMap);

		return jsonStr;

	};

	/**
	 * 使用JSON-lib将XML转JSON[效率低下]
	 *
	 * @param xml
	 * @return
	 */
	public String xml2json_jsonlib(String xml) {
		// 创建 XMLSerializer对象
		XMLSerializer xmlSerializer = new XMLSerializer();
		// 将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）
		String jsonStr = xmlSerializer.read(xml).toString();
		// 输出json内容
		System.out.println(jsonStr);

		return jsonStr;

	};

	public static void main(String[] args) {

		try {
			JsonUtils.getInstance().xml2json_jsonjava(
					"<?xml version=\"1.0\" encoding=\"UTF-8\"?><InternationalTrade xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><Head><MessageID>KJ881112_C011111100396626_2018090711301583588</MessageID><MessageType>KJ881112</MessageType><Sender>YINYINGT</Sender><Receiver>KJPUBLICPT</Receiver><SendTime>20180907113015</SendTime><FunctionCode>CUS</FunctionCode><SignerInfo></SignerInfo><Version>3.0</Version></Head><Declaration><PaymentHead><DeclEntNo>C011111100396626</DeclEntNo><DeclEntName>银盈通支付有限公司</DeclEntName><PayEntNo>C011111100396626</PayEntNo><PayEntName>银盈通支付有限公司</PayEntName><DeclTime>20180907113015</DeclTime><OpType>A</OpType><CustomsCode>5100</CustomsCode><CIQOrgCode>440000</CIQOrgCode></PaymentHead><PaymentList><PaymentDetail><EntPayNo>201809250000001005</EntPayNo><PayStatus>D</PayStatus><PayAmount>1</PayAmount><PayCurrCode>142</PayCurrCode><PayTime>20180824000000</PayTime><PayerName>雷雨晴</PayerName><PayerDocumentType>01</PayerDocumentType><PayerDocumentNumber>452427199206241327</PayerDocumentNumber><PayerPhoneNumber>020160888</PayerPhoneNumber><EntOrderNo>201809250000001005</EntOrderNo><EBPEntNo>C011111100396626</EBPEntNo><EBPEntName>银盈通支付有限公司</EBPEntName><Notes>020160888</Notes></PaymentDetail></PaymentList></Declaration></InternationalTrade>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
