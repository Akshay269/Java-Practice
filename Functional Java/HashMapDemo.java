
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        //does not extend collection framework

        HashMap<Integer,String> hashmap=new HashMap<>();
        
        hashmap.put(1,"Akshay");
        hashmap.put(2,"Harsh");
        hashmap.put(3,"Jyoti");

        System.out.println(hashmap);
        // String s=hashmap.get(4);
        System.out.println(hashmap.containsKey(3));
        System.out.println(hashmap.containsValue("Harsh"));

        Set<Integer>keys=hashmap.keySet();
        for(int i:keys){
            System.out.println(hashmap.get(i));
        }


        //keys me ek hi null ho sakta h, baki values me kitne bhi null chalenge , 


        //Internal Function of hashmap

        //key,value,bucket,hash function
        //hash function takes key and returns index.
        // input:- key , output:- fixed size string.

        //how Data is stored in hashmap
        //Step 1:- hashing the key :- hash function takes key and returns unique hash code. Ye hash code helps location where key-value pair will be stored in bucket array.

        //Do inputs ka same index aa sakta h, kyunki jo output index h, wo finite h, isliye collision ho sakta h. Aisse collision k wakt multiple (k,v)s store hote h same index pe, Ye linked list k hisab se store hote h. 
        // ek (k,v) k pass hashcode, key ,value ,node<k,v> next pointer to next pair hota h

        //java 8 k bad linkedlist k jagh Red black tree use hota h(balanced binary search tree)

        //Step 2:- hash code -> index
        // index= hashCode % arraySize

        //Step 3 :- Searching in the Bucket
        //Once the correct bucket is found, it checks for the key in that bucket. If it finds the key, it returns the assosiated value.


    }
}
