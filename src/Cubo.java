public class Cubo extends Cuadrado {
    @Override
    public double calcularArea() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);
        double lado = a.calcularDistancia(b);
        return 6 * lado * lado;
    }

    public double calcularVolumen() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);
        double lado = a.calcularDistancia(b);
        return lado * lado * lado;
    }
    public double calcularPerimetro() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);

        double lado = a.calcularDistancia(b);

        double perimetroCubo = 12 * lado;

        return perimetroCubo;
    }
}