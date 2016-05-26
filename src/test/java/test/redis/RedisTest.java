package test.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import core.redis.RedisCenter;
import redis.clients.jedis.Jedis;

public class RedisTest {

	public Jedis jedis = RedisCenter.getJedis();
	
	public static void main(String[] args) {
		new RedisTest().testPing();
//		new RedisTest().TestKey();
//		new RedisTest().testList();
	}

	public void testPing(){
		System.out.println(jedis.ping());
	}
	
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
	
	public void testList(){
		System.out.println(jedis.flushDB());
		jedis.lpush("hiyondTest", "1111","5555");
		jedis.lpush("hiyondTest", "2222");
		jedis.lpush("hiyondTest", "3333");
		jedis.lpush("hiyondTest", "4444");
		System.out.println(jedis.lrange("hiyondTest", 0, -1));
		jedis.close();
	}
	
	public void testMap(){
		System.out.println(jedis.flushDB());
		Map<String,String> map = new HashMap<>();
		map.put("name", "hiyond");
		map.put("age", "111");
		jedis.hmset("hiyondTest", map);
		System.out.println(jedis.hvals("hiyondTest"));
	}
	
}
