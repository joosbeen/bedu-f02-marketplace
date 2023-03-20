package carrito

import producto.Producto

object Carrito {

    private var cart = mutableListOf<Producto>()

    fun add(producto: Producto): Unit {
        cart.add(producto)
    }

    fun list(): MutableList<Producto> {
        return cart
    }

    fun removeProducto(producto: Producto) {
        cart.remove(producto)
    }

    fun clear() {
        cart = mutableListOf()
    }

}