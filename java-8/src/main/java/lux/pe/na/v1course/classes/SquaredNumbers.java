package lux.pe.na.v1course.classes;import lux.pe.na.v1course.interfaces.IFunction;public class SquaredNumbers implements IFunction {    @Override    public Integer apply(Integer value) {        return value * value;    }}