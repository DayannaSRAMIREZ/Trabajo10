package casosInesperados;

import casosInesperados.exceptions.registro.PersonaMenorException;
import casosInesperados.exceptions.registro.PersonaYaExisteException;

import java.util.HashMap;
import java.util.Map;

public class Registro {
    public static Map<Integer, Persona> miRegistro = new HashMap<>();
    final static int MENOR_DE_EDAD=1;
    final static int CONTIENE_PERSONA=2;

    public static int analizarDatos(Persona persona) {

        if (persona.edad < 18) {
            return MENOR_DE_EDAD;
        }
        if (miRegistro.containsKey(persona.dni)) {
            return CONTIENE_PERSONA;
        }
        return 0;
    }

    public static Persona validarPersona(Persona persona) throws PersonaMenorException, PersonaYaExisteException {

        if (analizarDatos(persona)== MENOR_DE_EDAD) {
            PersonaMenorException e = new PersonaMenorException("Persona menor de edad");
            throw e;
        } else if (analizarDatos(persona) == CONTIENE_PERSONA) {
            PersonaYaExisteException e = new PersonaYaExisteException("Persona ya existe en registro");
            throw e;
        } else {
            return persona;
        }
    }

    public static void agregarPersona(Persona persona) {
        try {
            miRegistro.put(persona.dni, validarPersona(persona));
        } catch (PersonaMenorException e) {
            System.out.println("La persona es menor de edad: " + persona.edad + " años.");
        } catch (PersonaYaExisteException e) {
            System.out.println("La persona ya existe: " + persona);
        }
    }


    public static void imprimirRegistro() {
        miRegistro.values().forEach(persona -> System.out.println(persona));

    }
}

