class Cuenta(val numCuenta:String, var saldo:Int) {


    fun consultarSaldo() {
        println("Tu saldo actual es de ${this.saldo}Є")
    }

    fun recibirAbono(cant:Int) {
        this.saldo += cant
    }

    fun realizarPago(cant: Int) {
        this.saldo -= cant
    }
}