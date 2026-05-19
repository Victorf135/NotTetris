import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks;
    private int[][] grid;

    public BrickLayout(String inputFile) {
        ArrayList<String> fileData = getFileData("src/input");
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        grid = new int[30][40];
    }

    public int[][] getGrid() {
        return grid;
    }

    public void dropOneBrick() {
        // implement dropping the most brick into grid
        for (int Brick = 0; Brick < bricks.size(); Brick++) {
           int startOfBrick = bricks.get(Brick).getStart();
           int endOfBrick = bricks.get(Brick).getEnd();
           for (int g = 40; g >= 0; g--){
               for (int fill = startOfBrick; fill <= 0; fill++) {
                   if (grid[g][fill] == 1){
                       grid[g -1][fill] = 1;
                   }else {
                       grid[g][fill] = 1;
                   }
               }
           }
        }
    }

     //for (int r = 0; r < 30; r++) {
        //for (int c = 40; c >= 0; c++) {
            //if (bricks.get()[r][c] == 0){
                //bricks.get(r)[c] = 1;
            //}
        //}
    //}

    public  ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }
}