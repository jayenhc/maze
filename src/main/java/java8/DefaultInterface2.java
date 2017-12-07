package java8;

/**
 * Created by jchondig on 03/03/2017.
 */
@FunctionalInterface
public interface DefaultInterface2 {
    public void overrideme();

    // can't define defalutMethod() because test calss will give error
    // as it is defined in DefaultInterface1

    // if define here then need to override in implemented class
    default String defalutMethod() {
            return"default method";
    }

}
