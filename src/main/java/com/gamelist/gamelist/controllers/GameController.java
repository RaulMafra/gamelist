package com.gamelist.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamelist.gamelist.dto.GameDTO;
import com.gamelist.gamelist.dto.GameMinDTO;
import com.gamelist.gamelist.services.GameService;

@RestController
@RequestMapping(value = "/games")
@Configuration
@ComponentScan("com.gamelist.gamelist.services") //Descarta a configuração xml em relação a verificação de componentes
public class GameController {

	// injetando uma instância do GameService no GameController
	@Autowired
	private GameService gameService;

	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}

}
