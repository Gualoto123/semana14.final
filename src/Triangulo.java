public class Triangulo extends Figura {
    @Override
    public double calcularArea() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);
        Punto c = puntos.get(2);
        double base = a.calcularDistancia(b);
        double altura = c.calcularDistancia(a);
        return base * altura / 2;
    }

    @Override
    public double calcularPerimetro() {
        Punto a = puntos.get(0);
        Punto b = puntos.get(1);
        Punto c = puntos.get(2);
        double ladoAB = a.calcularDistancia(b);
        double ladoBC = b.calcularDistancia(c);
        double ladoCA = c.calcularDistancia(a);
        return ladoAB + ladoBC + ladoCA;
    }
    public String toString() {
        return "Triángulo";
    }
}