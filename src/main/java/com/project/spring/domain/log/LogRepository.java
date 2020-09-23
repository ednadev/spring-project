package com.project.spring.domain.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    @Query("SELECT l FROM Log l ORDER BY l.id DESC")
    List<Log> findAllDesc();
}
