package com.example.MJ_App_BE.data.dto.usertagdto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserTagDto {

    private Long userId;
    private List<Long> tagIds;
}
