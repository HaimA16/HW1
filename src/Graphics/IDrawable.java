package Graphics;

public interface IDrawable {
    public final static String PICTURE_PATH = "…";
    public void loadImages(String nm);
    public <Graphics> void drawObject (Graphics g);
}
