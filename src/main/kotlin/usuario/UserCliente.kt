package usuario

import carrito.Carrito
import menu
import producto.Producto
import producto.Productos
import sesion.SesionUser
import utileria.*
import ventas.HistorialVentas
import ventas.Venta
import java.util.*

/**
 * Clase hija de clase usuario.
 * Herencia
 */
class UserCliente(id: Long = Date().time, nombre: String, correo: String, contrasena: String) :
    Usuario(id, nombre, correo, contrasena) {

    override fun showMenu() {

        menuClienteInicio()

        print("Ingresa el número de la opción: ")
        val opcion = readLine()

        when (opcion) {
            "1" -> opcionVerProductos()
            "2" -> opcionDetalleProducto()
            "3" -> opcionVerCarrito()
            "4" -> menu()
            else -> {
                println("\nSelecciona una opción valida.")
                showMenu()
            }
        }

    }

    /**
     * Menu opcion 1.
     * Ver lista de productos
     */
    private fun opcionVerProductos() {

        mensajeTitulo("LISTA DE PRODUCTOS")

        val productosLista = Productos.findStock()

        if (productosLista.isEmpty()) {
            mensajeError("Lista de prodcutos vacia.")
        } else {
            productosLista.forEach {
                println("Clave: ${it.id}, Nombre: ${it.nombre}, Precio: ${it.precio}")
            }
        }

        println()
        showMenu()

    }

    /**
     * Menu opcion 2.
     * Ver detalle de carrito, opciones:
     * 1) Agregar
     * 2) Comprar
     * 3) Regresar
     */
    private fun opcionDetalleProducto() {

        println("Ingresa la clave del producto: ")
        val clave = readLine() ?: ""
        val id = clave.toLongOrNull()

        if (clave.isEmpty() || clave.isBlank() || id == null) {
            mensajeError("Clave de producto invalida.")
            showMenu()
        }

        val producto = Productos.findById(id)

        if (producto == null) {
            mensajeError("Clave de producto invalida.")
            showMenu()
        } else if (producto.stock == 0) {
            mensajeError("Producto fuera de stock.")
            showMenu()
        } else {
            opcionesDetalleProducto(producto)
        }

    }

    private fun opcionesDetalleProducto(producto: Producto) {

        mensajeTitulo("DETALLE DE PRODUCTO")

        println(
            """
            Clave: ${producto.id}
            Producto: ${producto.nombre}
            Precio: ${producto.precio}
            Stock: ${producto.stock}
            Descripcion: ${producto.descripcion}
        """.trimIndent()
        )

        menuClienteDetalleProducto()

        println("\nIngrese su opcion:")

        var opcion = readLine() ?: ""
        val opciones = arrayOf("1", "2", "3")

        while (opcion.isEmpty() || opcion.isBlank() || !opciones.contains(opcion)) {

            mensajeError("Ingrese una opcion valida.")
            opcion = readLine() ?: ""

        }

        when (opcion) {
            "1" -> {
                //Carrito.add(producto)
                Productos.addCart(producto)
                mensajeTitulo("SE AGREGO AL CARRITO!")
                showMenu()
            }
            "2" -> {
                //Carrito.add(producto)
                Productos.addCart(producto)
                comprarProductos()
            }

            else -> showMenu()
        }


    }

    /**
     * Menu opcion 3.
     * Ver lista de carrito, opciones:
     * 1) Comprar
     * 2) Regresar
     */
    private fun opcionVerCarrito() {

        val carritoProductos = Carrito.list()

        if (carritoProductos.size == 0) {
            mensajeError("Su carrito esta vacio, agregue un producto")
            showMenu()
            return
        }

        mensajeTitulo("MI CARRITO")
        var total = 0f
        carritoProductos.forEach {
            total += it.precio
            println("Clave: ${it.id}, Nombre: ${it.nombre}, Precio: $ ${it.precio}, Descripcion: ${it.descripcion}")
        }
        println("Total de compra: $total")

        menuClienteVerCarrito()

        println("\nIngresa una opcion:")
        var opcion = readLine() ?: ""
        val opciones = arrayOf("1", "2")

        while (opcion.isEmpty() || opcion.isBlank() || !opciones.contains(opcion)) {

            mensajeError("Ingrese una opcion valida.")
            opcion = readLine() ?: ""

        }

        when (opcion) {
            "1" -> comprarProductos()
            "2" -> showMenu()
        }

    }


    /**
     * Menu opcion 4.
     * Comprar lisa de carrito, opciones:
     * 1) Comprar
     * 2) Regresar
     */
    private fun comprarProductos() {

        val carritoProductos = Carrito.list()

        if (carritoProductos.size == 0) {
            mensajeError("Su carrito se encuentra vacio.")
        } else {

            println("Ingresa tu numero de tarjeta")
            var opcion = readLine() ?: ""

            while (opcion.isEmpty() || opcion.isBlank()) {

                mensajeError("Ingrese una opcion valida.")
                opcion = readLine() ?: ""

            }

            val venta = Venta(1, carritoProductos, SesionUser.user!!)
            HistorialVentas.add(venta)

            println("Compra en proceso.")
            println("Compra en proceso..")
            println("Compra en proceso...")
            println("Compra en proceso....")
            println("Compra exiosa!")
            Carrito.clear()

        }

        showMenu()

    }

}

