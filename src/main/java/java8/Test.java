package java8;

import java.lang.annotation.Repeatable;

/**
 * Created by jchondig on 03/03/2017.
 */
public class Test {
    //@Repeatable()
    private static class DefImpl implements DefaultInterface1, DefaultInterface2{
        @Override
        public void overrideme(){
            System.out.println("DefImpl");

        }
        @Override
        public String defalutMethod() {
            return" from main default method";
        }

    }
    public static void main(String arg[]){
        System.out.println(3*0.1 == 0.3? true : false);
        DefImpl def = new DefImpl();
        def.overrideme();
        System.out.println(def.defalutMethod());
        DefaultInterface1.staticMethod();
    }
}
