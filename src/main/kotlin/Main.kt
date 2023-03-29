import sesion.SesionUser
import usuario.UserAdmin
import usuario.UserCliente
import usuario.Usuario
import utileria.*

var usuariosRegistrados = mutableListOf<Usuario>(
    UserCliente(nombre = "Jose", correo = "jose@gmail.com", contrasena = "12345"),
    UserCliente(nombre = "Carlos", correo = "carlos@gmail.com", contrasena = "Carlos12"),
    UserCliente(nombre = "Juan", correo = "juan@gmail.com", contrasena = "Juan123"),
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

    mensajeTitulo("REGISTRAR")

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

    /* Guardar datos nuevos del usuario. */
    val usuario = UserCliente(nombre = nombre, correo = correo, contrasena = contrasena)
    usuariosRegistrados.add(usuario)
    println("Registro exitoso!")
    iniciar_sesion()

}

/**
 * Menu principal opcion 2) iniciar sesion
 */
fun iniciar_sesion() {

    mensajeTitulo("INICIAR SESION")

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

    /* Validar datos de usuario */
    val login = usuariosRegistrados.find { it.correo == correo && it.contrasena == contrasena }

    if (login != null) { /* Si existe el usuario */

        mensajeTitulo("Bienvenido ${login.nombre}")

        SesionUser.user = login
        SesionUser.user?.showMenu()
    } else { /* Si no existe el usuario */
        mensajeError("Datos de usuario invalidos. Vuelve a intentarlo:")
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
