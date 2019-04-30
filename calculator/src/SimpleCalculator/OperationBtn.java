package SimpleCalculator;

import javax.swing.*;
import java.awt.*;

/**
 * 设置运算符、操作符按钮的类
 */

public class OperationBtn extends JButton {
    //成员变量，确定所创建的操作按钮，包括加、减、乘、除等操作
    String operateStr ;
    /**
     * 构造方法
     */
    public OperationBtn ( String str ) {
        operateStr = str ;
        //设置字体颜色
        this.setText( str ) ;
        this.setForeground( Color.red ) ;

    }
    /**
     * 调用该方法返回其所含有的字符
     */
    public String getOpStr () {
        return operateStr ;
    }
}
