package hello.aop.domain.repository;

import hello.aop.domain.entity.ProdEntity;
import hello.aop.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<UserEntity, Long> {
}
