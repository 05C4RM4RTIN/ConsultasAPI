package com.examen.derechohabiente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examen.derechohabiente.entity.DerechoHabiente;
import java.util.List;


@Repository
public interface DerechoHabienteRepository extends JpaRepository<DerechoHabiente, Long>{
	
	List<DerechoHabiente>findByNombreIgnoreCase(String nombre);
	
}
