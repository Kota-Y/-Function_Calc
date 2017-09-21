import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/** イコールボタンを生成するクラス*/
public class OldEqualButton extends JButton implements MouseListener{

    /** 演算器*/
    private OldArithmeticUnit arithmUnit;

    public OldEqualButton(OldArithmeticUnit arithmUnit){
	this.arithmUnit = arithmUnit;
	setText("=");
	addMouseListener(this);
    }

    /** イコールボタンが押された*/
    public void mouseClicked(MouseEvent e){
	arithmUnit.operate();
	arithmUnit.clear();
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}




