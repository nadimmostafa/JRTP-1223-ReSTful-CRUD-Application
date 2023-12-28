package org.nadim.service;

import java.util.List;

import org.nadim.entity.Student;


public interface IStudentService {
	//1. save student data
	public Integer saveStudent(Student std);
	
	//2. fetch one student data
	public Student getOneStudent(Integer id);
	
	//3. Delete student record
	public void deleteById(Integer id);
	
	//4. update student record
	public void updateStudent(Student std);
	
	// 5. fetch all student records
	public List<Student> getAllStudents();
}
