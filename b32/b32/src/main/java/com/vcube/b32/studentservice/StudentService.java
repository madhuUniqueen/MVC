package com.vcube.b32.studentservice;

import java.util.List;

import com.vcube.b32.entity.StudentEntity;

public interface StudentService {
   public StudentEntity createStudent(StudentEntity student);
   public List<StudentEntity> getAll();
}
