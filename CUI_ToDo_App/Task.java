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
                System.out.println("\n追加：1  完了:2  プログラムの終了：3\n");
                System.out.print("行いたいアクションの番号を選択してください >> ");
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
                    default:
                        break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
    public void append() {
        try {
            Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("タスクを入力してください >> ");
            String task = scanner.nextLine();
            if (task.equals("")) {
                Thread.sleep(500);
                System.out.println("タスクの内容が入力されませんでした");
                Thread.sleep(500);
                System.out.println("アクション選択に戻ります");
                return;
            }
            this.taskList[taskCount] = task;
            taskCount++;
            Thread.sleep(500);
            System.out.println("新たにタスクを追加しました");  
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void complete() {
        try {
            Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("完了したタスクの番号を選択してください >> ");
            int complete = scanner.nextInt();
            if (isInvalidValue(complete, this.taskCount)) {
                System.out.println("無効な値が入力されました");
                System.out.println("アクション選択に戻ります");
                return;
            }
            Thread.sleep(500);
            System.out.println("タスクを完了しました");
            Thread.sleep(500);
            System.out.println("完了したタスク → " + this.taskList[complete]);
            for (int i = complete; i <= this.taskCount; i++) {
                this.taskList[i] = this.taskList[i + 1];
            }
            taskCount--;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void end(Scanner scanner) {
        System.out.println("プログラムを終了します");
        this.isEnd = true;
        scanner.close();
    }

    public void displayList() {
        try {
            Thread.sleep(500);
            System.out.println("\n現在のタスク");
            if (this.taskCount == 0) {
                System.out.println("なし");
                return;
            }
            for (int i = 0; i < this.taskCount; i++) {
                System.out.println(this.taskList[i] + "：" + i);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public Boolean isInvalidValue(int complete, int taskCount) {
        return (complete > taskCount - 1 || complete < 0 );
    }
}
