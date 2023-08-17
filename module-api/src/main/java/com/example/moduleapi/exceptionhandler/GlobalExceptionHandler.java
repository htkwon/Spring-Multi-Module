package com.example.moduleapi.exceptionhandler;

import com.example.moduleapi.exception.CustomException;
import com.example.moduleapi.response.CommonResponse;
import com.example.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice 어노테이션으로 어디선가 throw를 통해 에러가 잡히게 되면
 * Custom한 exception을 세팅을 해서 클라이언트와 규격을 정했던 CommonResponce 객체로 반환
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e){
        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    //아무리 꼼꼼하게 코딩하더라도 혹시 모를 Exception에 대비
    @ExceptionHandler(Exception.class)
    public CommonResponse handlerException(Exception e){
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }


}
