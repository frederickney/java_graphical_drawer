/**
 *@Project  :   TP5
 *@File     :   File.java
 *@Revision :   1.0.1
 *@Created  :   10/09/2015 19:32
 *@Author   :   Frederick NEY's WEBMASTER
 */
package sources.reader;

import sources.geom2D.Line2D;
import sources.geom2D.Point2D;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author admin_master
 */
public class File {
    /**
     * @param fileName  The file name/path with some numerics for building lines and points.
     * @param pointsList Point2D array list.
     * @see Point2D
     * @param linesList Line2D array list.
     * @see Line2D
     * @throws IOException : file not found
     */
    public void readFile(String fileName, ArrayList<Point2D> pointsList, ArrayList<Line2D> linesList) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");
                System.out.println(Arrays.toString(tokens));
                
                if(this.checkTokens(tokens)) {
                    
                    switch(tokens.length) {
                        case 2:
                            pointsList.add(new Point2D(
                                    Double.parseDouble(tokens[0]),
                                    Double.parseDouble(tokens[1])));
                            break;

                        case 4:
                            linesList.add(new Line2D(
                                    Double.parseDouble(tokens[0]),
                                    Double.parseDouble(tokens[1]),
                                    Double.parseDouble(tokens[2]),
                                    Double.parseDouble(tokens[3])));
                            break;     

                        default: 
                                System.out.println("Bad input line: " + line);
                            break;
                    }
                } else {
                    System.out.println("Bad input line: " + line);
                }
            }
        }
    }
    /**
     * @param token An array of string taken from the input file.
     * @return : boolean
     */
    private boolean checkTokens(String[] token) {
        boolean bool = true;
        for(String string : token) 
            bool &= this.isNumeric(string);  
        return bool;
    }
    /**
     * @param string A string from the input file. testing if it's a numeric or not.
     * @return : boolean
     */
    private boolean isNumeric(String string) {
        try {
            double value = Double.parseDouble(string);
        }
        catch(NumberFormatException e) {
            return false;
        }
        
        return true;        
    }
}
