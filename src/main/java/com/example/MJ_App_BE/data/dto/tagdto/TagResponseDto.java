package com.example.MJ_App_BE.data.dto.tagdto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TagResponseDto {
    private List<TagDto> tags;
}
