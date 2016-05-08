package test.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import server.entity.Student;
import server.mapper.StudentDaoMapper;

/**
 * 
 * @author Hiyond
 *
 */
public class MybatisTest {

	private static SqlSessionFactory sqlSessionFactory;
	
	 private static Reader reader; 
	 
	 static {
		 try {
			 reader = Resources.getResourceAsReader("mybatis/mybatis_config.xml");
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public SqlSessionFactory getSqlSession(){
		 return sqlSessionFactory;
	 }
	 
	 public static void main(String[] args) {
		 SqlSession session = sqlSessionFactory.openSession();
		 try {
			 StudentDaoMapper studentDaoMapper = session.getMapper(StudentDaoMapper.class);
			 Student student = new Student();
			 List<Student> studentList = studentDaoMapper.findStudentByColumn(student);
			 System.out.println(studentList);
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		}
	}
	
}
