package ventas

import producto.Producto
import usuario.Usuario

class Venta(val id: Int, productos: MutableList<Producto>, usuario: Usuario) {
}