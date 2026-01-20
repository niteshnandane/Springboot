package in.sp.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.main.beans.Student;

@Configuration
public class AppConfig {
	
	@Bean
	public CommandLineRunner cmdCommandLineRunner() {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				studentbean().display();
				System.out.println(".....................................");
				studentbean2().display();
				
			}
		};
	}

	@Bean
	public Student studentbean() {
		return new Student("nitesh", 1010, 95.0f);
		
	}
	
	@Bean
	public Student studentbean2() {
		return new Student("Bhanu", 5362, 90.0f);
	}
}
