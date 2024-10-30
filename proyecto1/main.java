public class main {
    public static void main(String[] args) {
        Circulo figura1= new Circulo(4);
        Cuadrado figura2= new Cuadrado(8);
        Rectangulo figura3= new Rectangulo(5, 4);
        TrianguloRectangulo figura4= new TrianguloRectangulo(5, 5);

        System.out.println("El valor del circulo es: "+ figura1.calcularArea());
        figura4.determinarTipoTriangulo();
        
    }

}
