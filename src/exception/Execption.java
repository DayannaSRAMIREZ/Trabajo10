package exception;

/*Hacer una función que tire Exception con un mensaje.
 •	Llamarla y dejar que la excepción se propague hasta el main y rompa el programa
 •	Llamarla y atraparla imprimiendo el mensaje
 */
public class Execption {

    /*
        public static void main(String[] args) throws Exception {
            esMayor(8, 8);
        }
    */
    public static void main(String[] args) {
        try {
            esMayor(8, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void esMayor(int a, int b) throws Exception {
        if (a > b) {
            System.out.println(a + " es mayor que " + b);
        } else if (a < b) {
            System.out.println(b + " es mayor que " + a);
        } else {
            Exception e = new Exception("Los numeros son iguales");
            throw e;
        }

    }
}
