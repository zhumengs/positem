package cn.nhsoft.amazoncloud.apitest;

import org.databene.feed4testng.FeedTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 提供Feed4Testng和Spring支持
 * 以及一些公用的方法
 * 
 * @createtime 2019年12月24日 下午6:18:47
 * @author Jimmy.Qiu[37153420@qq.com]
 * @version 0.0.1
 */
public class AmazoncloudTestBase extends FeedTest {
	private final String AMAZONCLOUDXMLCLASSPATH = "classpath:/cn/nhsoft/amazoncloud/apitest/amazoncloud.xml";
	private ApplicationContext appContext = null;

	/**
	 * 获取数据库操作的 XxxxxMapper 类实例
	 */
	protected <T> T getMybatisMapper(Class<T> clazz) {
		return appContext.getBean(clazz);
	}

	public AmazoncloudTestBase() {
		appContext = initSpringApplicationContext();
	}

	public ApplicationContext initSpringApplicationContext() {
		return new ClassPathXmlApplicationContext(AMAZONCLOUDXMLCLASSPATH);
	}
}
