
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Java8Demo {

    public static void main(String[] args) {
        //minimal
        //object oriented programming -> Functional Oriented Programming
        //Lambda Expressions
        //Date and Time
        Thread t1 = new Thread(() -> {
            System.out.println("Hello");
        });
        t1.run();

        Predicate<Integer> pred= x->x%2==0;
        System.out.println(pred.test(5));

        Function<Integer, Integer>func=x->x+2;
        int h=func.apply(4);
        System.out.println(h);

        Consumer<Integer>Cons=x-> System.out.println(x+5);
        Cons.accept(4);

        Supplier<String>supp=()->"helolo";
        System.out.println(supp.get());


        //method refernce
        List<String>students=Arrays.asList("Ram","Shyam","Ghanshyam");
        students.forEach(x->System.out.println(x));

        students.forEach(System.out::println);

        //constructor reference
        List<String>names=Arrays.asList("A","B","C");
        List<MobilePhone>mobilePhoneList=names.stream().map(MobilePhone::new).collect(Collectors.toList());
        


        

    }

}

class MobilePhone{
    String phNo;
    public MobilePhone(String ph){
        this.phNo=ph;
    }
}


