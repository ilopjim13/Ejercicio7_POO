/**
 * Clase persona con el dni y una lista con las cuentas de la persona,
 *
 * @param dni :String DNI de la persona con el que se va a identificar
 * @param cuentas :Array<Cuenta> array con las cuentas de tipo Cuenta de la persona
 */
class Persona(val dni: String)  {

    var cuentas = Array(3) {Cuenta("", 0)}
    init {
        require(cuentas.count() <= 3 ) {"**ERROR**"}
    }

    /**
     * Comprueba si en alguna cuenta del cliente este debe dinero, si es así devuelve true.
     * @param persona :Persona persona de la que se va a comprobar si es morosa o no
     * @return Boolean devuelve true si debe dinero y false si no.
     */
    fun personaMorosa(persona:Persona) : Boolean {
        persona.cuentas.forEach {if (it.saldo < 0) return true}
        return false
    }

    /**
     * Agrega una cuenta a la lista de cuentas del cliente que no puede ser más de 3 cuentas
     * @param numC :String numero de la cuenta del cliente
     * @param saldo :Int saldo de la cuenta del cliente.
     */
    fun agregarCuentas(numC:String, saldo: Int){
            if (this.cuentas[0].numCuenta == ""  && this.cuentas[1].numCuenta == "" && this.cuentas[2].numCuenta == "") this.cuentas[0] = Cuenta(numC, saldo)
            else if (this.cuentas[0].numCuenta != ""  && this.cuentas[1].numCuenta == "" && this.cuentas[2].numCuenta == "") this.cuentas[1] = Cuenta(numC, saldo)
            else if (this.cuentas[0].numCuenta != ""  && this.cuentas[1].numCuenta != "" && this.cuentas[2].numCuenta == "") this.cuentas[2] = Cuenta(numC, saldo)
            else if (this.cuentas[0].numCuenta != ""  && this.cuentas[1].numCuenta != "" && this.cuentas[2].numCuenta != "")  println("Limite de cuentas alcanzado.")
    }

    /**
     * Realiza una transferencia entre una persona y otra persona.
     * @param personaB :Persona persona a la que se le va a hacer la transferencia.
     * @param numCuenta :String, número de la cuenta del cliente.
     * @param cant :Int cantidad que se va a transferir.
     */
    fun realizarTransferencia(personaB:Persona, numCuenta:String, numCuentaB:String, cant:Int) {
        var transferenciaExitosa = false

        for (cuenta in this.cuentas) {
            if(numCuenta != cuenta.numCuenta && !transferenciaExitosa) {
                for (cuentaB in personaB.cuentas) {
                    if (numCuentaB != cuentaB.numCuenta) {
                        cuenta.realizarPago(cant)
                        cuentaB.recibirAbono(cant)
                        println("La transferencia se ha completado con éxito.")
                        transferenciaExitosa = true
                        break
                    }
                }
            }
        }

        if (!transferenciaExitosa) println("Lo sentimos, la transferencia no se ha podido completar, inténtelo en otro momento.")

    }
}