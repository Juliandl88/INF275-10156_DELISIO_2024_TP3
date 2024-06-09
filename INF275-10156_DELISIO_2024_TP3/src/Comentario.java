public class Comentario {
    // Aributos
    private String id;
    private Usuario usuario;
    private String texto;
    private int calificación; // De 0 a 5

    // Constructor
    public Comentario(String id, Usuario usuario, String texto, int calificación) {
        this.id = id;
        this.usuario = usuario;
        this.texto = texto;
        this.calificación = calificación;
    }

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public int getCalificación() { return calificación; }
    public void setCalificación(int calificación) { this.calificación = calificación; }
}
