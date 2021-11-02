package casosInesperados.exceptions.registro;

public class PersonaYaExisteException extends PersonaException{
    public PersonaYaExisteException() {
        super("Persona ya existe en el registro");
    }
}
