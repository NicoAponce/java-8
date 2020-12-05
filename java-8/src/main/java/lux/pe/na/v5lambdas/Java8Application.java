package lux.pe.na.v5lambdas;

import lux.pe.na.v5lambdas.functions.SuperFlow;
import lux.pe.na.v5lambdas.interfaces.IOperatorBinary;
import lux.pe.na.v5lambdas.interfaces.IOperatorFunction;
import lux.pe.na.v5lambdas.interfaces.IPredicate;
import lux.pe.na.v5lambdas.interfaces.IProvider;
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
        Integer total = new SuperFlow<>(List.of(1, 2, 3, 4, 5))
                .filter(value -> value % 2 == 0)
                .transform(value -> value * value)
                .sum(0, (value1, value2) -> value1 + value2);
        System.out.println("La sum es: " + total);
    }


}
