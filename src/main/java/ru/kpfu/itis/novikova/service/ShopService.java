package ru.kpfu.itis.novikova.service;

import ru.kpfu.itis.novikova.dto.ShopDto;

import java.util.List;

public interface ShopService {
    List<ShopDto> getAllOrders();
    ShopDto addOrder(ShopDto shopDto);
    void deleteOrder(Long id);
}
