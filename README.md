
## 구현 내용

**1\. 환경**
* Spring Boot, JAVA 1.8, Gradle
* H2 ,JPA, JUnit5

**2\. Swagger& H2 console**
* swagger : http://localhost:8080/swagger-ui/index.html   ("http://localhost:8080/") 로 접근해도 reidect처리 하였기때문에 swagger화면으로이동
* H2 console : http://localhost:8080/fis

**3\. DB**
* mysql사용 (실구현:H2)
* hbm2ddl.auto: update 설정하여 프로젝트 실행시 자동 테이블생성, DDL을 이용하여 별도 스키마 생성 필요  X
* defer-datasource-initialization : true , data.sql로 기초데이터 생성 (기초데이터 값 크리에이터, 유튜브채널)