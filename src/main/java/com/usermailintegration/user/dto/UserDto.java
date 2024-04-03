package com.usermailintegration.user.dto;

import jakarta.validation.constraints.Email;

public record UserDto(
         String name,
        @Email String email
) {
}
