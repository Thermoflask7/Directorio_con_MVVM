package zaragoza.mateo.directorio.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import zaragoza.mateo.directorio.modelos.Usuario
import zaragoza.mateo.directorio.modelos.UsuarioRepositorio
import kotlin.collections.emptyList

class UsuarioViewModel (
    private val repositorio: UsuarioRepositorio
) : ViewModel() {
    private val _usuarios = mutableStateOf<List<Usuario>>(emptyList())
    val usuarios: State<List<Usuario>> = _usuarios

    val miUsuario: Usuario = repositorio.getMiUsuario()

    init{
        cargarUsuarios()
    }
    private fun cargarUsuarios(){
        _usuarios.value = repositorio.getUsuarios()
    }
}