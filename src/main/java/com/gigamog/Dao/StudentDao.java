package com.gigamog.Dao;

import java.util.Collection;

import com.gigamog.Entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	void removeStudentById(Integer id);

	void updateStudent(Student student);

	void insertStudent(Student student);

}