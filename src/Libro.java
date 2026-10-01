import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Libro {
    private String isbn;
    private String titulo;
    private List<Ejemplar> ejemplares = new ArrayList<>();

    public Libro(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public Ejemplar agregarEjemplar(String codigo) {
        Ejemplar ejemplar = new Ejemplar(codigo, this);
        ejemplares.add(ejemplar);
        return ejemplar;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Ejemplar> getEjemplares() {
        return Collections.unmodifiableList(ejemplares);
    }
}