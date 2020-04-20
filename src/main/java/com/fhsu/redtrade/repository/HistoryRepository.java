package com.fhsu.redtrade.repository;

import com.fhsu.redtrade.entity.History;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HistoryRepository extends CrudRepository<History, Integer> {
}
