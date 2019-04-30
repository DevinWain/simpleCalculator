package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 * 运算符（加减乘除）的事件监听类
 */
public class OperationListener extends BaseListener{
    /**
     * 构造方法
     */
    public OperationListener (LinkedList< String > list, JTextField resultShow ) {
        super ( list, resultShow ) ;
    }
    /**
     * 运算符（加减乘除）的事件监听处理
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        OperationBtn b = ( OperationBtn ) e.getSource() ;
        switch ( list.size() ) {
            case 1 :
            {
                String op = b.getOpStr() ;
                list.add( op ) ;
            }
            break ;
            //替换原来存在的运算符
            case 2 :
            {
                String op = b.getOpStr() ;
                list.set( 1,op ) ;

            }
            break ;
            //实现连续运算
            case 3 :
            {
                String numOne = list.getFirst() ;
                String numTwo = list.getLast() ;
                String op = list.get( 1 ) ;
                try {
                    double n1 = Double.parseDouble(numOne);
                    double n2 = Double.parseDouble(numTwo);
                    double result = 0;
                    result = OpUtil.getResult(op, n1, n2);
                    String oper = b.getOpStr();
                    list.clear();
                    list.add("" + result);
                    list.add(oper);
                    resultShow.setText("" + result);

                }
                catch ( Exception ex) {
                    throw new RuntimeException( ex ) ;
                }
            }
                break ;
            default:
                break ;

        }
    }
}
