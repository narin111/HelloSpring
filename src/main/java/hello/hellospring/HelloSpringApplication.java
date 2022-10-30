package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
	// 환경설정 성공
	// 어노테이션에 따라 스프링 부트 애플리케이션이 실행됨
	// 톰캣 웹 서버 내장하고 있음
	// 톰캣 웹 서버를 자체적으로 띄우면서 스프링 부트가 같이 올라감
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
// 요즘 인텔리제이를 쓰면 빌드가 gradle를 통해서 실행될 떄가 있는데
// preference 들어가서 gradle 검색 -> build and run using을 둘다 인텔리제이로 바꾸어준다.
// gradle을 통해서 실행하면 느린데, 설정을 바꾸어주면 인텔리제이에서 자바를 바로 띄워서 실행
// 속도 up!

// spring.io spring boot 들어가서 features에서 필요한 기능 검색
// 템플릿 엔진을 사용하면...

