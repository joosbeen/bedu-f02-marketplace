package ventas

import producto.Producto
import producto.Productos
import usuario.UserCliente

object HistorialVentas {

    private var ventas = mutableListOf(
        Venta(
            id = 230,
            productos = mutableListOf(
                Productos.findAll()[0],
                Productos.findAll()[1],
                Productos.findAll()[2]
            ),
            usuario = UserCliente(nombre = "Jose", correo = "jose@gmail.com", contrasena = "12345")
        )
    )

    /**
     * Agregar una venta a la lista.
     */
    fun add(venta: Venta) {
        ventas.add(venta)
    }

    /**
     * Obtener lista de ventas registradas
     */
    fun list(): MutableList<Venta> {
        return ventas
    }

}

