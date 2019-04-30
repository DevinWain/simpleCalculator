package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * 求相反数的事件监听类
 */

public class ReverseListener extends BaseListener {
    /**
     * 构造方法
     */
    public ReverseListener ( LinkedList < String > list, JTextField resultShow ) {
        super( list, resultShow ) ;
    }
    /**
     * 求相反数的事件监听处理
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        switch ( list.size() ) {
            case 1 :
            {
                String numOne = list.getFirst() ;
                try {
                    double d = Double.parseDouble( numOne ) ;
                    d = -1 * d ;
                    String str = String.valueOf( d ) ;
                    list.set ( 0 , str ) ;
                    resultShow.setText( str ) ;
                }   catch ( Exception ex ) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            case 3 :
            {
                String numTwo = list.getLast() ;
                try {
                    double d = Double.parseDouble( numTwo ) ;
                    String str = String.valueOf( d ) ;
                    list.set( 2, str ) ;
                    resultShow.setText( str ) ;
                }   catch ( Exception ex ) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            default:
                break ;
        }
    }
}
