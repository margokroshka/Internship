package baranovskaya;
import java.util.Scanner;


public class FileSystem {
    private Folder currentFolder = new Folder("root");

    public void add(String element){
        currentFolder = PathBuilder.processInput(element, currentFolder);
    }
    public String print (){
        return  currentFolder.toString();
    }

    public static void main(String[] args){
        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }else {
                fs.add(input);
                System.out.println(fs.print());
            }
        }
    }
}