package interfaz.marvel.integration;

import interfaz.marvel.api.entity.pojo.Characters;
import interfaz.marvel.api.entity.pojo.CharactersData;
import interfaz.marvel.api.entity.pojo.ComicsData;
import interfaz.marvel.api.entity.pojo.StoriesData;
import interfaz.marvel.utils.CharactersUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CharactersClientImpl implements CharactersClient {

    private WebClient webClient;

    @Value("${marvelApiPublicKey}")
    public String publicKey;
    @Value("${marvelApiPrivateKey}")
    public String privateKey;

    public CharactersClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://gateway.marvel.com:443/v1/public/").build();
    }

    @Cacheable(value = "characters")
    @Override
    public Flux<CharactersData> getCharacters() {

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToFlux(CharactersData.class).cache().retry();
    }

    @Cacheable(value = "characters")
    @Override
    public Mono<CharactersData> getCharacterss(String nombre) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("name", nombre)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToMono(CharactersData.class).cache().retry();
    }

    @Cacheable(value = "characters")
    @Override
    public Flux<CharactersData> getCharacters(String nombre) {

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("nameStartsWith", nombre)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToFlux(CharactersData.class).cache().retry();
    }

    @Cacheable(value = "characters")
    @Override
    public Flux<CharactersData> getCharacters(String nombre, String historietas, String serie) {
        Map parametros = new HashMap();
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("name", nombre)
                .queryParam("stories", historietas)
                .queryParam("series", serie)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToFlux(CharactersData.class).cache().retry();
    }

    @Override
    public Mono<CharactersData> getCharactersById(int id) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters/" + id)
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToMono(CharactersData.class).retry();
    }

    @Override
    public Flux<ComicsData> getComics() {

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/comics")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToFlux(ComicsData.class).cache().retry();
    }

    @Override
    public Mono<ComicsData> getComics(int id) {

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/comics")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("id", id)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToMono(ComicsData.class).cache().retry();
    }

    @Override
    public Mono<CharactersData> getCharactersPowers(int id) {
        return null;
    }

    @Override
    public Flux<StoriesData> getStories(String creator) {

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/stories")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                .queryParam("creators", creator)
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToFlux(StoriesData.class).cache().retry();

    }
    @Override
    public Flux<StoriesData> getStories() {

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/stories")
                .queryParam("ts", CharactersUtil.timeStamp)
                .queryParam("apikey", publicKey)
                
                .queryParam("hash", CharactersUtil.MD5hash(publicKey, privateKey, CharactersUtil.timeStamp))
                .build())
                .retrieve()
                .bodyToFlux(StoriesData.class).cache().retry();

    }
}
