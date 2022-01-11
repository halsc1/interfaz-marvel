package interfaz.marvel.api.entity.pojo;

import lombok.Data;

@Data
public class Characters {

    private int id;
    private String name;
    private String description;
    private Thumbnail thumbnail;
}
