package Graphics;

import java.awt.Graphics; // הוספת שורת ה-import

public interface IDrawable {
    public final static String PICTURE_PATH = "…";
    public void loadImages(String nm);
    public void drawObject(Graphics g); // שימוש ב-Graphics עם ה-import הנכון
}


