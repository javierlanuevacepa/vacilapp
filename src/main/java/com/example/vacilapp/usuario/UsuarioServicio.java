package com.example.vacilapp.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.vacilapp.like.LikeREG;
import com.example.vacilapp.usuario.UsuarioDTO;
import com.example.vacilapp.tipousuario.TipoUsuarioServicio;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;


@Service
public class UsuarioServicio {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioServicio tipoUsuarioServicio;
    

    @Autowired
    public UsuarioServicio(UsuarioRepository usuarioRepository,TipoUsuarioServicio tipoUsuarioServicio){
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioServicio = tipoUsuarioServicio;

    }

    public List<Usuario> getAllUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public void registrarUsuario(UsuarioREG user){
        //OBVIAMENTE AÑADIRLE TODAS LAS VALIDACIONES
        usuarioRepository.save(new Usuario(user.getNombreUsuario(),user.getCorreo(),user.getContrasena(),user.getFotoPerfil(),tipoUsuarioServicio.getTipoUsuarioConId(user.getIdTipoUsuario())));
    }

    public Usuario getUsuarioConId(Long id){
        return usuarioRepository.findById(id).orElseThrow(()->new IllegalStateException("Usuario con Id:"+id+" no encontrado."));
    }

    public List<UsuarioDTO> getUsuariosFormateados(){
        List<UsuarioDTO> usuarios = new ArrayList<>();
        for (Usuario x : getAllUsuarios()){
            usuarios.add(new UsuarioDTO(x));
        }
        return usuarios;
    }

    public Usuario iniciarSesionUsuario(String nombreUsuario,String contrasena){
       return usuarioRepository.loginUsuarioDevolver(nombreUsuario, contrasena).orElseThrow(()->new IllegalStateException("Usuario o contraseña incorrectos."));
    }

    
    



}
