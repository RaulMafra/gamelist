package com.gamelist.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamelist.gamelist.dto.GameListDTO;
import com.gamelist.gamelist.entities.GameList;
import com.gamelist.gamelist.projections.GameMinProjection;
import com.gamelist.gamelist.repositories.GameListRepository;
import com.gamelist.gamelist.repositories.GameRepository;

// registra o GameService como um componente do sistema

@Service // pode ser utilizado a annotation @Component ou @Service(para classes do tipo Services) para criação de componente
public class GameListService {
	
	// injetando uma instância do GameRepository no GameListService
	@Autowired
	private GameListRepository gameListRepository;
	
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();

	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		

	}
	

}
