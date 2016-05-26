package test.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import core.redis.RedisCenter;
import redis.clients.jedis.Jedis;

public class RedisTest {

	public Jedis jedis = null;
	
	public RedisTest(){
		jedis = RedisCenter.getJedis();
	}
	
	@Test
	public void testPing(){
		System.out.println(jedis.ping());
	}
	
	@Test
	public void TestKey(){
		System.out.println(jedis.ping());
		System.out.println(jedis.flushDB());
		jedis.set("hiyond", "hiyondTest");
		jedis.set("key", "hiyondTest");
		jedis.expire("hiyond", 20);
		System.out.println(jedis.get("hiyond"));
//		
		System.out.println(jedis.exists("hiyond"));
		
		Set<String> setKeys = jedis.keys("*");
		System.out.println(setKeys.size());
		System.out.println(jedis.ttl("hiyond"));
		jedis.close();
	}
	
	@Test
	public void testList(){
		System.out.println(jedis.flushDB());
		jedis.lpush("hiyondTest", "1111","5555");
		jedis.lpush("hiyondTest", "2222");
		jedis.lpush("hiyondTest", "3333");
		jedis.lpush("hiyondTest", "4444");
		System.out.println(jedis.lrange("hiyondTest", 0, -1));
		jedis.close();
	}
	
	@Test
	public void testMap(){
		System.out.println(jedis.flushDB());
		Map<String,String> map = new HashMap<>();
		map.put("name", "hiyond");
		map.put("age", "111");
		jedis.hmset("hiyondTest", map);
		System.out.println(map);
		System.out.println(jedis.hvals("hiyondTest"));
		jedis.close();
	}
	
}
