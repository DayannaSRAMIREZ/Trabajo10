package runtimeExceptions;

public class Run {
    public static void main(String[] args) {
        int [] array= new int[3];

        try {
            System.out.println(array[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        Integer num= null;
        try {
            System.out.println(num.compareTo(8));
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
