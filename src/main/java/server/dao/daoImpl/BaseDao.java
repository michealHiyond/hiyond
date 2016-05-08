package server.dao.daoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 
 * @author Hiyond
 *
 */
public abstract class BaseDao {

	@Autowired
	private DataSource dataSource;
	
	public NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
}
