package so.springboot.atomikos.atomikosdemo;

import java.util.function.Function;

public class App {

   public static Integer add(Integer a, Function<Integer,Integer> fun){
       return fun.apply(a);
   }



    public static void main(String[] arg){
        //System.out.println("xxxxxx");
        Function<Integer, Integer> name = e -> e * 2;
        Integer a=name.apply(100);
        System.out.println(a);


        System.out.print( add(10,e->{
            System.out.println(e);
            return e+1;
        }));
    }
}
