package com.gigamog.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.Collection;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gigamog.Entity.Student;
import com.gigamog.Exceptions.UnauthorizedHttpException;
import com.gigamog.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method= RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value = "/{id}",method= RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") Integer id){
		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "/{id}",method= RequestMethod.DELETE)
	public void deleteStudentById(@PathVariable("id") Integer id){
		studentService.removeStudentById(id);
	}
	

	
	@RequestMapping(method= RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public void insertStudent(@RequestBody Student student){
		studentService.insertStudent(student);
	}
	
	@RequestMapping(value = "/testError",method= RequestMethod.GET)
	public void testError(){
		throw new UnauthorizedHttpException("testing");
	}
}
