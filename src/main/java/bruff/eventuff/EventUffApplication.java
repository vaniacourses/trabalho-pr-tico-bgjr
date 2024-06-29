package bruff.eventuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "bruff.eventuff.model")
@EnableJpaRepositories(basePackages = "bruff.eventuff.repository")
public class EventUffApplication {
	//catalogo
	public static void main(String[] args) {
		SpringApplication.run(EventUffApplication.class, args);
	}

}
