import java.util.LinkedList;
import java.util.Queue; // 雖然不直接用 JCF 的 Queue 類，但 LinkedList 實現了它

/**
 * 實現一個可以置入任意類別物件的 Queue。
 * 底層使用 JCF 中的 LinkedList 來模擬 Queue 的行為（先進先出 FIFO）。
 * 不直接使用 JCF 中的 ArrayDeque 或 PriorityQueue 等專門的 Queue 實現。
 */
class MyQueue<T> {

    // 使用 JCF 中的 LinkedList 作為底層資料結構。
    // LinkedList 實現了 Deque 和 List 介面。
    private final LinkedList<T> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * 將一個元素加入隊列的尾部 (Enqueue/入隊)。
     */
    public void enqueue(T item) {
        // 在 LinkedList 中，addLast 或 add() 都是將元素加到尾部。
        queue.addLast(item); 
    }

    /**
     * 移除並返回隊列頭部的元素 (Dequeue/出隊)。
     */
    public T dequeue() {
        // 由於原先的程式碼是 return queue.first(); 
        // 這裡需要修改為移除並返回頭部元素。
        // removeFirst() 會移除並返回隊列頭部的元素。
        return queue.removeFirst(); 
    }

    /**
     * 查看隊列頭部的元素，但不移除 (Peek/查看)。
     */
    public T peek() {
        // getFirst() 返回頭部元素但不移除。
        return queue.getFirst();
    }
    
    // 檢查隊列是否為空
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // 返回隊列中的元素數量
    public int size() {
        return queue.size();
    }
}

public class QueueExample {
    public static void main(String[] args) {
        MyQueue<Integer> intQueue = new MyQueue<>();
        
        // 測試 Integer Queue
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        System.out.println("Queue Size: " + intQueue.size()); // 輸出 2
        System.out.println("First Dequeue: " + intQueue.dequeue()); // 輸出 10 (先進先出)
        System.out.println("Second Dequeue: " + intQueue.dequeue()); // 輸出 20

        // 測試 Person Object Queue
        MyQueue<Person> personQueue = new MyQueue<>();
        personQueue.enqueue(new Person("Alice", 30));
        personQueue.enqueue(new Person("Bob", 25));
        System.out.println("Person Queue Peek: " + personQueue.peek()); // 輸出 Alice
        System.out.println("Person Dequeue: " + personQueue.dequeue()); // 輸出 Alice
    }
}



//我的Junit測試會測這個Object，這邊以下請不要修改
//---------------------------------------------------------------------------------
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
//---------------------------------------------------------------------------------