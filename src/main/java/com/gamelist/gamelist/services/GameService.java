package com.gamelist.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamelist.gamelist.DTO.GameMinDTO;
import com.gamelist.gamelist.entities.Game;
import com.gamelist.gamelist.repositories.GameRepository;

// registra o GameService como um componente do sistema

@Service // pode ser utilizado a annotation @Component ou @Service(para classes do tipo Services) para criação de componente
public class GameService {
	
	// injetando uma instância do GameRepository no GameService
	@Autowired
	private GameRepository gameRespository;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRespository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();

	}
	

}
