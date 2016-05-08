package server.service_m;

import java.util.List;

import server.entity.Student;

/**
 * 
 * @author Hiyond
 *
 */
public interface StudentService {
	
	int queryStudentNum(Student student) throws Exception;
	
	List<Student> findStudentByColumn(Student student) throws Exception;
	
	List<Student> queryStudent(Student student) throws Exception;
	
}
