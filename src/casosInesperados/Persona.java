package casosInesperados;

import casosInesperados.exceptions.persona.DniInvalido;
import casosInesperados.exceptions.persona.EdadMenor;
import casosInesperados.exceptions.persona.NombreVacio;

import static casosInesperados.Registro.agregarPersona;

public class Persona {
    String nombre;
    int edad;
    int dni;
    final static int NOMBRE_VACIO = 1;
    final static int EDAD_INVALIDA = 2;
    final static int DNI_INVALIDO = 3;


    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", dni=").append(dni);
        sb.append('}');
        return sb.toString();
    }

    public static int validacionDeDatos(String nombre, int edad, int dni) {

        if (nombre == null || nombre.equals(" ")) {
            return NOMBRE_VACIO;
        } else if (edad < 0) {
            return EDAD_INVALIDA;
        } else if (dni <= 0) {
            return DNI_INVALIDO;
        }
        return 0;
    }

    public static Persona validaPersona(String nombre, int edad, int dni) throws NombreVacio, DniInvalido, EdadMenor {

        if (validacionDeDatos(nombre, edad, dni) == 0) {
            Persona persona1 = new Persona(nombre, edad, dni);
            return persona1;
        } else if (validacionDeDatos(nombre, edad, dni) == NOMBRE_VACIO) {
            NombreVacio e = new NombreVacio();
            throw e;
        } else if (validacionDeDatos(nombre, edad, dni) == EDAD_INVALIDA) {
            EdadMenor e = new EdadMenor();
            throw e;
        } else if (validacionDeDatos(nombre, edad, dni) == DNI_INVALIDO) {
            DniInvalido e = new DniInvalido();
            throw e;
        }
        return null;
    }

    public static Persona crearPersona(String nombre, int edad, int dni) {

        try {
            Persona persona1 = validaPersona(nombre, edad, dni);

            agregarPersona(persona1);
            return persona1;

        } catch (DniInvalido e) {
            System.out.println(e.getMessage());
        } catch (EdadMenor e) {
            System.out.println(e.getMessage());
        } catch (NombreVacio e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
