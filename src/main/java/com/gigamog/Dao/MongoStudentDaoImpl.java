package com.gigamog.Dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gigamog.Entity.Student;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {

	Connection mongoConnection;
	
	@Override
	public Collection<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return new ArrayList<Student>(){
			{
				add(new Student(1, "Mario", "Nothing"));
			}
		};
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStudentById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

}
