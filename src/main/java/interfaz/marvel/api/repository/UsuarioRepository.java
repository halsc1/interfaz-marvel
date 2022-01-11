/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.marvel.api.repository;

import interfaz.marvel.api.entity.SsUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author hilso
 */
public interface UsuarioRepository extends JpaRepository<SsUsuarios, Integer> {

    @Query(value = "SELECT u FROM SsUsuarios u WHERE u.codigoUsuario=:username ", nativeQuery = false)
    SsUsuarios findByUsername(@Param("username") String username);
}
