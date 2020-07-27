package java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static com.sun.xml.internal.stream.writers.XMLStreamWriterImpl.SPACE;

/**
 * In Java 8, Stream can hold different data types, for examples:
 * Stream<String[]>
 * Stream<Set<String>>
 * Stream<List<String>>
 * Stream<List<Object>>
 * <p>
 * But,  the Stream operations (filter, sum, distinct…) and collectors do not support it, so, we need flatMap() to do the following conversion :
 * Stream<String[]>		-> flatMap ->	Stream<String>
 * Stream<Set<String>>	-> flatMap ->	Stream<String>
 * Stream<List<String>>	-> flatMap ->	Stream<String>
 * Stream<List<Object>>	-> flatMap ->	Stream<Object>
 * <p>
 * How flatMap() works :
 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 * https://www.mkyong.com/java8/java-8-flatmap-example/
 */
public class MapFlatMap {
    String name;
    List<String> items;

    public MapFlatMap(String name, String... items) {
        this.name = name;
        this.items = Arrays.asList(items);
    }

    public List<String> getItems() {
        return items;
    }

    public static void main(String arg[]) {

        Parent p1 = new Parent(1, "a1", LocalDate.now().minusYears(25));
        p1.getChildren().add(new Child("c11", "L11", 11));
        p1.getChildren().add(new Child("c12", "L12", 12));

        Parent p2 = new Parent(2, "a2", LocalDate.now().minusYears(20));
        p2.getChildren().add(new Child("c21", "L21", 21));
        p2.getChildren().add(new Child("c22", "L22", 22));

        //Both map and flatMap can be applied to a Stream<T> and they both return a Stream<R>.
        // The difference is that the map operation produces one output value for each input value,
        // whereas the flatMap operation produces an arbitrary number (zero or more) values for each input value.
        List<Parent> employeeList = Arrays.asList(p1, p2);
        System.out.println(
                employeeList.stream()
                        .flatMap(e -> e.getChildren().stream()) //flatmap on list attribute
                        .collect(Collectors.toList()));
        // output  [11 : c11, 12 : c12, 21 : c21, 22 : c22]
        //The flatMap method lets you replace each value of a stream with another stream and then joins all the generated streams into a single stream.


        MapFlatMap amazon = new MapFlatMap("amazon", "Laptop", "Phone");
        MapFlatMap ebay = new MapFlatMap("ebay", "Mouse", "Keyboard");
        List<MapFlatMap> parcels = Arrays.asList(amazon, ebay);
        List<String> flatMapReturn = parcels.stream()
                .map(MapFlatMap::getItems)
                .flatMap(Collection::stream) //flat map on stream it self
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + flatMapReturn);
        //out put [Laptop, Phone, Mouse, Keyboard]

        System.out.println("\t map or else  returns parent Name: " + amazon.getParentName(p1));
        System.out.println("\t map or else  returns Children's name : " + amazon.getChildrenName(p1));
    }

    private String getChildrenName(final Parent p1) {
        return p1.getChildren().stream()
                .map(child -> child.firstName + " " + child.lastName)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(","));
    }

    private String getParentName(Parent person) {
        return Stream.of(Optional.ofNullable(person)
                        .map(Parent::getName)
                        .orElse(null),
                Optional.ofNullable(person)
                        .map(Parent::getName)
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.joining( ));
    }

    public void UsingParallelStream() {
        /* Create object of AtomicInteger with initial value `0` */
        AtomicInteger atomicInteger = new AtomicInteger(0);

        /* Create list of names. */
        List<String> listNames = new ArrayList<String>(Arrays.asList("Vicky Thakor", "Chirag Thakor", "Dave Hill", "Finn Jones", "Heer Thakor"));

        listNames.parallelStream()
                .filter(name -> name.endsWith("Thakor"))
                .forEach(name -> {
                    /* Get the previous value of count and increment it by `1` */
                    atomicInteger.getAndIncrement();

                    /* Print the name */
                    System.out.println(name);
                });

        /* Get value of `atomicInteger` */
        System.out.println("Total match found using `parallelStream()`: " + atomicInteger.get());
    }

}
