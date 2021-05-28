package com.application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.dao.LogModel;

@Repository
public interface RepositoryClass extends JpaRepository<LogModel,String>{

	List<LogModel> findByDate(String date);

		
}
