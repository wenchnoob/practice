import java.io.BufferedInputStream;
import java.io.IOException;
public class ProcessPractice {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder();

        Process p = Runtime.getRuntime().exec(new String[]{"java", "./src/SortingPractice.java"});

        p.waitFor();
        try {
            BufferedInputStream bf = new BufferedInputStream(p.getInputStream());
            System.out.println(new String(bf.readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        p = Runtime.getRuntime().exec(new String[]{"python3", "./python/summer.py", "23", "22"});
        p.waitFor();
        try {
            BufferedInputStream bf = new BufferedInputStream(p.getInputStream());
            System.out.println(new String(bf.readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        // Process p = Runtime.getRuntime().exec(new String[]{"python", "./python/summer.py", "12", "13"});
    }

}
