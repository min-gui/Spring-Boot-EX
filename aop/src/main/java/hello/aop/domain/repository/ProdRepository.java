package hello.aop.domain.repository;

import hello.aop.domain.entity.ProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdRepository extends JpaRepository<ProdEntity, Long> {

}
