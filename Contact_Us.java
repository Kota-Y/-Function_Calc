import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;

/** お問い合わせに関する案内のウィンドウを表示 */
public class Contact_Us extends JFrame{
    
    /**メインメソッド*/
    public static void main(String[] args){
	Contact_Us frame = new Contact_Us("お問い合わせ");
	frame.setVisible(true);
   }
    
    /**コンストラクタ*/
    Contact_Us(String text) {
	setTitle(text);
	setSize(510,290);
	setLocation(930, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel pa = new JPanel();
	
	JTextArea letter = new JTextArea(20, 50);
	letter.setText("\n\n\n\n\n\n　　　　　　　　　　　　　　～お問い合わせに関するご案内～ \n\n\n 　ご不明な点などありましたら下記メールアドレスにてメールでのご質問やお問い合わせなどを承っております。 \n\n 　　　　　　　　　　　　　　　jikkenb7@gmail.com");
	letter.setEditable(false);
	letter.setLineWrap(true);
	letter.setWrapStyleWord(true);
	
	pa.add(letter);
	
	Container contentPane = getContentPane();
	contentPane.add(pa, BorderLayout.CENTER);
    }
  }
