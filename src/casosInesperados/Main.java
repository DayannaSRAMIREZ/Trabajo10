package casosInesperados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Realizar una función que tome una lista de números positivos y
devuelva el primer elemento mayor a 10. ¿Cómo manejaría el caso que no haya números mayores a 10?

*/
public class Main {
    public static void main(String[] args) {
        Integer[] numeros = {1, 5, 7, 6};
        List<Integer> num = new ArrayList<>(Arrays.asList(numeros));
        pobrarMayor(num);
    }


    public static int mayorADiez(List<Integer> numeros) throws RuntimeException  {

        int mayor=-1;
        boolean hayMayor= false;

        for (Integer numero : numeros) {
            if (numero > 10) {
                 mayor=numero;
                 hayMayor= true;
                break;
            }
        }
        if (!hayMayor) throw new RuntimeException ("No hay mayor");
        return mayor;
    }
    public static void pobrarMayor (List<Integer> numeros) {
        try {
            System.out.println(mayorADiez(numeros));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
