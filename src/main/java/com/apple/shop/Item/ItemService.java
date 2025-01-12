package com.apple.shop.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public void saveItem(String title, int price) {
        validateItem(title, price);
        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setPrice(price);
        itemRepository.save(newItem);
    }

    public void editItem(Long id, String title, int price) {
        validateItem(title, price);
        Item newItem = new Item();
        newItem.setId(id);
        newItem.setTitle(title);
        newItem.setPrice(price);

        itemRepository.save(newItem);
    }

    private void validateItem(String title, int price) {
        if(price < 0) {
            throw new IllegalArgumentException("가격은 0원 이상이어야 합니다.");
        }
        if(title.length() > 100) {
            throw new IllegalArgumentException("상품명은 100자를 넘을 수 없습니다.");
        }
    }

    public Item findItem(Long id) {
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("해당하는 제품을 찾을 수 없습니다.");
    }
}
