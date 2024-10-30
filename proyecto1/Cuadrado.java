public class Cuadrado {
    int lado;

    Cuadrado(int lado){
    this.lado= lado;
    }

    double calcularArea(){
        return lado*lado; //Pow es para calcular potencias      
        }
    
    double calcularPerimetro(){
        return lado*4;
        }
}
