package com.api.ekologictur.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.ekologictur.model.Destino;
import com.api.ekologictur.service.DestinoServiceImpl;

@RestController
@Controller
public class DestinoController {

	@Autowired
	private DestinoServiceImpl destinoServiceImpl;

	@PostMapping(value="/destino")
	public ResponseEntity<Destino> createDestino(@RequestBody Destino destino) {
		try {
			Destino dest = destinoServiceImpl.save(new Destino(null, destino.getNomeDestino(), destino.getLocalidade(),
					destino.getTipoDestino(), destino.getPacote()));
			return new ResponseEntity<>(dest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/destino/{id}")
	public ResponseEntity<HttpStatus> deleteDestino(@PathVariable("id") long id) {
		try {
			destinoServiceImpl.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/destino/{id}")
	public ResponseEntity<Destino> getDetinoById(@PathVariable("id") long id) {
		Optional<Destino> dadosDestino = destinoServiceImpl.findById(id);
		if (dadosDestino.isPresent()) {
			return new ResponseEntity<>(dadosDestino.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/destinos")
	public ResponseEntity<List<Destino>> getAllDestinos() {
		try {
			List<Destino> destinos = new ArrayList<Destino>();

			if (destinos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(destinos, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/destino/{id}")
	public ResponseEntity<Destino> updatePacote(@PathVariable("id") long id, @RequestBody Destino destino) {
		Optional<Destino> dadosDestino = destinoServiceImpl.findById(id);
		if (dadosDestino.isPresent()) {
			Destino dest = dadosDestino.get();

			dest.setNomeDestino(destino.getNomeDestino());
			dest.setLocalidade(destino.getLocalidade());
			dest.setTipoDestino(destino.getTipoDestino());
			dest.setPacote(destino.getPacote());

			return new ResponseEntity<>(destinoServiceImpl.save(dest), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
