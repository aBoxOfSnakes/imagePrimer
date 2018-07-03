package primer;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.math.BigInteger;
import java.lang.StringBuilder


public class ImagePrime {

    public static void main(String[] args) throws IOException{
        File img = new File("feynman.jpg");
        BufferedImage img = ImageIO.read(imgFile);
        int[][] nuMatrix = numifyImg(img);
        StringBuilder bigString = buildString(nuMatrix);
        BigInteger bigInt = New BigInteger(bigString);
    }

    public int[][] numifyImg(BufferedImage img) {
        BufferedImage grImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        int[][] nuMatrix = new int [img.getWidth()][img.getHeight()]
        for (int x=0;x<img.getWidth();x++){
            for (int y=0;y<img.getHeight();y++){
                Color c = new Color(img.getRGB(x,y));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                int gr = (r+g+b)/3;

                if(gr < 84){
                    nuMatrix[x][y] = 1
                }
                else if(gr < 169){
                    nuMatrix[x][y] = 2
                }
                else{
                    nuMatrix[x][y] = 8
                }
            }
        }  
        return nuMatrix
    }

    public StringBuilder buildString(int[][] nuMatrix){
        StringBuilder bigString = StringBuilder("");
        for (int x=0;x<nuMatrix.length();x++) {
            for (int y=0;y<nuMatrix[0].length();y++){
                bigString.append(nuMatrix[x][y]);
            }
        }
        return bigString;
    }
}
