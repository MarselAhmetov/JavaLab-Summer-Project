package ru.itis.javalabsummerproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InviteDto {
    private LocalDateTime inviteTime;
    private String text;
    private Long userId;
    private Long resumeId;
    private Long vacancyId;
}
