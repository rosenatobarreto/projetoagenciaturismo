package com.api.ekologictur.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.ekologictur.model.Pacote;
import com.api.ekologictur.service.PacoteService;

@RestController
@Controller
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@PostMapping(value="/pacote")
	public ResponseEntity<Pacote> createPacote(@RequestBody Pacote pacote) {
		try {
			Pacote pac = pacoteService.save(new Pacote(pacote.getNomePacote(), pacote.getEpoca(),
					pacote.getPreco(), pacote.getPeriodoEmDias()));
			return new ResponseEntity<>(pac, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value="/pacote/{id}")
	public ResponseEntity<HttpStatus> deletePacote(@PathVariable("id") long id) {
		try {
			pacoteService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="/pacote/{id}")
	public ResponseEntity<Pacote> getPacoteById(@PathVariable("id") long id) {
		Optional<Pacote> dadosPacote = pacoteService.findById(id);
		if (dadosPacote.isPresent()) {
			return new ResponseEntity<>(dadosPacote.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/pacotes")
	public ResponseEntity<List<Pacote>> getAllPacotes() {
		try {
			List<Pacote> pacotes = new ArrayList<Pacote>();

			if (pacotes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(pacotes, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value="/pacote/{id}")
	public ResponseEntity<Pacote> updatePacote(@PathVariable("id") long id, @RequestBody Pacote pacote) {
		Optional<Pacote> dadosPacote = pacoteService.findById(id);
		if (dadosPacote.isPresent()) {
			Pacote pac = dadosPacote.get();

			pac.setNomePacote(pacote.getNomePacote());
			pac.setEpoca(pacote.getEpoca());
			pac.setPreco(pacote.getPeriodoEmDias());
			pac.setDestinos(pacote.getDestinos());

			return new ResponseEntity<>(pacoteService.save(pac), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/pacotes", method=RequestMethod.GET)
    public ModelAndView getPacotes(){
        ModelAndView mv = new ModelAndView("pacotes");
        List<Pacote> pacotes = pacoteService.findAll();
        mv.addObject("pacotes", pacotes);
        return mv;
    }

	public Page<Pacote> findAllPorNomePacote(String nome, Pageable sortedByName) {
		return null;
	}

}
