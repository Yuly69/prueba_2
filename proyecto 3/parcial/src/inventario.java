public class inventario {
    private int hamburguesa;
    private int salchipapa;
    private int perro;
    private int gaseosa;
    private int te;
    private int agua;

    public inventario(int hamburguesa, int salchipapa, int perro, int gaseosa, int te, int agua) {
        this.hamburguesa = hamburguesa;
        this.salchipapa = salchipapa;
        this.perro = perro;
        this.gaseosa = gaseosa;
        this.te = te;
        this.agua = agua;
    }

    // Métodos para reducir productos
    public boolean reducirHamburguesa(int cantidad) {
        if (hamburguesa >= cantidad) {
            hamburguesa -= cantidad;
            return true;
        }
        return false;
    }

    public boolean reducirSalchipapa(int cantidad) {
        if (salchipapa >= cantidad) {
            salchipapa -= cantidad;
            return true;
        }
        return false;
    }

    public boolean reducirPerro(int cantidad) {
        if (perro >= cantidad) {
            perro -= cantidad;
            return true;
        }
        return false;
    }

    public boolean reducirGaseosa(int cantidad) {
        if (gaseosa >= cantidad) {
            gaseosa -= cantidad;
            return true;
        }
        return false;
    }

    public boolean reducirTe(int cantidad) {
        if (te >= cantidad) {
            te -= cantidad;
            return true;
        }
        return false;
    }

    public boolean reducirAgua(int cantidad) {
        if (agua >= cantidad) {
            agua -= cantidad;
            return true;
        }
        return false;
    }

    // Métodos para aumentar productos
    public void aumentarHamburguesa(int cantidad) {
        hamburguesa += cantidad;
    }
    public void aumentarSalchipapa(int cantidad) {
        salchipapa += cantidad;
    }
    public void aumentarPerro(int cantidad) {
        perro += cantidad;
    }
    public void aumentarGaseosa(int cantidad) {
        gaseosa += cantidad;
    }
    public void aumentarTe(int cantidad) {
        te += cantidad;
    }
    public void aumentarAgua(int cantidad) {
        agua += cantidad;
    }

    //GETERSS
    public int getHamburguesa() {
        return hamburguesa;
    }
    public int getSalchipapa() {
        return salchipapa;
    }
    public int getPerro() {
        return perro;
    }
    public int getGaseosa() {
        return gaseosa;
    }
    public int getTe() {
        return te;
    }
    public int getAgua() {
        return agua;
    }
}
