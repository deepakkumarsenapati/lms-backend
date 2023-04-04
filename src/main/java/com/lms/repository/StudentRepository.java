package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Students;

public interface StudentRepository extends JpaRepository<Students,Integer >{

}
