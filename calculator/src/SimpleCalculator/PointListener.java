package SimpleCalculator;

import javax.swing.*;
import java.util.LinkedList;
import java.awt.event.*;

/**
 * 小数点按钮的事件监听类
 */

public class PointListener extends BaseListener {
    /**
     * 构造方法
     */
    public PointListener ( LinkedList < String > list , JTextField resultShow ) {
        super( list , resultShow ) ;
    }
    /**
     * 小数点的事件监听处理
     */
    public void actionPerformed ( ActionEvent e ) {
        String point = e.getActionCommand() ;

        switch ( list.size() ) {
            case 1 :
            {
                String num = list.getFirst() ;
                String s = null ;
                if ( !num.contains( point ) ) {
                    s = num.concat( point ) ;
                    list.set( 0, s ) ;
                }
                else {
                    s = num ;
                }
                list.set( 0 , s ) ;
                resultShow.setText( s ) ;
            }
                break ;
            case 2 :
            {
                String num = list.getFirst() ;
                String s = null ;
                if( !num.contains( point ) ) {
                    s = num.concat ( point ) ;
                    //这个越界了
                    list.set( 2 , s ) ;
                }
                else {
                    s = num ;
                }
                resultShow.setText( s ) ;
            }
                break ;
            //3没有了
            default :
                break ;
        }
    }

}
