import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        if (nuevaFecha == null || !nuevaFecha.isAfter(this.fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException("Error, la fecha nueva debe ser posterior la fecha actual: " + fechaPrevistaDevolucion);
        }

        Renovacion renovacion = new Renovacion(LocalDate.now(), fechaPrevistaDevolucion, nuevaFecha);
        renovaciones.add(renovacion);
        fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public List<Renovacion> getRenovaciones() {
        return renovaciones;
    }
}
