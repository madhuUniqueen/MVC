package com.vcube.b32.studentserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.b32.entity.StudentEntity;
import com.vcube.b32.repository.StudentRepository;
import com.vcube.b32.studentservice.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
   @Autowired
   private StudentRepository studentRepository;
	@Override
	public StudentEntity createStudent(StudentEntity student) {
		return studentRepository.save(student);
	}
	public List<StudentEntity> getAll() {
		return studentRepository.findAll();
	}
	public Optional<StudentEntity> findByStudentId(Long studentId) {
		return studentRepository.findById(studentId);
	}
	public StudentEntity save(StudentEntity student) {
		return studentRepository.save(student);
	}
	public void delete(StudentEntity student) {
	  studentRepository.delete(student);	
	}

}
