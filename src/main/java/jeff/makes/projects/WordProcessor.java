package jeff.makes.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WordProcessor {

    public static void main (String... args){
        SpringApplication.run(WordProcessor.class);
    }
}
