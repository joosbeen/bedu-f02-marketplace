package producto

import carrito.Carrito
import utileria.mensajeError

class Productos {

    companion object {
        private var productos = mutableListOf<Producto>(
            Producto(id = 1, nombre = "Chamarra Thats Hot Estilo Casual", stock = 1, precio = 299f, descripcion = "Estilo Casual En Poliéster Para Mujer"),
            Producto(id = 2, nombre = "Tenis adidas", stock = 4, precio = 2111f, descripcion = "Ultrabounce Running Horma Clásica Para Mujer"),
            Producto(id = 3, nombre = "Playera Reebok", stock = 0, precio = 345f, descripcion = "Wor Melange Tee Deportiva Para Hombre"),
            Producto(id = 4, nombre = "Short Reebok", stock = 3, precio = 81.9f, descripcion = "Graphic Speed 2.0 Deportivo Para Hombre"),
            Producto(id = 5, nombre = "Gorra Red Bull Racing", stock = 0, precio = 95.9f, descripcion = "Visera Curva Sergio Perez 2022 Azul Ma"),
        )

        /**
         * Agregar a carrito
         */
        fun addCart(producto: Producto) {

            val findProducto = productos.find { it.id == producto.id }
            if (findProducto?.stock == 0) {
                mensajeError("Producto no disponibe")
                return
            }

            productos.forEach {
                if (it.id == producto.id) {
                    it.stock--
                }
            }

            Carrito.add(producto)

        }

        /**
         * Obtener lista completa de productos
         */
        fun findAll(): MutableList<Producto> {
            return productos
        }

        /**
         * Obtener lista de productos con stock
         */
        fun findStock(): List<Producto> {
            val stocks = productos.filter { it.stock > 0 }
            return stocks
        }

        /**
         * Buscar producto por id
         */
        fun findById(id: Long?): Producto? {
            return productos.find { it.id == id }
        }
    }

}