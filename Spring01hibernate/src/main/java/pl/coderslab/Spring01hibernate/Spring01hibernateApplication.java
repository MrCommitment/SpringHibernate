package pl.coderslab.Spring01hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Spring01hibernateApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Spring01hibernateApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Spring01hibernateApplication.class);
	}

}
