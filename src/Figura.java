import java.util.ArrayList;

public abstract class Figura {
    protected ArrayList<Punto> puntos;

    public Figura() {
        puntos = new ArrayList<>();
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public void agregarPunto(Punto punto) {
        puntos.add(punto);
    }}
