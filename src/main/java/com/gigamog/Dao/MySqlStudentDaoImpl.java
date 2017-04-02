package com.gigamog.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.gigamog.Entity.Student;
@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class StudentRowMapper implements RowMapper<Student>{

		@Override
		public Student mapRow(ResultSet rs, int i) throws SQLException {
			// TODO Auto-generated method stub
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setCourse(rs.getString("course"));
			return student;
		}
		
	}
	
	@Override
	public Collection<Student> getAllStudents() {
		// TODO Auto-generated method stub
		final String query = "call select_students()";
		return jdbcTemplate.query(query, new StudentRowMapper());
	
	}

	@Override
	public Student getStudentById(int id) {
		final String query = "call selct_student_by_id(?)";
		return jdbcTemplate.queryForObject(query, new StudentRowMapper(),
		id);

	}

	@Override
	public void removeStudentById(Integer id) {
		final String query = "call delete_student(?)";
		jdbcTemplate.update(query, id);
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
		final String query = "call update_student(?,?,?)";
		jdbcTemplate.update(query, student.getId(), student.getName(), student.getCourse());
		
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		final String query = "call insert_student(?,?)";
		jdbcTemplate.update(query, student.getName(), student.getCourse());
		
	}

}
