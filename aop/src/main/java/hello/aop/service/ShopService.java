package hello.aop.service;

import hello.aop.annotation.ShopValidation;
import hello.aop.domain.repository.ShopRepository;
import hello.aop.domain.repository.ShopV1Repository;
import hello.aop.domain.repository.ShopV2Repository;
import hello.aop.model.Shop;
import hello.aop.model.ShopVO;
import hello.aop.sample.exam.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor()
public class ShopService {

    private final ShopV1Repository shopV1Repository;
    private final ShopV2Repository shopV2Repository;




    @ShopValidation
    public void getShopInfo(String shopCd, String serviceId) {
        ShopRepository shopRepository = getShopRepository(serviceId);

        List<Shop> list = shopRepository.findShop(shopCd);
        list.forEach(shop -> log.info("shop info : {}", shop.getShopNm()));
        log.info("shop info : {}", list.size());
    }

    public ShopRepository getShopRepository(String serviceId) {
        ShopRepository shopRepository = null;
        if ("V1".equals(serviceId)){
            shopRepository = shopV1Repository;
        } else if ("V2".equals(serviceId)){
            shopRepository = shopV2Repository;
        }
        return shopRepository;
    }

}
