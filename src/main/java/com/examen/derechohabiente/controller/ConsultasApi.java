package com.examen.derechohabiente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.derechohabiente.dto.DerechoHambienteDTO;
import com.examen.derechohabiente.entity.DerechoHabiente;
import com.examen.derechohabiente.response.ApiResponse;
import com.examen.derechohabiente.service.ConsultasService;


@RestController
@RequestMapping("/api")
public class ConsultasApi {
	@Autowired
	ConsultasService consultasService;

	@GetMapping("/derechohabiente/buscar")
	public ResponseEntity<List<DerechoHabiente>> buscar(@RequestParam String nombre) {
		List<DerechoHabiente> resultados = consultasService.buscar(nombre);
		if (resultados.isEmpty()) {
	        return ResponseEntity.notFound().build(); 
	    }
		return ResponseEntity.ok(resultados);		
		
	}
	
	@PutMapping("/derechohabiente/{id}")
	public ResponseEntity<ApiResponse> actualizaderechoHabiente(@PathVariable Long id, @RequestBody DerechoHambienteDTO dto) {
		ApiResponse response = new ApiResponse(consultasService.actualizaderechoHabiente(dto,id), "Item updated successfully");
        return ResponseEntity.ok(response);
		
	}
}
