package hello.aop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_prod")
public class ProdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "prod_cd", nullable = false, length = 50)
    private String prodCd;

    @Column(name = "prod_nm", nullable = false, length = 50)
    private String prodNm;

    @Column(name = "prod_desc", length = 100)
    private String prodDesc;

    @Column(name = "shop_cd", nullable = false, length = 10)
    private String shopCd;

    @Column(name = "img", length = 255)
    private String img;

    @Column(name = "ins_at", nullable = false, updatable = false)
    private LocalDateTime insAt;

    @Column(name = "ins_id", length = 50)
    private String insId;

    @Column(name = "upd_at", nullable = false)
    private LocalDateTime updAt;

    @Column(name = "upd_id", length = 50)
    private String updId;

}
