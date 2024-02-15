package thread;

class Define{
    private void print(String string){
        for(int i=0;i<string.length();i++){
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(200);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }
    public synchronized void printWelcome(String chars){this.print(chars);}
    public synchronized void printStars(String chars){this.print(chars);}
    public synchronized void printMsg(String chars){this.print(chars);}
    public synchronized void printLine(String chars){this.print(chars);}
}

class Reader1 extends Thread{
    @Override
    public void run() {

    }
}

public class Homework {
    public static void main(String[] arg){
        Define define = new Define();
        String welcome = "Welcome to CSTAD!";
        String star = "*".repeat(49);
        String msg = "No giving up this opportunity, do your best first";
        String line = "-".repeat(49);
        Thread thread1 = new Thread(() -> {
            define.printWelcome(welcome);
        });
        Thread thread2 = new Thread(() -> {
            define.printStars(star);
        });
        Thread thread3 = new Thread(() -> {
            define.printMsg(msg);
        });
        Thread thread4 = new Thread(() -> {
            define.printLine(line);
        });

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
            thread4.start();
            thread4.join();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}