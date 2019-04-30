package SimpleCalculator;
   //数字按钮的初始化设计
import javax.swing.*;
import java.awt.*;

/**
 * 数字按钮的设计类
 */
public class NumberBtn extends JButton {
    //成员变量，确定所创建的数字按钮所含有的数字
    private int number;
    /**
     * 构造方法
     */
    public NumberBtn( int number ) {
        this.number = number ;
        //按钮的内容
        this.setText( "" + number );
        //设置字体颜色
        this.setForeground( Color.BLUE ) ;
    }
    /**
     * 调用该方法返回其所含有的数字
     */
    public int getNumber() {
        return number;
    }
}
