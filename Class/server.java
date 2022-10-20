//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class server extends Applet implements ActionListener, TextListener {
    Button bt1;
    Button bt2;
    Button bt3;
    TextField tf1;
    TextField tf2;
    TextField tf3;
    TextArea ta1;
    TextArea ta2;
    Label lb1;
    Label lb2;
    Label lb3;
    String msg;
    String imsg;
    dialog dob;
    frame fob;
    InetAddress iad;
    int port;
    Exception exob;
    boolean flg;
    ServerSocket ss;
    Socket s;
    InputStream ips;
    OutputStream ops;
    conect cnt;

    server() {
    }

    public static void main(String[] var0) {
        server var1 = new server();
        frame var2 = new frame("Server Messenger");
        var1.fob = var2;
        var1.init();
        var1.start();
        var2.addWindowListener(var2);
        var2.add("Center", var1);
        var2.setLocation(10, 30);
        var2.setBackground(Color.lightGray);
        var2.setForeground(Color.blue);
        var2.setSize(470, 435);
        var2.setResizable(false);
        var2.show();
    }

    public void init() {
        try {
            this.iad = InetAddress.getLocalHost();
        } catch (Exception var2) {
            System.out.println(var2);
        }

        this.bt1 = new Button("Start");
        this.bt3 = new Button("Clear");
        this.bt2 = new Button("Send");
        this.lb1 = new Label("Server : " + this.iad.getHostName() + " [" + this.iad.getHostAddress() + "]");
        this.lb2 = new Label("Port :");
        this.lb3 = new Label("Notification  :");
        this.tf1 = new TextField("8080", 4);
        this.tf2 = new TextField("", 42);
        this.ta1 = new TextArea("", 15, 55, 1);
        this.ta2 = new TextArea("", 4, 48, 1);
        this.setLayout(new FlowLayout(1));
        this.bt1.addActionListener(this);
        this.bt2.addActionListener(this);
        this.bt3.addActionListener(this);
        this.ta1.addTextListener(this);
        this.ta2.addTextListener(this);
        this.ta1.setBackground(Color.black);
        this.ta1.setForeground(Color.green);
        this.ta2.setForeground(Color.magenta);
        this.tf1.setForeground(Color.red);
        this.tf2.setForeground(Color.red);
        this.tf2.setFocusable(false);
        this.ta1.setFocusable(false);
        this.ta2.setFocusable(false);
        this.bt2.setEnabled(false);
        this.bt3.setEnabled(false);
        this.requestFocus();
        this.add(this.lb1);
        this.add(this.lb2);
        this.add(this.tf1);
        this.add(this.bt1);
        this.add(this.bt3);
        this.add(this.ta1);
        this.add(this.ta2);
        this.add(this.bt2);
        this.add(this.lb3);
        this.add(this.tf2);
        this.cnt = new conect(this);
    }

    public void textValueChanged(TextEvent var1) {
        if (this.ta1.getText().equals("")) {
            this.bt3.setEnabled(false);
        } else {
            this.bt3.setEnabled(true);
        }

        if (this.ta2.getText().endsWith("\n")) {
            this.imsg = this.ta2.getText();
            this.ta1.append("Server :  " + this.imsg);
            this.ta2.setText("");
            if (this.flg) {
                this.readdat();
            }
        }

    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = var1.getActionCommand();
        if (var2.equals(this.bt3.getLabel())) {
            this.ta1.setText("");
        }

        if (var2.equals("Stop")) {
            this.flg = false;
            this.bt2.setEnabled(false);
            this.tf1.setFocusable(true);
            this.ta2.setFocusable(false);
            this.bt1.setLabel("Start");

            try {
                this.ss.close();
                this.s.close();
                this.tf2.setText("Server Disconnected from Client .");
            } catch (Exception var5) {
                System.out.println(var5);
            }
        }

        if (var2.equals("Start")) {
            if (this.tf1.getText().equals("")) {
                this.msg = "Please Enter Port No..";
                this.dob = new dialog(this.fob, "Invalid Port", 1, this.msg);
                this.dob.setVisible(true);
            } else {
                try {
                    this.msg = "Port must be Number.";
                    this.exob = new Exception(this.msg);
                    this.port = Integer.parseInt(this.tf1.getText());
                    this.bt1.setEnabled(false);
                    this.tf1.setFocusable(false);
                    this.cnt.t = new Thread(this.cnt);
                    this.cnt.t.start();
                } catch (Exception var4) {
                    this.dob = new dialog(this.fob, "Invalid Port", 1, this.msg);
                    this.dob.setVisible(true);
                }
            }
        }

        if (var2.equals(this.bt2.getLabel())) {
            this.imsg = this.ta2.getText();
            this.ta1.append("Server :  " + this.imsg + "\n");
            this.imsg = this.ta2.getText() + "\n";
            this.ta2.setText("");
            if (this.flg) {
                this.readdat();
            }
        }

    }

    void readdat() {
        try {
            this.msg = "IO Exception Occured.";
            this.exob = new Exception(this.msg);
            this.ops.write(this.imsg.getBytes());
        } catch (Exception var2) {
            this.flg = false;
            this.bt1.setEnabled(true);
            this.bt2.setEnabled(true);
            this.tf1.setFocusable(true);
            this.tf2.setFocusable(true);
            this.ta2.setFocusable(false);
            this.dob = new dialog(this.fob, "IO Error", 1, this.msg);
            this.dob.setVisible(true);
        }

    }
}
