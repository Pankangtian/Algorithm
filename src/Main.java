import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Date;

public class Main {
    public static Object exec(String cmd) {
        try {
            String[] cmdA = { "/bin/sh", "-c", cmd };
            Process process = Runtime.getRuntime().exec(cmdA);
            LineNumberReader br = new LineNumberReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

         long time=new Date().getTime();
         System.out.println(exec("cp   /root/webpower/webpower.zip  /root/webpower"+time+".zip"));
         exec("unzip -o -d /root/webpower   /root/webpower/webpower.zip");
       //  System.out.println(exec("unzip webpower.zip"));
    }
}
