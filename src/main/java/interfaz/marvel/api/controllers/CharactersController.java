/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.marvel.api.controllers;

import interfaz.marvel.api.entity.SsUsuarios;
import interfaz.marvel.api.entity.pojo.Characters;
import interfaz.marvel.api.entity.pojo.CharactersData;
import interfaz.marvel.api.entity.pojo.ComicsData;
import interfaz.marvel.api.entity.pojo.StoriesData;
import interfaz.marvel.api.service.UsuarioService;
import interfaz.marvel.integration.CharactersClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author hilso
 */
@RestController
@RequestMapping("api")
public class CharactersController {

    private static final Logger logger = LoggerFactory.getLogger(CharactersController.class);

    @Autowired
    UsuarioService usuarioService;

    private CharactersClient charactersService;

    public CharactersController(CharactersClient charactersService) {
        this.charactersService = charactersService;
    }

    //@GetMapping
    @RequestMapping(value = "usuarios/listar", method = RequestMethod.GET)
    public List<SsUsuarios> findAll() {
        logger.debug("Obteniendo todos los usuarios");
        return usuarioService.findAll();
    }

    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/characters")
    public Flux<CharactersData> getCaracters() {
        return charactersService.getCharacters();
    }

    //1	Buscar a los personajes de Marvel por nombre, historietas y serie.  
    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/characters/{nombre}/{historietas}/{serie}")
    public Flux<CharactersData> getCaracters(@PathVariable("nombre") String nombre, @PathVariable("historietas") String historietas, @PathVariable("serie") String serie) {

        return charactersService.getCharacters(nombre, historietas, serie);
    }

    //2	Obtener el listado de comic que tiene un personaje especifico.
    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/characters/{nombre}")
    public Flux<CharactersData> getCaracters(@PathVariable("nombre") String nombre) {

        return charactersService.getCharacters(nombre);
    }

    //3	Obtener la imagen y descripción de un personaje especifico.
    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/charactersimage/{nombre}")
    public Mono<CharactersData> getCaracterss(@PathVariable("nombre") String nombre) {

        return charactersService.getCharacterss(nombre);
    }

    //4 Mostrar listas de comic completas 
    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/comics")
    public Flux<ComicsData> getComics() {

        return charactersService.getComics();
    }
//5Mostrar comic filtrado por id 

    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/comics/{id}")
    public Mono<ComicsData> getComics(@PathVariable("id") int id) {

        return charactersService.getComics(id);
    }

    //6
    //7	 Mostrar las historietas filtradas por su creador.
    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/stories")
    public Flux<StoriesData> getStories() {

        return charactersService.getStories();
    }

    @ApiOperation(value = "Get marvel characters", notes = "Provides characters ids")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful retrieval of characters", response = Characters.class)
        ,
			@ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping("/stories/{creator}")
    public Flux<StoriesData> getStories(@PathVariable("creator") String creator) {

        return charactersService.getStories(creator);
    }
}
