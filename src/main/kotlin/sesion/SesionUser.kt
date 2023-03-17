package sesion

import usuario.Usuario

/**
 * Sesion del usuario.
 * Polimorfismo
 */
object SesionUser {

    var user: Usuario? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }
        get() {
            return field
        }

}