package com.goormthon.memo_study.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),

    // 404 NOT_FOUND 잘못된 리소스 접근
    MEMO_NOT_FOUND(404, "존재하지 않는 메모 ID 입니다."),


    // 500 INTERNAL_SERVER_ERROR
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다.");


    private final Integer status;
    private final String message;
}
