package br.com.wagnerww.springBoot.services;

import br.com.wagnerww.springBoot.converter.DozerConverter;
import br.com.wagnerww.springBoot.data.vo.PersonVO;
import br.com.wagnerww.springBoot.exception.ResourceNotFoundException;
import br.com.wagnerww.springBoot.data.model.Person;
import br.com.wagnerww.springBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.paseObject(person, Person.class);
        var vo = DozerConverter.paseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = repository.save(entity);
        return DozerConverter.paseObject(vo, PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

    public PersonVO findById(Long id) {

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return DozerConverter.paseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        var list = repository.findAll();

        return DozerConverter .paseListObjects(list, PersonVO.class);

    }


}
