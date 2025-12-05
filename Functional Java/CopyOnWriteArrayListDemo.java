
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bags");
        shoppingList.add("Deo");
        shoppingList.add("Eggs");

        for (String item : shoppingList) {
            System.out.println(item);
            if (item.equals("Eggs")) {
                shoppingList.add("Butter");
                System.out.println("Butter added");
            }
        }
        System.out.println("Updated Shopping List" + shoppingList);
    }
}
