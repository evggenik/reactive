package com.evggenn.reactive;

import com.evggenn.reactive.student.Student;
import com.evggenn.reactive.student.StudentRepository;
import com.evggenn.reactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveAppApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(
			StudentRepository repository
	) {
		return args->{
			for (int i=0;i<100;i++) {
				repository.save(Student.builder()
								.firstname("Wasya " + i)
								.lastname("Vasechkin " + i)
								.age(i)
						.build()).subscribe();
			}
		};
	}

}
