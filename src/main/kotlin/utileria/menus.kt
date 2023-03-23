package utileria

fun menuClienteInicio() {
    println("1) Ver productos")
    println("2) Detalle producto")
    println("3) Ver carrito")
    println("4) Cerrar Sesion")
    println()
}

fun menuClienteDetalleProducto() {
    mensajeError("Opcines: ")
    println("1) Agregar")
    println("2) Comprar")
    println("3) Regresar")
}

fun menuClienteVerCarrito() {
    println("\nMenu opciones:")
    println("1) Comprar")
    println("2) Regresar")
}

fun menuAdminInicio() {
    println("1) Ventas totales")
    println("2) Productos")
    println("3) Clientes Registrados")
    println("4) Cerrar Sesion")
}