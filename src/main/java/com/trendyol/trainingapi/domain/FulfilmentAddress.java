package com.trendyol.trainingapi.domain;

import com.trendyol.trainingapi.common.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fulfilment_address")
public class FulfilmentAddress extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fulfilment_address_id_gen")
    @SequenceGenerator(name = "fulfilment_address_id_gen", sequenceName = "fulfilment_address_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", length = 1024)
    private String address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "fulfilmentAddress", orphanRemoval = true)
    private Order order;

}