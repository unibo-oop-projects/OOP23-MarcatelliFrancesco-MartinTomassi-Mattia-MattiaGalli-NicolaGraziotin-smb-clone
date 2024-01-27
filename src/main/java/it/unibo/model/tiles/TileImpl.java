package it.unibo.model.tiles;

public class TileImpl implements Tile {

    private final int x;
    private final int y;
    private final String identifier;
    private final String srcImage;
    
    /**
     * Constructs a new Tile with the specified coordinates.
     *
     * @param x The x-coordinate of the Tile.
     * @param y The y-coordinate of the Tile.
     */
    public TileImpl(final int x, final int y, final String srcImage) {
        this.x = x;
        this.y = y;
        this.srcImage = srcImage;
        this.identifier = generateImageIdentifier();
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String getSrcImage() {
        return this.srcImage;
    }

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * Generates a unique identifier for the image associated with the Tile.
     * The identifier is constructed using the X and Y coordinates of the Tile.
     *
     * @return A string representing the image identifier.
     */
    private String generateImageIdentifier() {
        return "Image_" + this.x + "_" + this.y;
    }

}
