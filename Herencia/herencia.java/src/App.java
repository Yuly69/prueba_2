public class App {

    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30);
        persona.mostrarInfo();
        
        System.out.println();

        Estudiante estudiante = new Estudiante("Ana", 20, "Ingeniería");
        estudiante.mostrarInfo();

    }
}
