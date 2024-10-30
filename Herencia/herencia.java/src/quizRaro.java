
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Scanner;
     
    class Ficha {
        int codigo;
        String nombre;
        int genero;
        float matricula;
    }
     
    public class quizRaro {
        public static void main(String[] args) {
            // Llama a la clase Ficha y genera el arreglo
            Ficha[] UMNG = new Ficha[3];
           
            // Crear un escáner para leer la entrada del usuario
            Scanner scanner = new Scanner(System.in);
     
            // Variables de acumulación
            int ac = 0, cont_hombres = 0, cont_mujeres = 0;
     
            System.out.println("Digite código, nombre, género (1 para hombre, 2 para mujer), matrícula:");
     
            // Cargar la estructura con los datos
            for (int i = 0; i < 3; i++) {
                UMNG[i] = new Ficha(); // Inicializar el objeto dentro del arreglo
                UMNG[i].codigo = scanner.nextInt(); // Capturar el valor del código en el arreglo creado
                scanner.nextLine(); // Consumir la nueva línea después del int
                UMNG[i].nombre = scanner.nextLine(); // Capturar el nombre
                UMNG[i].genero = scanner.nextInt(); // Capturar el género
                UMNG[i].matricula = scanner.nextFloat(); // Capturar la matrícula
               
                // Sumar la cantidad de matrículas
                ac += UMNG[i].matricula;
     
                // Permite validar si es hombre o mujer
                if (UMNG[i].genero == 1) {
                    cont_hombres++;
                } else {
                    cont_mujeres++;
                }
            }
     
            // Mostrar los datos ingresados
            for (int i = 0; i < 3; i++) {
                System.out.println(UMNG[i].codigo + " " + UMNG[i].nombre + " " + UMNG[i].genero + " " + UMNG[i].matricula);
            }
           
            // Mostrar estadísticas
            System.out.println("\t La cantidad total de ingresos es: " + ac);
            System.out.println("\t El total de hombres es: " + cont_hombres + " y mujeres es: " + cont_mujeres);
     
            // Crear un archivo de salida
            try (FileWriter salida = new FileWriter("prueba7777.xls")) {
                salida.write("UMNG\n");
                salida.write("\t****\n\n");
                for (int i = 0; i < 3; i++) {
                    salida.write(UMNG[i].codigo + " " + UMNG[i].nombre + " " + UMNG[i].genero + " " + UMNG[i].matricula + "\n");
                }
                salida.write("\t La cantidad total de ingresos es: " + ac + "\n");
                salida.write("\t El total de hombres es: " + cont_hombres + " y mujeres es: " + cont_mujeres + "\n");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al escribir el archivo.");
                e.printStackTrace();
            }
     
            scanner.close();
        }
    }

