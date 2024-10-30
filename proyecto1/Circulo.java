public class Circulo {
    int radio;

    Circulo(int radio){ // No dice publico porque la clase principal es publico, si es privado, entonces si se aclara que el constructor es público
        this.radio= radio;
    }

    double calcularArea(){
    return Math.PI*Math.pow(radio, 2); //Pow es para calcular potencias      
    }

    double calcularPerimetro(){
        return 2*Math.PI*radio;
    }
}
