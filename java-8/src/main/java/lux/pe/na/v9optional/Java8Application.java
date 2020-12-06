package lux.pe.na.v9optional;

import lux.pe.na.v9optional.functions.Description;
import lux.pe.na.v9optional.functions.NumberUtils;
import lux.pe.na.v9optional.functions.SuperFlow;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.Optional;
import java.util.Random;


@SpringBootApplication
public class Java8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

    Random random = new Random();

    @Override
    public void run(String... args) throws Exception {

        SuperFlow.provide(10, this::randomInt)
                .filter(value -> value >= 0)
                .order(Integer::compareTo)
                .transform(NumberUtils::squared)
                .transform(Description::new)
                .transform(Description::getValue)
                .max(Comparator.naturalOrder())
                .ifPresent(value -> System.out.println("maximo: " + value));
    }

    private int randomInt() {
        return random.nextInt(10);
    }
}
