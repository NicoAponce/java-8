package lux.pe.na.v2anonymous;

import lux.pe.na.v2anonymous.functions.SuperFunction;
import lux.pe.na.v2anonymous.interfaces.IBinaryFunction;
import lux.pe.na.v2anonymous.interfaces.IFunction;
import lux.pe.na.v2anonymous.interfaces.IPredicate;
import lux.pe.na.v2anonymous.interfaces.IProvider;
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
        List<Integer> numbers = SuperFunction.provide(10, new IProvider() {
            Random random = new Random();

            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        });
        List<Integer> pairs = SuperFunction.filter(numbers, new IPredicate() {
            @Override
            public Boolean test(Integer value) {
                return value % 2 == 0;
            }
        });
        List<Integer> square = SuperFunction.transform(pairs, new IFunction() {
            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        });
        Integer sum = SuperFunction.sum(square, 0, new IBinaryFunction() {
            @Override
            public Integer apply(Integer value1, Integer value2) {
                return value1 + value2;
            }
        });

        System.out.println("numeros " + numbers);
        System.out.println("pares " + pairs);
        System.out.println("cuadrado " + square);
        System.out.println("suma " + sum);
    }

}
