package com.examen.derechohabiente.service;

import java.util.List;

import com.examen.derechohabiente.dto.DerechoHambienteDTO;
import com.examen.derechohabiente.entity.DerechoHabiente;

public interface ConsultasService {

	List<DerechoHabiente> buscar(String nombre);

	boolean actualizaderechoHabiente(DerechoHambienteDTO dto,Long id);	

}
