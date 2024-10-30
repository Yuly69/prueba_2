class Trabajador extends Persona {

    String ocupacion;
    int salario;

    public Trabajador(String ocupacion, int salario, String nombre, int edad) {
        super(nombre, edad);
        this.ocupacion= ocupacion;
        this.salario= salario;
        
    }

    public String getOcupacion(){
        return ocupacion;
    }
    public int getSalario(){
        return salario;
    }
}
