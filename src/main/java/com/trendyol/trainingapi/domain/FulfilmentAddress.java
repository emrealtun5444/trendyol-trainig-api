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

    @Column(name = "address", length = 1024)
    private String address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "fulfilmentAddress", orphanRemoval = true)
    private Order order;

}