
    import java.io.*;
    import java.util.Scanner;
     
    public class Paciente {
        private static class HistoriaClinica {
            String nombre;
            int edad;
            String genero;
            int identificacion;
            float estatura;
            String enfermedad;
        }
     
        private HistoriaClinica historia;
     
        public Paciente(String n, int e, String g, int id, float est, String enf) {
            historia = new HistoriaClinica();
            historia.nombre = n;
            historia.edad = e;
            historia.genero = g;
            historia.identificacion = id;
            historia.estatura = est;
            historia.enfermedad = enf;
        }
        public String getNombre() {
            return historia.nombre;
        }
     
        public int getEdad() {
            return historia.edad;
        }
     
        public String getGenero() {
            return historia.genero;
        }
        public int getIdentificacion() {
            return historia.identificacion;
        }
        public float getEstatura() {
            return historia.estatura;
        }
        public String getEnfermedad() {
            return historia.enfermedad;
        }
     
        public void mostrarInfo() {
            System.out.println("Nombre: " + historia.nombre);
            System.out.println("Edad: " + historia.edad);
            System.out.println("Genero: " + historia.genero);
            System.out.println("Identificacion: " + historia.identificacion);
            System.out.println("Estatura: " + historia.estatura);
            System.out.println("Enfermedad: " + historia.enfermedad);
        }
     
        public void escribirArchivo(String nombreArchivo) {
            try (FileWriter writer = new FileWriter(nombreArchivo)) {
                writer.write(historia.nombre + "\n");
                writer.write(historia.edad + "\n");
                writer.write(historia.genero + "\n");
                writer.write(historia.identificacion + "\n");
                writer.write(historia.estatura + "\n");
                writer.write(historia.enfermedad + "\n");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir en el archivo.");
                e.printStackTrace();
            }
        }
     
        public static Paciente leerArchivo(String nombreArchivo) {
            try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
                String nombre = reader.readLine();
                int edad = Integer.parseInt(reader.readLine());
                String genero = reader.readLine();
                int identificacion = Integer.parseInt(reader.readLine());
                float estatura = Float.parseFloat(reader.readLine());
                String enfermedad = reader.readLine();
     
                return new Paciente(nombre, edad, genero, identificacion, estatura, enfermedad);
            } catch (IOException e) {
                System.out.println("Ocurrió un error al leer del archivo.");
                e.printStackTrace();
                return null;
            }
        }
     
        public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
     
            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();
     
            System.out.print("Ingrese la edad: ");
            int edad = sc.nextInt();
     
            sc.nextLine(); // Limpiar el buffer
     
            System.out.print("Ingrese el genero: ");
            String genero = sc.nextLine();
     
            System.out.print("Ingrese la identificacion: ");
            int identificacion = sc.nextInt();
     
            System.out.print("Ingrese la estatura: ");
            float estatura = sc.nextFloat();
     
            sc.nextLine(); // Limpiar el buffer
     
            System.out.print("Ingrese la enfermedad: ");
            String enfermedad = sc.nextLine();
     
            Paciente paciente = new Paciente(nombre, edad, genero, identificacion, estatura, enfermedad);
           // Paciente paciente = new Paciente("Daniel", 105,"Masculino", 100, (float)1.7,"Dolor de cabeza");
            // Escribir en el archivo
            String nombreArchivo = "historia_clinica.txt";
            paciente.escribirArchivo(nombreArchivo);
     
            // Leer del archivo
            Paciente pacienteLeido = Paciente.leerArchivo(nombreArchivo);
            if (pacienteLeido != null) {
                System.out.println("\nInformación del paciente leída desde el archivo:");
                pacienteLeido.mostrarInfo();
            }
     
            sc.close();
        }
    }

