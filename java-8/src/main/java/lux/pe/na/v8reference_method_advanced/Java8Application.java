package lux.pe.na.v8reference_method_advanced;

import lux.pe.na.v8reference_method_advanced.functions.Description;
import lux.pe.na.v8reference_method_advanced.functions.NumberUtils;
import lux.pe.na.v8reference_method_advanced.functions.SuperFlow;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;


@SpringBootApplication
public class Java8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

    Random random = new Random();

    @Override
    public void run(String... args) throws Exception {

        Integer total = SuperFlow.provide(10, this::randomInt)
                .filter(NumberUtils::prime)
                .order(Integer::compareTo)
                .transform(NumberUtils::squared)
                .transform(Description::new)
                .transform(Description::getValue)
                .sum(0, Integer::sum);
        System.out.println("La sum es: " + total);
    }

    private int randomInt() {
        return random.nextInt(10);
    }
}
