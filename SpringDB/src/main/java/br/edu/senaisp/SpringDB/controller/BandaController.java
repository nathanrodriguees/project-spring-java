package br.edu.senaisp.SpringDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.SpringDB.repository.BandaRepository;

@RestController
@RequestMapping("/banda")
public class BandaController {

	@Autowired
	BandaRepository repository;

	@GetMapping("/lista")
	public String ListaBandas() {

		return repository.lista().get(0).getNome();
	}
}
