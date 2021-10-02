package com.example.pay.repository;

import com.example.pay.entity.ItemDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDetailRepository extends JpaRepository<ItemDetailEntity, Long> {

}
