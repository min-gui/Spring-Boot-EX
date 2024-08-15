package hello.aop.domain.repository;

import hello.aop.domain.entity.ProdEntity;
import hello.aop.domain.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface TestRepository extends JpaRepository<TestEntity, Long> {
}
