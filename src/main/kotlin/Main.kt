import sesion.SesionUser
import usuario.UserCliente
import usuario.Usuario

var usuariosRegistrados = mutableListOf<Usuario>(UserCliente(nombre = "Jose", correo = "jose@gmail.com", contrasena = "12345"))


fun main(args: Array<String>) {
    menu()
}

fun menu() {

    println()
    println("1) REGISTRARSE")
    println("2) INICIAR SESION")
    println("3) SALIR")

    println()
    print("Ingresa el número de la opción: ")
    val opcion = readLine()

    when(opcion) {
        "1" -> registrarse()
        "2" -> iniciar_sesion()
        "3" -> println("Opcion 3 Salir")
        else -> {
            println("\nSelecciona una opción valida.")
            menu()
        }
    }
}
fun registrarse() {

    println("Ingresa tu nombre: ")
    var nombre = readLine()?: ""

    // Validar nombre no este vacio
    while (nombre.isEmpty() || nombre.isBlank()) {
        println("Ingresa nombre valido.!!!")
        println()
        println("Ingresa tu nombre nuevamente: ")
        nombre = readLine()?: ""
    }

    println("Ingresa tu correo: ")
    var correo = readLine()?:""

    // Validar correo no este vacio
    while (correo.isEmpty() || correo.isBlank()) {
        println("Ingresa correo valido!!!!.")
        println()
        println("Ingresa tu correo nuevamente: ")
        correo = readLine()?:""
    }

    println("Ingresa tu contraseña: ")
    var contrasena = readLine()?:""

    // Validar contraseña no este vacio
    while (contrasena.isEmpty() || contrasena.isBlank()) {
        println("Ingresa una contrasena valida!!!!!.")
        println()
        println("Ingresa tu contraseña nuevamente: ")
        contrasena = readLine()?:""
    }

    // Datos son validos
    // Se guardan datos en sesion
    val usuario = UserCliente(nombre = nombre, correo = correo, contrasena = contrasena)
    usuariosRegistrados.add(usuario)
    iniciar_sesion()


}

fun iniciar_sesion () {
    println("Ingresa tu correo: ")
    var correo = readLine()?:""

    // Validar correo no este vacio
    while (correo.isEmpty() || correo.isBlank()) {
        println("Ingresa correo valido!!!!.")
        println()
        println("Ingresa tu correo nuevamente: ")
        correo = readLine()?:""
    }

    println("Ingresa tu contraseña: ")
    var contrasena = readLine()?:""

    // Validar contraseña no este vacio
    while (contrasena.isEmpty() || contrasena.isBlank()) {
        println("Ingresa una contrasena valida!!!!!.")
        println()
        println("Ingresa tu contraseña nuevamente: ")
        contrasena = readLine()?:""
    }

    val login = usuariosRegistrados.find { it.correo == correo && it.contrasena == contrasena }

    if (login != null){
        SesionUser.user = login
        SesionUser.user?.showMenu()
    }else {
        println("Datos de usuario invalidos. Vuelve a intentarlo: \n")
        iniciar_sesion()
    }

}