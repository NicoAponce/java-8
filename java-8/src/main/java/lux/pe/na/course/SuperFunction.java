package lux.pe.na.course;import lux.pe.na.course.interfaces.IPredicate;import lux.pe.na.course.interfaces.IProvider;import java.util.ArrayList;import java.util.List;public class SuperFunction {    public static List<Integer> filter(List<Integer> numbers, IPredicate predicate) {        List<Integer> result = new ArrayList<>();        for (Integer value : numbers) {            if (predicate.test(value)) {                result.add(value);            }        }        return result;    }    public static List<Integer> provide(int size, IProvider provider) {        List<Integer> result = new ArrayList<>();        for (int i = 0; i < size; i++) {            result.add(provider.get());        }        return result;    }}