package server.service_m.service_mImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entity.Student;
import server.mapper.StudentDaoMapper;
import server.service_m.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDaoMapper studentDaoMapper;
	
	@Override
	public int queryStudentNum(Student student) throws Exception {
		return studentDaoMapper.queryStudentNum(student);
	}

	@Override
	public List<Student> findStudentByColumn(Student student) throws Exception {
		return studentDaoMapper.findStudentByColumn(student);
	}

	@Override
	public List<Student> queryStudent(Student student) throws Exception {
		return studentDaoMapper.queryStudent(student);
	}

}
