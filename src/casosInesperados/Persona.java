package casosInesperados;

import casosInesperados.exceptions.persona.DniInvalidoException;
import casosInesperados.exceptions.persona.EdadMenorException;
import casosInesperados.exceptions.persona.NombreVacioException;

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public static Persona validaPersona(String nombre, int edad, int dni) throws NombreVacioException, DniInvalidoException, EdadMenorException {

        if (validacionDeDatos(nombre, edad, dni) == 0) {
            Persona persona1 = new Persona(nombre, edad, dni);
            return persona1;
        } else if (validacionDeDatos(nombre, edad, dni) == NOMBRE_VACIO) {
            NombreVacioException e = new NombreVacioException();
            throw e;
        } else if (validacionDeDatos(nombre, edad, dni) == EDAD_INVALIDA) {
            EdadMenorException e = new EdadMenorException();
            throw e;
        } else if (validacionDeDatos(nombre, edad, dni) == DNI_INVALIDO) {
            DniInvalidoException e = new DniInvalidoException();
            throw e;
        }
        return null;
    }
    /**/

    public static Persona crearPersona(String nombre, int edad, int dni) throws NombreVacioException,
            EdadMenorException, DniInvalidoException {

        Persona persona1 = validaPersona(nombre, edad, dni);
        agregarPersona(persona1);
        return persona1;

    }
}
