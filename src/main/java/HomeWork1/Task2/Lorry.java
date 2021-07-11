package HomeWork1.Task2;

//public class Lorry extends Car, Moveable, Stopable{ - ошибка

public class Lorry extends Car implements Moveable, Stopable {

    @Override //не переопределен метод
    void open() {
        System.out.println("Car is open");
    }

    @Override // не было аннотации
    public void move() {
        System.out.println("Car is moving");
    }

    @Override // не было аннотации
    public void stop() {
        System.out.println("Car is stop");

    }
}
