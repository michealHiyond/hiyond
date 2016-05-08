package server.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Hiyond
 *
 */
public class Student implements Serializable{

	private static final long serialVersionUID = 6221120281516069608L;
	
	private long studentId;
	
	private String studentName;
	
	private String studentSex;
	
	private Date studentBirthday;
	
	private int classId;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentSex=" + studentSex
		        + ", studentBirthday=" + studentBirthday + ", classId=" + classId + "]";
	}

}
