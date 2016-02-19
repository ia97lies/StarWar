package mygame;

import com.simsilica.es.Entity;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cli
 */
public class Colliders {

    private static final Logger logger = Logger.getLogger(Colliders.class.getName());

    static public boolean hasCollides(Entity e1, Entity e2) {
        logger.log(Level.FINE, "hasColliders {0} and {1}", new Object[]{e1, e2});
        CollisionShape e1Shape = e1.get(CollisionShape.class);
        CollisionShape e2Shape = e2.get(CollisionShape.class);
        Position e1Pos = e1.get(Position.class);
        Position e2Pos = e2.get(Position.class);

        float threshold = e1Shape.getRadius() + e2Shape.getRadius();
        threshold *= threshold;
        float distance = e1Pos.getLocation().distanceSquared(e2Pos.getLocation());

        if (distance < threshold) {
            logger.log(Level.FINE, "Collide {0} with {1}", new Object[]{distance, threshold});
            return true;
        }
        return false;
    }
}
