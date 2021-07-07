package com.loca.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.loca.app.entity.UF;
@Repository
public interface UFRepository extends JpaRepository<UF, Integer> {

}