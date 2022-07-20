package springintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan("springintroduction")
public class MyConfig {

    @Bean
    @Scope("Singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    @Scope("Singleton")
    public Person personBean() {
        return new Person(catBean());
    }

}
