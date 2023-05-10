package com.gamelist.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamelist.gamelist.dto.GameListDTO;
import com.gamelist.gamelist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	// injetando uma instância do GameService no GameController
	@Autowired
	private GameListService gameListService;

	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

}
