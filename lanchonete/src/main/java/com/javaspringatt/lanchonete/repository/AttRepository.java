package com.javaspringatt.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspringatt.lanchonete.models.AttModel;

public interface AttRepository extends jpaRepository<AttModel,Integer>{

}
