package Singleton;

// public class Reflection {
    
// }
// public class Singleton {

//     // 1. Standard volatile variable
//     private static volatile Singleton instance;

//     // 2. VULNERABLE Constructor
//     // Because this is empty, Reflection can force its way in and 
//     // just create a new object without any errors.
//     private Singleton() {
//         // No code here to check if instance exists!
//     }

//     // 3. Standard Access Method
//     public static Singleton getInstance() {
//         if (instance == null) {
//             synchronized (Singleton.class) {
//                 if (instance == null) {
//                     instance = new Singleton();
//                 }
//             }
//         }
//         return instance;
//     }
// }

// public static void main(String[] args) throws Exception {

//     // 1. Get the first valid instance

//     Singleton instance1 = Singleton.getInstance();

    

//     // 2. Access the class constructor using Reflection

//     Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();

    

//     // 3. This is the "Magic Key" - we turn off the private check! 🔓

//     constructor.setAccessible(true);

    

//     // 4. Create a second instance manually

//     Singleton instance2 = constructor.newInstance();



//     // Now instance1 and instance2 are different objects. Singleton is broken.

// }




//Defending against Singleton
// public class Singleton {
    
//     private static volatile Singleton instance;

//     // Modified Constructor with Defense
//     private Singleton() {
//         // If an instance already exists, stop the execution!
//         if (instance != null) {
//             throw new RuntimeException("Security Breach! Use getInstance() to create the object.");
//         }
//     }

//     public static Singleton getInstance() {
//         if (instance == null) {
//             synchronized (Singleton.class) {
//                 if (instance == null) {
//                     instance = new Singleton();
//                 }
//             }
//         }
//         return instance;
//     }
// }