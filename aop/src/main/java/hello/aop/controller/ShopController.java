package hello.aop.controller;

import hello.aop.model.ShopProductRes;
import hello.aop.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShopController {


    private final ShopService shopService;

    /*
     * 3.0 @PathVariable(value = "shopCode") 이름 붙여 줘야 된다.
     */
    @GetMapping("/shops/{shopCode}")
    @Operation(summary = "매장조회", description = "매장조회")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "매장 조회"
            ),
    })
    public ShopProductRes getShop(@PathVariable(value = "shopCode") String shopCode,
                                  @RequestParam(value = "serviceId") String serviceId) {
        log.info("shopCode : {}", shopCode);
        log.info("serviceId : {}", serviceId);

        shopService.getShopInfo(shopCode, serviceId);
        return ShopProductRes.builder()
                .shopCode(shopCode)
                .prodName("prodName")
                .prodCode("prodCode")
                .prodPrice("prodPrice")
                .build();

    }

    @GetMapping("/shops/{shopCode}/prods/{prodCode}")
    @Operation(summary = "매장상품조회", description = "매장상품조회")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "매장 상품 조회"
            ),
    })
    public ShopProductRes getShopProd(@PathVariable(value = "shopCode") String shopCode,
                                      @PathVariable(value = "prodCode") String prodCode,
                                      @RequestParam(value = "serviceId") String serviceId) {
        log.info("shopCode : {} , prodCode : {} , serviceId : {}", shopCode, prodCode, serviceId);
        return ShopProductRes.builder()
                .shopCode(shopCode)
                .prodName("prodName")
                .prodCode("prodCode")
                .prodPrice("prodPrice")
                .build();

    }
}
