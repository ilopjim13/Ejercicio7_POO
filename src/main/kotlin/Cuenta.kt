/**
 * Cuenta del cliente co el numero de cuenta y el saldo que le corresponde a la cuenta.
 * @param numCuenta :String, número de la cuenta del cliente.
 * @param saldo :Int saldo correspondiente a la cuenta del cliente.
 */
class Cuenta(val numCuenta:String, var saldo:Int) {

    /**
     * Permite contultar el saldo de la cuenta.
     */
    fun consultarSaldo() {
        println("Tu saldo actual es de ${this.saldo}Є")
    }

    /**
     * Permite recibir un abono que se le añadirá al saldo de su cuenta.
     */
    fun recibirAbono(cant:Int) {
        this.saldo += cant
    }

    /**
     * Permite realizar un pago para otra cuenta restandoselo de su cuenta.
     */
    fun realizarPago(cant: Int) {
        this.saldo -= cant
    }
}