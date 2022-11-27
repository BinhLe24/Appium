package src.test_flows.authentication;

public class Verifier {

    public static void equals(String actualStr, String expectedStr){
        if(!actualStr.equalsIgnoreCase(expectedStr)){
            throw new RuntimeException("verify 1");
        }
    }

    public static void equals(int num1, int num2){
        if (num1 == num2){
            throw new RuntimeException("verify2");
        }
    }
}
