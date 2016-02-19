/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.simsilica.es.Entity;
import com.simsilica.es.EntityData;
import com.simsilica.es.EntityId;
import com.simsilica.es.EntitySet;
import java.util.logging.Logger;

/**
 *
 * @author cli
 */
public class CollisionAppState extends AbstractAppState {

    private static final Logger logger = Logger.getLogger(DecayAppState.class.getName());
    private SimpleApplication app;
    private EntityData ed;
    private EntitySet damagingParts;
    private EntitySet defendingParts;

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);

        this.app = (SimpleApplication) app;
        this.ed = this.app.getStateManager().getState(EntityDataState.class).getEntityData();

        damagingParts = ed.getEntities(CollisionShape.class, Position.class);
        defendingParts = ed.getEntities(CollisionShape.class, Position.class);
    }

    @Override
    public void update(float tpf) {
        damagingParts.applyChanges();
        defendingParts.applyChanges();
        damagingParts.stream().forEach((damagingPart) -> {
            defendingParts.stream().forEach((defendingPart) -> {
                if (Colliders.hasCollides(damagingPart, defendingPart)) {
                }
            });
        });
    }

    @Override
    public void cleanup() {
        super.cleanup();
        damagingParts.release();
        damagingParts = null;
        defendingParts.release();
        defendingParts = null;
    }

}
