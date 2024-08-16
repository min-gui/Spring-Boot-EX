package hello.aop.domain.repository;

import hello.aop.domain.entity.ShopEntity;
import hello.aop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopV1Repository extends JpaRepository<ShopEntity, Long>, ShopRepository {

    @Override
    @Query(value = "SELECT " +
            "shop_cd as shopCd," +
            "shop_nm as shopNm," +
            "address as address," +
            "phone_number as phoneNumber," +
            "ins_at as insAt," +
            "upd_at as updAt " +
            "FROM tb_shop " +
            "WHERE shop_cd = :shopCd", nativeQuery = true)
    List<Shop> findShop(@Param("shopCd") String shopCd);

}
