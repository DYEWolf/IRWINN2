package sample.Kernels;

import sample.Main.ImageMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by cristopher_ramirez on 14/12/16.
 */
public class GrayKernel {


    private int width = ImageMatrix.getWidth();
    private int height = ImageMatrix.getHeight();


    public GrayKernel(int Matrix[][]){

        //passing the value from the matrix to this class
        int GrayMatrix[][] = Matrix;
        BufferedImage GrayImage = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
        File GrayFile = null;

        for(int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {

                int p = GrayMatrix[y][x];


                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                System.out.print(avg + " ");

                //replace RGB value with avg
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;


                GrayImage.setRGB(y, x, p);
            }
            System.out.println();
        }

        try{
            GrayFile = new File("/home/cristopher_ramirez/Documents/TESTMATRIX/KernelImages/Gray.jpg");
            ImageIO.write(GrayImage, "jpg", GrayFile);

        }catch(Exception e){
            e.printStackTrace();
        }


        System.out.println(width);
        System.out.println(height);


    }


}
