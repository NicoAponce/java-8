package lux.pe.na.course;

import lux.pe.na.course.classes.Adder;
import lux.pe.na.course.classes.NaturalNumbers;
import lux.pe.na.course.classes.OnlyPairs;
import lux.pe.na.course.classes.SquaredNumbers;
import lux.pe.na.course.functions.SuperFunction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Java8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Java8Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Integer> numbers = SuperFunction.provide(10, new NaturalNumbers());
        List<Integer> pairs = SuperFunction.filter(numbers, new OnlyPairs());
        List<Integer> square = SuperFunction.transform(pairs, new SquaredNumbers());
        Integer sum = SuperFunction.sum(square, 0, new Adder());

        System.out.println("numeros " + numbers);
        System.out.println("pares " + pairs);
        System.out.println("cuadrado " + square);
        System.out.println("suma " + sum);
    }

}
