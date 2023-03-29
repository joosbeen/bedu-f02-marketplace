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

        mensajeTitulo("MENU")
        menuClienteInicio()

        val opcion = inputRequieredOptions(
            "Ingresa el número de la opción: ",
            "Selecciono una opción invalida.",
            arrayOf("1", "2", "3", "4")
        ) { showMenu() }

        when (opcion) {
            "1" -> opcionVerProductos()
            "2" -> opcionDetalleProducto()
            "3" -> opcionVerCarrito()
            "4" -> menu()
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

        val clave = inputRequiered(
            "Ingresa la clave del producto: ",
            "Clave de producto invalida.",
            "Ingresa una clave de producto valida: "
        )

        val id = clave.toLongOrNull()

        if (id == null) {
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

        val opciones = arrayOf("1", "2", "3")
        val opcion = inputRequiered(
            "Ingrese su opción:",
            "Selecciono una opción invalida.",
            "Ingrese una opción valida.",
            opciones
        )

        when (opcion) {
            "1" -> {
                Productos.addCart(producto)
                mensajeTitulo("SE AGREGO AL CARRITO!")
                showMenu()
            }

            "2" -> {
                Productos.addCart(producto)
                comprarProductos()
            }

            "3" -> showMenu()
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

        val opciones = arrayOf("1", "2")
        val opcion = inputRequiered(
            "\nIngresa una opcion:",
            "Selecciono una opción invalida.",
            "Ingrese una opción valida.",
            opciones
        )

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

        mensajeTitulo("COMPRAR PRODCUTOS")

        val carritoProductos = Carrito.list()

        if (carritoProductos.size == 0) {
            mensajeError("Su carrito se encuentra vacio.")
        } else {

            var total = 0f
            carritoProductos.forEach { total+=it.precio }

            val opcion = inputRequiered(
                "Ingresa tu numero de tarjeta",
                "Selecciono una opción invalida.",
                "Ingrese una opcion valida."
            )

            println("=== Total = $${total}")
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

