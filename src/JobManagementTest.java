import java.io.IOException;

public class JobManagementTest {

    public static void main(String[] args) throws IOException, InterruptedException {
//        String cmd = "java -version";
//        Runtime run = Runtime.getRuntime();
//        Process pr = run.exec(cmd);
//        pr.waitFor();
//        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        String line = "";
//        while ((line = buf.readLine()) != null) {
//            System.out.println(line);
//        }

        try {
            Runtime.getRuntime().exec(new String[]{"cmd /c start cmd.exe /K \\\"dir && ping localhost\\"});
//            Runtime.getRuntime().exec(new String[]{"dir"});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
