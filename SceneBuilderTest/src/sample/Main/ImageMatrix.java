package sample.Main;

import sample.Kernels.GrayKernel;

import java.awt.image.BufferedImage;

/**
 * Created by cristopher_ramirez on 13/12/16.
 */
public class ImageMatrix {

    private BufferedImage MatrixImage = null;
    private static int width;
    private static int height;
    public int ImageMatrix[][];

    public ImageMatrix(BufferedImage image) throws Exception {

        try{

            MatrixImage= image;

            //get the image width and height
             width = MatrixImage.getWidth();
             height = MatrixImage.getHeight();

            //defining the matrix array for the image
             ImageMatrix = new int[width][height];

            //getting the RGB values from the image and put it on on the matrix array
            for(int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    ImageMatrix[y][x] = MatrixImage.getRGB(y, x);
                    System.out.print(ImageMatrix[y][x] + " ");
                }
                System.out.println();
            }

            GrayKernel GrayImage = new GrayKernel(ImageMatrix);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static int getWidth(){ return width; }
    public static  int getHeight(){ return height; }
}
