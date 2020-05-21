package com.bangstagram.user.controller.dto.response;

import com.bangstagram.user.domain.model.user.User;
import lombok.Getter;

@Getter
public class JoinResponseDto {
    private final User user;

    private final String jwtToken;

    public JoinResponseDto(User user, String apiToken) {
        this.user = user;
        this.jwtToken = apiToken;
    }
}