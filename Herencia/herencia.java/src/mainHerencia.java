 import java.io.FileWriter;
import java.io.IOException;

public class mainHerencia {

    public static void main(String[] args) {
        
        animalHijo animal1 = new animalHijo("vaca", "Manchado", "Hembra", 4, "MUUuuUuUuUUu");
        
        animal1.mostrarinformacion();
        animal1.mostrarComoHace();

        animalHijo animal2 = new animalHijo("Gato", "Naranja", "Macho", 6, "Miau");
        
        animal2.mostrarinformacion();
        animal2.mostrarComoHace();

        animalHijo animal3 = new animalHijo("Perro", "Negro", "Macho", 3, "Wauf");
        
        animal3.mostrarinformacion();
        animal3.mostrarComoHace();
        
        try (FileWriter salida = new FileWriter("animalitosPrueba.doc")) {
                salida.write("animal\n");
                salida.write("\n****\n\n");
                
                salida.write(animal1.getRaza() + "   " + animal1.getColor() + "   " + animal1.getGenero() + "   " + animal1.getEdad() +"   "+ animal1.getComo_Hace()+ "\n");
                salida.write(animal2.getRaza() + "   " + animal2.getColor() + "   " + animal2.getGenero() + "   " + animal2.getEdad() +"   "+ animal2.getComo_Hace()+ "\n");
                salida.write(animal3.getRaza() + "   " + animal3.getColor() + "   " + animal3.getGenero() + "   " + animal3.getEdad() +"   "+ animal3.getComo_Hace()+ "\n");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir el archivo.");
                e.printStackTrace();
            }
    }
}
