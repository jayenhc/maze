package java8;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by jchondig on 07/12/2017.
 * java.util.function.Predicate is a functional interface that can be used as assignment target for lambda expression.
 * The Predicate interface represents an operation that takes a single input and returns a boolean value.
 */
public class PredicatesImpl {
    public static void main(String arg[]) {

        //Predicate String
        Predicate<String> predicateStr = s -> (s.equals("Jayen"));
        System.out.println(" predicate is lambda function, take one argument and return boolean-" + predicateStr.test("Jayen"));
        System.out.println(" predicate is lambda function, take one argument and return boolean-" + predicateStr.test("jayen"));

        //Predicate integer
        Predicate<Integer> predicateInt = i -> {
            return i > 5;
        };
        System.out.println(" Int -> " + predicateInt.test(4));
        System.out.println(" Int -> " + predicateInt.test(6));

        Predicate<Integer> predicateAnd = predicateInt.and(i -> {
            return i < 10;
        });

        System.out.println(" And Int -> " + predicateAnd.test(6));
        System.out.println(" And Int -> " + predicateAnd.test(16));
        // other logical peridcate opration are
        // or, negate

        // allMatch() checks if calling stream totally matches to given Predicate,  if yes it returns true otherwise false.
        // anyMatch() checks if there is any element in the stream which matches the given Predicate.
        // noneMatch() returns true only when no element matches the given Predicate.

        Predicate<Employee> p1 = e -> e.id < 10 && e.firstName.startsWith("A");
        Predicate<Employee> p2 = e -> e.sal < 10000;
        List<Employee> list = Employee.getEmpList();
        //using allMatch
        boolean b1 = list.stream().allMatch(p1);
        System.out.println("all match ->" + b1);
        boolean b2 = list.stream().allMatch(p2);
        System.out.println("all match ->" + b2);
        //using anyMatch
        boolean b3 = list.stream().anyMatch(p1);
        System.out.println("any match ->" + b3);
        boolean b4 = list.stream().anyMatch(p2);
        System.out.println("any match ->" + b4);
        //using noneMatch
        boolean b5 = list.stream().noneMatch(p1);
        System.out.println("none match ->" + b5);
    }
}
