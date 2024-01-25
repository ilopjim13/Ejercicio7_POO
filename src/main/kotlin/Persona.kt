class Persona(val dni: String, var cuentas:Array<Cuenta>) {

    fun personaMorosa() {
        cuentas.forEach {if (it.saldo < 0) println("Esta persona es muy morosa")}
    }

    fun realizarTransferencia(personaB:Persona) {

    }
}