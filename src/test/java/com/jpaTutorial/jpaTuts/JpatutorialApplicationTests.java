package com.jpaTutorial.jpaTuts;

import com.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nest123")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity savedProductEntity= productRepository.save(productEntity);

		System.out.println(savedProductEntity);

	}

	@Test
	void getRepository(){
//		List<ProductEntity> entityList= productRepository.findByTitle("Pepasi");
//		System.out.println(entityList);

//		List<ProductEntity> entityList= productRepository.findByCreatedAtAfter(
//				LocalDateTime.of(2025,1,1,0,0,0)
//		);
//		System.out.println(entityList);

		List<ProductEntity> entityList= productRepository.findByQuantityAndPrice(3,BigDecimal.valueOf(16.3));
//		System.out.println(entityList);

//		List<ProductEntity> entityList= productRepository.findByQuantityGreaterThanOrPriceLessThan(3,BigDecimal.valueOf(16.3));
//		System.out.println(entityList);

//		List<ProductEntity> entityList= productRepository.findByTitleLike("%Choco%");
//		List<ProductEntity> entityList= productRepository.findByTitleContaining("Choco");
//		List<ProductEntity> entityList= productRepository.findByTitleContainingIgnoreCase("CHOco");


		System.out.println(entityList);
	}
}
