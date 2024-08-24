package com.myCompany.shop.item;

import com.myCompany.shop.item.Item;
import com.myCompany.shop.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public void saveItem(Item newItem) {
        if(newItem.getTitle().length() >= 100) {
            throw new ArrayIndexOutOfBoundsException("제목은 100자 이하로 작성 필요");
        }
        if(newItem.getPrice() < 0) {
            throw new IllegalArgumentException("가격은 0원 이상 해야함");
        }
        itemRepository.save(newItem);
    }
    public Optional<Item> findItem(Long id) {
        try {
            return itemRepository.findById(id);
        } catch(Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "해당 아이디로 된 item이 없어 에러 발생"
            );
        }
    }
}
