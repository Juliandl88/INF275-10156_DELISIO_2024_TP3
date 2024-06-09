
import java.util.ArrayList;

public class Anfitrion extends Usuario {
    private final ArrayList<Alojamiento> alojamientos;

    public Anfitrion(String id, String nombre, String correo, String contraseña) {
        super(id, nombre, correo, contraseña);
        this.alojamientos = new ArrayList<>();
    }

    public void añadirAlojamiento(Alojamiento alojamiento) {
        alojamientos.add(alojamiento);
    }

    public ArrayList<Alojamiento> getAlojamientos() {
        return alojamientos;
    }
}
