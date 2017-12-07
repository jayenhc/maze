package java8;

/**
 * Created by jchondig on 03/03/2017.
 */
@FunctionalInterface
public interface DefaultInterface1 {
    public void overrideme();

    // can't define another mothod for FunctionalInterface
    //public void overrideme2();

    default String defalutMethod() {
            return"default method";
    }

    static void staticMethod(){
        System.out.println("FunctionalInterface static method");
    }
}
