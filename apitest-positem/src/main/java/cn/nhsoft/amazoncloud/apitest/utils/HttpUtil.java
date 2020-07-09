package cn.nhsoft.amazoncloud.apitest.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpClient工具类
 * 
 * @createtime 2019年12月26日 上午9:22:50
 * @author Jimmy.Qiu[37153420@qq.com]
 * @version 0.0.1
 */
public abstract class HttpUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String postJson(final String url, String body, Map<String, String> headerMap) {
		HttpClient httpclient = new DefaultHttpClient();

		try {
			HttpPost httppost = new HttpPost(url);

			// 添加header
			// httppost.addHeader("content-type", "application/json");
			if (headerMap != null && headerMap.size() > 0) {
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					httppost.addHeader(entry.getKey(), entry.getValue());
				}
			}

			// 设置body
			httppost.setEntity(new StringEntity(body, "UTF-8"));

			// 发送请求
			HttpResponse response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();

			logger.debug("----------------------------------------");
			logger.debug(response.getStatusLine().toString());

			if (entity != null) {
				logger.debug("Response content length: " + entity.getContentLength());
				if (entity.getContentType() != null) {
					logger.debug("Response content type: " + entity.getContentType().toString());
				}
				logger.debug("----------------------------------------");

				String respStr = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);

				return respStr;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return null;
	}

	public static String get(String url, Map<String, String> headerMap) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);

		try {
			if (headerMap != null && headerMap.size() > 0) {
				for (Map.Entry<String, String> entry : headerMap.entrySet()) {
					httpget.addHeader(entry.getKey(), entry.getValue());
				}
			}

			HttpResponse response = httpclient.execute(httpget);

			HttpEntity entity = response.getEntity();

			logger.debug("----------------------------------------");
			logger.debug("HttpGET URL :" + httpget.getURI());
			logger.debug(response.getStatusLine().toString());

			if (entity != null) {
				logger.debug("Response content length: " + entity.getContentLength());
				logger.debug("----------------------------------------");

				String respStr = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);

				return respStr;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return null;
	}
}
