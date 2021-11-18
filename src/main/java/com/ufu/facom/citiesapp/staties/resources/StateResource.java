package com.ufu.facom.citiesapp.staties.resources;

import com.ufu.facom.citiesapp.staties.entities.State;
import com.ufu.facom.citiesapp.staties.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {
    private final StateRepository repository;


    public StateResource(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> stateList() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<State> optional = repository.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else
            return ResponseEntity.notFound().build();

    }
}
