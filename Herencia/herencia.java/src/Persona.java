import java.io.*;

public class Persona {
    
    private static class parametrosPersona{
    private String nombre;
    private int edad;
    }
    private parametrosPersona persona;

    public Persona(String nombre, int edad){
        persona = new parametrosPersona();
        persona.nombre = nombre;
        persona.edad = edad;
    }

    public String getNombre(){
        return persona.nombre;
    }

    public int getEdad(){
        return persona.edad;
    }


    public void mostrarInfo(){
        System.out.println("Nombre: "+ persona.nombre);
        System.out.println(("Edad: "+ persona.edad));

    }

    public void escribirArchivo(String nombreArchivo){
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(persona.nombre + "\n");
            writer.write(persona.edad + "\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}