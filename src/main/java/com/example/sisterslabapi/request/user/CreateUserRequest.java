package com.example.sisterslabapi.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public record CreateUserRequest(

         @NotBlank String name,

         @NotBlank String username,

         @NotBlank String email,

         @NotBlank String password
) {
}
