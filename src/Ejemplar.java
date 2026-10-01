public class Ejemplar {

    private String codigo;
    private Libro libro;
    private boolean disponible;

    public Ejemplar(String codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return this.disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void prestar() {

        if (!disponible) {
            throw new IllegalStateException("El ejemplar no está disponible");
        }

        disponible = false;
    }

    public void devolver() {
        if (!this.disponible) {
            this.disponible = true;

        } else {
            System.out.println("El ejemplar " + this.codigo + " ya estaba disponible.");
        }
    }
}