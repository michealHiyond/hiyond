package server.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import server.dao.UserDao;
import server.entity.User;

/**
 * 
 * @author Hiyond
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao{
	
	@Override
	public List<User> getUser() throws Exception {
		List<User> queryList = new ArrayList<User>();
		User user = null;
		for(int i = 0;i < 10;i++){
			user = new User();
			user.setId(i);
			user.setName("hiyond"+i);
			queryList.add(user);
		}
		return queryList;
	}

	@Override
	public List<User> queryUser() throws Exception {
		String sql = "select id, name,password,last_login_time from tb_user_info limit 10";
		List<User> queryList = getNamedJdbcTemplate().query(sql,new RowMapper<User>() {
			User user = null;
			@Override
			public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				return user;
			}
		});
		return queryList;
	}

	@Override
	public boolean insertUser(User user) throws Exception {
		String sql = "insert into tb_user_info(name,password,last_login_time)"+
						"values(:name,:password,:lastLoginTime)";
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
		int flag = getNamedJdbcTemplate().update(sql, sqlParameterSource);
		return flag > 0 ? true : false;
	}

	@Override
	public User findUserById(int id)  throws Exception {
		String sql = "select id, name,password,last_login_time from tb_user_info where id = :id";
		final User user = new User();
		getNamedJdbcTemplate().query(sql, new RowCallbackHandler() {
			public void processRow(ResultSet resultSet) throws SQLException {
				user.setName(resultSet.getString("name"));
				user.setPassword((resultSet.getString("password")));
				user.setLastLoginTime(resultSet.getDate("last_login_time"));
			}
		});
		return user;
	}

	@Override
	public int findUserByName(User user) throws Exception {
		String sql = "select count(*) from tb_user_info where name = :name";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		int num = getNamedJdbcTemplate().queryForObject(sql, paramSource, Integer.class);
		return num;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		String sql = "update tb_user_info set last_login_time = :lastLoginTime"+
					 " where name = :name";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		int flag = getNamedJdbcTemplate().update(sql, parameterSource);
		return flag > 0 ? true : false;
	}

	public int loginUser(User user)  throws Exception {
		String sql = "select count(*) from tb_user_info where name = :name and password = :password";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		int num = getNamedJdbcTemplate().queryForObject(sql, paramSource, Integer.class);
		return num;
	}
	
}
