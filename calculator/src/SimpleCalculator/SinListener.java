package SimpleCalculator;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * sin函数的监听事件类
 */
public class SinListener extends BaseListener {
    /**
     * 构造方法
     */
    public SinListener (LinkedList < String > list , JTextField resultShow ) {
        super ( list , resultShow ) ;
    }
    /**
     * sin函数的事件监听处理
     */
    public void actionPerformed (ActionEvent e) {
        switch ( list.size() ) {
            case 1 :
            case 2 :
            {
                String numOne = list.getFirst() ;
                try {
                    double x = Double.parseDouble( numOne ) ;
                    double result = Math.sin( x ) ;
                    String str = String.valueOf( result ) ;
                    list.set( 0 , str ) ;
                    resultShow.setText( str ) ;
                        if ( list.size() == 2 ) {
                            list.removeLast() ;
                        }
                }   catch ( Exception ex ) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            case 3 :
            {
                String numTwo = list.getLast();
                try {
                    double x = Double.parseDouble(numTwo);
                    double result = Math.sin(x);
                    String str = String.valueOf(result);
                    list.set(0, str);
                    resultShow.setText(str);
                    list.removeLast();
                    list.removeLast();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
                break ;
            default:
                break ;
        }
    }
}
