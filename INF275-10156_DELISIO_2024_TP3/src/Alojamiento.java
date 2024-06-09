import java.util.ArrayList;

public class Alojamiento {
    // Atributos
    private String id;
    private String título;
    private String descripción;
    private String dirección;
    private double precioPorNoche;
    private ArrayList<Comentario> comentarios;

    // Contructor
    public Alojamiento(String id, String título, String descripción, String dirección, double precioPorNoche) {
        this.id = id;
        this.título = título;
        this.descripción = descripción;
        this.dirección = dirección;
        this.precioPorNoche = precioPorNoche;
        this.comentarios = new ArrayList<>();
    }

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTítulo() { return título; }
    public void setTítulo(String título) { this.título = título; }

    public String getDescripción() { return descripción; }
    public void setDescripción(String descripción) { this.descripción = descripción; }

    public String getDirección() { return dirección; }
    public void setDirección(String dirección) { this.dirección = dirección; }

    public double getPrecioPorNoche() { return precioPorNoche; }
    public void setPrecioPorNoche(double precioPorNoche) { this.precioPorNoche = precioPorNoche; }

    public ArrayList<Comentario> getComentarios() { return comentarios; }

    public void agregarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }
}
