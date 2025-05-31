package com.coudevi.web.controller;

import com.coudevi.application.service.IOrderService;
import com.coudevi.web.dto.OrderRequestDto;
import com.coudevi.web.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;
    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto requestDto) {
        return ResponseEntity.ok(orderService.createOrder(requestDto));
    }
}
