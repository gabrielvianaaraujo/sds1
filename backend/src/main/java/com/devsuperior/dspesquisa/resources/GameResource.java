package com.devsuperior.dspesquisa.resources;

import java.util.List;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/games")
public class GameResource {

    @Autowired
    private GameService service;

    @GetMapping
    public ResponseEntity<List<GameDTO>> getGames(){
        List<GameDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getGame(@PathVariable Long id){
        GameDTO gameDTO = service.findById(id);
        if(gameDTO != null){
            return ResponseEntity.ok().body(gameDTO);
        }
        else return ResponseEntity.notFound().build();
    }

}
