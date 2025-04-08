package com.goormthon.memo_study.dto;

import com.goormthon.memo_study.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoResponseDto {
    private Long id;
    private String title;
    private String content;

}
