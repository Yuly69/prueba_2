public class tienda {

    private int hamburguesa= 20000;
    private int salchipapa= 10000;
    private int perro= 15000;
    private int gaseosa = 4000;
    private int te = 3000;
    private int agua = 8000;

    tienda(int hamburguesa, int salchipapa, int perro, int gaseosa, int te, int agua){
        this.hamburguesa= hamburguesa;
        this.salchipapa= salchipapa;
        this.perro= perro;
        this.gaseosa= gaseosa;
        this.te= te;
        this.agua= agua;
    }

    public int getHamburguesa(){
        return hamburguesa;
    }
    public int getSalchipapa(){
        return salchipapa;
    }
    public int getPerro(){
        return perro;
    }
    public int getGaseosa(){
        return gaseosa;
    }
    public int getTe(){
        return te;
    }
    public int getAgua(){
        return agua;
    }
}
