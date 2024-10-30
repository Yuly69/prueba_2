public class cuentaBancaria {
    String nombre_titular;
    String apellido_titular;
    String numero_cuenta;
    String tipo_cuenta;
    float saldo_cuenta= 0;

    public cuentaBancaria(String nombre_titular, String apellido_titular, String numero_cuenta, String tipo_cuenta, float saldo_cuenta){
        this.nombre_titular= nombre_titular;
        this.apellido_titular= apellido_titular;
        this.numero_cuenta= numero_cuenta;
        this.tipo_cuenta= tipo_cuenta;
    }

    String getNombre(){
        return nombre_titular;
    }
    String getApellido(){
        return apellido_titular;
    }
    String getNumeroCuenta(){
        return numero_cuenta;
    }
    String getTipoCuenta(){
        return tipo_cuenta;
    }
    float getSaldo(){
        return saldo_cuenta;
    }

    public boolean comparar(cuentaBancaria otraCuenta){
        return this.numero_cuenta == otraCuenta.numero_cuenta && this.saldo_cuenta == otraCuenta.saldo_cuenta;
    }
/* 
    public boolean trasferir(cuentaBancaria otraCuenta, float monto){
        if (this.saldo_cuenta >= monto) {
            this.retirar(monto);
            otraCuenta.consignar(monto);
            return true
        }
    } */

}
 