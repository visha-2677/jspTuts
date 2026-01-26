package com.jpaTutorial.jpaTuts.repositories;

import com.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
//    List<ProductEntity> findByTitleOrderByPrice(String title);
//    List<ProductEntity> findByOrderByPrice();
    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime of);

//    List<ProductEntity> findByQuantityAndPrice(int i, BigDecimal bigDecimal);
//   @Query("select e from ProductEntity e where e.quantity=?1 and e.price=?2")
   @Query("select e from ProductEntity e where e.quantity=:quantity and e.price=:bigDecimal")
    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByTitleLike(String s);

    List<ProductEntity> findByTitleContaining(String s);

    List<ProductEntity> findByTitleContainingIgnoreCase(String string, Pageable pageable);
}
