package hello.aop.domain.repository;

import hello.aop.domain.entity.ProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProdRepository extends JpaRepository<ProdEntity, Long> {
}
