package com.goormthon.memo_study.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemoRequestDto {

    @NotBlank(message = "제목은 비워둘 수 없습니다.")
    private String title;

    private String content;
}
