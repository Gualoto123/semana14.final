public class Punto {
    private double x;
    private double y;
    private double z;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Punto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double calcularDistancia(Punto otroPunto) {
        double dx = x - otroPunto.x;
        double dy = y - otroPunto.y;
        double dz = z - otroPunto.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    public double getZ() {
        return z;
    }}