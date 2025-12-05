
package Singleton;
//Lazy Initialization :- we don't create the object until the moment someone actually asks for it
// public class Singleton {

//     private Singleton() {
//     } //private constructor

//     private static Singleton instance; //private instance variable

//     public static Singleton getInstance() {
//         if (instance == null) {
//             instance = new Singleton();
//         }
//         return instance;
//     }
// }

//Not thread-safe
//  public static synchronized Singleton getInstance() {
//         if (instance == null) {
//             instance = new Singleton();
//         }
//         return instance;
//     }
// Performance Pendalty :- Every time a thread calls getInstance(), it has to wait for the lock—even if the instance was created hours ago and we just want to return it.To optimize this, we only want to lock if the instance hasn't been created yet.

// public static Singleton getInstance() {
//     // 1. First check: only lock if instance doesn't exist
//     if (instance == null) {
        
//         // 2. The Lock
//         synchronized (Singleton.class) {
//             instance = new Singleton();
//         }
//     }
//     return instance;
// }
//This improves performance significantly. However, there is still a subtle trap here.

// Imagine Thread A and Thread B both check line 1 (if instance == null) at the exact same time. They both see it is null.

// Thread A grabs the lock, creates the object, and leaves. Thread B (which was waiting right at the synchronized line) now enters the block.

// public static Singleton getInstance() {
//     // 1. First check (no locking)
//     if (instance == null) {
        
//         synchronized (Singleton.class) {
//             // 2. Second check (inside the lock)
//             if (instance == null) {
//                 instance = new Singleton();
//             }
//         }
//     }
//     return instance;
// }

//This is double checked locking. But Too complex code




//*_____________________________________ */


//Eager Initialization
// class EagerSingleton {
//     // The single instance, created immediately
//     private static final EagerSingleton instance = new EagerSingleton(); 

//     private EagerSingleton() {}

//     public static EagerSingleton getInstance() {
//         return instance;
//     }
// }
// Bin faltu memory assign krdiya instance ko, agar use hi nhi hua toh memory and space waste jaegi




//Best method:-  Static Inner class method
// This method relies on a specific behavior of the Java ClassLoader:

// Lazy: When your application starts and loads the Singleton class, the SingletonHelper inner class is not loaded yet. It sits dormant.

// Thread-Safe: When getInstance() is finally called, the JVM loads SingletonHelper. The JVM guarantees that static class initialization is atomic (thread-safe).

// public class Singleton{
//     private Singleton(){}

//     private static class SingletonHelper{
//         private static final Singleton INSTANCE=new Singleton();

//     }
//     public static Singleton getInstance(){
//         return SingletonHelper.INSTANCE;
//     }
// }


// Breaking and Defending :- Even we use private constructor, still it can  be broken through reflection. Think of it as X-ray vision of code.

