package com.vcube.b32.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.b32.entity.StudentEntity;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>{

}
