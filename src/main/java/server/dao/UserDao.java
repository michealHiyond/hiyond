package server.dao;

import java.util.List;

import server.entity.User;

public interface UserDao {

	List<User> getUser() throws Exception;
	
	List<User> queryUser() throws Exception;
	
	boolean insertUser(User user) throws Exception;
	
	User findUserById(int id) throws Exception;
	
	int findUserByName(User user) throws Exception;
	
	boolean updateUser(User user) throws Exception;
	
	int loginUser(User user) throws Exception;
}
