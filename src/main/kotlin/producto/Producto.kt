package producto

import java.util.*

data class Producto(val id: Long = (Date().time + (1..100).random()), val nombre: String, val stock: Int, val precio: Float, val descripcion: String)
