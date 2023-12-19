package com.example.catchtable.controller;

import com.example.catchtable.common.response.BaseResponse;
import com.example.catchtable.common.response.exception.MenuException;
import com.example.catchtable.dto.menu.PostMenuRequest;
import com.example.catchtable.dto.menu.PostMenuResponse;
import com.example.catchtable.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.catchtable.common.response.status.BaseExceptionResponseStatus.INVALID_MENU;
import static com.example.catchtable.util.BindingResultUtils.getErrorMessages;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/restaurants/{restaurantId}/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public BaseResponse<PostMenuResponse> saveMenu(@PathVariable long restaurantId, @Validated @RequestBody PostMenuRequest postMenuRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new MenuException(INVALID_MENU, getErrorMessages(bindingResult));
        }
        return new BaseResponse<>(menuService.saveMenu(postMenuRequest, restaurantId));
    }
}
