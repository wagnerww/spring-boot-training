package br.com.wagnerww.springBoot.controller;

import br.com.wagnerww.springBoot.data.vo.PersonVO;
import br.com.wagnerww.springBoot.data.vo.v2.PersonVOV2;
import br.com.wagnerww.springBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService services;

    @GetMapping
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return services.create(person);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return services.createV2(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }

}
