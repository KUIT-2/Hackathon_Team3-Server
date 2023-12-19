package com.example.catchtable.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
