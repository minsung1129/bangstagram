package com.bangstagram.timeline.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class TimelineResponseDto {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private Long userId;
    private Long roomId;

    @Builder
    public TimelineResponseDto(Long id, String title, String body, LocalDateTime createdAt, Long userId, Long roomId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.userId = userId;
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "TimelineResponseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createdAt=" + createdAt +
                ", userId=" + userId +
                ", roomId=" + roomId +
                '}';
    }
}
