package ExceptionHandling;

public class LimitToFiveException extends RuntimeException{

    LimitToFiveException(){
        super("Only Number Above 5 is Agreed..");
    }
    
}
