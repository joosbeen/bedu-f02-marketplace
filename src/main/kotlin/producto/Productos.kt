package producto

class Productos {

    companion object {
        private var productos = mutableListOf<Producto>(
            Producto(id= 1, nombre = "Producto 1", stock = 3, precio = 99.9f, descripcion = "Descripcion 1"),
            Producto(id= 2, nombre = "Producto 2", stock = 4, precio = 155.5f, descripcion = "Descripcion 2"),
            Producto(id= 3, nombre = "Producto 3", stock = 0, precio = 88.9f, descripcion = "Descripcion 3"),
            Producto(id= 4, nombre = "Producto 4", stock = 3, precio = 81.9f, descripcion = "Descripcion 4"),
            Producto(id= 5, nombre = "Producto 5", stock = 0, precio = 95.9f, descripcion = "Descripcion 5"),
        )

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