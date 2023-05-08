import java.io.*;


public class PythonRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        String name = "docNameTest";
        String action = "actionTest";

        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(new File("/Users/seungtoc/Desktop/motion"));
        pb.command("/Users/seungtoc/anaconda3/bin/conda", "run", "-n", "motion", "python", "setMotionFor.py", name, action);

        Process process = pb.start();

        // 출력 받아오기
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("setMotionFor.py executed successfully.");
        } else {
            System.out.println("setMotionFor.py execution failed.");
        }
    }
}
