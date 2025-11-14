import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1,Integer o2){
        return o2-o1;
    }

}

public class collections {
    public static void main(String[] args) {
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(5);
    
        // list.add(1,50);
       
        // List<String>list3=Arrays.asList("Mopday","Tuesday");//immutable but replaceable

        
        // List<Integer>list2=List.of(1,1,3,5,4);//completely immutable


        // List<Integer> list4=new ArrayList<>(list2);
        // list4.add(6);

        // System.out.println(list4);


        // List<Integer>list5=List.of(3,545,45,3,343,34);

        // list4.addAll(list5);

        // System.out.println(list4);
        List<Integer>list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(0);

        // list.sort(new MyComparator());
        list.sort((a,b)-> a-b);
        System.out.println(list);

        

        

  








    }
}
