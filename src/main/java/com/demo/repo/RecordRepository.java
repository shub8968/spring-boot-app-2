package com.demo.repo;

import com.demo.model.RedCarpet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface RecordRepository extends CrudRepository<RedCarpet, Long> {

}
