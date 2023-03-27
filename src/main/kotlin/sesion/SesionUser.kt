package sesion

import usuario.Usuario

/**
 * Sesion del usuario.
 * Polimorfismo
 */
object SesionUser {

    var user: Usuario? = null
        set(value) {
            field = value
        }
        get() {
            return field
        }

}