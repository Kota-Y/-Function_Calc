import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
/** gnuplotを開き、実行したい命令を渡し、一定時間待った後にそのウィンドウを閉じる*/
public class Gnuoutput implements Runnable {

    /** ２次元表示用 */
     public void plot(String str)throws IOException {
        Process p = new ProcessBuilder("gnuplot").start();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(p.getOutputStream())));
        out.println("plot " + str);
        out.flush();
	try{
            Thread.sleep(7000); 
	}catch (InterruptedException e){
	}
        out.close();    
     }
    
    /** 3次元表示用 */
    public void splot(String str)throws IOException {
        Process p = new ProcessBuilder("gnuplot").start();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(p.getOutputStream())));
        out.println("splot " + str);
        out.flush();
	try{
            Thread.sleep(7000);
	}catch (InterruptedException e){
	}
        out.close();    
    }
    
    /** Runnableのrunメソッドをオーバーライド */
    public void run(){
    }
}

