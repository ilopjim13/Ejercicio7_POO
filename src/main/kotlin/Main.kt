fun main() {

    val persona1 = Persona("123456789H")
    val persona2 = Persona("123456789H")
    persona1.agregarCuentas("1111111", 0)
    persona1.agregarCuentas("222222", 700)
    persona2.agregarCuentas("3333333", 450)
    persona2.agregarCuentas("123456", 500)


    persona1.cuentas[0].recibirAbono(1100)
    persona1.cuentas[1].realizarPago(750)

    if (persona1.personaMorosa(persona1)) println("Esta es una persona morosa.")

    persona2.realizarTransferencia(persona1, persona2.cuentas[1].numCuenta, persona1.cuentas[1].numCuenta, 150)

}