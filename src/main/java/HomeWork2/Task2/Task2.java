package HomeWork2.Task2;

public class Task2 {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        System.out.println("размер массива: " + array.size());
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);
        array.add(50);
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println("размер массива: " + array.size());

        array.remove(2);
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println("размер массива: " + array.size());

        System.out.println("Элемент массива: " + array.get(2));
    }
}
