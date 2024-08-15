package hello.aop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_test")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "gold_price", precision = 13, scale = 2)
    private BigDecimal goldPrice;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "ins_at")
    private LocalDateTime insAt;

    @Column(name = "upd_at")
    private LocalDateTime updAt;

}
