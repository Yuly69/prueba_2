public class animalHijo extends animal {

    String como_Hace;
    
    public animalHijo(String raza, String color, String genero, int edad, String como_Hace) {
        super(raza, color, genero, edad);
        this.como_Hace = como_Hace;
    }

    public String getComo_Hace(){
        return como_Hace; 
    }
    
    public void mostrarComoHace(){
        System.out.println(" Como hace: "+ como_Hace);
    }
}
 