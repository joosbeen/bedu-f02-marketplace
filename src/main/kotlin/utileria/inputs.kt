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
        mensajeError(lblError)
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
 *  opciones: Lista de opciones permitida
 *  lambda: funciones que trae el menu a mostrar
 */
fun inputRequieredOptions(lblTitulo: String, lblError: String, opciones: Array<String>, showMenu: () -> Unit): String {

    println()
    println(lblTitulo)
    val entrada = readLine() ?: ""

    while (entrada.isEmpty() || entrada.isBlank() || !opciones.contains(entrada)) {
        mensajeError("$lblError")
        showMenu()
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
 *  opciones: Lista de opciones permitida
 */
fun inputRequiered(lblTitulo: String, lblError: String, lblTituloIntento: String,  opciones: Array<String>): String {
    println(lblTitulo)
    var entrada = readLine() ?: ""

    while (entrada.isEmpty() || entrada.isBlank() || !opciones.contains(entrada)) {
        mensajeError(lblError)
        println(lblTituloIntento)
        entrada = readLine() ?: ""
    }

    return entrada
}