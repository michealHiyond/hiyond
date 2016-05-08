package server.properties;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * jdbc配置文件
 */

public class JdbcProperties implements Serializable {

	private static final long serialVersionUID = -1536945609712606613L;

	private static Logger logger = Logger.getLogger(JdbcProperties.class);

	/**
	 * jdbc配置文件路径
	 */
	private static final String JDBC_PROPERTIES_PATH = "/db/jdbc.properties";

	private static String driverClassName;

	private static String url;

	private static String userName;

	private static String password;

	public static String getDriverClassName() {
		return driverClassName;
	}

	private static void setDriverClassName(String driverClassName) {
		JdbcProperties.driverClassName = driverClassName;
	}

	public static String getUrl() {
		return url;
	}

	private static void setUrl(String url) {
		JdbcProperties.url = url;
	}

	public static String getUserName() {
		return userName;
	}

	private static void setUserName(String userName) {
		JdbcProperties.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	private static void setPassword(String password) {
		JdbcProperties.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	static {
		InputStream inputStream = null;
		Properties properties = null;
		try {
			inputStream = JdbcProperties.class.getResourceAsStream(JDBC_PROPERTIES_PATH);
			properties = new Properties();
			properties.load(inputStream);
			String temp = null;
			temp = properties.getProperty("jdbc.driverClassName");
			setDriverClassName(temp);
			temp = properties.getProperty("jdbc.url");
			setUrl(temp);
			temp = properties.getProperty("jdbc.userName");
			setUserName(temp);
			temp = properties.getProperty("jdbc.password");
			setPassword(temp);
		} catch (Exception e) {
			logger.error("读取jdbc配置信息出错：" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(JdbcProperties.getDriverClassName());
		System.out.println(JdbcProperties.getUrl());
		System.out.println(JdbcProperties.getUserName());
		System.out.println(JdbcProperties.getPassword());
	}

}
