/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.marvel.api.service;

import interfaz.marvel.api.entity.SsUsuarios;
import java.util.List;

/**
 *
 * @author hilso
 */
public interface UsuarioService {

   List<SsUsuarios> findAll();

    
}
