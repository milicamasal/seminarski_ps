/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Projection;
import java.util.List;

/**
 *
 * @author Milica i Nikola
 */
public interface StorageProjection {

    public Projection saveProjection(Projection projection);

    public List<Projection> getAllProjections();

    public Projection updateProjection(Projection projection);
    
}
