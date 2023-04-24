package ru.kpfu.itis.novikova.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.novikova.dto.ShopDto;
import ru.kpfu.itis.novikova.service.ShopService;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ShopRestController {

    private final ShopService ordersService;

    @GetMapping("orders/getAllOrders")
    public ResponseEntity<List<ShopDto>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @PostMapping(value ="orders/addOrder")
    public ResponseEntity<ShopDto> addOrders(@RequestBody ShopDto orderDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordersService.addOrder(orderDto));
    }

    @DeleteMapping("orders/deleteOrder/{order-id}")
    public void deleteOrder(@PathVariable("order-id") Long id) {
        ordersService.deleteOrder(id);
    }
}
