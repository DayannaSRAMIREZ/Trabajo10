package casosInesperados.exceptions.registro;

public class PersonaMenorException extends PersonaException{
    public PersonaMenorException() {
        super("Persona ya menor");
    }
}
