package ventas

import producto.Producto
import usuario.Usuario

data class Venta(val id: Int, val productos: MutableList<Producto>, val usuario: Usuario) {}