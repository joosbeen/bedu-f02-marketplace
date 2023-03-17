package usuario

import java.util.*

/**
 * Clase hija de clase usuario.
 * Herencia
 */
class UserCliente(id: Long = Date().time, nombre: String, correo: String, contrasena: String) : Usuario(id, nombre, correo, contrasena) {
    override fun showMenu() {
        println("-------------------------------")
        println("---------- menu aqui ----------")
        println("-------------------------------")
    }

}