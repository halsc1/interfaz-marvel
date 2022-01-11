/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.marvel.integration;

import interfaz.marvel.api.entity.pojo.CharactersData;
import interfaz.marvel.api.entity.pojo.ComicsData;
import interfaz.marvel.api.entity.pojo.StoriesData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author hilso
 */
public interface CharactersClient {

    public Flux<CharactersData> getCharacters();

    public Flux<CharactersData> getCharacters(String nombre);

    public Mono<CharactersData> getCharacterss(String nombre);

    Flux<CharactersData> getCharacters(String nombre, String historietas, String serie);

    public Mono<CharactersData> getCharactersById(int id);

    public Mono<CharactersData> getCharactersPowers(int id);

    public Flux<ComicsData> getComics();

    public Mono<ComicsData> getComics(int id);
    
    public Flux<StoriesData> getStories(String creator);
     public Flux<StoriesData> getStories();
}
