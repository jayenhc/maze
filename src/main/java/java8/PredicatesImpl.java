package java8;

import java.util.function.Predicate;

/**
 * Created by jchondig on 07/12/2017.
 java.util.function.Predicate is a functional interface that can be used as assignment target for lambda expression.
 The Predicate interface represents an operation that takes a single input and returns a boolean value.
 *
 */
public class PredicatesImpl {
    public static void main(String arg[]){

        //Predicate String
        Predicate<String> predicateStr = s->(s.equals("Jayen"));
        System.out.println(" predicate is lambda function, take one argument and return boolean-" + predicateStr.test("Jayen"));
        System.out.println(" predicate is lambda function, take one argument and return boolean-" + predicateStr.test("jayen"));

        //Predicate integer
        Predicate<Integer> predicateInt = i -> {
            return i > 5;
        };
        System.out.println(" Int -> " + predicateInt.test(4));
        System.out.println(" Int -> " + predicateInt.test(6));

        Predicate<Integer> predicateAnd = predicateInt.and(i->{
            return i<10;
        });

        System.out.println(" And Int -> " + predicateAnd.test(6));
        System.out.println(" And Int -> " + predicateAnd.test(16));
        // other logical peridcate opration are
        // or, negate

    }
}
