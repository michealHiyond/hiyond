package server.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.dao.UserDao;
import server.entity.User;
import server.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUser() throws Exception {
		return userDao.getUser();
	}

	@Override
	public List<User> queryUser() throws Exception {
		return userDao.queryUser();
	}


	@Override
	public boolean insertUser(User user) throws Exception {
		return userDao.insertUser(user);
	}

	@Override
	public User findUserById(int id) throws Exception {
		return userDao.findUserById(id);
	}

	@Override
	public int findUserByName(User user) throws Exception {
		return userDao.findUserByName(user);
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	public int loginUser(User user) throws Exception {
		return userDao.loginUser(user);
	}

}
