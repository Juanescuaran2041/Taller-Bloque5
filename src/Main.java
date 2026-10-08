import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("1001", "Ana Pérez", "ana@uni.edu", "EST-2026-01", "Ingeniería de Sistemas");
        Libro libro = new Libro("978-0132350884", "Clean Code");
        Ejemplar ejemplar = new Ejemplar("EJ-001", libro);
        libro.agregarEjemplar(ejemplar);

        ejemplar.prestar();
        Prestamo prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 1));

        // Prueba 1: renovación válida
        System.out.println("=== Prueba 1: renovación válida ===");
        LocalDate fechaRenovada = LocalDate.of(2026, 10, 15);
        prestamo.renovar(fechaRenovada);
        estudiante.notificar("Su préstamo fue renovado.");

        System.out.println("Nueva fecha de devolución: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones: " + prestamo.getRenovaciones().size());
        if (!fechaRenovada.equals(prestamo.getFechaPrevistaDevolucion())
                || prestamo.getRenovaciones().size() != 1) {
            throw new AssertionError("La renovación válida no actualizó correctamente el préstamo.");
        }

        // Prueba 2: renovación inválida (fecha anterior a la vigente).
        // Debería lanzarse IllegalArgumentException y el préstamo debe quedar
        // intacto: la fecha sigue en 2026-10-15 y las renovaciones siguen en 1.
        System.out.println();
        System.out.println("=== Prueba 2: renovación inválida ===");
        try {
            prestamo.renovar(LocalDate.of(2026, 10, 10));
            throw new AssertionError("Se aceptó una renovación inválida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Renovación rechazada: " + e.getMessage());
        }
        System.out.println("Fecha de devolución (sin cambios): " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones (sin cambios): " + prestamo.getRenovaciones().size());
        if (!fechaRenovada.equals(prestamo.getFechaPrevistaDevolucion())
                || prestamo.getRenovaciones().size() != 1) {
            throw new AssertionError("El préstamo cambió después de rechazar la renovación.");
        }

        System.out.println();
        System.out.println("Todas las pruebas finalizaron correctamente.");
    }
}
