package com.example.catchtable.service;

import com.example.catchtable.dto.menu.GetRestaurantMenuResponse;
import com.example.catchtable.dto.menu.MenuDto;
import com.example.catchtable.dto.reservation.GetRestaurantReservationsResponse;
import com.example.catchtable.dto.restaurant.*;
import com.example.catchtable.dto.restaurantImage.GetRestaurantImagesResponse;
import com.example.catchtable.dto.review.GetReviewResponse;
import com.example.catchtable.model.Reservation;
import com.example.catchtable.model.Restaurant;
import com.example.catchtable.model.Review;
import com.example.catchtable.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public GetRestaurantListResponse getRestaurantList() {
        List<GetBriefRestaurantResponse> restaurantList = restaurantRepository.findAll()
                .stream()
                .map(restaurant -> new GetBriefRestaurantResponse(
                        restaurant.getRestaurantId(),
                        restaurant.getRestaurantImages().get(0).getUrl(),
                        restaurant.getName(),
                        // 가정: 별점은 별도의 계산 또는 필드를 통해 가져옵니다.
                        calculateStarCount(restaurant),
                        restaurant.getCategory(),
                        restaurant.getRegion()))
                .collect(Collectors.toList());

        return new GetRestaurantListResponse(restaurantList);
    }

    public GetRestaurantResponse getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<String> restaurantImages = restaurant.getRestaurantImages()
                .stream()
                .map(restaurantImage -> restaurantImage.getUrl())
                .collect(Collectors.toList());

        List<MenuDto> menuList = restaurant.getMenus()
                .stream()
                .map(menu -> new MenuDto(menu.getName(), menu.getPrice()))
                .collect(Collectors.toList());

        return new GetRestaurantResponse(
                restaurantImages,
                restaurant.getCategory(),
                restaurant.getRegion(),
                restaurant.getName(),
                calculateStarCount(restaurant),
                restaurant.getBriefInfo(),
                restaurant.getLunchPrice(),
                restaurant.getDinnerPrice(),
                menuList,
                restaurant.getAddress(),
                restaurant.getPhoneNumber(),
                restaurant.getDescription(),
                restaurant.getOperatingHour(),
                restaurant.getRegularClosed()
        );
    }

    private double calculateStarCount(Restaurant restaurant) {
        // 별점 계산 로직 구현
        List<Review> reviews = restaurant.getReviews();
        double sum = 0;
        int count = 0;
        for (Review review : reviews) {
            sum += review.getRating();
            count++;
        }
        sum /= count;
        return sum; // 임시 반환값
    }


    public List<GetRestaurantMenuResponse> getMenuList(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).
                orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return restaurant.getMenus().stream()
                .map(menu -> new GetRestaurantMenuResponse(
                        menu.getName(),
                        menu.getPrice()))
                .collect(Collectors.toList());
    }

    public List<GetRestaurantImagesResponse> getRestaurantImageList(long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).
                orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return restaurant.getRestaurantImages().stream()
                .map(image -> new GetRestaurantImagesResponse(image.getUrl()))
                .collect(Collectors.toList());
    }

    public List<GetReviewResponse> getReviews(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).
                orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return restaurant.getReviews().stream()
                .map(review -> new GetReviewResponse(
                        review.getReviewId(),
                        review.getImageUrl(),
                        review.getContents(),
                        review.getIsRevisit(),
                        review.getRating(),
                        review.getDate(),
                        review.getUser().getName()))
                .collect(Collectors.toList());
    }

    public GetRestaurantReservationsResponse getReservations(long restaurantId, String date) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<Timestamp> occupiedTimes = restaurant.getReservations().stream()
                .filter(reservation -> isSameDay(reservation.getDate(), date))
                .map(Reservation::getTime) // 예약된 시간을 리스트에 추가합니다.
                .collect(Collectors.toList());

        return new GetRestaurantReservationsResponse(
                restaurant.getLunchStart(),
                restaurant.getLunchEnd(),
                restaurant.getDinnerStart(),
                restaurant.getDinnerEnd(),
                occupiedTimes);
    }

    private boolean isSameDay(Timestamp timestamp, String inputDateString) {
        LocalDate reservationDate = timestamp.toInstant().atZone(ZoneId.of("UTC")).toLocalDate();

        LocalDate inputDate = LocalDate.parse(inputDateString);

        return reservationDate.isEqual(inputDate);
    }


    public PostRestaurantResponse saveRestaurant(PostRestaurantRequest postRestaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(
                new Restaurant(
                        postRestaurantRequest.getCategory(),
                        postRestaurantRequest.getRegion(),
                        postRestaurantRequest.getAddress(),
                        postRestaurantRequest.getName(),
                        postRestaurantRequest.getBriefInfo(),
                        postRestaurantRequest.getLunchPrice(),
                        postRestaurantRequest.getPhoneNumber(),
                        postRestaurantRequest.getDescription(),
                        postRestaurantRequest.getOperatingHour(),
                        postRestaurantRequest.getRegularClosed(),
                        postRestaurantRequest.getDinnerPrice(),
                        postRestaurantRequest.getLunchStart(),
                        postRestaurantRequest.getLunchEnd(),
                        postRestaurantRequest.getDinnerStart(),
                        postRestaurantRequest.getDinnerEnd()
                )
        );
        return new PostRestaurantResponse(restaurant.getRestaurantId());
    }


//    public PostReservationResponse postReservation(PostReservationRequest postReservationRequest, long restaurantId) {
//        Restaurant restaurant = restaurantRepository.findById(restaurantId).
//                orElseThrow(() -> new RuntimeException("Restaurant not found"));
//
//
//    }
}

