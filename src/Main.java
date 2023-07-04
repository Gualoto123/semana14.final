import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        List<Figura> figuras = new ArrayList<>();

        do {
            System.out.println("Escoja una opción:");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Círculo");
            System.out.println("4. Pirámide");
            System.out.println("5. Cubo");
            System.out.println("6. Esfera");
            System.out.println("7. Ver listado");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                Figura figura;
                double area = 0;
                double perimetro = 0;
                double volumen = 0;

                switch (opcion) {
                    case 1:
                        figura = new Triangulo();
                        leerPuntos(figura, scanner, 3);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        figuras.add(figura);
                        break;
                    case 2:
                        figura = new Cuadrado();
                        leerPuntos(figura, scanner, 2);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        figuras.add(figura);
                        break;
                    case 3:
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        figura = new Circulo(radio);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        figuras.add(figura);
                        break;
                    case 4:
                        figura = new Piramide();
                        leerPuntos(figura, scanner, 4);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        volumen = ((Piramide) figura).calcularVolumen();
                        figuras.add(figura);
                        break;
                    case 5:
                        figura = new Cubo();
                        leerPuntos(figura, scanner, 2);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        volumen = ((Cubo) figura).calcularVolumen();
                        figuras.add(figura);
                        break;
                    case 6:
                        System.out.print("Ingrese el radio de la esfera: ");
                        double radioEsfera = scanner.nextDouble();
                        figura = new Esfera(radioEsfera);
                        area = figura.calcularArea();
                        volumen = ((Esfera) figura).calcularVolumen();
                        figuras.add(figura);
                        break;
                    default:
                        continue;
                }

                String informacionFigura = "-------------------------------\n";
                informacionFigura += "       FIGURA      \n";
                informacionFigura += figura.toString();
                informacionFigura += "Área: " + area + "\n";
                informacionFigura += "Perímetro: " + perimetro + "\n";
                if (figura instanceof Piramide) {
                    informacionFigura += "Volumen: " + volumen + "\n";
                } else if (figura instanceof Cubo) {
                    informacionFigura += "Volumen: " + volumen + "\n";
                } else if (figura instanceof Esfera) {
                    informacionFigura += "Volumen: " + volumen + "\n";
                }
                informacionFigura += "-------------------------------\n";

                System.out.println(informacionFigura);
            } else if (opcion == 7) {
                if (figuras.isEmpty()) {
                    System.out.println("No hay figuras guardadas.");
                } else {
                    System.out.println("-------------------------------");
                    System.out.println("    FIGURAS GUARDADAS          ");
                    System.out.println("-------------------------------");
                    for (Figura figura : figuras) {
                        System.out.println(figura.toString());
                        System.out.println("Área: " + figura.calcularArea());
                        if (figura instanceof Triangulo || figura instanceof Cuadrado || figura instanceof Circulo) {
                            System.out.println("Perímetro: " + figura.calcularPerimetro());
                        }
                        if (figura instanceof Piramide) {
                            System.out.println("Volumen: " + ((Piramide) figura).calcularVolumen());
                        } else if (figura instanceof Cubo) {
                            System.out.println("Volumen: " + ((Cubo) figura).calcularVolumen());
                        } else if (figura instanceof Esfera) {
                            System.out.println("Volumen: " + ((Esfera) figura).calcularVolumen());
                        }
                        System.out.println("-------------------------------");
                    }
                }
            }
        } while (opcion != 7);
    }

    private static void leerPuntos(Figura figura, Scanner scanner, int cantidadPuntos) {
        for (int i = 1; i <= cantidadPuntos; i++) {
            System.out.print("Ingrese la coordenada x del punto " + i + ": ");
            double x = scanner.nextDouble();
            System.out.print("Ingrese la coordenada y del punto " + i + ": ");
            double y = scanner.nextDouble();
            Punto punto = new Punto(x, y);
            figura.agregarPunto(punto);
        }
    }
}