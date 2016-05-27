package core.constant;

import java.io.Serializable;

/**
 * 常量配置
 * @author hiyond
 *
 */
public class Constant implements Serializable{

	private static final long serialVersionUID = 8385690457977714173L;

	
	/**
	 * redis配置文件路径
	 */
	public static final String REDIS_PATH = "/redis/redis.properties";
	
	/**
	 * cookie名称，值为放入redis的用户信息的key
	 */
	public static final String COOKIE_AUTH_NAME = "uc";
	
	/**
	 * cookie名称，值为放入redis的用户信息的key的过期时间
	 */
	public static final Integer COOKIE_AUTH_NAME_EXPIRES = 30*60;
	
	/**
	 * 值为放入redis的用户信息的key的过期时间
	 */
	public static final Integer REDIS_AUTH_NAME_EXPIRES = 30*60;
	
	/**
	 * cookie 路径
	 */
	public static final String COOKIE_PATH = "/";
	
	/**
	 * cookie 作用域
	 */
	public static final String COOKIE_DOMAIN = ".hiyond.com";
	
}
