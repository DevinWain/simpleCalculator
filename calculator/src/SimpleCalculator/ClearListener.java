package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * 清零功能的事件监听类
 */
public class ClearListener extends BaseListener {
    /**
     * 构造方法
     */
    public ClearListener ( LinkedList< String > list , JTextField resultShow ) {
        super( list, resultShow ) ;
    }
    /**
     * 清零按钮的事件监听类
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        this.resultShow.setText( "0" ) ;
        this.list.clear() ;
    }

}
