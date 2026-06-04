package java.com.trip.user.dto;

import lombok.Builder;

import java.com.trip.user.entity.enums.UserRole;

@Builder
public record CustomUserInfoDto(

        Long userId,
        String email,
        String nickname,
        UserRole userRole
) {
}
