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
class StoriesResults {
    private List<Stories> results;
    
}
