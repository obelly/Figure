package com.company.App;

//public class JFrame extends javax.swing.JFrame implements ActionListener {
//    private JFrame frame;
//    JMenuBar JMenuBar;
//    JMenu File, Commands;
//    JMenuItem open, save, exit, create, move, scale, rotate, delete;
//    JTextField text;
//    JTextField InputX, InputY;
//    JLabel TextX,TextY;
//    Box box;
//    JButton btnAdd;
//
//    public JFrame() {
//        super("Figures");
//        this.setLayout(new BorderLayout());
//
//       // Container container = super.getContentPane();
//        //container.setLayout(new BorderLayout(BorderLayout));
//
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();// возвращает размер экрана
//        super.setBounds((int) (dimension.getWidth()/2 - 500), (int) (dimension.getHeight()/2 - 500), 1000,1000);
//
//        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        box = Box.createVerticalBox();
//
//        TextX = new JLabel("Значение x: ");
//        InputX = new JTextField();
//        TextY = new JLabel("Значение y: ");
//        InputY = new JTextField();
//        InputY.setSize(100,100);
//
//        btnAdd = new JButton("Добавить");
//
//       // TextX.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        //InputX.setAlignmentX(Component.RIGHT_ALIGNMENT);
//
//        box.add(TextX);
//        box.add(InputX);
//        box.add(TextY);
//        box.add(InputY);
//        box.add(btnAdd);
//
//        this.getContentPane().add(box, BorderLayout.WEST);
//
//        // Создание МЕНЮ
//        JMenuBar = new JMenuBar();
//        this.setJMenuBar(JMenuBar);
//
//        File = new JMenu("Файл");
//        Commands = new JMenu("Команды");
//
//        JMenuBar.add(File);
//        JMenuBar.add(Commands);
//
//        open = new JMenuItem("Открыть файл");
//        save = new JMenuItem("Сохранить файл");
//        exit = new JMenuItem("Выход");
//
//        File.add(open);
//        File.add(save);
//        File.add(new JSeparator());
//        File.add(exit);
//
//        create = new JMenuItem("Создать фигуру");
//        move = new JMenuItem("Подвинуть фигуру");
//        scale = new JMenuItem("Масштабировать фигуру");
//        rotate = new JMenuItem("Повернуть фигуру");
//        delete = new JMenuItem("Удалить");
//
//        Commands.add(create);
//        Commands.add(new JSeparator());
//        Commands.add(move);
//        Commands.add(scale);
//        Commands.add(rotate);
//        Commands.add(new JSeparator());
//        Commands.add(delete);
//
//        open.addActionListener(this);
//        save.addActionListener(this);
//        exit.addActionListener(this);
//        create.addActionListener(this);
//        move.addActionListener(this);
//        scale.addActionListener(this);
//        rotate.addActionListener(this);
//        delete.addActionListener(this);
//
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource()==open){
//            System.out.println("OPEN");
//        }
//        if (e.getSource()==save){
//            System.out.println("SAVE");
//        }
//        if (e.getSource()==exit){
//            System.exit(0);
//        }
//        if (e.getSource()==create){
//            System.out.println("CREATE");
//        }
//        if (e.getSource()==move){
//            System.out.println("MOVE");
//        }
//        if (e.getSource()==scale){
//            System.out.println("SCALE");
//        }
//        if (e.getSource()==rotate){
//            System.out.println("ROTATE");
//        }
//        if (e.getSource()==delete){
//            System.out.println("DELETE");
//        }
//    }
//}