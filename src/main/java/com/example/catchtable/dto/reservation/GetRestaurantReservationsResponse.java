package com.example.catchtable.dto.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetRestaurantReservationsResponse {

    private Timestamp lunchStart;
    private Timestamp lunchEnd;
    private Timestamp dinnerStart;
    private Timestamp dinnerEnd;

    private List<Timestamp> occupiedTime;
}
