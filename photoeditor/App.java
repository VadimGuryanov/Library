package ru.kpfu.itis.ru.photoeditor;

import ru.kpfu.itis.ru.photoeditor.filters.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        FilterSetter fs = new FilterSetter();
        RGchanged bw = new RGchanged();
        File imagina = new File("Test.jpg");
        BufferedImage picture = null; //= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        try {
            picture = ImageIO.read(imagina); //new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        } catch (IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
        File file = new File("ceil.png");
        try {
            ImageIO.write(fs.applyFilter(picture, bw), "png", file);
        } catch (IOException io) {
            System.out.println(io.getLocalizedMessage());
        }
    }
}
