package jose.as2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JustificativosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustificativosServiceApplication.class, args);
	}

}
