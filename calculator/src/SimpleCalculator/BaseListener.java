package SimpleCalculator;
  //封装了监听器类的通用属性

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * 按钮监听事件的父类
 */
public abstract class BaseListener implements ActionListener {
    protected LinkedList < String > list ;
    protected JTextField resultShow ;
    public BaseListener () { }
    public BaseListener ( LinkedList < String > list , JTextField resultShow ) {
        //super 不写好像也可以
        super() ;
        this.list = list ;
        this.resultShow = resultShow ;


    }


}
