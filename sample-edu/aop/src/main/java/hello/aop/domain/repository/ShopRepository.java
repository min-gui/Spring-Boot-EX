package hello.aop.domain.repository;

import hello.aop.model.Shop;

import java.util.List;

public interface ShopRepository {

    List<Shop> findShop(String ShopCd);
}
