package ru.kpfu.itis.novikova.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.novikova.dto.ShopDto;
import ru.kpfu.itis.novikova.model.Shop;
import ru.kpfu.itis.novikova.repositories.ShopRepository;
import ru.kpfu.itis.novikova.service.ShopService;

import static ru.kpfu.itis.novikova.dto.ShopDto.from;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public List<ShopDto> getAllOrders() {
        return from(shopRepository.findAll());
    }

    @Override
    public ShopDto addOrder(ShopDto shopDto) {
        return from(shopRepository.save(
                Shop.builder()
                        .client_email(shopDto.getClient_email())
                        .client_phone_number(shopDto.getClient_phone_number())
                        .client_book_name(shopDto.getClient_book_name())
                        .build()));
    }

    @Override
    public void deleteOrder(Long id) {
        Shop order = shopRepository.getById(id);
        shopRepository.delete(order);
    }
}
