package com.example.catchtable.service;

import com.example.catchtable.dto.reservation.PostReservationRequest;
import com.example.catchtable.dto.reservation.PostReservationResponse;
import com.example.catchtable.model.Reservation;
import com.example.catchtable.model.Restaurant;
import com.example.catchtable.repository.ReservationRepository;
import com.example.catchtable.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RestaurantRepository restaurantRepository;

    public PostReservationResponse saveReservation(PostReservationRequest reservationRequest, Long restaurantId) {

        Reservation reservation = reservationRepository.save(
                new Reservation(
                        reservationRequest.getDate(),
                        reservationRequest.getTime(),
                        reservationRequest.getCountPeople(),
                        getRestaurantById(restaurantId).get()
                )
        );

        return new PostReservationResponse(reservation.getReservationId());

    }

    private Optional<Restaurant> getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}