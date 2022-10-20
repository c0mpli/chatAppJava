//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dialog extends Dialog implements ActionListener {
    int tp;
    String msg;
    boolean fg;
    Button bt1;
    Button bt2;
    Label lb;

    dialog(Frame var1, String var2, int var3, String var4) {
        super(var1, var2, true);
        this.setLayout(new FlowLayout());
        this.setSize(320, 80);
        this.setLocation(var1.getX() + 10, var1.getY() + 20);
        this.setResizable(false);
        this.tp = var3;
        this.msg = var4;
        this.draw_di();
    }

    void draw_di() {
        switch(this.tp) {
            case 1:
                this.bt1 = new Button("OK");
                this.lb = new Label(this.msg);
                this.add(this.lb);
                this.add(this.bt1);
                this.bt1.addActionListener(this);
                break;
            case 2:
                this.bt1 = new Button("Yes");
                this.bt2 = new Button("No");
                this.lb = new Label(this.msg);
                this.add(this.lb);
                this.add(this.bt1);
                this.add(this.bt2);
                this.bt1.addActionListener(this);
                this.bt2.addActionListener(this);
        }

    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = var1.getActionCommand();
        switch(this.tp) {
            case 1:
                if (var2.equals(this.bt1.getLabel())) {
                    this.dispose();
                }
                break;
            case 2:
                if (var2.equals(this.bt1.getLabel())) {
                    this.fg = true;
                    this.dispose();
                } else if (var2.equals(this.bt2.getLabel())) {
                    this.fg = false;
                    this.dispose();
                }
        }

    }
}
