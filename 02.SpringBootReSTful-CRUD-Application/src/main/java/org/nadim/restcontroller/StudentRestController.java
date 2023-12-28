package org.nadim.restcontroller;

import java.util.List;

import org.nadim.entity.Student;
import org.nadim.exception.StudentNotFoundException;
import org.nadim.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/v1/api/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;
	
	//1. save student
	@PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody Student std){
		Integer stdId = service.saveStudent(std);
		String message = "Student " +stdId + " Created";
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	// 2. fetch all students
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> allRecords(){
		List<Student> list = service.getAllStudents();
		return ResponseEntity.ok(list);
	}
	
	// 3. fetch one record by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStudentById(@PathVariable("id") Integer id){
		
		ResponseEntity<Student> response = null;
		try {
			Student student = service.getOneStudent(id);
			response = new ResponseEntity<Student>(student,HttpStatus.OK);
		}catch(StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
		}
		return response;
	}
	
	//4. delete record by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable("id") Integer id){
		ResponseEntity<String> response = null;
		try {
			service.deleteById(id);
			response = new ResponseEntity<String>("Student "+ id + " DELETED",HttpStatus.OK);
		}catch(StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
		}
		return response;
	}
	
	//5. update student record
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student std){
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(std);
			response = new ResponseEntity<String>("Student "+std.getStdId()+" UPDATED",HttpStatus.OK);
		}catch(StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
		}
		return response;
	}
	
}
