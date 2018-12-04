import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {
    String fullpath;

    public FileWorker(String filepath) {
        fullpath = filepath;
    }

    public FileWorker(String filepath, String filename) {
        File newFile = new File(filepath + "//" + filename + ".txt");
        try
        {
            if(newFile.createNewFile())
            {
                System.out.println("Файл " + filename + ".txt создан");
                fullpath = filepath + "//" + filename + ".txt";
            }
            else
            {
                System.out.println("Файл " + filename + ".txt уже существует");
                fullpath = filepath + "//" + filename + ".txt";
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void print() {
        try(BufferedReader br = new BufferedReader(new FileReader(fullpath)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){

                System.out.println(s);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public void changeFirstLetters() {
        try(BufferedReader br = new BufferedReader(new FileReader(fullpath)))
        {
            StringBuilder text = new StringBuilder("");
            String s;
            while((s=br.readLine())!=null) {
                Pattern pattern = Pattern.compile("[.?!]\\s[A-ZА-Я]");
                Matcher matcher = pattern.matcher(s);
                while(matcher.find()) {
                    String tmp = matcher.group();
                    System.out.println(tmp);
                    s = s.replaceAll(tmp, tmp.toLowerCase());
                }
                text.append(s);
            }
            write(text.toString());
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public void write(String text) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fullpath)))
        {
            bw.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
