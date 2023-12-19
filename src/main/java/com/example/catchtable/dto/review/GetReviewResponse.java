package com.example.catchtable.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetReviewResponse {
    private Long reviewId;
    private String imageUrl;
    private String contents;
    private boolean isRevisit;
    private int rating;
    private Timestamp date;
    private String userName;
}
