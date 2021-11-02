package Error;
/*
Crear un programa que intente crear arrays cada vez más largos hasta tirar OutOfMemoryError.
 Cuando tire el error, atraparlo e imprimir el último tamaño exitoso.
*/

public class Error {
    public static void main(String[] args) {
        int tamanio=0;
        try {

            for (int i = 1; i > 0; i++) {
                int[] miArray = new int[i * 1000 * 1000 * 100];
                tamanio= miArray.length;
            }

        } catch (OutOfMemoryError e) {

            System.out.println("El ultimo tamaño exitoso es: "+tamanio);

        }
    }
}
