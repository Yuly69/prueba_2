public class TrianguloRectangulo {
    int base;
    int altura;

    TrianguloRectangulo(int base, int altura){
        this.base= base;
        this.altura= altura;
    }

    double calcularArea(){
        return (base*altura)/2; //Pow es para calcular potencias      
        }
    double calcularPerimetro(){
        return (base+altura+calcularHipotenusa()); //Pow es para calcular potencias      
        }
    double calcularHipotenusa(){
        return Math.pow(base*base+ altura*altura, 0.5);
    }

    void determinarTipoTriangulo(){
        if ((base== altura) &&(base==calcularHipotenusa()) &&(altura==calcularHipotenusa())) {
            System.out.println("Es un triangulo equilatero");
            }
        else if((base!= altura) &&(base!=calcularHipotenusa()) &&(altura!=calcularHipotenusa())){
            System.out.println("Es escaleno");
            }
        else{
            System.out.println("Es la otra");
        }    
    
        
    }
}
