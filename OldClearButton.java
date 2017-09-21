import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**クリアボタンを生成するクラス*/
public class OldClearButton extends JButton
    implements MouseListener{
    /** 表示する数 **/
    private OldDisplayedNumber dispNumber;
    /** 演算器 **/
    private OldArithmeticUnit arithmUnit;

    /**コンストラクタ*/
    public OldClearButton(OldDisplayedNumber dispNumber,OldArithmeticUnit arithmUnit){
	this.dispNumber = dispNumber;
	this.arithmUnit = arithmUnit;
	setText("C");
	addMouseListener(this);
    }

    /**クリアボタンが押された時*/
    public void mouseClicked(MouseEvent e)
    {
	dispNumber.clear();
	arithmUnit.clear();	
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
