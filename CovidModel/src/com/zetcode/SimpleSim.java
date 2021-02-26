package com.zetcode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SimpleSim extends JFrame {

    JLabel picLabel;
    GamePanel gamePanel = new GamePanel();
    int N;
    int IonStart;
    int zmienna;

    public SimpleSim() {
        initUI();

    }

    public void initUI() {

        setTitle("Covid 19 simulator");
        setSize(1500, 1100);
        setLayout(new GridLayout(1, 2));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);




/*        var basePanel = new JPanel(new BorderLayout());
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.X_AXIS));
        basePanel.setBackground(Color.lightGray);
        basePanel.setBorder(new EmptyBorder(new Insets(15, 25, 15, 25)));
        add(basePanel);*/



        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        var label1 = new JLabel("Susceptibles:");
        var label2 = new JLabel("Infected :");
        var label3 = new JLabel("Parameter3:");


        var field1 = new JTextField(10);
        field1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                doit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                doit();
            }

            public void doit(){
                if(field1.getText()!=""){
                    N = Integer.parseInt(field1.getText());
                }
            }
        });
        var field2 = new JTextField(10);
        field2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                doit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                doit();
            }
            public void doit(){
                if(field2.getText()!=""){
                    IonStart = Integer.parseInt(field2.getText());
                }
            }
        });
        var field3 = new JTextField(10);

        JButton refreshButton = new JButton("Refresh");

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteHumans();
                startAnimation();

            }
        });




        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3))
                .addGroup(gl.createParallelGroup()
                        .addComponent(field1)
                        .addComponent(field2)
                        .addComponent(field3))
                        .addComponent(refreshButton)
                .addComponent(gamePanel,1000,1000,1000)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addGroup(gl.createSequentialGroup()
                                .addGroup(gl.createParallelGroup()
                                        .addComponent(label1,20,20,20)
                                        .addComponent(field1,20,20,20))
                                .addGroup(gl.createParallelGroup()
                                        .addComponent(label2,20,20,20)
                                        .addComponent(field2,20,20,20))
                                .addGroup(gl.createParallelGroup()
                                        .addComponent(label3,20,20,20)
                                        .addComponent(field3,20,20,20))
                                .addGroup(gl.createParallelGroup()
                                        .addComponent(refreshButton)))
                        .addGroup(gl.createParallelGroup()
                                .addComponent(gamePanel,1000,1000,1000)))
        );


/*        var basePanel = new JPanel(new BorderLayout());
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.X_AXIS));
        basePanel.setBackground(Color.lightGray);
        basePanel.setBorder(new EmptyBorder(new Insets(15, 25, 15, 25)));
        add(basePanel);*/
//        var settingsPanel = new JPanel(new BorderLayout());
//        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
//        //settingsPanel.setSize(600,700);
//        settingsPanel.setBackground(Color.LIGHT_GRAY);
/*        settingsPanel.add(new JButton("Button"));
        settingsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        settingsPanel.add(new JButton("Button2"));*/
/*        var lbl = new JLabel("Name:");
        var field = new JTextField(1);
        field.setSize(200,20);
        var lbl2 = new JLabel("Name2:");
        var field2 = new JTextField(1);
        field2.setPreferredSize( new Dimension( 200, 24 ) );


        pane.add(lbl);
        pane.add(field);
        pane.add(lbl2);
        pane.add(field2);*/
//        basePanel.add(settingsPanel);
     /*   var separator = new JSeparator();
        separator.setForeground(Color.gray);

        add(separator, BorderLayout.CENTER);*/
        //gamePanel.setBorder(BorderFactory.createEmptyBorder(15, 625, 15, 25));
/*        var pane = new JTextPane();
        pane.setContentType("text/html");
        var text = "<p><b>Closing windows using the mouse wheel</b></p>" +
                "<p>Clicking with the mouse wheel on an editor tab closes the window. " +
                "This method works also with dockable windows or Log window tabs.</p>";
        pane.setText(text);
        pane.setEditable(false);
        gamePanel.add(pane);*/
//        basePanel.add(gamePanel);
// add(basePanel);


        //ImagePanelHandler();
        //gamePanel.add(picLabel);


    }



    public void deleteHumans(){
        gamePanel.deleteHuman();
    }
    public void startAnimation(){
        gamePanel.addHuman();
    }
    class GamePanel extends JPanel {

        ArrayList humanList = new ArrayList();

        public GamePanel() {
            super();
            this.setSize(1000, 1000);
            this.setBackground(Color.black);
        }

        public void addHuman(){
            for(int i = 0; i< N; i++){
                humanList.add(new Human(0));
                System.out.println(((Human)humanList.get(i)).group);

            }
            System.out.println(humanList.size());
            for(int i = 0; i< IonStart; i++){
                humanList.add(new Human(2));
                System.out.println(((Human)humanList.get(i)).group);
            }
            System.out.println(humanList.size());
            for(int i = 0; i< humanList.size(); i++){
                System.out.println(((Human)humanList.get(i)).group);

            }
            System.out.println(humanList.size());
            this.paint(this.getGraphics());
        }

        public void deleteHuman(){
            humanList.clear();
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for(int i = 0 ; i < N ; i++){
                g.drawImage(((Human)humanList.get(i)).getImg(), ((Human)humanList.get(i)).x, ((Human)humanList.get(i)).y,20,20, null);
            }

            for(int i = N ; i < IonStart + N ; i++){
                g.drawImage(((Human)humanList.get(i)).getImg(), ((Human)humanList.get(i)).x, ((Human)humanList.get(i)).y,20,20, null);
            }


            //Graphics2D g2 = (Graphics2D)g;
        }


    }




    private void createMenuBar() {

        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(eMenuItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);


    }

    public void ImagePanelHandler(){
/*        try {
            URL imgUrl = new URL("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_white.png");
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }*/
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_white.png"); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);  // transform it back
            picLabel = new JLabel(imageIcon);

//            BufferedImage image1 = ImageIO.read(new File("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_white.png"));
 //           picLabel = new JLabel(new ImageIcon(image1));

    }



    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new com.zetcode.SimpleSim();
            ex.setVisible(true);
        });
    }




}





class Human{

    public Image getImg(){
        if(group == 0){ return Human.Simage; }
        if(group == 1){ return Human.Eimage; }
        if(group == 2){ return Human.Iimage; }
        if(group == 3){ return Human.Rimage; }
        else return Simage;
    }

    public Human(int group1){
        group = group1;
    }

    public void changeGroup(int group1){
        group = group1;
    }





    public static Image Simage = new ImageIcon("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_white.png").getImage();
    public static Image Eimage = new ImageIcon("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_yellow.png").getImage();
    public static Image Iimage = new ImageIcon("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_red.png").getImage();
    public static Image Rimage = new ImageIcon("C:\\Users\\Bartosz Wawrzyniak\\Desktop\\human_blue.png").getImage();



    Random r1 =	new Random();
    Random r2 =	new Random();
    Random r3 =	new Random();
    Random r4 =	new Random();
    int x = r1.nextInt(1000);
    int y = r2.nextInt(1000);
    int dx = r3.nextInt(3);
    int dy = r4.nextInt(3);
    int xHuman = Simage.getWidth(null);
    int yHuman = Simage.getHeight(null);


    int action;
    int group;


}

