package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * 开平方函数的事件监听类
 */

public class SqrtListener extends BaseListener {
    /**
     * 构造函数
     */
    public SqrtListener (LinkedList < String > list , JTextField resultShow ) {
        super ( list , resultShow ) ;
    }

    /**
     * 开平方的事件处理
     * @param e
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        switch ( list.size() ) {
            case 1 :
            case 2 :
            {
                String numOne = list.getFirst() ;
                try {
                    double d = Double.parseDouble( numOne ) ;
                    double result = Math.sqrt( d ) ;
                    String str = String.valueOf( result ) ;
                    list.set( 0 , str ) ;
                    resultShow.setText( str ) ;
                        if( list.size() == 2 ) {
                            list.removeLast() ;
                        }
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
                    double result = Math.sqrt( d ) ;
                    String str = String.valueOf( result ) ;
                    list.set( 0 , str ) ;
                    resultShow.setText( str ) ;
                    list.removeLast() ;
                    list.removeLast() ;
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
