package com.vcube.b32.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.b32.Exception.ResourseNotFoundException;
import com.vcube.b32.entity.StudentEntity;
import com.vcube.b32.studentserviceimpl.StudentServiceImpl;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private  StudentServiceImpl studentService;
	@PostMapping("/students")
     public StudentEntity createStudent(@Valid @RequestBody StudentEntity student) {
		System.out.println(student);
    	 return studentService.createStudent(student);
     }
	@GetMapping("/students")
	public List<StudentEntity> getAllStudents() {
	return studentService.getAll();
	}
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable(value="id") Long studentId) throws ResourseNotFoundException{
	StudentEntity student=studentService.findByStudentId(studentId) 
	.orElseThrow(()-> new ResourseNotFoundException("student not found on this id::"+studentId));
    return ResponseEntity.ok().body(student);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value="id")Long studentId,@Valid @RequestBody StudentEntity studentDetails)throws ResourseNotFoundException{
		 StudentEntity student=studentService.findByStudentId(studentId)
		.orElseThrow(()-> new ResourseNotFoundException("student not found by this id"+studentId));
		 student.setFirstname(studentDetails.getFirstname());
		 final StudentEntity updatedStudent=studentService.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
//	@DeleteMapping("/students/{id}")
//
//	public Map deleteStudent(@PathVariable(value = "id") Long studentId)
//
//	throws ResourseNotFoundException {
//
//	StudentEntity student = studentService.findByStudentId(studentId)
//
//	.orElseThrow(() -> new ResourseNotFoundException("Student not found for this id :: " + studentId));
//	studentService.delete(student);
//	Map response = new HashMap<>();
//	response.put("deleted", Boolean.TRUE);
//	return response;
//	}
 }

    
    
    
    
    
    
    
    
    