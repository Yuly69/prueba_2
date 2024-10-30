public class animal {

//atributos clase animal
private String raza;
private String color;
private String genero;
private int edad;

//Constructor
public animal(String raza, String color, String genero, int edad) {
    this.raza = raza;
    this.color = color;
    this.genero = genero;
    this.edad = edad;
}
//Metodos
public String getRaza() { 
    return raza;
}
public String getColor() { 
    return color;
}
public String getGenero() { 
    return genero;
}
public int getEdad(){
    return edad;
}
public void mostrarinformacion () {
    System.out.println("Raza: " +raza+"\n Color: "+color+"\n Genero: "+genero+"\n Edad: "+edad);
}



public static void main(String[] args) throws Exception {

    animal animal1 = new animal("Gato", "Amarillo", "Hembra", 3);

   System.out.println("Raza: "+animal1.getRaza());
   System.out.println("Color: "+animal1.getColor());
   System.out.println("Genero: "+animal1.getGenero());
   System.out.println("Edad: "+animal1.getEdad());

   animal1.mostrarinformacion();
   
}
}
