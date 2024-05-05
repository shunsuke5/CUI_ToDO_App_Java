import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task {
    String[] taskList = new String[99];
    int taskCount = 0;
    Boolean isEnd = false;

    public void question() {
        try {
            while(!isEnd) {
                displayList();
                System.out.println("追加：1  完了:2  プログラムの終了：3\n");
                System.out.print("番号を選択してください >> ");
                Scanner scanner = new java.util.Scanner(System.in);
                int choice = scanner.nextInt();
                
                switch(choice) {
                    case 1:
                        append();
                        break;
                    case 2:
                        complete();
                        break;
                    case 3:
                        end(scanner);
                        break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
    public void append() {
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("タスクを入力してください >> ");
        String task = scanner.nextLine();
        this.taskList[taskCount] = task;
        taskCount++;
        System.out.println("新たにタスクを追加しました");
    }

    public void complete() {
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("\n完了したタスクを選択してください >> ");
        int complete = scanner.nextInt();
        for (int i = complete; i < this.taskCount; i++) {
            this.taskList[i] = this.taskList[i + 1];
        }
        System.out.println("タスクを完了しました");
        taskCount--;
    }

    public void end(Scanner scanner) {
        System.out.println("プログラムを終了します");
        this.isEnd = true;
        scanner.close();
    }

    public void displayList() {
        for (int i = 0; i < this.taskCount; i++) {
            System.out.println(this.taskList[i]);
        }
    }
}