import javax.swing.*;
import java.awt.*;

/** 履歴用のウィンドウを作成 */
public class Rireki extends JFrame{
    
    private  static JLabel la = new JLabel();
    
/** 履歴用に関数電卓の横にウィンドウを表示 */
    public void expose(){
	setTitle("履歴");
	setSize(250,402);
	setLocation(680,700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	la.setFont(new Font("Dialog",Font.BOLD, 12));
	la.setForeground(new Color(50,150,50));
	add(la);
    }
    
    /** 渡された文字列をexposeで開いたウィンドウに表示 */
    public void set(String st){
	la.setText(st);
    }
}
