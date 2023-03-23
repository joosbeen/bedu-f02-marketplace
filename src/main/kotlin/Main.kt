import sesion.SesionUser
import usuario.UserAdmin
import usuario.UserCliente
import usuario.Usuario
import utileria.inputRequiered
import utileria.inputRequieredOptions

var usuariosRegistrados = mutableListOf<Usuario>(
    UserCliente(nombre = "Jose", correo = "jose@gmail.com", contrasena = "12345"),
    UserAdmin(nombre = "Super Admin", correo = "admin@gmail.com", contrasena = "admin123")
)

fun main(args: Array<String>) {
    menu()
}

/**
 * Menu principal de la aplicación
 */
fun menu() {

    println()
    println("1) REGISTRARSE")
    println("2) INICIAR SESION")
    println("3) SALIR")

    val opcion = inputRequieredOptions(
        "Ingresa el número de la opción: ",
        "Selecciona una opción valida.",
        arrayOf("1", "2", "3"),
        { menu() }
    )

    /*println()
    println("Ingresa el número de la opción: ")
    val opcion = readLine()*/

    when (opcion) {
        "1" -> registrarse()
        "2" -> iniciar_sesion()
        "3" -> salir()
    }
}

/**
 * Menu principal opcion 1) Registrarse
 */
fun registrarse() {

    var nombre = inputRequiered(
        "Ingresa tu nombre: ",
        "* Nombre es obligatorio.",
        "Ingresa tu nombre nuevamente: "
    )

    var correo = inputRequiered(
        "Ingresa tu correo: ",
        "* Correo es obligatorio.",
        "Ingresa tu correo nuevamente:"
    )

    var contrasena = inputRequiered(
        "Ingresa tu contraseña: ",
        "* Contraseña es obligatorio.",
        "Ingresa tu contraseña nuevamente: "
    )

    // Datos son validos
    // Se guardan datos en sesion
    val usuario = UserCliente(nombre = nombre, correo = correo, contrasena = contrasena)
    usuariosRegistrados.add(usuario)
    iniciar_sesion()

}

/**
 * Menu principal opcion 2) iniciar sesion
 */
fun iniciar_sesion() {

    var correo = inputRequiered(
        "Ingresa tu correo: ",
        "* Correo es obligatorio.",
        "Ingresa tu correo nuevamente: "
    )

    var contrasena = inputRequiered(
        "Ingresa tu contraseña: ",
        "* Contraseña es obligatorio",
        "Ingresa tu contraseña nuevamente: "
    )

    val login = usuariosRegistrados.find { it.correo == correo && it.contrasena == contrasena }

    if (login != null) {

        println("---------- Bienvenido ${SesionUser.user?.nombre} ----------")

        SesionUser.user = login
        SesionUser.user?.showMenu()
    } else {
        println("Datos de usuario invalidos. Vuelve a intentarlo: \n")
        iniciar_sesion()
    }

}

/**
 * Menu principal opcion 3) Salir
 */
fun salir() {
    println("---------------------------")
    println("----- !VUELVA PRONTO! -----")
    println("---------------------------")
}
