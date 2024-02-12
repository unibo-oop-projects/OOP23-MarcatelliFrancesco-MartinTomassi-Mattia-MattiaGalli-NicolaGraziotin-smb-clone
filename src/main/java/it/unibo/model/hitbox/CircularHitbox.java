package it.unibo.model.hitbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * The CircularHitbox rapresents the implementation of the Hitbox
 * with a circular shape.
 */
public class CircularHitbox implements Hitbox<Ellipse2D> {

    private final Ellipse2D hitbox;
    /**
     * Constructs a new CircularHitbox with specified coordinates and radius.
     * 
     * @param x The x-coordinate of the hitbox
     * @param y The y-coordinate of the hitbox
     * @param radius The radius of the hitbox
     */
    public CircularHitbox(final double x, final double y, final int radius) {
        this.hitbox = new Ellipse2D.Double(x, y, radius, radius);
    }

    /**
     * Update the position of the circular shape hitbox.
     */
    @Override
    public void updatePosition(final double x, final double y) {
        this.hitbox.setFrame(x, y, hitbox.getWidth(), hitbox.getHeight());
    }

    /**
     * Returns the Ellipse2D hitbox shape.
     * 
     * @return shape of the hitbox
     */
    @Override
    public Ellipse2D getHitbox() {
        return this.hitbox;
    }

    /**
     * Draw the shape of the Hitbox.
     */
    @Override
    public void draw(final Graphics2D g) {
        g.setColor(Color.MAGENTA);
        g.draw(hitbox);
    }
}
