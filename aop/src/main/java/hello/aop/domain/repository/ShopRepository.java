package hello.aop.domain.repository;

import hello.aop.domain.entity.ProdEntity;
import hello.aop.domain.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface ShopRepository extends JpaRepository<ShopEntity, Long> {
}
