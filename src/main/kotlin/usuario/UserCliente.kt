package usuario

import sesion.SesionUser
import java.util.*

/**
 * Clase hija de clase usuario.
 * Herencia
 */
class UserCliente(id: Long = Date().time, nombre: String, correo: String, contrasena: String) : Usuario(id, nombre, correo, contrasena) {
    override fun showMenu() {
        println("--------------------------------------------------")
        println("---------- Bienvenido ${SesionUser.user?.nombre} ----------")
        println("--------------------------------------------------")

        println("1) Ver productos")
        println("2) Ver carrito")
        println("3) Cerrar Sesion")

    }

}