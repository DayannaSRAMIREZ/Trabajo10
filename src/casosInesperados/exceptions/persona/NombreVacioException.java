package casosInesperados.exceptions.persona;

public class NombreVacioException extends DatosInvalidosException {
    public NombreVacioException() {
        super("El nombre se encuentra vacio");
    }
}

