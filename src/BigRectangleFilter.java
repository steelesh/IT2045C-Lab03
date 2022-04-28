import java.awt.*;

public class BigRectangleFilter implements Filter{
    public boolean accept(Object x){

        Rectangle rect = (Rectangle) x;
        if ((rect.width) * 2 + (rect.height) * 2 < 10){
            return true;
        }
        else{
            return false;
        }
    }
}