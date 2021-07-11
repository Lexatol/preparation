package HomeWork1.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>(Arrays.asList(
                new Circle(), new Square(), new Triangle()));
        for (int i = 0; i < shapeList.size(); i++) {
           shapeList.get(i).draw();
        }
    }
}
