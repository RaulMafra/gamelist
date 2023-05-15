 package com.gamelist.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gamelist.gamelist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	//realiza consultas no banco H2
	
	@Modifying //utilizado para realizar modificações no banco (update, delete, etc)
	@Query(nativeQuery = true,
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
 	void updateBelongingPosition(Long listId, long gameId, Integer newPosition);
}
