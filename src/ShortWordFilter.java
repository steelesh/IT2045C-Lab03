
public class ShortWordFilter implements Filter {
    public boolean accept(Object x){

        String str = (String) x;

        if(str.length() < 5){
            return true;
        }
        else{
            return false;
        }
    }
}