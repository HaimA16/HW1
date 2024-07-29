package Graphics;

import java.awt.Graphics;

/**
 * Interface representing drawable objects.
 * Provides methods for loading images and drawing objects.
 */
public interface IDrawable {
    /**
     * Path to the directory containing images.
     */
    public final static String PICTURE_PATH = "C:\\Users\\haima\\IdeaProjects\\HW1\\src\\graphics2\\";

    /**
     * Loads images for the drawable object.
     *
     * @param nm the name of the image file to load
     */
    public void loadImages(String nm);

    /**
     * Draws the object using the provided Graphics context.
     *
     * @param g the Graphics context to use for drawing the object
     */
    public void drawObject(Graphics g);
}
