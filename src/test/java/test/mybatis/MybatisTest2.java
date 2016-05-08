package test.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import server.entity.Student;
import server.service_m.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/springApplication.xml"})
public class MybatisTest2 {

	@Autowired
	private StudentService studentService;
	
	@Test
	public void testStudentService() throws Exception{
		Student student = new Student();
		System.out.println(studentService.findStudentByColumn(student));
	}
	
}
