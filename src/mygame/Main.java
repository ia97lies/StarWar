package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public Main() {
        super(new VisualAppState(),
                new ExplosionAppState(),
                new DecayAppState(),
                new ControlAppState(),
                new InvadersAIAppState(),
                new CollisionAppState(),
                new BulletAppState(),
                new GameAppState(),
                new EntityDataState());
    }

    @Override
    public void simpleInitApp() {
    }

    @Override
    public void simpleUpdate(float tpf) {
    }

    @Override
    public void simpleRender(RenderManager rm) {
    }
}
