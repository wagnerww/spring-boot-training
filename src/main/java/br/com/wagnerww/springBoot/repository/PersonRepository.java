package br.com.wagnerww.springBoot.repository;

import br.com.wagnerww.springBoot.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
