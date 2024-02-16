package it.unibo.model.hitbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.obstacles.PlatformImpl;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;

/**
 * JUnit test class for testing the hitboxes of various game entities, including MeatBoy, BandageGirl,
 * Platform, and CircularSaw.
 */
public class TestHitbox {

    private MeatBoy meatBoy;
    private Platform platform;
    private BandageGirl bandageGirl;
    private CircularSaw saw;

    /**
     * Initializes instances of game entities for testing hitboxes.
     *
     * @throws MalformedURLException if there is an issue with URL creation.
     */
    @BeforeEach 
    public void init() throws MalformedURLException {
        this.meatBoy = new MeatBoyImpl(0, 0);
        assertNotNull(this.meatBoy);
        this.bandageGirl = new BandageGirlImpl(0, 0);
        assertNotNull(this.bandageGirl);
        this.platform = new PlatformImpl(0, 0, 300, 100);
        assertNotNull(this.platform);
        this.saw = new CircularSawImpl(0, 0, 30);
        assertNotNull(this.saw);
    }

    /**
     * Tests the hitbox of the MeatBoy entity.
     */
    @Test
    void testMeatBoyHitbox(){
        RectangleHitbox meatboyHitbox = this.meatBoy.getHitbox();
        assertNotNull(meatboyHitbox);
        Rectangle hitboxShapeMB = meatboyHitbox.getHitbox();
        assertNotNull(hitboxShapeMB);
        assertEquals(
                List.of(this.meatBoy.getX(), this.meatBoy.getY()),
                List.of(hitboxShapeMB.getX(), hitboxShapeMB.getY()));
        assertEquals(
                List.of(
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION), 
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION)),
                List.of(hitboxShapeMB.getWidth(), hitboxShapeMB.getHeight()));
        this.meatBoy.setX(100);
        this.meatBoy.setY(100);
        assertEquals(
                List.of(this.meatBoy.getX(), this.meatBoy.getY()),
                List.of(hitboxShapeMB.getX(), hitboxShapeMB.getY()));
        assertEquals(
                List.of(
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION), 
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION)),
                List.of(hitboxShapeMB.getWidth(), hitboxShapeMB.getHeight()));
    }

    /**
     * Tests the hitbox of the BandageGirl entity.
     */
    @Test
    void testBandageGirlHitbox(){
        RectangleHitbox bandageGirlHitbox = this.bandageGirl.getHitbox();
        assertNotNull(bandageGirlHitbox);
        Rectangle hitboxShapeBG = bandageGirlHitbox.getHitbox();
        assertNotNull(hitboxShapeBG);
        assertEquals(
                List.of(this.bandageGirl.getX(), this.bandageGirl.getY()),
                List.of(hitboxShapeBG.getX(), hitboxShapeBG.getY()));
        assertEquals(
                List.of(
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION), 
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION)),
                List.of(hitboxShapeBG.getWidth(), hitboxShapeBG.getHeight()));
        this.bandageGirl.setX(100);
        this.bandageGirl.setY(100);
        assertEquals(
                List.of(this.bandageGirl.getX(), this.bandageGirl.getY()),
                List.of(hitboxShapeBG.getX(), hitboxShapeBG.getY()));
        assertEquals(
                List.of(
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION), 
                    Math.floor(Constants.TILE_SIZE * Constants.SCALE_PROPORTION)),
                List.of(hitboxShapeBG.getWidth(), hitboxShapeBG.getHeight()));
    }

    /**
     * Tests the hitbox of the Platform entity.
     */
    @Test
    void testPlatformHitbox(){
        RectangleHitbox PlatformHitbox = this.platform.getHitbox();
        assertNotNull(PlatformHitbox);
        Rectangle hitboxShapeP = PlatformHitbox.getHitbox();
        assertNotNull(hitboxShapeP);
        assertEquals(
                List.of(this.platform.getX(), this.platform.getY()),
                List.of(hitboxShapeP.getX(), hitboxShapeP.getY()));
        assertEquals(
                List.of(300.0, 100.0),
                List.of(hitboxShapeP.getWidth(), hitboxShapeP.getHeight()));
        this.platform.setX(100);
        this.platform.setY(100);
        assertEquals(
                List.of(this.platform.getX(), this.platform.getY()),
                List.of(hitboxShapeP.getX(), hitboxShapeP.getY()));
        assertEquals(
                List.of(300.0, 100.0),
                List.of(hitboxShapeP.getWidth(), hitboxShapeP.getHeight()));
    }

    /**
     * Tests the hitbox of the CircularSaw entity.
     */
    @Test
    void testSawHitbox(){
        CircularHitbox sawHitbox = this.saw.getHitbox();
        assertNotNull(sawHitbox);
        Ellipse2D hitboxShapeS = sawHitbox.getHitbox();
        assertNotNull(hitboxShapeS);
        assertEquals(
                List.of(this.saw.getX(), this.saw.getY()),
                List.of(hitboxShapeS.getX(), hitboxShapeS.getY()));
        assertEquals(
                List.of(30.0, 30.0),
                List.of(hitboxShapeS.getWidth(), hitboxShapeS.getHeight()));
        this.saw.setX(100);
        this.saw.setY(100);
        assertEquals(
                List.of(this.saw.getX(), this.saw.getY()),
                List.of(hitboxShapeS.getX(), hitboxShapeS.getY()));
        assertEquals(
                List.of(30.0, 30.0),
                List.of(hitboxShapeS.getWidth(), hitboxShapeS.getHeight()));
    }
}
