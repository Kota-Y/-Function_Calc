import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;

/** アンケートに関する案内のウィンドウを表示 */
public class Questionnaire extends JFrame{
    
    /**メインメソッド*/
    public static void main(String[] args){
	Questionnaire frame = new Questionnaire("アンケートに関するご案内");
	frame.setVisible(true);
    }
    
    /**コンストラクタ*/
    Questionnaire(String text) {
	setTitle(text);
	setSize(510,290);
	setLocation(930, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel pa = new JPanel();

	JTextArea letter = new JTextArea(20, 50);	
	letter.setText("\n\n\n\n\n 　　　　　　　　　　　　～WEBによるアンケートご協力のご案内～\n\n\n　私達は皆様の貴重なご意見をお聞かせいただき、現状を再認識すると共に、今後の向上に努めて参りたいと思っております。つきましては、下記URLのWEBにてアンケートを実施しております。是非ともご協力賜わりますようお願い申し上げます。\n\n　https://docs.google.com/forms/d/e/1FAIpQLSe1nGpW4DjfidVJ3pH9g01MzQJSGIBazSUR4UYGW5iTlaouag/viewform");
	letter.setEditable(false);
	letter.setLineWrap(true);
	letter.setWrapStyleWord(true);
	
	pa.add(letter);
	
	Container contentPane = getContentPane();
	contentPane.add(pa, BorderLayout.CENTER);
    }
}
