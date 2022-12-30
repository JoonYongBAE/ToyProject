package joonyong.toy.toyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //생성일자와 수정일자를 자동으로 등록을 하도록 해주는 어노테이션이다.
public class ToyProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToyProjectApplication.class, args);
    }

}
