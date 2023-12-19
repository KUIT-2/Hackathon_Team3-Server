package com.example.catchtable.controller;

import com.example.catchtable.common.response.BaseResponse;
import com.example.catchtable.common.response.exception.ReservationException;
import com.example.catchtable.common.response.exception.UserException;
import com.example.catchtable.dto.reservation.PostReservationRequest;
import com.example.catchtable.dto.reservation.PostReservationResponse;
import com.example.catchtable.dto.user.PostUserRequest;
import com.example.catchtable.dto.user.PostUserResponse;
import com.example.catchtable.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.catchtable.common.response.status.BaseExceptionResponseStatus.INVALID_RESERVATION;
import static com.example.catchtable.common.response.status.BaseExceptionResponseStatus.INVALID_USER_VALUE;
import static com.example.catchtable.util.BindingResultUtils.getErrorMessages;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public BaseResponse<PostUserResponse> saveUser(@Validated @RequestBody PostUserRequest postUserRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserException(INVALID_USER_VALUE, getErrorMessages(bindingResult));
        }
        return new BaseResponse<>(userService.saveUser(postUserRequest));
    }

}
