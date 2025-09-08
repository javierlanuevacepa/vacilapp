package com.example.vacilapp.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.vacilapp.tipousuario.TipoUsuarioServicio;
import com.example.vacilapp.ApiError;
import com.example.vacilapp.like.LikeREG;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;


@RestController

@RequestMapping(path = "carretapp/v0/usuario")
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioController(UsuarioServicio usuarioServicio){
        this.usuarioServicio = usuarioServicio;


    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioServicio.getAllUsuarios();
    }

    @GetMapping(path = "formated")
    public List<UsuarioDTO> getUsuariosFormateados() {
        return usuarioServicio.getUsuariosFormateados();
    }

    @PostMapping
    public void registrarUsuario(@RequestBody UsuarioREG user){
        usuarioServicio.registrarUsuario(user);
    }

    @PostMapping(path = "iniciarSesion/{nombreUsuario}YkdnM{contrasena}")
    public ResponseEntity<?> iniciarSesionUsuario(@PathVariable("nombreUsuario") String nombreUsuario, @PathVariable("contrasena") String contrasena){
        Usuario user = usuarioServicio.iniciarSesionUsuario(nombreUsuario, contrasena);
        if (user!=null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiError("Usuario o contraseña incorrectos"));
        }
    }

    



}
