package cn.nhsoft.amazoncloud.apitest.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * JacksonJson JSON<=>对象转化
 * 
 * @createtime 2013-4-19 上午11:04:30
 * @author Jimmy.Qiu[37153420@qq.com]
 * @version 1.0.0
 */
public class JacksonUtils {
	private static final Logger logger = LoggerFactory.getLogger(JacksonUtils.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T extends Object> T jsonToObject(String json, Class<T> className) throws IOException {
		try {
			objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
			objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			return objectMapper.readValue(json, className);
		} catch (IOException e) {
			logger.error("json:{} to object:{} failure.", json, className);
			throw e;
		}
	}

	public static String objectToJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.error("object:{} to json failure.", object);
			return null;
		}
	}
}