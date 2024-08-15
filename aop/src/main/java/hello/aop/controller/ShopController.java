package hello.aop.controller;

import hello.aop.model.ShopProductRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShopController {

    @GetMapping("/shops/{shopCode}")
    @Operation(summary = "매장조회", description = "매장조회")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "매장 조회"
            ),
    })
    public ShopProductRes getShopProd(@PathVariable String shopCode){
        return ShopProductRes.builder()
                .shopCode(shopCode)
                .prodName("prodName")
                .prodCode("prodCode")
                .prodPrice("prodPrice")
                .build();

    }
}
