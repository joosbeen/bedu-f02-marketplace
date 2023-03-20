package usuario

import java.util.*

class UserAdmin(id: Long = Date().time, nombre: String, correo: String, contrasena: String) :
    Usuario(id, nombre, correo, contrasena) {
    override fun showMenu() {

        println("------------------------------")
        println("----- MENU DE ADMIN AQUI -----")
        println("------------------------------")

    }
}