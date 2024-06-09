import java.util.Date;

public class Reserva {
    // Atributos
    private String id;
    private Usuario usuario;
    private Alojamiento alojamiento;
    private Date fechaInicio;
    private Date fechaFin;
    private double totalPago;


    // Constructor
    public Reserva(String id, Usuario usuario, Alojamiento alojamiento, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.usuario = usuario;
        this.alojamiento = alojamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalPago = calcularTotalPago();
    }

    private double calcularTotalPago() {
        long diff = fechaFin.getTime() - fechaInicio.getTime();
        int numDías = (int) (diff / (1000 * 60 * 60 * 24));
        return numDías * alojamiento.getPrecioPorNoche();
    }

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Alojamiento getAlojamiento() { return alojamiento; }
    public void setAlojamiento(Alojamiento alojamiento) { this.alojamiento = alojamiento; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public double getTotalPago() { return totalPago; }
}
