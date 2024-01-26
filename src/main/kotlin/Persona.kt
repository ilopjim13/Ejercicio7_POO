/**
 * Clase persona con el dni y una lista con las cuentas de la persona,
 *
 * @param dni :String DNI de la persona con el que se va a identificar
 * @param cuentas :Array<Cuenta> array con las cuentas de tipo Cuenta de la persona
 */
class Persona(val dni: String, var cuentas:Array<Cuenta>) {

    init {
        require(cuentas.count() < 3 ) {"**ERROR**"}
    }
    fun personaMorosa(persona:Persona) : Boolean {
        persona.cuentas.forEach {if (it.saldo < 0) return true}
        return false
    }

    fun agregarCuentas() {

    }

    fun realizarTransferencia(personaB:Persona, numCuenta:String, numCuentaB:String, cant:Int) {
        var transferenciaExitosa = false

        for (cuenta in this.cuentas) {
            if(numCuenta != cuenta.numCuenta ) {
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