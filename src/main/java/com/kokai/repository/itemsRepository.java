package com.kokai.repository;

import com.kokai.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemsRepository extends JpaRepository<Items, Long> {
}
