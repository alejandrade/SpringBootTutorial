package com.gigamog.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gigamog.Dao.StudentDao;
import com.gigamog.Entity.Student;

@Service
public class StudentService {
	@Autowired
	@Qualifier("mysql")
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	public  Student getStudentById(int id){
		return studentDao.getStudentById(id);
	}

	public void removeStudentById(Integer id) {
		this.studentDao.removeStudentById(id);
		
	}
	
	public void updateStudent(Student student){
		this.studentDao.updateStudent(student);
	
	}

	public void insertStudent(Student student) {
		this.studentDao.insertStudent(student);
		
	}


}
