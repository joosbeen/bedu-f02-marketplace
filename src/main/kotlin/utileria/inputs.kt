package utileria

/**
 *  Entrada de dato validando que no sea vacio
 *  y no contenga solo espacios.
 *
 *  lblTitulo: String, mensaje para ingresar por el usuario
 *  lblError: String, mensaje de error si el usuario ingresa un valor invalido.
 *  lblTituloIntento: String, mensaje para solicitarle que escriba de nuevo escriba
 */
fun inputRequiered(lblTitulo: String, lblError: String, lblTituloIntento: String): String {
    println(lblTitulo)
    var entrada = readLine() ?: ""

    // Validar que no este vacio o solo contenga espacios
    while (entrada.isEmpty() || entrada.isBlank()) {
        println(lblError)
        println(lblTituloIntento)
        entrada = readLine() ?: ""
    }

    return entrada
}

/**
 *  Entrada de dato validando que no sea vacio
 *  y no contenga solo espacios.
 *
 *  lblTitulo: String, mensaje para ingresar por el usuario
 *  lblError: String, mensaje de error si el usuario ingresa un valor invalido.
 *  lblTituloIntento: String, mensaje para solicitarle que escriba de nuevo escriba
 */
fun inputRequieredOptions(lblTitulo: String, lblError: String, opciones: Array<String>, showMenu: () -> Unit): String {

    println()
    println(lblTitulo)
    val entrada = readLine() ?: ""

    while (entrada.isEmpty() || entrada.isBlank() || !opciones.contains(entrada)) {
        println("$lblError")
        showMenu()
    }

    return entrada
}