import sesion.SesionUser
import usuario.UserCliente
import usuario.Usuario

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
        "2" -> println("Opcion 2")
        "3" -> println("Opcion 3 Salir")
        else -> {
            println("\nSelecciona una opción valida.")
            menu()
        }
    }
}
fun registrarse() {

    println("Ingresa tu nombre: ")
    val nombre = readLine()?: ""

    // Validar nombre no este vacio
    if (nombre.isEmpty() || nombre.isBlank()) {
        println("Ingresa nombre valido.")
        println()
        registrarse()
        return
    }

    println("Ingresa tu correo: ")
    val correo = readLine()?:""

    // Validar correo no este vacio
    if (correo.isEmpty() || correo.isBlank()) {
        println("Ingresa correo valido.")
        println()
        registrarse()
        return
    }

    println("Ingresa tu contraseña: ")
    val contrasena = readLine()?:""

    // Validar contraseña no este vacio
    if (contrasena.isEmpty() || contrasena.isBlank()) {
        println("Ingresa nombre valido.")
        println()
        registrarse()
        return
    }

    // Datos son validos
    // Seguardan datos en sesion
    val usuario = UserCliente(nombre = nombre, correo = correo, contrasena = contrasena)
    SesionUser.user = usuario
    SesionUser.user?.showMenu()

}
