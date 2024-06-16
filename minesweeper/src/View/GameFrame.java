package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.LoadData;

public class GameFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoadData loadData;
    private GamePanel gamePanel;

    private JMenuBar mnb;
    private JMenu menu1,menu2;
    private JMenuItem easy,normal,hard,newGame,exit;

    public GameFrame(int w, int h, int boom) {
        loadData = new LoadData();

        setJMenuBar(mnb = new JMenuBar());
        mnb.add(menu1 = new JMenu("Game mode"));
        mnb.add(menu2 = new JMenu("Option"));

        menu1.add(easy = new JMenuItem("Easy"));
        menu1.add(normal = new JMenuItem("Normal"));
        menu1.add(hard = new JMenuItem("Hard"));
        
        menu2.add(newGame = new JMenuItem("New Game"));
        menu2.add(exit = new JMenuItem("Exit"));
        if(w == 8){
            easy.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
        } else if(w == 16){
            normal.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
        } else {
            hard.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
        }

        easy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                new GameFrame(8, 8, 10);
			}
        });

        normal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                new GameFrame(16, 16, 40);
			}
        });

        hard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                new GameFrame(16, 30, 99);
			}
        });

        newGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
                new GameFrame(w, h, boom);
			}
        });

        exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        });

        add(setGamePanel(new GamePanel(w, h, boom, this)));
        setIconImage(loadData.getListImage().get("title"));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new GameFrame(8,8,10);
    }

    public LoadData getLoadData() {
        return loadData;
    }

    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public GamePanel setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		return gamePanel;
	}
}
