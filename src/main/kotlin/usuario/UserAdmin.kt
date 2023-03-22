package usuario

import utileria.menuAdminInicio
import menu
import ventas.HistorialVentas
import java.util.*

class UserAdmin(id: Long = Date().time, nombre: String, correo: String, contrasena: String) :
    Usuario(id, nombre, correo, contrasena) {
    override fun showMenu() {

        menuAdminInicio()

        println("------------------------------")
        println("----- Menu de Administrador, Selecciona una opcion:  -----")
        println("------------------------------")

        val opcion = readLine()

        when (opcion) {
            "1" -> opcionVerVentasTotales()
            "2" -> opcionProductos()
            "3" -> opcionVerClientes()
            "4" -> menu()
            else -> {
                println("\nSelecciona una opción valida.")
                showMenu()
            }
        }

    }

    private fun opcionVerVentasTotales() {
        val ventasTotales = HistorialVentas.list()
    }
}