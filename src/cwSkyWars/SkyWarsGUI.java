package cwSkyWars;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.event.WindowListener;
import java.util.TreeMap;
import javax.swing.JTextArea;

public class SkyWarsGUI extends JFrame {
	
	private Game theGame;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnSave;
	private JButton btnStart;
	private JButton btnExit;
	private JButton btnMove;
	private JLabel r1s1;
	private JLabel r1s2;
	private JLabel r1s3;
	private JLabel r1s4;
	private JLabel r2s1;
	private JLabel r2s2;
	private JLabel r2s3;
	private JLabel r2s4;
	private JLabel r3s1;
	private JLabel r3s2;
	private JLabel r3s3;
	private JLabel r3s4;
	private JLabel r4s1;
	private JLabel r4s2;
	private JLabel r4s3;
	private JLabel r4s4;
	private JToggleButton tglbtnNewToggleButton_1;
	private boolean msOnSquare = false;
	private JButton btnRestart;
	private JTextArea textArea;
	private JLabel starsCount;
	private JLabel cruisesCount;
	private JLabel newCount;
	private int stars = 0;
	private int cruises = 0;
	private int newType = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkyWarsGUI frame = new SkyWarsGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SkyWarsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 889, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getR1s1());
		contentPane.add(getR1s2());
		contentPane.add(getR1s3());
		contentPane.add(getR1s4());
		contentPane.add(getR2s1());
		contentPane.add(getR2s2());
		contentPane.add(getR2s3());
		contentPane.add(getR2s4());
		contentPane.add(getR3s1());
		contentPane.add(getR3s2());
		contentPane.add(getR3s3());
		contentPane.add(getR3s4());
		contentPane.add(getR4s1());
		contentPane.add(getR4s2());
		contentPane.add(getR4s3());
		contentPane.add(getR4s4());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnSave());
		contentPane.add(getBtnStart());
		contentPane.add(getBtnExit());
		contentPane.add(getBtnMove());
		contentPane.add(getTglbtnNewToggleButton_1());
		contentPane.add(getBtnRestart());
		contentPane.add(getTextArea());
		contentPane.add(getStarsCount());
		contentPane.add(getCruisesCount());
		contentPane.add(getNewCount());
	}
	
	// Method to check conflict resolution
	private void checkConflict() {
		theGame.getCountESsOnMsSq();
		theGame.isGameOver();
		theGame.constructGameOver();
		theGame.printGameOver();
		if(theGame.isGameOver() == true) {
			JOptionPane.showMessageDialog(null, "Game over!", "STATUS", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	// Method to check Master Ship location and construct display correctly
 	private boolean isMSOnSquare(int row, int sq) {
		if(theGame.mSRow() == row && theGame.mSSq() == sq) {
			msOnSquare = true;
		} else {
			msOnSquare = false;
		}
		return this.msOnSquare;
	}
	
 	// Method to update Master Ship display
	private void updateMSDisplay() {
//		Image img = new ImageIcon(this.getClass().getResource("/img/MasterShip.png")).getImage().getScaledInstance(50, 50, 50);
			if(isMSOnSquare(1, 1) == true) {
//				r1s1.setIcon(new ImageIcon(img));
				r1s1.setText("MS");
			} 
			if(isMSOnSquare(1, 2) == true) {
//				r1s2.setIcon(new ImageIcon(img));
				r1s2.setText("MS");
			} 
			if(isMSOnSquare(1, 3) == true) {
//				r1s3.setIcon(new ImageIcon(img));
				r1s3.setText("MS");
			} 
			if(isMSOnSquare(1, 4) == true) {
				r1s4.setText("MS");
			}
			if(isMSOnSquare(2, 1) == true) {
				r2s1.setText("MS");
			} 
			if(isMSOnSquare(2, 2) == true) {
				r2s2.setText("MS");
			} 
			if(isMSOnSquare(2, 3) == true) {
				r2s3.setText("MS");
			} 
			if(isMSOnSquare(2, 4) == true) {
				r2s4.setText("MS");
			}
			if(isMSOnSquare(3, 1) == true) {
				r3s1.setText("MS");
			} 
			if(isMSOnSquare(3, 2) == true) {
				r3s2.setText("MS");
			} 
			if(isMSOnSquare(3, 3) == true) {
				r3s3.setText("MS");
			} 
			if(isMSOnSquare(3, 4) == true) {
				r3s4.setText("MS");
			}
			if(isMSOnSquare(4, 1) == true) {
				r4s1.setText("MS");
			} 
			if(isMSOnSquare(4, 2) == true) {
				r4s2.setText("MS");
			} 
			if(isMSOnSquare(4, 3) == true) {
				r4s3.setText("MS");
			} 
			if(isMSOnSquare(4, 4) == true) {
				r4s4.setText("MS");
			}
			
	}
	
	// Method to reset all labels
	private void resetAllLabels() {
		// Row 1 reset
		r1s1.setText(""+ theGame.resetR1S1());
		r1s2.setText(""+ theGame.resetR1S2());
		r1s3.setText(""+ theGame.resetR1S3());
		r1s4.setText(""+ theGame.resetR1S4());
//		r1s1.setIcon(null);
//		r1s2.setIcon(null);
//		r1s2.setIcon(null);
//		r1s4.setIcon(null);
		// Row 2 reset
		r2s1.setText(""+ theGame.resetR2S1());
		r2s2.setText(""+ theGame.resetR2S2());
		r2s3.setText(""+ theGame.resetR2S3());
		r2s4.setText(""+ theGame.resetR2S4());
		// Row 3 reset
		r3s1.setText(""+ theGame.resetR3S1());
		r3s2.setText(""+ theGame.resetR3S2());
		r3s3.setText(""+ theGame.resetR3S3());
		r3s4.setText(""+ theGame.resetR3S4());
		// Row 4 reset
		r4s1.setText(""+ theGame.resetR4S1());
		r4s2.setText(""+ theGame.resetR4S2());
		r4s3.setText(""+ theGame.resetR4S3());
		r4s4.setText(""+ theGame.resetR4S4());
	}
	
	// Method to update squares
	private void updateSquares() {
		resetAllLabels();
		// Row 1 representation
		r1s1.setText(""+ theGame.resetR1S1());
		r1s1.setText("" + theGame.countESsonR1S1());
		r1s2.setText(""+ theGame.resetR1S2());
		r1s2.setText("" + theGame.countESsonR1S2());
		r1s3.setText(""+ theGame.resetR1S3());
		r1s3.setText("" + theGame.countESsonR1S3());
		r1s4.setText(""+ theGame.resetR1S4());
		r1s4.setText("" + theGame.countESsonR1S4());
		// Row 2 representation
		r2s1.setText(""+ theGame.resetR2S1());
		r2s1.setText("" + theGame.countESsonR2S1());
		r2s2.setText(""+ theGame.resetR2S2());
		r2s2.setText("" + theGame.countESsonR2S2());
		r2s3.setText(""+ theGame.resetR2S3());
		r2s3.setText("" + theGame.countESsonR2S3());
		r2s4.setText(""+ theGame.resetR2S4());
		r2s4.setText("" + theGame.countESsonR2S4());
		// Row 3 representation
		r3s1.setText(""+ theGame.resetR3S1());
		r3s1.setText("" + theGame.countESsonR3S1());
		r3s2.setText(""+ theGame.resetR3S2());
		r3s2.setText("" + theGame.countESsonR3S2());
		r3s3.setText(""+ theGame.resetR3S3());
		r3s3.setText("" + theGame.countESsonR3S3());
		r3s4.setText(""+ theGame.resetR3S4());
		r3s4.setText("" + theGame.countESsonR3S4());
		// Row 4 representation
		r4s1.setText(""+ theGame.resetR4S1());
		r4s1.setText("" + theGame.countESsonR4S1());
		r4s2.setText(""+ theGame.resetR4S2());
		r4s2.setText("" + theGame.countESsonR4S2());
		r4s3.setText(""+ theGame.resetR4S3());
		r4s3.setText("" + theGame.countESsonR4S3());
		r4s4.setText(""+ theGame.resetR4S4());
		r4s4.setText("" + theGame.countESsonR4S4());	
	}
	
	// Move Button
	private JButton getBtnMove() {
		if (btnMove == null) {
			btnMove = new JButton("MOVE");
			btnMove.setForeground(Color.BLUE);
			btnMove.setFont(new Font("Bahnschrift", Font.BOLD, 26));
			btnMove.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 204), new Color(0, 255, 255), new Color(204, 0, 153), new Color(0, 153, 153)));
			btnMove.setBackground(Color.LIGHT_GRAY);
			btnMove.setBounds(238, 504, 159, 49);
			btnMove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetAllLabels();
					updateSquares();
					updateMSDisplay();
					theGame.moveAllShips();
					countStars();
					updateStarsLabel();
					countCruises();
					updateCruisesLabel();
					countNewTypes();
					updateNewTypeLabel();
//					theGame.getEsIdToRemove();
//					theGame.updateEnemyShipsList();
					checkConflict();
					updateSquares();
					updateMSDisplay();
				}
			});
		}
		return btnMove;
	}
	
	// Mode Button
	private JToggleButton getTglbtnNewToggleButton_1() {
		if (tglbtnNewToggleButton_1 == null) {
			tglbtnNewToggleButton_1 = new JToggleButton("MODE");
			tglbtnNewToggleButton_1.setForeground(Color.RED);
			tglbtnNewToggleButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 26));
			tglbtnNewToggleButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 204), new Color(0, 255, 255), new Color(204, 0, 153), new Color(0, 153, 153)));
			tglbtnNewToggleButton_1.setBackground(new Color(255, 102, 0));
			tglbtnNewToggleButton_1.setBounds(530, 504, 159, 49);
		}
		return tglbtnNewToggleButton_1;
	}
	
	// Start Button
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.setForeground(Color.WHITE);
			btnStart.setFont(new Font("Bahnschrift", Font.BOLD, 23));
			btnStart.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), new Color(102, 255, 204), new Color(255, 0, 255), new Color(255, 0, 0)));
			btnStart.setBackground(new Color(0, 102, 0));
			btnStart.setOpaque(isOpaque());
			btnStart.setBounds(772, 18, 95, 42);
			btnStart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					textArea.setVisible(false);
					theGame = new Game();
					r1s1.setVisible(true);
					r1s2.setVisible(true);
					r1s3.setVisible(true);
					r1s4.setVisible(true);			
					r2s1.setVisible(true);
					r2s2.setVisible(true);
					r2s3.setVisible(true);
					r2s4.setVisible(true);
					r3s1.setVisible(true);
					r3s2.setVisible(true);
					r3s3.setVisible(true);
					r3s4.setVisible(true);
					r4s1.setVisible(true);
					r4s2.setVisible(true);
					r4s3.setVisible(true);
					r4s4.setVisible(true);
//					countStars();

				}
			});
		}
		return btnStart;
	}
	
	// Save Button
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.setOpaque(true);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSave.setForeground(new Color(0, 102, 0));
			btnSave.setFont(new Font("Bahnschrift", Font.BOLD, 23));
			btnSave.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 204), new Color(0, 255, 255), new Color(204, 0, 153), new Color(0, 153, 153)));
			btnSave.setBackground(Color.LIGHT_GRAY);
			btnSave.setBackground(getBackground());
			btnSave.setBounds(31, 62, 95, 33);
		}
		return btnSave;
	}
	
	// Exit Button
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Exit");
			btnExit.setForeground(Color.BLACK);
			btnExit.setFont(new Font("Bahnschrift", Font.BOLD, 23));
			btnExit.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 204), new Color(0, 255, 255), new Color(204, 0, 153), new Color(0, 153, 153)));
			btnExit.setBackground(Color.RED);
			btnExit.setBounds(31, 18, 95, 33);
			btnExit.setOpaque(isOpaque());			
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btnExit;
	}

	// Restart Button
	private JButton getBtnRestart() {
		if (btnRestart == null) {
			btnRestart = new JButton("Restart");
			btnRestart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theGame = new Game();
					resetAllLabels();
					updateMSDisplay();	
					countStars();
					updateStarsLabel();
					countCruises();
					updateCruisesLabel();
					countNewTypes();
					updateNewTypeLabel();
				}
			});
			btnRestart.setOpaque(true);
			btnRestart.setForeground(Color.WHITE);
			btnRestart.setFont(new Font("Bahnschrift", Font.BOLD, 23));
			btnRestart.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 255), new Color(102, 255, 204), new Color(255, 0, 255), new Color(255, 0, 0)));
			btnRestart.setBackground(Color.BLUE);
			btnRestart.setBounds(772, 70, 95, 42);
		}
		return btnRestart;
	}
	
	// Labels for the Grid
	private JLabel getR1s1() {
		if (r1s1 == null) {
			r1s1 = new JLabel("r1s1");
			r1s1.setVisible(false);
			r1s1.setHorizontalAlignment(SwingConstants.CENTER);
			r1s1.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r1s1.setBorder(border);
			r1s1.setForeground(Color.WHITE);
			r1s1.setBackground(Color.LIGHT_GRAY);
			r1s1.setBounds(238, 114, 110, 80);			
		}
		return r1s1;
	}	
	private JLabel getR1s2() {
		if (r1s2 == null) {
			r1s2 = new JLabel("r1s2");
			r1s2.setVisible(false);
			r1s2.setHorizontalAlignment(SwingConstants.CENTER);
			r1s2.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r1s2.setBorder(border);
			r1s2.setForeground(Color.WHITE);
			r1s2.setBackground(Color.LIGHT_GRAY);
			r1s2.setBounds(348, 114, 110, 80);
		}
		return r1s2;
	}	
	private JLabel getR1s3() {
		if (r1s3 == null) {
			r1s3 = new JLabel("r1s3");
			r1s3.setVisible(false);
			r1s3.setHorizontalAlignment(SwingConstants.CENTER);
			r1s3.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r1s3.setBorder(border);
			r1s3.setForeground(Color.WHITE);
			r1s3.setBackground(Color.LIGHT_GRAY);
			r1s3.setBounds(458, 114, 110, 80);
		}
		return r1s3;
	}	
	private JLabel getR1s4() {
		if (r1s4 == null) {
			r1s4 = new JLabel("r1s4");
			r1s4.setVisible(false);
			r1s4.setHorizontalAlignment(SwingConstants.CENTER);
			r1s4.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r1s4.setBorder(border);
			r1s4.setForeground(Color.WHITE);
			r1s4.setBackground(Color.LIGHT_GRAY);
			r1s4.setBounds(568, 114, 110, 80);
		}
		return r1s4;
	}	
	private JLabel getR2s1() {
		if (r2s1 == null) {
			r2s1 = new JLabel("r2s1");
			r2s1.setVisible(false);
			r2s1.setHorizontalAlignment(SwingConstants.CENTER);
			r2s1.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r2s1.setBorder(border);
			r2s1.setForeground(Color.WHITE);
			r2s1.setBackground(Color.LIGHT_GRAY);
			r2s1.setBounds(238, 194, 110, 80);			
		}
		return r2s1;
	}	
	private JLabel getR2s2() {
		if (r2s2 == null) {
			r2s2 = new JLabel("r2s2");
			r2s2.setVisible(false);
			r2s2.setHorizontalAlignment(SwingConstants.CENTER);
			r2s2.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r2s2.setBorder(border);
			r2s2.setForeground(Color.WHITE);
			r2s2.setBackground(Color.LIGHT_GRAY);
			r2s2.setBounds(348, 194, 110, 80);
		}
		return r2s2;
	}	
	private JLabel getR2s3() {
		if (r2s3 == null) {
			r2s3 = new JLabel("r2s3");
			r2s3.setVisible(false);
			r2s3.setHorizontalAlignment(SwingConstants.CENTER);
			r2s3.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r2s3.setBorder(border);
			r2s3.setForeground(Color.WHITE);
			r2s3.setBackground(Color.LIGHT_GRAY);
			r2s3.setBounds(458, 194, 110, 80);
		}
		return r2s3;
	}	
	private JLabel getR2s4() {
		if (r2s4 == null) {
			r2s4 = new JLabel("r2s4");
			r2s4.setVisible(false);
			r2s4.setHorizontalAlignment(SwingConstants.CENTER);
			r2s4.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r2s4.setBorder(border);
			r2s4.setForeground(Color.WHITE);
			r2s4.setBackground(Color.LIGHT_GRAY);
			r2s4.setBounds(568, 194, 110, 80);
		}
		return r2s4;
	}
	private JLabel getR3s1() {
		if (r3s1 == null) {
			r3s1 = new JLabel("r3s1");
			r3s1.setVisible(false);
			r3s1.setHorizontalAlignment(SwingConstants.CENTER);
			r3s1.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r3s1.setBorder(border);
			r3s1.setForeground(Color.WHITE);
			r3s1.setBackground(Color.LIGHT_GRAY);
			r3s1.setBounds(238, 274, 110, 80);			
		}
		return r3s1;
	}	
	private JLabel getR3s2() {
		if (r3s2 == null) {
			r3s2 = new JLabel("r3s2");
			r3s2.setVisible(false);
			r3s2.setHorizontalAlignment(SwingConstants.CENTER);
			r3s2.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r3s2.setBorder(border);
			r3s2.setForeground(Color.WHITE);
			r3s2.setBackground(Color.LIGHT_GRAY);
			r3s2.setBounds(348, 274, 110, 80);
		}
		return r3s2;
	}	
	private JLabel getR3s3() {
		if (r3s3 == null) {
			r3s3 = new JLabel("r3s3");
			r3s3.setVisible(false);
			r3s3.setHorizontalAlignment(SwingConstants.CENTER);
			r3s3.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r3s3.setBorder(border);
			r3s3.setForeground(Color.WHITE);
			r3s3.setBackground(Color.LIGHT_GRAY);
			r3s3.setBounds(458, 274, 110, 80);
		}
		return r3s3;
	}	
	private JLabel getR3s4() {
		if (r3s4 == null) {
			r3s4 = new JLabel("r3s4");
			r3s4.setVisible(false);
			r3s4.setHorizontalAlignment(SwingConstants.CENTER);
			r3s4.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r3s4.setBorder(border);
			r3s4.setForeground(Color.WHITE);
			r3s4.setBackground(Color.LIGHT_GRAY);
			r3s4.setBounds(568, 274, 110, 80);
		}
		return r3s4;
	}
	private JLabel getR4s1() {
		if (r4s1 == null) {
			r4s1 = new JLabel("r4s1");
			r4s1.setVisible(false);
			r4s1.setHorizontalAlignment(SwingConstants.CENTER);
			r4s1.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r4s1.setBorder(border);
			r4s1.setForeground(Color.WHITE);
			r4s1.setBackground(Color.LIGHT_GRAY);
			r4s1.setBounds(238, 354, 110, 80);			
		}
		return r4s1;
	}	
	private JLabel getR4s2() {
		if (r4s2 == null) {
			r4s2 = new JLabel("r4s2");
			r4s2.setVisible(false);
			r4s2.setHorizontalAlignment(SwingConstants.CENTER);
			r4s2.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r4s2.setBorder(border);
			r4s2.setForeground(Color.WHITE);
			r4s2.setBackground(Color.LIGHT_GRAY);
			r4s2.setBounds(348, 354, 110, 80);
		}
		return r4s2;
	}	
	private JLabel getR4s3() {
		if (r4s3 == null) {
			r4s3 = new JLabel("r4s3");
			r4s3.setVisible(false);
			r4s3.setHorizontalAlignment(SwingConstants.CENTER);
			r4s3.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r4s3.setBorder(border);
			r4s3.setForeground(Color.WHITE);
			r4s3.setBackground(Color.LIGHT_GRAY);
			r4s3.setBounds(458, 354, 110, 80);
		}
		return r4s3;
	}	
	private JLabel getR4s4() {
		if (r4s4 == null) {
			r4s4 = new JLabel("r4s4");
			r4s4.setVisible(false);
			r4s4.setHorizontalAlignment(SwingConstants.CENTER);
			r4s4.setFont(new Font("Tahoma", Font.BOLD, 20));
			Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
			r4s4.setBorder(border);
			r4s4.setForeground(Color.WHITE);
			r4s4.setBackground(Color.LIGHT_GRAY);
			r4s4.setBounds(568, 354, 110, 80);
		}
		return r4s4;
	}
	// Sky Wars Title
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sky Wars");
			lblNewLabel.setBounds(334, 11, 197, 42);
			lblNewLabel.setForeground(new Color(51, 255, 51));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		}
		return lblNewLabel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(" Game rules:\r\n\n"
					+ " The sky is a four-by-four grid with one \n Master Ship, represented by “MS”. Press the \n “MOVE” button to move it to an adjacent \n (including diagonal) square. Enemy Ships may \n enter the sky through the one-directional \n intergalactic hole on Row one Square one, \n represented by “r1s1”. Enemy Ship numbers are \n displayed on each square. In defensive mode, \n the Master Ship destroys one Enemy Ship but \n is defeated by two. In offensive mode, it can \n kill two Enemy Ships and requires three to \n be eliminated. \n\n Enjoy!\r\n"
					+ "");
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
			textArea.setVisible(true);
			textArea.setBounds(238, 92, 469, 362);
		}
		return textArea;
	}
	private int countStars() {
		stars = theGame.countStars();
		return this.stars;
	}
	private void updateStarsLabel() {
		this.stars = 0;
		starsCount.setText(countStars() + " Star Ships");
	}
	private JLabel getStarsCount() {
		if (starsCount == null) {
			starsCount = new JLabel("");
			starsCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
			starsCount.setForeground(Color.LIGHT_GRAY);
			starsCount.setBackground(new Color(0, 0, 51));
			starsCount.setBounds(31, 277, 169, 49);
		}
		return starsCount;
	}
	private int countCruises() {
		cruises = theGame.countCruises();
		return this.cruises;
	}
	private void updateCruisesLabel() {
		this.cruises = 0;
		cruisesCount.setText(countCruises() + " Cruise Ships");
	}
	private JLabel getCruisesCount() {
		if (cruisesCount == null) {
			cruisesCount = new JLabel("");
			cruisesCount.setForeground(Color.LIGHT_GRAY);
			cruisesCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
			cruisesCount.setBackground(new Color(0, 0, 51));
			cruisesCount.setBounds(31, 320, 169, 49);
		}
		return cruisesCount;
	}
	private int countNewTypes() {
		newType = theGame.countNewTypes();
		return this.newType;
	}
	private void updateNewTypeLabel() {
		this.newType = 0;
		newCount.setText(countNewTypes() + " New type \nof Enemy Ships");
	}
	private JLabel getNewCount() {
		if (newCount == null) {
			newCount = new JLabel("");
			newCount.setForeground(Color.LIGHT_GRAY);
			newCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
			newCount.setBackground(new Color(0, 0, 51));
			newCount.setBounds(31, 367, 169, 56);
		}
		return newCount;
	}
} // end class
