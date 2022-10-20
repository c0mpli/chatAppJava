//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.net.Socket;

class connect implements Runnable {
    client cob;
    Thread t;
    dialog dob;
    String msg;
    Exception exc;
    byte[] bt;

    connect(client var1) {
        this.cob = var1;
    }

    public void run() {
        try {
            this.msg = "No Any Server Exist OR Port is Already in Use.";
            this.exc = new Exception(this.msg);
            this.cob.s = new Socket(this.cob.sad, this.cob.port);
            this.cob.tf3.setText("Client Connected to Server.");
            this.cob.bt1.setLabel("Stop");
            this.cob.bt1.setEnabled(true);
            this.cob.bt2.setEnabled(true);
            this.cob.ta2.setFocusable(true);
            this.cob.tf1.setFocusable(false);
            this.cob.tf2.setFocusable(false);
            this.cob.ops = this.cob.s.getOutputStream();
            this.cob.ips = this.cob.s.getInputStream();
            this.msg = "Server is Disconnected.";
            this.exc = new Exception(this.msg);
            this.cob.flg = true;

            while(this.cob.flg) {
                try {
                    this.bt = new byte[100];
                    this.cob.ips.read(this.bt);
                    this.cob.ta1.append("Server :  " + new String(this.bt) + "\n");
                } catch (Exception var2) {
                    this.cob.flg = false;
                    this.cob.bt1.setEnabled(true);
                    this.cob.bt1.setLabel("Start");
                    this.cob.bt2.setEnabled(false);
                    this.cob.tf1.setFocusable(true);
                    this.cob.tf2.setFocusable(true);
                    this.cob.ta2.setFocusable(false);
                    this.dob = new dialog(this.cob.fob, "IO Error", 1, this.msg);
                    this.dob.setVisible(true);
                }
            }
        } catch (Exception var3) {
            this.cob.bt1.setEnabled(true);
            this.cob.bt1.setLabel("Start");
            this.cob.bt2.setEnabled(false);
            this.cob.tf1.setFocusable(true);
            this.cob.tf2.setFocusable(true);
            this.cob.ta2.setFocusable(false);
            this.dob = new dialog(this.cob.fob, "Server/Port Error", 1, this.msg);
            this.dob.setSize(400, 80);
            this.dob.setVisible(true);
        }

    }
}
