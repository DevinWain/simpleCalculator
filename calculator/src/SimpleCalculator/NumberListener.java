package SimpleCalculator;
   // 数字按钮的事件监听处理

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * 数字按钮（1234567890）的事件监听类
 */
public class NumberListener extends BaseListener{
    /**
     * 构造方法
     */

    public NumberListener (LinkedList < String > list , JTextField resultShow ) {
        super ( list, resultShow ) ;
    }
    /**
     * 数字按钮的事件监听处理
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        NumberBtn b = (NumberBtn) e.getSource() ;
        switch ( list.size() ) {
            case 0: {
                int number = b.getNumber() ;
                list.add ( "" + number ) ;
                resultShow.setText( "" + number ) ;

            }
                break ;
            case 1: {
                int number = b.getNumber() ;
                String num = list.getFirst() ;
                //将数字连接到num的结尾
                String s = num.concat( "" + number ) ;
                //用s代替第0个元素
                list.set( 0, s ) ;
                resultShow.setText( s );
                System.out.println( s ) ;
            }
                break ;
            case 2: {
                int number = b.getNumber() ;
                list.add ( "" + number ) ;
                resultShow.setText( "" + number );
            }
                break ;
            case 3: {
                int number = b.getNumber() ;
                String num = list.getLast() ;
                String s = num.concat( "" + number ) ;
                list.set( 2, s ) ;
                resultShow.setText( s );
            }
                break ;
            default:
                break ;
        }

    }
}
