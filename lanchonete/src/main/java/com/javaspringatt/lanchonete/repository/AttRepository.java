package com.javaspringatt.lanchonete.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspringatt.lanchonete.models.AttModel;


public interface AttRepository extends JpaRepository<AttModel,Integer>{
     List<AttModel> findByCategoriaAndDisponivelTrue(String categoria);

    

}
