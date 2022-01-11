/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.marvel.api.entity.pojo;

import java.util.List;
import lombok.Data;

/**
 *
 * @author hilso
 */
@Data
class Stories {

    private int id;
    private String title;
    private String description;
    private Thumbnail thumbnail;
    private List<Comincs> comics;
}
