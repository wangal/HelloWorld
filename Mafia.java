import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Mafia extends JFrame {
	static final long serialVersionUID = 1;
	private JComboBox<String> citizenBox;
	private JComboBox<String> doctorBox;
	private JComboBox<String> mafiaBox;
	private JComboBox<String> copBox;
	private JComboBox<String> hookerBox;
	private JLabel messageLabel; // message that signals whether the options are valid
	
	public Mafia() {
		super("Mafia");
		setSize(500, 500);
		setLocation(50, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel citizenLabel = new JLabel("How many citizens?");
		JLabel doctorLabel = new JLabel("How many doctors?");
		JLabel mafiaLabel = new JLabel("How many mafias?");
		JLabel copLabel = new JLabel("How many cops?");
		JLabel hookerLabel = new JLabel("How many hookers?");
		
		citizenBox = new JComboBox<String>();
		doctorBox = new JComboBox<String>();
		mafiaBox = new JComboBox<String>();
		copBox = new JComboBox<String>();
		hookerBox = new JComboBox<String>();

		for(int i=0; i<5; ++i) { // Adds the numbers for the boxes
			copBox.addItem("" + i);
			doctorBox.addItem("" + i);
			hookerBox.addItem("" + i);
		}

		for(int i=1; i<5; ++i) { // Adds the numbers for the boxes
			mafiaBox.addItem("" + i);
		}
		
		for(int i=2; i<10; ++i) { // Adds the numbers for the boxes
			citizenBox.addItem("" + i);
		}
		
		JButton okButton = new JButton("Okay"); // Confirmation button
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int goodNum = citizenBox.getSelectedIndex();
				goodNum += copBox.getSelectedIndex();
				goodNum += doctorBox.getSelectedIndex();
				int badNum = mafiaBox.getSelectedIndex();
				badNum += hookerBox.getSelectedIndex();
				if(goodNum < badNum) // checks ratio NOTE: modify accordingly
					messageLabel.setText("Error. You need to more citizens/cop/doctors.");
				messageLabel.setText("Total number of roles: " + (goodNum + badNum));
			}
		}
		);
		
		JPanel selectPanel = new JPanel();
		selectPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;		gbc.gridy = 0;
		selectPanel.add(citizenBox, gbc);
		gbc.gridx = 1;
		selectPanel.add(citizenLabel, gbc);
		gbc.gridx = 0;		gbc.gridy = 1;
		selectPanel.add(copBox, gbc);
		gbc.gridx = 1;
		selectPanel.add(copLabel, gbc);
		gbc.gridx = 0;		gbc.gridy = 2;
		selectPanel.add(doctorBox, gbc);
		gbc.gridx = 1;
		selectPanel.add(doctorLabel, gbc);
		gbc.gridx = 0;		gbc.gridy = 3;
		selectPanel.add(mafiaBox, gbc);
		gbc.gridx = 1;
		selectPanel.add(mafiaLabel, gbc);
		gbc.gridx = 0;		gbc.gridy = 4;
		selectPanel.add(hookerBox, gbc);
		gbc.gridx = 1;
		selectPanel.add(hookerLabel, gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		selectPanel.add(okButton, gbc);
		
		JPanel numPanel = new JPanel();
		numPanel.add(new JLabel("Choose the number of roles for this round."));
		numPanel.setBackground(Color.white);

		messageLabel = new JLabel("Number of players: 5"); // Will contain number of roles needed for players
		JPanel messagePanel = new JPanel();
		messagePanel.add(messageLabel);
		messagePanel.setBackground(Color.white);

		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(Color.gray);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(selectPanel);
		mainPanel.add(playerPanel);
		
		JPanel hostPanel = new JPanel();
		hostPanel.setLayout(new BorderLayout());
		hostPanel.add(mainPanel, BorderLayout.CENTER);
		hostPanel.add(numPanel, BorderLayout.NORTH);
		hostPanel.add(messagePanel, BorderLayout.SOUTH);

		add(hostPanel);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Mafia();
	}
}
