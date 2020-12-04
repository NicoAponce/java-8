package lux.pe.na.course.functions;import lux.pe.na.course.interfaces.IBinaryFunction;import lux.pe.na.course.interfaces.IFunction;import lux.pe.na.course.interfaces.IPredicate;import lux.pe.na.course.interfaces.IProvider;import java.util.ArrayList;import java.util.List;public class SuperFunction {    public static List<Integer> filter(List<Integer> numbers, IPredicate predicate) {        List<Integer> result = new ArrayList<>();        for (Integer value : numbers) {            if (predicate.test(value)) {                result.add(value);            }        }        return result;    }    public static List<Integer> provide(int size, IProvider provider) {        List<Integer> result = new ArrayList<>();        for (int i = 0; i < size; i++) {            result.add(provider.get());        }        return result;    }    public static List<Integer> transform(List<Integer> values, IFunction function) {        List<Integer> result = new ArrayList<>();        for (Integer value : values) {            result.add(function.apply(value));        }        return result;    }    public static Integer sum(List<Integer> values, Integer id, IBinaryFunction binaryFunction) {        int total = id;        for (Integer vaIue : values) {            total = binaryFunction.apply(total, vaIue);        }        return total;    }}