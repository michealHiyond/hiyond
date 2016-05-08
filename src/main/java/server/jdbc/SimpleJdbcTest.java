package server.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import server.properties.JdbcProperties;


public class SimpleJdbcTest {

	private final String driverClassName = JdbcProperties.getDriverClassName();
	
	private final String URL = JdbcProperties.getUrl();
	
	private final String userName = JdbcProperties.getUserName();
	
	private final String password = JdbcProperties.getPassword();
	
	private Connection connection;
	
	private PreparedStatement pStatement;
	
	private ResultSet resultSet;
	
	public void testConnection(){
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(URL,userName,password);
			connection.setAutoCommit(false);
			String sql = "select * from tb_user_info limit 10";
			pStatement = connection.prepareStatement(sql);
			resultSet = pStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("shop_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null){
					resultSet.close();
				}
			} catch (Exception e2) {
			}
			try {
				if(pStatement != null){
					pStatement.close();
				}
			} catch (Exception e2) {
			}
			try {
				if(connection != null){
					connection.close();
				}
			} catch (Exception e2) {
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SimpleJdbcTest().testConnection();
	}
	
}
