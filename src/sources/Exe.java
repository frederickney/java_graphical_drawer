 /**
 *@Project  :   TP5
 *@File     :   sources.Exe.java
 *@Revision :   1.0.1
 *@Created  :   10/09/2015 19:32
 *@Author   :   Frederick NEY's WEBMASTER
 */

package sources;
import sources.application.GUI;
import java.io.IOException;

/**
 * @author admin_master
 */
public class Exe {
    /**
     * @param args The input file argument.
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        new GUI(args[0]);
    }
}
