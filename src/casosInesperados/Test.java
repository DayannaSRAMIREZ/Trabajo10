package casosInesperados;

import static casosInesperados.Persona.crearPersona;


/*Realizar una función que tome un nombre, una edad, y un numero de DNI y devuelva un
        objeto Persona. Cómo manejaría el caso en que los valores sean incorrectos? (Por ejemplo nombre
        null o “”, edad negativa, DNI <= 0
        RuntimeException exepcion sin chequear,*/
/*Jerarquía de excepciones

Modificar esta función para que al crear una persona la agregue a un registro de todas
las personas, indexada por DNI. Crear una jerarquía de excepciones basada en PersonaException.
En caso que la persona ya exista en el registro, tirar PersonaYaExisteException.
También, queremos registrar sólo los adultos. En el caso que la persona sea menor de edad (< 18)
 tirar PersonaMenorException.

Atrapar ambas por separado y mostrar un error correspondiente. En el caso de persona menor,
 debe mostrar la edad de la persona. En el caso de persona ya existente, debe mostrar el DNI y el
 nombre de la persona que se esta queriendo ingresar.
*/
public class Test {
    public static void main(String[] args) {
        Persona persona1 = crearPersona("Maria Perez", 50, 27);
        Persona persona2 = crearPersona("Pablo Rodrigez ", 10, 28);
        Persona persona3 = crearPersona("Luciano Alvarez ", 20, 27);
        Persona persona4 = crearPersona("Patricio Juarez ", 36, 112);
        Persona persona5 = crearPersona("Roberto Garcia ", 18, 114);
        Persona persona6 = crearPersona("Luca rossi ", 20, 66);
        Persona persona7 = crearPersona("Lucrecia Diaz ", 32, 66);
        Persona persona8 = crearPersona("Lita Vallejos ", 40, 44);

        Registro.imprimirRegistro();

    }
}



