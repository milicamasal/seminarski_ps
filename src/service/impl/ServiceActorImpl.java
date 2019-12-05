/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Actor;
import service.ServiceActor;
import storage.StorageActor;
import storage.impl.database.StorageDatabaseActor;

/**
 *
 * @author Milica i Nikola
 */
public class ServiceActorImpl implements ServiceActor {

    private final StorageActor storageActor;

    public ServiceActorImpl() {
        storageActor = new StorageDatabaseActor();
    }

    @Override
    public Actor saveActor(Actor actor) {
        return storageActor.saveActor(actor);
    }

}
