package ru.kpfu.itis.novikova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.novikova.model.Shop;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShopDto {

    private Long id;
    private String client_email;
    private String client_phone_number;
    private String client_book_name;


    public static ShopDto from(Shop shop) {
        return ShopDto.builder()
                .id(shop.getId())
                .client_email(shop.getClient_email())
                .client_phone_number(shop.getClient_phone_number())
                .client_book_name(shop.getClient_book_name())
                .build();
    }

    public static List<ShopDto> from(List<Shop> shops) {
        return shops.stream().map(ShopDto::from).collect(Collectors.toList());
    }
}
