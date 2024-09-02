package hello.aop.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductRes {

    private String shopCode;
    private String prodName;
    private String prodCode;
    private String prodPrice;
}
