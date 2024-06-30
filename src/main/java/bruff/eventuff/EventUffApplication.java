package bruff.eventuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("my.package.base.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EntityScan("my.package.base.*")   
// @EntityScan(basePackages = "bruff.eventuff.model")
// @EnableJpaRepositories(basePackages = "bruff.eventuff.repository")
public class EventUffApplication {
	//catalogo
	public static void main(String[] args) {
		SpringApplication.run(EventUffApplication.class, args);
	}

}
