
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        //functional progamming
        // Source,intermediate operations.terminal operation



        List<Integer>nums=Arrays.asList(1,2,34);
        int ct=0;
        for(int i:nums){
            if(i%2==0){
                ct++;
            }
        }
        System.out.println(ct);


        long ct2=nums.stream().filter(x->x%2==0).count();
        System.out.println(ct2);



        //creating streams
        //1 
        List<Integer>l1=Arrays.asList(1,4,5,66,4);
        l1.stream();

        //2
        String[] strArray={"a","b","c"};
        Stream<String>stream1=Arrays.stream(strArray);

        //3
        Stream<String>stream2=Stream.of("a","b","v");


        //4 -> all 1 infinite
        Stream<Integer>generate=Stream.generate(()->1);

        //5 -> start 1 then 2,3,4,5...
        Stream.iterate(1, x->x+1);


        


        
    }
}
