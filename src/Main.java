import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        List<String> figuras = new ArrayList<>();

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
                        break;
                    case 2:
                        figura = new Cuadrado();
                        leerPuntos(figura, scanner, 2);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        break;
                    case 3:
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        figura = new Circulo(radio);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        break;
                    case 4:
                        figura = new Piramide();
                        leerPuntos(figura, scanner, 4);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        volumen = ((Piramide) figura).calcularVolumen();
                        break;
                    case 5:
                        figura = new Cubo();
                        leerPuntos(figura, scanner, 2);
                        area = figura.calcularArea();
                        perimetro = figura.calcularPerimetro();
                        volumen = ((Cubo) figura).calcularVolumen();
                        break;
                    case 6:
                        System.out.print("Ingrese el radio de la esfera: ");
                        double radioEsfera = scanner.nextDouble();
                        figura = new Esfera(radioEsfera);
                        area = figura.calcularArea();
                        volumen = ((Esfera) figura).calcularVolumen();
                        break;
                    default:
                        continue;
                }

                String informacionFigura = "-------------------------------\n";
                informacionFigura += "       FIGURA      \n";
                informacionFigura += "Figura: " + figura.getClass().getSimpleName() + "\n";
                informacionFigura += "Área: " + area + "\n";

                // para figuras de tres dimensiones
                if (figura instanceof Piramide) {
                    informacionFigura += "Perímetro: " + perimetro + "\n";
                    informacionFigura += "Volumen: " + volumen + "\n";
                } else if (figura instanceof Cubo) {
                    informacionFigura += "Perímetro: " + perimetro + "\n";
                    informacionFigura += "Volumen: " + volumen + "\n";
                } else if (figura instanceof Esfera) {
                    informacionFigura += "Volumen: " + volumen + "\n";
                }

                informacionFigura += "-------------------------------\n";

                figuras.add(informacionFigura);
                System.out.println(informacionFigura);
            }
        } while (opcion != 7);

        // Imprimir  las figuras guardadas
        System.out.println("-------------------------------");
        System.out.println("    FIGURAS GUARDADAS          ");
        System.out.println("-------------------------------");
        for (String figura : figuras) {
            System.out.println(figura);
        }
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