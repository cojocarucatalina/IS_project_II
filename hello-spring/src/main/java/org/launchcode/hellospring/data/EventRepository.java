package org.launchcode.hellospring.data;

import org.launchcode.hellospring.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {


}






