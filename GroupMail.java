
import java.io.*;

public class GroupMail {
    public static void main(String[] args) {
        File file = new File(args[0]);
        File file2 = new File("mail2.txt");
        if (!file.exists()) {
            System.out.println(args[0] + " does not exist.");
            return;
        }
        try {
            
            FileOutputStream fos = new FileOutputStream(file2);
            FileInputStream fis = new FileInputStream(file);
            char current;
            while (fis.available() > 0) {
                current = (char) fis.read();
                if(current == '<'){
                    while(current != '>'){
                        
                        current = (char) fis.read();
                        if(current != '>'){
                            fos.write(current);
                        }
                    }
                    fos.write(" ".getBytes());
                }
            }
            fos.close();
            fis.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
