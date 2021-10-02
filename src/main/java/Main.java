import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println(hacerDirDoble());
    }

    public static String hacerDirDoble() {

        String resul = "";
        String cad1 = "";
        String cad2 = "";

        try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\\" && dir");

            builder.redirectErrorStream(true);

            Process p = builder.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            while ((line = r.readLine()) != null) {

                if (line.contains("DIR") || line.contains("Directorio") || line.contains("bytes") || line.isEmpty())

                    cad1 = cad1 + line + "\n";

                if (line.contains("DIR")) {

                    int posicion = line.indexOf('>');

                    line = line.substring(posicion + 1).trim();

                    cad2 += dir2(line);
                }

                resul = cad1 + cad2;

            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return resul;

    }

    public static String dir2(String cajas){

        String resulFinal = "";

        try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\" + cajas + "\" && dir");

            builder.redirectErrorStream(true);

            Process p = builder.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((cajas = r.readLine()) != null) {

                resulFinal = resulFinal + cajas + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resulFinal;

    }
}