package com.example.moduleapi.service;

import com.example.moduleapi.exception.CustomException;
import com.example.modulecommon.domain.Member;
import com.example.modulecommon.enums.CodeEnum;
import com.example.modulecommon.repository.MemberRepository;
import com.example.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;



    private final CommonDemoService commonDemoService;

    private final MemberRepository memberRepository;

    public String save(){

        System.out.println("NAME : " + name);

        memberRepository.save(Member.builder()
                .name(Thread.currentThread().getName())
                .build());

        //common 모듈과의 의존성 설정 확인 (common 모듈의 순수 자바 객체)
        System.out.println(CodeEnum.SUCCESS.getCode());

        // ->
        // common 모듈의 component scan을 위해 application에서 공통의 경로 설정 필요.
        /**
         * common 모듈과의 의존성 설정 확인 (common 모듈의 bean 주입)
         * 이를 위해, (두가지 방법)
         * 1.common 모듈의 component scan을 위해 application에서 공통의 경로 설정
         * 2. !!!실무에선!!! @SpringBootApplication 어노테이션의 scanBasePackages에 빈으로 등록하고 싶은 하위 모듈의 경로 추가
         */
        System.out.println(commonDemoService.commonService());

        return "save";
    }

    public String find(){
        System.out.println("SIZE : "+  memberRepository.findAll().size());
        return "find";
    }

    public String exception(){
        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }

        return "exception";
    }

}
