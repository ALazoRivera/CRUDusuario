package com.fabril.tarea.controller;

import com.fabril.tarea.domain.Usuario;
import com.fabril.tarea.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuario(){
        return usuarioRepository.listar();
    }

    @PostMapping
    public ResponseEntity<?>  createUsuario(@RequestBody Usuario usuario) {
         usuarioRepository.guardar(usuario);
      return  ResponseEntity.ok("Se agregado al Usuario");
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable  long id){
        Usuario usuario = usuarioRepository.findByid(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id:" + id));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable long id,@RequestBody Usuario usuarioDetails) {
        Usuario updateUsuario = usuarioRepository.findByid(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: " + id));

        updateUsuario.setName(usuarioDetails.getName());
        updateUsuario.setLastName(usuarioDetails.getLastName());
        updateUsuario.setDate(usuarioDetails.getDate());
        updateUsuario.setPhone(usuarioDetails.getPhone());
        updateUsuario.setAddress(usuarioDetails.getAddress());

        usuarioRepository.guardar(updateUsuario);

        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable long id){

        Usuario usuario = usuarioRepository.findByid(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con id: " + id));

        usuarioRepository.eliminar(usuario);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
