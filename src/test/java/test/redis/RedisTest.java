package test.redis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import core.redis.RedisCenter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import server.entity.User;

public class RedisTest {
	public JedisPool jedisPool = null;
	public Jedis jedis = null;

	{
		jedisPool = RedisCenter.getJedisPool();
		jedis = jedisPool.getResource();
	}

	public void returnResource(JedisPool jedisPool, Jedis jedis) {
		jedisPool.returnResource(jedis);
	}

	@Test
	public void testPing() {
		System.out.println(jedis.ping());
	}

	@Test
	public void TestKey() {
		System.out.println(jedis.ping());
		String result = jedis.set("hiyond", "hiyondTest");
		System.out.println(result);
		System.out.println(jedis.del("hiyond"));
		System.out.println(jedis.get("hiyond"));
	}

	@Test
	public void testList() {
		System.out.println(jedis.flushDB());
		jedis.lpush("hiyondTest", "1111", "5555");
		jedis.lpush("hiyondTest", "2222");
		jedis.lpush("hiyondTest", "3333");
		jedis.lpush("hiyondTest", "4444");
		System.out.println(jedis.lrange("hiyondTest", 0, -1));
	}

	@Test
	public void testMap() {
		// System.out.println(jedis.flushDB());
		Map<String, String> map = new HashMap<>();
		map.put("name", "hiyond");
		map.put("age", "111");
		jedis.hmset("hiyondTest", map);
		// System.out.println(map);
		System.out.println(jedis.hgetAll("hiyondTest"));
		User user = new User();
		user.setId(1);
		user.setName("123");
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("user", user.toString());
		jedis.hmset("userMap", userMap);
		System.out.println(jedis.hgetAll("userMap"));
		userMap = jedis.hgetAll("userMap");
		System.out.println(userMap);
	}

	@Test
	public void test() {
		String a = new String("123");
		String b = new String(a);
		a = new String("456");
		System.out.println(b);
		int a1 = 1;
		int b1 = a1;
		a1 = 3;
		System.out.println(b1);
	}

}
