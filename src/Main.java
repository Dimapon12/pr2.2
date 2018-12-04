import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while(true){
            Scanner in = new Scanner(System.in);

            System.out.println("\n1. Заменить первую букву каждого предложения на прописную.\n" +
                                 "2. Создать текстовый файл.\n");

            int command = in.nextInt();
            in.nextLine();
            switch (command){
                case 1: {
                    System.out.println("Введите путь к файлу: ");
                    String filepath = in.nextLine();
                    System.out.println();
                    FileWorker fw = new FileWorker(filepath);
                    fw.print();
                    fw.changeFirstLetters();
                    fw.print();
                    break;
                }
                case 2: {
                    System.out.println("Введите путь к файлу: ");
                    String filepath = in.nextLine();
                    System.out.println("Введите название файла: ");
                    String filename = in.nextLine();
                    FileWorker fw = new FileWorker(filepath, filename);
                    System.out.print("Введите текст (exit - закончить ввод): ");

                    StringBuilder text = new StringBuilder("");
                    String tmp;

                    while(true) {
                        tmp = in.nextLine();
                        if (tmp.equals("exit")) break;
                        else text.append(tmp + "\n");
                    }
                    fw.write(text.toString());
                    fw.print();
                    break;
                }
                default: {
                    System.out.println("Нет такого пункта меню");
                    break;
                }
            }
        }
    }
}
