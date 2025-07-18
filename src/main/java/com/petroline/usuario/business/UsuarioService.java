package com.petroline.usuario.business;

import com.petroline.usuario.business.converter.UsuarioConverter;
import com.petroline.usuario.business.dto.UsuarioDTO;
import com.petroline.usuario.infrastructure.entity.Usuario;
import com.petroline.usuario.infrastructure.repository.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }

}
