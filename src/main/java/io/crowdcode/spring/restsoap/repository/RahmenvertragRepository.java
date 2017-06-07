package io.crowdcode.spring.restsoap.repository;

import io.crowdcode.spring.restsoap.model.Rahmenvertrag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by idueppe on 06.06.17.
 */
public interface RahmenvertragRepository extends JpaRepository<Rahmenvertrag, Long> {

    Rahmenvertrag findByName(String name);

    List<Rahmenvertrag> findByTyp(String typ);
}
