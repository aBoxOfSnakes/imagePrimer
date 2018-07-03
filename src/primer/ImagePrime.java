package primer;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.math.BigInteger;
import java.lang.StringBuilder;


public class ImagePrime {

    public static void main(String[] args) throws IOException{
        File imgFile = new File("C:\\Users\\camer\\eclipse-workspace\\imagePrimer\\images\\feynman.jpg");
        BufferedImage img = ImageIO.read(imgFile);
        int[][] nuMatrix = numifyImg(img);
        String bigString = buildString(nuMatrix);
        BigInteger bigInt = new BigInteger(bigString);
        System.out.println(bigInt);
        System.out.println(nuMatrix);
    }

    public static int[][] numifyImg(BufferedImage img) {
        int[][] nuMatrix = new int [img.getWidth()][img.getHeight()];
        for (int x=0;x<img.getWidth();x++){
            for (int y=0;y<img.getHeight();y++){
                Color c = new Color(img.getRGB(x,y));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                int gr = (r+g+b)/3;

                if(gr < 84){
                    nuMatrix[x][y] = 1;
                }
                else if(gr < 169){
                    nuMatrix[x][y] = 2;
                }
                else{
                    nuMatrix[x][y] = 8;
                }
            }
        }  
        return nuMatrix;
    }

    public static String buildString(int[][] nuMatrix){
        StringBuilder bigStringBuilder = new StringBuilder("");
        for (int x=0;x<nuMatrix.length;x++) {
            for (int y=0;y<nuMatrix[0].length;y++){
                bigStringBuilder.append(nuMatrix[x][y]);
            }
        }
        String bigString = new String(bigStringBuilder);
        return bigString;
    }
}
