package com.schedular.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.schedular.backend.model.Shift;

public interface ShiftRepository extends CrudRepository<Shift, Integer> {

}
