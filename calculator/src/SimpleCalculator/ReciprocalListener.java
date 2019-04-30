package SimpleCalculator;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JTextField;

/**
 * 求倒数的事件监听类
 */
public class ReciprocalListener extends BaseListener {
    /**
     * 构造方法
     */
    public ReciprocalListener ( LinkedList< String > list , JTextField resultShow ) {
        super ( list, resultShow ) ;
    }
    /**
     * 1/X求倒数事件的监听处理
     */
    public void actionPerformed (ActionEvent e ) {
        switch ( this.list.size() ) {
            case 1 :
            case 2 :
            {
                String numOne = list.getFirst() ;
                try {
                    double d = Double.parseDouble( numOne ) ;
                    double result = 1.0 / d ;
                    String str = String.valueOf( result ) ;
                    list.set( 0 , str ) ;
                    resultShow.setText( str ) ;
                        if ( list.size() == 2 ) {
                            //移除运算符号
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
                    double result = 1.0 / d ;
                    String str = String.valueOf( result ) ;
                    list.set ( 0 , str ) ;
                    resultShow.setText( str ) ;
                    //移除第二个运算数及运算符
                    list.removeLast() ;
                    list.removeLast() ;
                }   catch( Exception ex) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            default:
                break ;
        }
    }
}
