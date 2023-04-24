package ru.kpfu.itis.novikova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.novikova.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
