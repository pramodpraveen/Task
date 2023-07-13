package com.task.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Number;

@Repository
public interface NumberRepo extends JpaRepository<Number, Integer> {

}
