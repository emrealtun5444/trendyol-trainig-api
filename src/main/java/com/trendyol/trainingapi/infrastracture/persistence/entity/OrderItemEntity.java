package com.trendyol.trainingapi.infrastracture.persistence.entity;

import com.trendyol.trainingapi.domain.entity.ItemCategory;
import com.trendyol.trainingapi.domain.entity.OrderItem;
import com.trendyol.trainingapi.infrastracture.persistence.entity.common.AbstractEntity;
import com.trendyol.trainingapi.infrastracture.persistence.entity.enm.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item", indexes = {
        @Index(name = "idx_order_item_order_id", columnList = "order_id"),
        @Index(name = "idx_order_item_product_code", columnList = "product_code")
})
public class OrderItemEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_id_gen")
    @SequenceGenerator(name = "order_item_id_gen", sequenceName = "order_item_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "product_code", length = 20)
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price", precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity")
    private Integer quantity;


    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public OrderItem toOrderItem() {
        return new OrderItem(id, ItemCategory.valueOf(category.name()), productCode, productName, price, quantity);
    }

}