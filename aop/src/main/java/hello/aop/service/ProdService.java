package hello.aop.service;

import hello.aop.model.ShopProductRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdService {



    public ShopProductRes getShopProd(String shopCode, String prodCode, String serviceId) {




        return ShopProductRes.builder()
                .shopCode(shopCode)
                .prodCode(prodCode)
                .prodName("상품명")
                .prodPrice("10000")
                .build();

    }
}
