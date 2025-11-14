
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer>st1=new Stack<>();
        st1.push(4);
        st1.push(5);
        st1.push(8);

        int index=st1.search(5); 
        System.out.println(index);




        // st1.pop();
    }
}
