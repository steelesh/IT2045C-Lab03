import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {

    public static void main(String[] args) {

        ArrayList<Object> rectList = new ArrayList<>();

        Rectangle rectangle1 = new Rectangle(3, 1); // Perimeter = 8
        rectList.add(rectangle1);
        Rectangle rectangle2 = new Rectangle(2, 3); // Perimeter = 10
        rectList.add(rectangle2);
        Rectangle rectangle3 = new Rectangle(3, 3); // Perimeter = 12
        rectList.add(rectangle3);
        Rectangle rectangle4 = new Rectangle(2, 1); // Perimeter = 6
        rectList.add(rectangle4);
        Rectangle rectangle5 = new Rectangle(4, 5); // Perimeter = 18
        rectList.add(rectangle5);
        Rectangle rectangle6 = new Rectangle(3, 4); // Perimeter = 14
        rectList.add(rectangle6);
        Rectangle rectangle7 = new Rectangle(4, 1); // Perimeter = 10
        rectList.add(rectangle7);
        Rectangle rectangle8 = new Rectangle(2, 1); // Perimeter = 6
        rectList.add(rectangle8);
        Rectangle rectangle9 = new Rectangle(5, 3); // Perimeter = 16
        rectList.add(rectangle9);
        Rectangle rectangle10 = new Rectangle(2, 3); // Perimeter = 10
        rectList.add(rectangle10);

        System.out.println("All rectangles:\n");
        int i = 0;
        for (Object x : rectList){
            i++;
            System.out.println(i + ".) " + x);
        }
        System.out.print("\n");
        System.out.println("Rectangles with Big Perimeters:\n");
        collectAll(rectList);
    }
    public static void collectAll(ArrayList al){

        BigRectangleFilter filter = new BigRectangleFilter();
        ArrayList<Object> filteredRectList = new ArrayList<>();
        for (Object rects : al){
            if (filter.accept(rects)){
                filteredRectList.add(rects);
            }
        }
        for (Object a : filteredRectList){
            System.out.println(a);
        }
    }
}