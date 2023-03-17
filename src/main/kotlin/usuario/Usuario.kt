package usuario

import java.util.Date

/**
 * Clase padre usuarios.
 */
abstract class Usuario(val id: Long, val nombre: String, val correo: String, val contrasena: String) {
    abstract  fun showMenu()

}