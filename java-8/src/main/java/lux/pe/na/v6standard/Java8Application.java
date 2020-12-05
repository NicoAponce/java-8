package lux.pe.na.v6standard;

import lux.pe.na.v6standard.functions.SuperFlow;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Java8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        Integer total = SuperFlow.provide(10, () -> random.nextInt(10))
                .filter(value -> value % 2 == 0)
                .transform(value -> value * value)
                .sum(0, (value1, value2) -> value1 + value2);
        System.out.println("La sum es: " + total);
    }


}
