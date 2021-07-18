package HomeWork2.Task1;
/*
Реализовать собственный LinkedList.
 */

public class Task1 {
    public static void main(String[] args) {
        MyLinkedList<Cat> catList = new MyLinkedList<>();
        Cat cat = new Cat("PETRO", 4);
        catList.push(cat);
        catList.push(new Cat("Vaska", 10));
        catList.push(new Cat("Petka", 5));
        catList.push(new Cat("Shlanga", 7));
        System.out.println(catList);
        catList.pop();
        System.out.println(catList);
        catList.delete(new Cat("Petka", 5));
        System.out.println(catList);
    }
}
