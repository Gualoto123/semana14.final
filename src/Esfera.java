public class Esfera extends Circulo {

    private double radio;

    public Esfera(double radio) {
        super(radio);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }


    public double calcularVolumen() {
        return (4 * Math.PI * radio * radio * radio) / 3;
    }}