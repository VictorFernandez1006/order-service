package com.coudevi.application.mapper;

import com.coudevi.domain.model.Order;
import com.coudevi.web.dto.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto toResponseDto(Order order) {
        return OrderResponseDto.builder()
                .orderId(order.getId())
                .productId(order.getProductId())
                .productName(order.getProductName())
                .productPrice(order.getProductPrice())
                .build();
    }
}
