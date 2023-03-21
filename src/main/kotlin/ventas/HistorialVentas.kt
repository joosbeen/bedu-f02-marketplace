package ventas

object HistorialVentas {

    private var ventas = mutableListOf<Venta>()

    fun add(venta: Venta) {

    }

    fun list(): MutableList<Venta> {
        return ventas
    }

}

