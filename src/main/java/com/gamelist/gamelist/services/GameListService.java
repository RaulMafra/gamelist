package com.gamelist.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamelist.gamelist.dto.GameListDTO;
import com.gamelist.gamelist.entities.GameList;
import com.gamelist.gamelist.repositories.GameListRepository;

// registra o GameService como um componente do sistema

@Service // pode ser utilizado a annotation @Component ou @Service(para classes do tipo Services) para criação de componente
public class GameListService {
	
	// injetando uma instância do GameRepository no GameService
	@Autowired
	private GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();

	}
	

}
