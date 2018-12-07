import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RedactorPhoto {

    private int width = 640;
    private int height = 480;
    BufferedImage picture = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    public void lighten(String nameFile1, String nameFile2, int a){
        a = (int)((double) a / 100 * 255);
        File imagina = new File(nameFile1);
        try {
            picture = ImageIO.read(imagina); //new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }
        catch(IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
        picture.createGraphics();
        Graphics2D g2d = picture.createGraphics();
        for(int i = 0; i < picture.getWidth(); i++) {
            for (int j = 0; j < picture.getHeight(); j++) {
                int cl = picture.getRGB(i, j);
                Color c = new Color(cl);
                int[] color = new int[3];
                color[0] = c.getGreen();
                color[1] = c.getBlue();
                color[2] = c.getRed();
                for (int m  = 0; m < 3; m++) {
                    if (color[m] + a < 0) {
                        color[m] = 0;
                    } else if (color[m] + a > 255) {
                        color[m] = 255;
                    } else {
                        color[m] = color[m] + a;
                    }
                }
                Color cn = new Color(color[0], color[1] , color[2]);

                picture.setRGB(i,j, cn.getRGB());
            }
        }

        g2d.dispose();

        File file = new File(nameFile2);
        try {
            ImageIO.write(picture, "png", file);
        }
        catch(IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
    }

}
