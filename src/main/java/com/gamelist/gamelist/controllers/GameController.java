package com.gamelist.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamelist.gamelist.DTO.GameMinDTO;
import com.gamelist.gamelist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	// injetando uma instância do GameService no GameController
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}

}