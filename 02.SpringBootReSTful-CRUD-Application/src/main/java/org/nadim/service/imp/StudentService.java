package org.nadim.service.imp;

import java.util.List;

import org.nadim.entity.Student;
import org.nadim.exception.StudentNotFoundException;
import org.nadim.repository.StudentRepository;
import org.nadim.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository repo;

	// 1. save operation
	@Override
	public Integer saveStudent(Student std) {
		std = repo.save(std);
		return std.getStdId();
	}

	// 2. get one student record
	@Override
	public Student getOneStudent(Integer id) {
		Student std = repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student " + id + " not found"));
		return std;
	}

	// 3. delete student record
	@Override
	public void deleteById(Integer id) {
		repo.delete(this.getOneStudent(id));
	}

	//4. update record
	@Override
	public void updateStudent(Student std) {
		if (std.getStdId() == null || !repo.existsById(std.getStdId())) {
			throw new StudentNotFoundException("Student " + std.getStdId() + " not found");
		} else {
			repo.save(std);
		}
	}

	//5. get all student records
	@Override
	public List<Student> getAllStudents() {
		List<Student> student = repo.findAll();
		return student;
	}

}
