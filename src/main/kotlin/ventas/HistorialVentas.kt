package ventas

import producto.Producto
import usuario.UserCliente

object HistorialVentas {

    private var ventas = mutableListOf<Venta>(
        Venta(id = 230, productos = mutableListOf(
            Producto(id = 1, nombre = "Producto 1", stock = 1, precio = 99.9f, descripcion = "Descripcion 1"),
            Producto(id = 2, nombre = "Producto 2", stock = 4, precio = 155.5f, descripcion = "Descripcion 2")
        ), usuario = UserCliente(nombre = "Jose", correo = "jose@gmail.com", contrasena = "12345"))
    )

    fun add(venta: Venta) {

    }

    fun list(): MutableList<Venta> {
        return ventas
    }

}

