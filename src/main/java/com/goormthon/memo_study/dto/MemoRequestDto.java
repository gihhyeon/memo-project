package com.goormthon.memo_study.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemoRequestDto {

    @NotBlank(message = "제목은 비워둘 수 없습니다.")
    @Schema(description = "메모 제목", example = "메모 제목입니다.")
    private String title;

    @Schema(description = "메모 내용", example = "메모 내용입니다.")
    private String content;
}
