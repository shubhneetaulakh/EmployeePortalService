package com.socgen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.socgen.entity.EmployeeEntity;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String>, JpaSpecificationExecutor<EmployeeEntity>{

	List<EmployeeEntity> findAllByOrderByFirstNameAsc();
}

	