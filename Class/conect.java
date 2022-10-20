//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.net.ServerSocket;

class conect implements Runnable {
    server sob;
    Thread t;
    dialog dob;
    String msg;
    Exception exc;
    byte[] bt;

    conect(server var1) {
        this.sob = var1;
    }

    public void run() {
        try {
            this.msg = "Port is Already in Use.";
            this.exc = new Exception(this.msg);
            this.sob.ss = new ServerSocket(this.sob.port);
            this.sob.tf2.setText("Server Listening for Client......");
            this.sob.s = this.sob.ss.accept();
            this.sob.tf2.setText("Server Connected to Client.");
            this.sob.bt1.setLabel("Stop");
            this.sob.bt1.setEnabled(true);
            this.sob.bt2.setEnabled(true);
            this.sob.ta2.setFocusable(true);
            this.sob.tf1.setFocusable(false);
            this.sob.ops = this.sob.s.getOutputStream();
            this.sob.ips = this.sob.s.getInputStream();
            this.sob.flg = true;
            this.msg = "IO Exception Occured.";
            this.exc = new Exception(this.msg);

            while(this.sob.flg) {
                try {
                    this.bt = new byte[100];
                    this.sob.ips.read(this.bt);
                    this.sob.ta1.append("Client :  " + new String(this.bt) + "\n");
                } catch (Exception var2) {
                    this.sob.flg = false;
                    this.sob.bt1.setEnabled(true);
                    this.sob.bt2.setEnabled(false);
                    this.sob.tf1.setFocusable(true);
                    this.sob.ta2.setFocusable(false);
                    this.dob = new dialog(this.sob.fob, "IO Error", 1, this.msg);
                    this.dob.setVisible(true);
                }
            }
        } catch (Exception var3) {
            this.sob.flg = false;
            this.sob.bt1.setEnabled(true);
            this.sob.bt2.setEnabled(true);
            this.sob.tf1.setFocusable(true);
            this.sob.tf2.setFocusable(true);
            this.sob.ta2.setFocusable(false);
            this.dob = new dialog(this.sob.fob, "Server/Port Error", 1, this.msg);
            this.dob.setVisible(true);
        }

    }
}
