package it.unibo.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import it.unibo.model.entity.obstacles.CircularSaw;
import it.unibo.model.entity.obstacles.CircularSawImpl;
import it.unibo.model.entity.obstacles.Platform;
import it.unibo.model.entity.obstacles.PlatformImpl;
import it.unibo.model.entity.player.MeatBoy;
import it.unibo.model.entity.player.MeatBoyImpl;
import it.unibo.model.entity.target.BandageGirl;
import it.unibo.model.entity.target.BandageGirlImpl;

public class GamePanel extends JPanel implements ActionListener {

    MeatBoy meatBoy;

    BandageGirl bandageGirl;

    CircularSaw saw;

    Platform platform;

    Timer gameTimer;

    public GamePanel() {
        meatBoy = new MeatBoyImpl(200, 200, 20, 20);
        bandageGirl = new BandageGirlImpl(300, 300, 20, 20);
        gameTimer = new Timer();
        saw = new CircularSawImpl(400, 500, 50, 50, 3);
        platform = new PlatformImpl(600, 600, 80, 20);

        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                meatBoy.update();
                repaint();
            }
            
        }, 0, 17);
    }

    public void paint (Graphics g) {

        super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        meatBoy.draw(gtd);

        saw.draw(gtd);

        platform.draw(gtd);

        bandageGirl.draw(gtd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void keyPressed(KeyEvent e) {
        meatBoy.move(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        meatBoy.stopMoving(e.getKeyCode());
    }

}
