package hello.itemservice.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.itemservice.domain.Item;
import java.util.*;
public interface SpringDataJapItemRepository extends JpaRepository<Item, Long> {   // 관리할 엔티티와 PK 타입

	List<Item> findByItemNameLike(String itemName);
	List<Item> findByPriceLessThanEqual(Integer price);

	//쿼리 메서드 (아래 메서드와 같은 기능 수행)
	List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);

	//쿼리 직접 실행
	@Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
		List<Item> findItems(@Param("itemName") String itemName, @Param("price")
		Integer price);
}
