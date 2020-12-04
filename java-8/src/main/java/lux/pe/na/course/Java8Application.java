package lux.pe.na.course;

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
        List<Integer> numbers = createList();
        List<Integer> pairs = filterPair(numbers);
        List<Integer> square = filterSquare(pairs);
        Integer sum = sumNumbers(square);

        System.out.println("numeros " + square);
        System.out.println("pares " + square);
        System.out.println("cuadrado " + square);
        System.out.println("suma " + sum);
    }

    private Integer sumNumbers(List<Integer> square) {
        return square.stream().mapToInt(val -> val).sum();
    }


    private List<Integer> createList() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private List<Integer> filterPair(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        result = numbers.stream().filter(val -> val % 2 == 0).collect(Collectors.toList());
        return result;
    }

    private List<Integer> filterSquare(List<Integer> pairs) {
        List<Integer> result = new ArrayList<>();
        result = pairs.stream().map(val -> val * val).collect(Collectors.toList());
        return result;
    }
}
