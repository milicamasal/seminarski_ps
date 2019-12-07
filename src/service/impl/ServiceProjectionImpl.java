/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Projection;
import java.util.List;
import service.ServiceProjection;
import storage.StorageProjection;
import storage.impl.database.StorageDatabaseProjection;

/**
 *
 * @author Milica i Nikola
 */
public class ServiceProjectionImpl implements ServiceProjection {

    private final StorageProjection storageProjection;

    public ServiceProjectionImpl() {
        storageProjection = new StorageDatabaseProjection();
    }

    @Override
    public Projection saveProjection(Projection projection) {
        return storageProjection.saveProjection(projection);

    }

    @Override
    public List<Projection> getAllProjections() {
        return storageProjection.getAllProjections();
    }

    @Override
    public Projection updateProjection(Projection projection) {
        return storageProjection.updateProjection(projection);
    }

}
