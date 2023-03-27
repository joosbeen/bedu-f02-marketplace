package carrito

import producto.Producto

object Carrito {

    private var cart = mutableListOf<Producto>()

    /**
     * Agregar nuevo producto
     */
    fun add(producto: Producto): Unit {
        cart.add(producto)
    }

    /**
     * Obtener lista de productos
     */
    fun list(): MutableList<Producto> {
        return cart
    }

    /**
     * remover producto de la lista
     */
    fun removeProducto(producto: Producto) {
        cart.remove(producto)
    }

    /**
     * Limpiar lista de productos.
     */
    fun clear() {
        cart = mutableListOf()
    }

}