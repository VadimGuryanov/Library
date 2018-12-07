import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;



public class RedactorPhoto {

    private int width = 640;
    private int height = 480;
//    private String nameFile1;
//    private String nameFile2;
//    public RedactorPhoto(String a, String b) {
//        nameFile1 = a;
//        nameFile2 = b;
//    }
    BufferedImage picture = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    public void blackAndWhite(String nameFile1, String nameFile2) {
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
                int green = c.getGreen();
                int blue = c.getBlue();
                int red = c.getRed();
                int otvet = (green + red + blue) / 3;
                Color cn = new Color(otvet, otvet, otvet);

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

    public void makeNegative(String nameFile1, String nameFile2){
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
                int green = c.getGreen();
                int blue = c.getBlue();
                int red = c.getRed();
                int otvet = 255 - (green + red + blue) / 3;
                Color cn = new Color(otvet, otvet, otvet);

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

    public void YYY(String nameFile1, String nameFile2, int a){
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
                int green = c.getGreen();
                int blue = c.getBlue();
                int red = c.getRed();
                int newGreen = 0;
                int newBlue = 0;
                int newRed =  0;
                if (green + a > 255) {
                    newGreen = 255;
                } else {
                    newGreen = (green + a);
                }
                if (red + a > 255) {
                    newRed = 255;
                }
                else {
                    newRed = (red + a);
                }
                if (blue + a > 255) {
                    newBlue = 255;
                } else {
                    newBlue = (blue + a);
                }
                Color cn = new Color(newRed, newGreen , newBlue);

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
