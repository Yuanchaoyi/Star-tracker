import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PointOutStars_txtRead
{
   public static void main(String args[]) throws IOException{
      int x,y;
      int num=0;
      int gray;
   
      ArrayList<Integer> gray_list = new ArrayList<Integer>();
      ArrayList<Integer> x_list = new ArrayList<Integer>();
      ArrayList<Integer> y_list = new ArrayList<Integer>();
   
      x = 1080;
      y = 1920;
      DrawingPanel panel = new DrawingPanel(x, y);
      panel.setBackground(Color.BLACK);
      Graphics g = panel.getGraphics();
   
      try
      {
         BufferedReader in = new BufferedReader(new FileReader(new File("star_position_8.txt")));
         int line = 0;
         for (String s = in.readLine(); s != null; s = in.readLine()){
            line++;
            String[] tokens = s.split(" ");
            int flag = 0;
            for (String token : tokens) {
               if (flag == 0) {
                  gray = Integer.parseInt(token);
                  gray_list.add(gray);
                  flag = 1;
               } else if (flag == 1) {
                  Integer position_x = Integer.valueOf(token);
                  x_list.add(position_x);
                  flag = 2;
               } else {
                  Integer position_y = Integer.valueOf(token);
                  y_list.add(position_y);
               }
            }
         }
      } catch (IOException e)
      {
         System.out.println("File I/O error!");
      }
   
      for (int i=0; i<gray_list.size(); i++) {
      /*
      if (gray_list.get(i) < 5) {
         g.setColor(Color.GRAY);
      } else {
         g.setColor(Color.WHITE);
      } */
         g.setColor(Color.WHITE);
         g.fillRect(x_list.get(i), y_list.get(i), 5, 5);
      }
   
   }
}
