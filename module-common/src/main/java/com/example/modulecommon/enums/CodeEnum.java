package com.example.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * module-api 에서 순수 자바 객체로 의존성 확인을 위한 클래스
 */


@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS("0000","SUCCESS"),
    UNKNOWN_ERROR("9999","UNKNOWN_ERROR");

    private String code;
    private String message;
}
