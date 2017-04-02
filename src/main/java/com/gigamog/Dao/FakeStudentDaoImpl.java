package com.gigamog.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gigamog.Entity.Student;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
	private static Map<Integer, Student> students;
	
	static{
		students = new HashMap<Integer, Student>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put(1, new Student(1, "Jason", "Chemistry"));
				put(2, new Student(2, "Ronals", "Finance"));
				put(3, new Student(3, "Pepe", "Economics"));
			}
		};
	}
	
	/* (non-Javadoc)
	 * @see com.gigamog.Dao.StudentDaoImpl#getAllStudents()
	 */
	@Override
	public Collection<Student> getAllStudents(){
		return FakeStudentDaoImpl.students.values();
	}
	
	/* (non-Javadoc)
	 * @see com.gigamog.Dao.StudentDaoImpl#getStudentById(int)
	 */
	@Override
	public  Student getStudentById(int id){
		return FakeStudentDaoImpl.students.get(id);
	}

	/* (non-Javadoc)
	 * @see com.gigamog.Dao.StudentDaoImpl#removeStudentById(java.lang.Integer)
	 */
	@Override
	public void removeStudentById(Integer id) {
		FakeStudentDaoImpl.students.remove(id);
		
	}
	
	/* (non-Javadoc)
	 * @see com.gigamog.Dao.StudentDaoImpl#updateStudent(com.gigamog.Entity.Student)
	 */
	@Override
	public void updateStudent(Student student){
		Student s = FakeStudentDaoImpl.students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
	
	}


	/* (non-Javadoc)
	 * @see com.gigamog.Dao.StudentDaoImpl#insertStudent(com.gigamog.Entity.Student)
	 */
	@Override
	public void insertStudent(Student student) {
		FakeStudentDaoImpl.students.put(student.getId(), student);
		
	}
}	
