package com.example.catchtable.service;

import com.example.catchtable.dto.menu.PostMenuRequest;
import com.example.catchtable.dto.menu.PostMenuResponse;
import com.example.catchtable.model.Menu;
import com.example.catchtable.model.Restaurant;
import com.example.catchtable.repository.MenuRepository;
import com.example.catchtable.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public PostMenuResponse saveMenu(PostMenuRequest postMenuRequest, long restaurantId) {

        Menu menu = menuRepository.save(
                new Menu(
                        postMenuRequest.getName(),
                        postMenuRequest.getPrice(),
                        getRestaurantById(restaurantId).get()
                )
        );

        return new PostMenuResponse(menu.getMenuId());

    }

    private Optional<Restaurant> getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}
