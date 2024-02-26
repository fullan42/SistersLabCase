package com.example.sisterslabapi.response.rating;

import lombok.Builder;

@Builder
public record CreateRatingResponse(

        Long userId,
        Double rating,
        Long movieId
) {
}
