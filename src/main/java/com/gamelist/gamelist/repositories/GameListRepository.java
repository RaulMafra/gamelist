 package com.gamelist.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamelist.gamelist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

	//realiza consultas no banco H2
}
