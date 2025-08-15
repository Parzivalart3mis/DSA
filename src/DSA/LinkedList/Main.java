package DSA.LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(100, 3);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();

        System.out.println("********************************************************");

        DLL list2 = new DLL();
        list2.insertFirst(3);
        list2.insertFirst(2);
        list2.insertFirst(8);
        list2.insertFirst(17);
        list2.insertLast(99);
//        list2.insert(100, 3);
        list2.display();
//        System.out.println(list2.deleteFirst());
//        list2.display();
//        System.out.println(list2.deleteLast());
//        list2.display();
//        System.out.println(list2.delete(2));
//        list2.display();
    }
}
