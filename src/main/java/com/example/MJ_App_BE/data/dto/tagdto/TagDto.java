package com.example.MJ_App_BE.data.dto.tagdto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TagDto {
    private Long tagId;
    private String tname;
}
