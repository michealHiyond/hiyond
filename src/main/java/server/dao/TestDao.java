package server.dao;

import java.util.List;
import java.util.Map;

import server.entity.User;

public interface TestDao {
	
	List<User> queryUser();
	
	boolean insertUser(Map<String, Object> map);
	
}
