package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * 退格事件监听类
 */
public class BackspaceListener  extends BaseListener {
    /**
     * 构造方法
     */
    public BackspaceListener (LinkedList < String > numList , JTextField txtResult) {
        super ( numList , txtResult ) ;
    }
    /**
     * 退格按钮的事件监听处理
     */
    @Override
    public void actionPerformed (ActionEvent e ) {
        switch ( this.list.size() ) {
            case 1 :
                {
                    String num = ( String ) this.list.getFirst() ;
                    if ( num.length() >= 1 ) {
                        num = num.substring( 0 , num.length()-1 ) ;
                        this.list.set( 0 , num ) ;
                        resultShow.setText( num ) ;
                    }
                    else {
                        this.list.removeLast() ;
                        resultShow.setText( "0") ;
                    }

                }
                break ;
            //2呢  2为运算符 首先源代码没有显示运算符 其次也无法退格  不合理
            case 3 :
            {
                String num = this.list.getLast() ;
                if( num.length() >= 1) {
                    num = num.substring( 0 , num.length() -1 ) ;
                    this.list.set( 2 , num ) ;
                    resultShow.setText( num ) ;
                }
                else {
                    this.list.removeLast() ;
                    resultShow.setText( "0" ) ;
                }
            }
                break ;
            default:
                break ;
        }
    }
}
