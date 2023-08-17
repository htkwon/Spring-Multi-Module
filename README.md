# Spring-Multi-Module
멀티모듈 프로젝트 구축 및 프로젝트 안에서 Exception 핸들링, Profile 설정 연습

---

## 개발 구성
- Java 11
- Spring 2.7.4
- Gradle
- Lombok
- Spring JPA
- MySQL

---

## 개념


Multi Module -> N개의 Module이 조립되어 있는 프로젝트 
사용 이유 -> 다른 서버를 각각 독립적으로 관리한다면 중복해서 관리해야하므로 risk가 커진다

*하위 모듈인 module-common 모듈을 module-api 모듈에서 component scan 하기 위한 2가지 방법*
1. application 클래스에서 스캔하고하자 하는 모듈과의 경로 일치시키기.
2. @SpringBootApplication 어노테이션의 scanBasePackages에 빈으로 등록하고 싶은 하위 모듈의 경로 추가. (실무에선 이 방법 사용.)


Exeption 핸들링 -> 언어 혹은 프레임워크에서 발생한 Exception은 반드시 Custom하게 Wrapping하여 처리.
또한, @RestControllerAdvice 어노테이션을 사용하여 모든 예외를 해당 클래스에서 클라이언트와 사전에 정의한 값으로 재정의.


Gradle 또는 Maven 으로 배포 이유 -> 실제 운영서버는 인텔리제이의 도움을 빌릴 수 없고 JAR 파일을 넘겨서 실행.
<멀티모듈 프로젝트에서 Gradle 배포시 유의점> 
--> application 실행하기위한 의존성, 클래스, 리소스이 필요 없을 시, build.gradle 파일에서 tasks.bootJar false 설정 및 tasks.jar 설정 true (현 프로젝트에선 module-common 모듈 적용.)


Profile 이 필요한 이유 -> 환경별로 설정해야 하는 property 값들이 다르기 때문에.
방법
1. 환경별 Property 값 설정.
2. IntelliJ 실행 시 profile 적용 설정
3. JAR 실행 시 JVM 옵션으로 적용








 
