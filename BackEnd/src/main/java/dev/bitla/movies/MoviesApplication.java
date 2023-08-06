package dev.bitla.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController // Let's the class know that its a REST API controller and not any random class
public class MoviesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MoviesApplication.class, args);
	}

//	@GetMapping("/root")// This lets the framework know that the method apiRoot is a get endpoint.
//	public String apiRoot() {
//		return "Hello World";
//	}

}
