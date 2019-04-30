    /*该文件用于完成系统的启动*/
package SimpleCalculator ;

    import javax.swing.*;
    import javax.swing.border.BevelBorder;
    import javax.swing.border.SoftBevelBorder;
    import java.awt.*;
    import java.util.LinkedList;

    public class SimpleCalculator extends JFrame {
        //声明主窗口所需要的全局变量
        //数字按钮数组，数字按钮中的数字包含1,2,3,4,5,6,7,8,9,0
        private NumberBtn numberBtn[] ;
        private OperationBtn operationBtn[] ;
        private JButton point, sign, backspace, equals, zero, sin, sqrt, reci ;
        //显示当前结果
        private JTextField txtresult ;
        //链表用来存放第一个运算数、运算符号和第二个运算数
        private LinkedList < String > numList ;
        //负责处理ActionEvent事件
        private NumberListener numberListener ;
        private OperationListener operationListener ;
        private BackspaceListener backspaceListener ;
        private ClearListener clearListener ;
        private EqualListener equalListener ;
        private PointListener pointListener ;
        private ReverseListener revListener ;
        private SinListener sinListener ;
        private SqrtListener sqrtListener ;
        private ReciprocalListener reciListener ;
        /**
         * 构造方法， 完成窗口初始化
         */
        public SimpleCalculator() {
            //设置窗口上方标题
            this.setTitle("SimpleCalculator") ;
            //属性赋值  新建链表
            this.numList = new LinkedList <String> () ;
            //结果显示区
            //设置文本框宽度
            this.txtresult = new JTextField( 10 ) ;
            //设置水平对齐方式 （右对齐）
            this.txtresult.setHorizontalAlignment( JTextField.RIGHT ) ;
            //设置前景颜色 （蓝色）
            this.txtresult.setForeground(Color.blue) ;
            //设置字体  Font(String name, int style, int size)
            this.txtresult.setFont(new Font ("TimesRoman" , Font.BOLD , 20 ) );
            //设置边框  BevelBorder.LOWERED 凹入斜面类型
            this.txtresult.setBorder( new SoftBevelBorder( BevelBorder.LOWERED));
            //设置是否可编辑
            this.txtresult.setEditable( false ) ;
            //设置背景颜色
            this.txtresult.setBackground( Color.white);
            //数字按钮
            //长度为10的对象数组
            this.numberBtn = new NumberBtn[10] ;
            //按钮监听器
            this.numberListener = new NumberListener( this.numList , this.txtresult ) ;
            for( int i = 0; i <= 9; i++ ) {
                //新建按钮
                this.numberBtn[i] = new NumberBtn( i );
                //按钮的数字的字体
                this.numberBtn[i].setFont( new Font ( "Arial", Font.BOLD , 18 )) ;
                //设置按钮监听器
                this.numberBtn[i].addActionListener( this.numberListener ) ;
            }
            //操作按钮
            this.operationBtn = new OperationBtn[4] ;
            this.operationListener = new OperationListener( this.numList , this.txtresult) ;
            String calculator[] = { "+", "-", "*", "/" } ;
            for( int i = 0 ; i < 4 ; i++) {
                this.operationBtn[i] = new OperationBtn( calculator[i] ) ;
                this.operationBtn[i].setFont( new Font ( "Arial" , Font.BOLD , 18 ) ) ;
                this.operationBtn[i].addActionListener( this.operationListener ) ;
            }
            //小数点 等于 及其他按钮
            this.sin = new JButton( "sin" ) ;
            this.sinListener = new SinListener( this.numList , this.txtresult ) ;
            this.sin.addActionListener( this.sinListener ) ;
            this.sqrt = new JButton( "sqrt" ) ;
            this.sqrtListener = new SqrtListener( this.numList , this.txtresult ) ;
            this.sqrt.addActionListener( this.sqrtListener ) ;
            this.sign = new JButton( "+/-" ) ;
            this.revListener = new ReverseListener( this.numList , this.txtresult ) ;
            this.sign.addActionListener( this.revListener ) ;
            this.equals = new JButton( "=" ) ;
            this.equalListener = new EqualListener( this.numList , this.txtresult ) ;
            this.equals.addActionListener( this.equalListener ) ;
            this.point = new JButton( "." ) ;
            this.pointListener = new PointListener( this.numList , this.txtresult ) ;
            this.point.addActionListener( this.pointListener ) ;
            this.reci = new JButton( "1/x" ) ;
            this.reciListener = new ReciprocalListener( this.numList , this.txtresult ) ;
            this.reci.addActionListener( this.reciListener ) ;
            //退格，清除，等号键
            this.backspace = new JButton( "退格" ) ;
            this.backspaceListener = new BackspaceListener( this.numList , this.txtresult ) ;
            this.backspace.addActionListener( this.backspaceListener ) ;
            this.backspace.setFont( new Font( "微软雅黑" , Font.BOLD , 16 ) ) ;
            this.zero = new JButton( "清零" ) ;
            this.clearListener = new ClearListener( this.numList , this.txtresult ) ;
            this.zero.addActionListener( this.clearListener ) ;
            this.zero.setFont( new Font("微软雅黑" , Font.BOLD , 16 ) ) ;
            this.zero.setForeground( Color.green ) ;
            this.backspace.setForeground( Color.green ) ;
            this.equals.setForeground( Color.red ) ;
            this.sin.setForeground( Color.blue ) ;
            this.sign.setForeground( Color.blue ) ;
            this.point.setForeground( Color.blue ) ;
            this.sqrt.setForeground( Color.blue ) ;
            this.sqrt.setForeground( Color.blue ) ;
            this.reci.setForeground( Color.blue ) ;
            //窗口的设计分为两部分
            JPanel panelDown , panelUp ;
            panelUp = new JPanel( new BorderLayout( ) ) ;
            panelUp.add( this.txtresult, BorderLayout.CENTER ) ;
            //数字存放区计算窗口按钮的摆放
            JPanel northInRight = new JPanel( ) ;
            JPanel centerInRight = new JPanel( ) ;
            JPanel southInRight = new JPanel( ) ;
            panelDown = new JPanel( new BorderLayout( ) ) ;
            panelDown.add( northInRight , BorderLayout.NORTH ) ;
            northInRight.setLayout( new GridLayout( 1 , 2 , 30 , 30 ) ) ;
            northInRight.add( zero ) ;
            northInRight.add( backspace ) ;
            //分割线
            JSplitPane split1 = new JSplitPane( JSplitPane.VERTICAL_SPLIT , northInRight , centerInRight ) ;
            panelDown.add( split1 , BorderLayout.NORTH ) ;
            panelDown.add( centerInRight , BorderLayout.WEST ) ;
            centerInRight.setLayout( new GridLayout( 4 , 3 , 10 , 8 ) ) ;
            centerInRight.add( numberBtn[7] ) ;
            centerInRight.add( numberBtn[8] ) ;
            centerInRight.add( numberBtn[9] ) ;
            centerInRight.add( numberBtn[4] ) ;
            centerInRight.add( numberBtn[5] ) ;
            centerInRight.add( numberBtn[6] ) ;
            centerInRight.add( numberBtn[1] ) ;
            centerInRight.add( numberBtn[2] ) ;
            centerInRight.add( numberBtn[3] ) ;
            centerInRight.add( numberBtn[0] ) ;
            centerInRight.add( point );
            centerInRight.add( reci ) ;
            //分割线
            JSplitPane split2 = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT , centerInRight , southInRight ) ;
            panelDown.add( split2 , BorderLayout.CENTER ) ;
            panelDown.add( southInRight , BorderLayout.EAST ) ;
            southInRight.setLayout( new GridLayout( 4 , 2 , 10 , 8 ) ) ;
            southInRight.add( operationBtn[0] ) ;
            southInRight.add( sin ) ;
            southInRight.add( operationBtn[1] ) ;
            southInRight.add( sqrt ) ;
            southInRight.add( operationBtn[2] ) ;
            southInRight.add( sign ) ;
            southInRight.add( operationBtn[3] ) ;
            southInRight.add( equals ) ;

            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
            JSplitPane split = new JSplitPane( JSplitPane.VERTICAL_SPLIT , panelUp , panelDown ) ;
            add( split , BorderLayout.CENTER ) ;
            setVisible( true ) ;
            setBounds( 500 , 350 , 450 ,280 ) ;
            validate() ;
        }
        /**
         * 计算器程序运行的入口函数
         */
        public static void main ( String args[ ] ) {
            new SimpleCalculator( ) ;
        }

}
