package com.coudevi.application.service.impl;

import com.coudevi.application.client.ProductClient;
import com.coudevi.application.dto.ProductDto;
import com.coudevi.application.kafka.KafkaProducerService;
import com.coudevi.application.mapper.OrderMapper;
import com.coudevi.application.service.IOrderService;
import com.coudevi.domain.event.OrderCreatedEvent;
import com.coudevi.domain.model.Order;
import com.coudevi.domain.repository.IOrderRepository;
import com.coudevi.web.dto.OrderRequestDto;
import com.coudevi.web.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IOrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductClient productClient;
    private final KafkaProducerService kafkaProducerService;
    @Override
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        ProductDto product = productClient.getProductById(requestDto.getProductId());
        if (product == null || product.getId() == null){
            throw new IllegalArgumentException("Product not found!");
        }
        Order order = Order.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .build();

        Order saved = orderRepository.save(order);
        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId(saved.getId())
                .productId(saved.getProductId())
                .build();
        kafkaProducerService.sendOrderCreatedEvent(event);

        return orderMapper.toResponseDto(saved);
    }
}
