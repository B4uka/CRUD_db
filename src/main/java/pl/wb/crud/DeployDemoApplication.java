package pl.wb.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DeployDemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DeployDemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DeployDemoApplication.class, args);
	}
}
// without extending SpringBootServletInitializer, App is not working on my computer, but is working on remote server
//https://stackoverflow.com/questions/48047909/why-it-is-necessary-to-extendspringbootservletinitializer-while-deploying-it-t