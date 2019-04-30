package SimpleCalculator;

import javax.swing.*;
import java.util.LinkedList;
import java.awt.event.*;

/**
 * 等号事件监听类
 */
public class EqualListener extends BaseListener {
    /**
     * 构造方法
     */
    public EqualListener (LinkedList< String > list , JTextField resultShow ) {
        super( list, resultShow ) ;
    }
    /**
     * 等号按钮的事件监听处理
     */
    public void actionPerformed ( ActionEvent e ) {
        switch ( list.size() ) {
            case 1 :
            {
                String num = list.getFirst() ;
                resultShow.setText( "" + num ) ;
            }
                break ;
            //这是一个有bug的case2  bug为 12+ = 24
            case 2 :
            {
                String num = list.getFirst() ;
                String op = list.get( 1 ) ;
                try {
                    double n1 = Double.parseDouble( num ) ;
                    double n2 = Double.parseDouble( num ) ;
                    double result = OpUtil.getResult( op, n1, n2 ) ;
                    resultShow.setText( "" + result ) ;
                    list.set( 0, "" + result ) ;
                } catch ( Exception ex) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            case 3 :
            {
                String numOne = list.getFirst() ;
                String op = list.get( 1 ) ;
                String numTwo = list.getLast() ;
                try {
                    double n1 = Double.parseDouble( numOne ) ;
                    double n2 = Double.parseDouble( numTwo ) ;
                    double result = OpUtil.getResult( op, n1, n2 ) ;
                    resultShow.setText( "" + result ) ;
                    list.set( 0, "" + result ) ;
                    //移掉第2个运算数
                    list.removeLast() ;
                    //移掉运算符号
                    list.removeLast() ;
                } catch ( Exception ex ) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            default :
                break ;
        }
    }
}
