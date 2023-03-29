package usuario

import utileria.menuAdminInicio
import menu
import producto.Productos
import usuariosRegistrados
import utileria.inputRequieredOptions
import utileria.mensajeTitulo
import ventas.HistorialVentas
import ventas.Venta
import java.util.*

class UserAdmin(id: Long = Date().time, nombre: String, correo: String, contrasena: String) :
    Usuario(id, nombre, correo, contrasena) {
    override fun showMenu() {

        menuAdminInicio()

        val opciones = arrayOf("1", "2", "3", "4")
        val opcion = inputRequieredOptions(
            "Selecciona una opcion:",
            "\nSelecciona una opción invalida.",
            opciones
        ) {
            showMenu()
        }

        when (opcion) {
            "1" -> opcionVerVentasTotales()
            "2" -> opcionProductos()
            "3" -> opcionVerClientes()
            "4" -> menu()
        }

    }

    /**
     * Opcion 1)
     * Ver ventas realizadas.
     */
    private fun opcionVerVentasTotales() {
        val ventasTotales = HistorialVentas.list()
        ventasTotales.forEach {
            val venta: Venta = it
            println("|---------------------")
            println("| Folio: ${it.id}")
            println("| Cliente: Nombre=${it.usuario.nombre}, Correo=${it.usuario.correo}")
            println("|---------------------")
            it.productos.forEach {
                println("| Clave: ${it.id}, Nombre: ${it.nombre}, Precio: ${it.precio}")
            }
            println("|---------------------\n")
        }
        showMenu()
    }

    /**
     * Opcion 2)
     * Ver prodcutos y su stock.
     */
    private fun opcionProductos() {

        val productos = Productos.findAll()

        mensajeTitulo("LISTA DE PRODUCTOS")
        println("|---------------------")
        productos.forEach {
            println("| Clave: ${it.id}, Nombre: ${it.nombre}, Precio: ${it.precio}, Stock: ${it.stock}, Descripción: ${it.descripcion}")
        }
        println("|---------------------\n")
        showMenu()

    }

    /**
     * Opcion 3)
     * Ver lista de clientes.
     */
    private fun opcionVerClientes() {

        mensajeTitulo("LISTA DE CLIENTES")
        val clientes = usuariosRegistrados.filter { it is UserCliente }
        println("|---------------------")
        clientes.forEach {
            println("| Clave: ${it.id}, Nombre: ${it.nombre}, Clave: ${it.correo}, Contraseña: ${it.contrasena}")
        }
        println("|---------------------\n")
        showMenu()
    }

}