package com.myCompany.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public void saveItem(Item newItem) {
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
