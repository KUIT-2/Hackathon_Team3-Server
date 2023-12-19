package com.example.catchtable.controller;

import com.example.catchtable.common.response.BaseResponse;
import com.example.catchtable.common.response.exception.ReservationException;
import com.example.catchtable.dto.reservation.PostReservationRequest;
import com.example.catchtable.dto.reservation.PostReservationResponse;
import com.example.catchtable.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.catchtable.common.response.status.BaseExceptionResponseStatus.INVALID_RESERVATION;
import static com.example.catchtable.util.BindingResultUtils.getErrorMessages;

@RestController
@RequestMapping("/restaurants/{restaurantId}/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public BaseResponse<PostReservationResponse> postReservation(@PathVariable long restaurantId, @Validated @RequestBody PostReservationRequest postReservationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ReservationException(INVALID_RESERVATION, getErrorMessages(bindingResult));
        }
        return new BaseResponse<>(reservationService.saveReservation(postReservationRequest, restaurantId));
    }
}
