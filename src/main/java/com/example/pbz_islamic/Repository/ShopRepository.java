package com.example.pbz_islamic.Repository;

import com.example.pbz_islamic.Model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
