package com.examen.derechohabiente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.derechohabiente.dto.DerechoHambienteDTO;
import com.examen.derechohabiente.entity.DerechoHabiente;
import com.examen.derechohabiente.repository.DerechoHabienteRepository;

@Service
public class ConsultasServiceImpl implements ConsultasService {
	@Autowired
	DerechoHabienteRepository derechoHabienteRepository;
	
	
	public List<DerechoHabiente> buscar(String nombre) {
		return derechoHabienteRepository.findByNombreIgnoreCase(nombre);
	}

	public boolean actualizaderechoHabiente(DerechoHambienteDTO dto,Long id) {
		Optional<DerechoHabiente> derechoHabienteOP = derechoHabienteRepository.findById(id);
		if(derechoHabienteOP.isPresent()) {
			DerechoHabiente derechoHabiente = derechoHabienteOP.get();
			derechoHabiente.setNombre(dto.getNombre());
			derechoHabiente.setImporte(dto.getImporte());
			derechoHabiente.setCiudad(dto.getCiudad());
			derechoHabienteRepository.save(derechoHabiente);
			return true;
		}
		return false;
	}

}
