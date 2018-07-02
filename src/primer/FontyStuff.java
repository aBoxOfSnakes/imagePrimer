package primer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FontyStuff {

    public static void main(String[] args) {
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String digit = digits[0];
        double[] darkness = new double[10];
        //Get size of rendered digit
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(digit);
        int height = fm.getHeight();
        g2d.dispose();
        
        for (int n=0; n < 10; n++) {
         
        	digit = digits[n];
        	img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        	g2d = img.createGraphics(); 
        	g2d.setFont(font);
        	fm = g2d.getFontMetrics();
        	g2d.setColor(Color.BLACK);
        	g2d.drawString(digit, 0, fm.getAscent());
        	g2d.dispose();
         
        	int k = 0;
        	for (int i = 0; i < img.getWidth();i++) {
        		for (int j = 0; j < img.getHeight();j++) {
        			int pixelcolour = img.getRGB(i, j);
        			if (pixelcolour != 0) {
        				k++;
        			}
        		}
        	}
        	darkness[n] = (double)k / (width*height);
        	System.out.println(darkness[n]);
        }

    }

}