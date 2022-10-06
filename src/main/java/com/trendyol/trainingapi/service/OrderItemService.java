package com.trendyol.trainingapi.service;

import com.trendyol.trainingapi.controller.request.OrderItemModel;
import com.trendyol.trainingapi.controller.response.OrderItemInfo;
import com.trendyol.trainingapi.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderItemModel> getOrderItemsByOrderId(Long id) {
        return orderItemRepository.findOrderItemByOrderId(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderItemInfo> getOrderItemInfosByOrderId(Long id) {
        return orderItemRepository.findOrderItemByOrder_Id(id);
    }

}
