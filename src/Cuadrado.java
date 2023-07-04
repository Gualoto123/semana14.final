public class Cuadrado extends Figura {
    @Override
    public double calcularArea() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);
        double lado = a.calcularDistancia(b);
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);
        double lado = a.calcularDistancia(b);
        return 4 * lado;
    }
    @Override
    public String toString() {
        return "Cuadrado";
    }
}