package sarantis.antonakas.springbike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("sarantis.antonakas.*")
@EntityScan("sarantis.antonakas.entity")
@EnableJpaRepositories("sarantis.antonakas.repository")
@EnableSwagger2
public class SpringbikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbikeApplication.class, args);
	}

}
