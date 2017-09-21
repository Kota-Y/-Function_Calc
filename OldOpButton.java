import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**演算記号ボタン**/
public class OldOpButton extends JButton implements MouseListener {
 	
    /**割り当てられた演算記号**/
    private String opStr;

    private OldArithmeticUnit arithmUnit;
    private OldDisplayedNumber dispNumber;

    /**  OpButtonのコンストラクタ.ボタンの作成をおこなう. **/
    public OldOpButton(String str,OldArithmeticUnit arithmUnit,OldDisplayedNumber dispNumber){
        super(str);
	this.opStr = str;
	this.arithmUnit = arithmUnit;
	this.dispNumber = dispNumber;
    	addMouseListener(this);
    }

    /**演算器号ボタンが押された**/
    public void mouseClicked(MouseEvent e){
	if(dispNumber.getValue() == arithmUnit.firstOperand){
	    arithmUnit.setOperator(opStr,true);
	}else{
	    arithmUnit.setOperator(opStr,false);
	}
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
