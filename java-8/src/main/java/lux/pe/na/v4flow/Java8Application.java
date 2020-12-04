package lux.pe.na.v4flow;

import lux.pe.na.v4flow.functions.SuperFlow;
import lux.pe.na.v4flow.interfaces.IOperatorBinary;
import lux.pe.na.v4flow.interfaces.IOperatorFunction;
import lux.pe.na.v4flow.interfaces.IPredicate;
import lux.pe.na.v4flow.interfaces.IProvider;
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

        SuperFlow<Integer> numbers = SuperFlow.provide(10, new IProvider<>() {
            Random random = new Random();

            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        });


        SuperFlow<Integer> pairs = numbers.filter(new IPredicate<>() {
            @Override
            public Boolean test(Integer value) {
                return value % 2 == 0;
            }
        });


        SuperFlow<Integer> square = pairs.transform(new IOperatorFunction<>() {
            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        });


        Integer sum = square.sum(0, new IOperatorBinary<>() {
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
