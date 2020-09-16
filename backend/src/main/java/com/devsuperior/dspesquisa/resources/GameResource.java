package com.devsuperior.dspesquisa.resources;

import java.util.List;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

    @Autowired
    private GameService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GameDTO>> getGames(){
        List<GameDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
