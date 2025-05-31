package com.coudevi.application.service;

import com.coudevi.web.dto.OrderRequestDto;
import com.coudevi.web.dto.OrderResponseDto;

public interface IOrderService {
    OrderResponseDto createOrder(OrderRequestDto requestDto);

}
