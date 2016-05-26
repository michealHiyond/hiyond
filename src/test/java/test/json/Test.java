package test.json;

import java.util.Date;

import net.sf.json.JSONObject;
import server.entity.User;

public class Test {

	@org.junit.Test
	public void test01() {
		User user = new User();
		user.setId(1);
		user.setLastLoginTime(new Date());
		user.setName("hiyond");
		user.setPassword("123456");
		
		JSONObject json = JSONObject.fromObject(user);
		System.out.println(json);
		User user1 = (User) JSONObject.toBean(JSONObject.fromObject(json.toString()), User.class);
		System.out.println(user1);
	}

}
