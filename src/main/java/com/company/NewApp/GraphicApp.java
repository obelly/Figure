package com.company.NewApp;

import com.company.App.JPanelFigures;
import com.company.Creator.FigureCreator;
import com.company.Figures.Figure;
import com.company.Figures.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class GraphicApp extends JFrame implements ActionListener {
    private JFrame frame;
    private Box leftPanel, rightPanel;
    private JPanelFigures jPanelFigures;
    public ArrayList<Figure> figuresList;
    boolean chooseFigureAvailable = false;
    Figure activeFigure = null;

    public GraphicApp(ArrayList<Figure> figures){
         createFrame();
         initElements();
         this.figuresList = figures;
     }

    private void createFrame (){
        frame = new JFrame("Графическое приложение");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void show(){
        frame.setVisible(true);
    }
    private void initElements() {
        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        leftPanel = createLeftPanel();
        rightPanel = createRightPanel();
        mainContainer.add(leftPanel, BorderLayout.WEST );
        mainContainer.add(rightPanel,BorderLayout.EAST);

        this.jPanelFigures = new JPanelFigures(this.figuresList);
        mainContainer.add(this.jPanelFigures);

        jPanelFigures.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            int x = e.getX() - jPanelFigures.getWidth()/2;
            int y = -e.getY() + jPanelFigures.getHeight()/2;
            ArrayList<Figure> activeFigures = new ArrayList<>();
            activeFigure = defineFigureByCursor(x,y, figuresList);
                activeFigures.add(activeFigure);
            if (chooseFigureAvailable && activeFigure !=null) {
                jPanelFigures.repaintGraphics(activeFigures);
            }
                System.out.println(activeFigure + "add active");
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        this.revalidate();
        this.repaint();

        JMenuBar menuBar = createJMenuBar();// создаем меню
        frame.setJMenuBar(menuBar);
    }
    private Box createLeftPanel() {
        Box panel = Box.createVerticalBox();
        JLabel title = new JLabel("<html>Введите координаты</html>");
        title.setFont(new Font(null, Font.BOLD, 12)); // изменяем шрифт
        panel.add(title);

        panel.add(Box.createVerticalStrut(20)); //в Box можно добавлять отступы

        JLabel labelX = new JLabel("Значение x:");
        panel.add(labelX);

        JTextField textFieldX = new JTextField();
        textFieldX.setMaximumSize(new Dimension(100, 50));
        panel.add(textFieldX);

        JLabel labelY = new JLabel("Значение y:");
        panel.add(labelY);

        JTextField textFieldY = new JTextField();
        textFieldY.setMaximumSize(new Dimension(100, 50));
        panel.add(textFieldY);

        //J LIST
        DefaultListModel<String> dfm = new DefaultListModel<>();
        JList<String> listPoints = new JList<>(dfm);

        JScrollPane scrollPane = new JScrollPane(listPoints);
        scrollPane.setPreferredSize(new Dimension(25,25));
        listPoints.setLayoutOrientation(JList.VERTICAL);

        JButton btnAdd = new JButton("Добавить точку");
        JButton btnDelete = new JButton("Удалить точку");
        btnDelete.setEnabled(false);

        btnAdd.addActionListener(e -> {
            String point = textFieldX.getText() + "; " + textFieldY.getText();
            dfm.addElement(point);

            textFieldX.setText(null);
            textFieldY.setText(null);

            btnDelete.setEnabled(true);

        });
        btnDelete.addActionListener(e -> dfm.removeElement(listPoints.getSelectedValue()));

        panel.add(btnAdd);
        panel.add(btnDelete);
        panel.add(scrollPane);

        JButton btnOk = new JButton("Создать фигуру");
        panel.add(btnOk);
        btnOk.addActionListener(e -> {
            ArrayList<Point> points = new ArrayList<>();
            ListModel<String> listModel = listPoints.getModel();
            for (int i = 0; i< listModel.getSize(); i++){
                String[] arrayOfPoint = listModel.getElementAt(i).split(";");
                points.add(new Point((Double.parseDouble(arrayOfPoint[0])), (Double.parseDouble(arrayOfPoint[1]))));
            }
            for (var p: points) {
                System.out.println(p);
            }
            FigureCreator figureCreator = new FigureCreator();

            Figure fig = figureCreator.create(points);
            figuresList.add(fig);
            jPanelFigures.repaintGraphics(figuresList);
            dfm.removeAllElements();

            for (var ph: figuresList) {
                System.out.println(ph);
            }
        });

        panel.add(Box.createVerticalGlue());

        panel.setVisible(false);
        return panel;
    }
    private Box createRightPanel(){

        Box rightPanel = Box.createVerticalBox();

        JLabel title = new JLabel("<html>Введите координаты перемещения</html>");
        title.setFont(new Font(null, Font.BOLD, 12));
        rightPanel.add(title);
        rightPanel.add(Box.createVerticalStrut(20));

        JLabel moveLabelX = new JLabel("Значение x: ");
        rightPanel.add(moveLabelX);

        JTextField moveTextFieldX = new JTextField();
        moveTextFieldX.setMaximumSize(new Dimension(100, 25));
        rightPanel.add(moveTextFieldX);

        JLabel moveLabelY = new JLabel("Значение y: ");
        rightPanel.add(moveLabelY);

        JTextField moveTextFieldY = new JTextField();
        moveTextFieldY.setMaximumSize(new Dimension(100, 25));
        rightPanel.add(moveTextFieldY);

        JButton btnMove = new JButton("Переместить");
        rightPanel.add(btnMove);
        btnMove.addActionListener(e -> {
            double x = Double.parseDouble(moveTextFieldX.getText());
            double y = Double.parseDouble(moveTextFieldY.getText());
            activeFigure.move(new Point(x,y));
            System.out.println("move " + activeFigure);
            this.repaint();
            //activeFigures.add(activeFigure);
            //jPanelFigures.repaintGraphics(activeFigures);
            jPanelFigures.repaintGraphics(figuresList);
        });

        JLabel titleScale = new JLabel("<html>Введите множитель <br> увеличения</html>");
        titleScale.setFont(new Font(null, Font.BOLD, 12));
        rightPanel.add(titleScale);
        rightPanel.add(Box.createVerticalStrut(20));

        JTextField scaleTextField = new JTextField();
        scaleTextField.setMaximumSize(new Dimension(100, 25));
        rightPanel.add(scaleTextField);

        JButton btnScale = new JButton("Увеличить");
        rightPanel.add(btnScale);
        btnScale.addActionListener(e -> {
            double a = Double.parseDouble(scaleTextField.getText());
            activeFigure.scale(a);
            jPanelFigures.repaintGraphics(figuresList);
            //jPanelFigures.repaintGraphics(activeFigures);
            System.out.println("scale" + activeFigure);
            this.repaint();
        });

        JLabel titleRotate = new JLabel("<html>Введите угол <br> поворота</html>");
        titleRotate.setFont(new Font(null, Font.BOLD, 12));
        rightPanel.add(titleRotate);
        rightPanel.add(Box.createVerticalStrut(20));

        JTextField rotateTextField = new JTextField();
        rotateTextField.setMaximumSize(new Dimension(100, 25));
        rightPanel.add(rotateTextField);

        JButton btnRotate = new JButton("Повернуть");
        rightPanel.add(btnRotate);
        btnRotate.addActionListener(e -> {
            double a = Double.parseDouble(rotateTextField.getText());
            activeFigure.rotate(a);
            //jPanelFigures.repaintGraphics(activeFigures);
            jPanelFigures.repaintGraphics(figuresList);
            System.out.println("rotate " + activeFigure);

            this.repaint();

        });
        rightPanel.setVisible(false);
        return rightPanel;
    }

    private JMenuBar createJMenuBar () {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("Файл");
        JMenu figures = new JMenu("Фигуры");
        JMenu operations = new JMenu("Операции");

        menuBar.add(file);
        menuBar.add(figures);
        menuBar.add(operations);

        JMenuItem open = new JMenuItem("Загрузить");
        JMenuItem save = new JMenuItem("Сохранить");
        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(e -> System.exit(0));
        file.add(open);
        file.add(save);
        file.add(new JSeparator());
        file.add(exit);

        JMenuItem itemCreate = new JMenuItem("Создать");
        itemCreate.addActionListener(e -> {
            leftPanel.setVisible(true);
            rightPanel.setVisible(false);
            chooseFigureAvailable = false;
        });

        JMenuItem delete = new JMenuItem("Удалить");
        delete.setEnabled(false);

        figures.add(itemCreate);
        figures.add(delete);

        JMenuItem changeItem = new JMenuItem("Изменить фигуру");
        changeItem.addActionListener(e -> {
            chooseFigureAvailable = true;
            leftPanel.setVisible(false);
            rightPanel.setVisible(true);
        });
        JMenuItem cancelItem = new JMenuItem("Отменить изменения");

        //JMenuItem allFiguresItem = new JMenuItem("Вывести все фигуры");
        //allFiguresItem.addActionListener(e -> {
          //  jPanelFigures.repaintGraphics(figuresList);
        //});

        operations.add(changeItem);
        operations.add(cancelItem);
        //operations.add(allFiguresItem);

        return menuBar;
    }
    public Figure defineFigureByCursor(int x, int y, ArrayList<Figure>figures){
        for (Figure f: figures){
            if (f.containPoint(x,y)) return f;
        }
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
