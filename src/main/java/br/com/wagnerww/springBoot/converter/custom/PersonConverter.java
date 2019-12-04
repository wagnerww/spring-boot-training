package br.com.wagnerww.springBoot.converter.custom;

import br.com.wagnerww.springBoot.data.model.Person;
import br.com.wagnerww.springBoot.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {
    public PersonVOV2 converterEntityToVO(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthday(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person converterVOToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        return entity;
    }

}
