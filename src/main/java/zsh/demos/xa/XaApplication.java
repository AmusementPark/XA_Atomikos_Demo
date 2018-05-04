package zsh.demos.xa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ 
	@PropertySource(value="classpath:application.properties", ignoreResourceNotFound=true)
})
public class XaApplication {
	public static void main(String[] args) {
		SpringApplication.run(XaApplication.class, args);
	}
}
