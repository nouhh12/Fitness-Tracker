package tracker;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.util.*;
import java.text.*;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import javax.swing.JSeparator;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FitnessTrack extends JFrame {

	private JPanel contentPane;
	private JTextField insertBox;
	Track track=new Track();
	public static JTextArea printingBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//To start running the window of the gui
			public void run() {
				try {
					FitnessTrack frame = new FitnessTrack();
					frame.setVisible(true);
				} catch (Exception e) {
					//Case there is an error in running the gui the error line is displayed to be addressed
					e.printStackTrace();
				}
			}
		});
	}

	public FitnessTrack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		insertBox = new JTextField();
		insertBox.setForeground(new Color(0, 0, 0));
		insertBox.setBorder(null);
		insertBox.setBackground(new Color(244, 245, 249));
		insertBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		insertBox.setBounds(190, 37, 165, 23);
		contentPane.add(insertBox);
		insertBox.setColumns(10);
		
		JLabel title = new JLabel("Insert Time:");
		title.setFont(new Font("Calibri", Font.BOLD, 15));
		title.setBounds(103, 36, 103, 30);
		contentPane.add(title);
		
		//To clear the Time field after each entry
		ActionListener messagePrint = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			insertBox.setText("");
		}
		};
		//Timer is set for the message to be displayed for a second each time
		final Timer mytimer= new Timer(1000, messagePrint);
		
		//Swimming button data
		final JLabel swimButton = new JLabel("");
		swimButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//To inform the user that a specific time should be inserted in field rather than leaving it empty
				if(insertBox.getText().isEmpty()) {
					insertBox.setText("Please Insert Time...");
					mytimer.start();
					mytimer.setRepeats(false);
				}
				else {
				//To pass the time of the activity to Track object
				int time=Integer.parseInt(insertBox.getText());
				track.getCaloriesBurnt(time, "Swimming");
				track.heartRateIncrease(time, "Swimming");
				insertBox.setText("Added Succesfully..");
				mytimer.start();
				mytimer.setRepeats(false);
				}
			}
			//To make an effect of changing background colour of button upon entry and exit
			public void mouseEntered(MouseEvent e) {
				swimButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/swimdButton.png")));
			}
			public void mouseExited(MouseEvent e) {
				swimButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/swimButton.png")));
			}
		});
		swimButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/swimButton.png")));
		swimButton.setBounds(10, 94, 130, 40);
		contentPane.add(swimButton);
		
		//Strength training button data
		final JLabel strengthButton = new JLabel("");
		strengthButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//To inform the user that a specific time should be inserted in field rather than leaving it empty
				if(insertBox.getText().isEmpty()) {
					insertBox.setText("Please Insert Time...");
					mytimer.start();
					mytimer.setRepeats(false);
				}
				else {
				//To pass the time of the activity to Track object
				int time=Integer.parseInt(insertBox.getText());
				track.getCaloriesBurnt(time, "Strength_Training");
				track.heartRateIncrease(time, "Strength_Training");
				insertBox.setText("Added Succesfully..");
				mytimer.start();
				mytimer.setRepeats(false);
			}
		}
			//To make an effect of changing background colour of button upon entry and exit
			public void mouseEntered(MouseEvent e) {
				strengthButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/stengthdButton.png")));
				}
			public void mouseExited(MouseEvent e) {
				strengthButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/strengthButton.png")));
			}
		});
		strengthButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/strengthButton.png")));
		strengthButton.setBounds(10, 169, 220, 40);
		contentPane.add(strengthButton);
		
		//Running button data
		final JLabel runButton = new JLabel("");
		runButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//To inform the user that a specific time should be inserted rather than leaving the field empty
				if(insertBox.getText().isEmpty()) {
					insertBox.setText("Please Insert Time...");
					mytimer.start();
					mytimer.setRepeats(false);
				}
				else {
				int time=Integer.parseInt(insertBox.getText());
				track.getCaloriesBurnt(time, "Running");
				track.heartRateIncrease(time, "Running");
				insertBox.setText("Added Succesfully..");
				mytimer.start();
				mytimer.setRepeats(false);
			}
		}
			//To make an effect of changing background colour of button upon entry and exit
			public void mouseEntered(MouseEvent e) {
				runButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/rundButton.png")));
			}
			public void mouseExited(MouseEvent e) {
				runButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/runButton.png")));
			}
		});
		runButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/runButton.png")));
		runButton.setBounds(304, 94, 120, 40);
		contentPane.add(runButton);
		
		//Kick Boxing button data
		final JLabel kickButton = new JLabel("");
		kickButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//To inform the user that a specific time should be inserted in field rather than leaving it empty
				if(insertBox.getText().isEmpty()) {
					insertBox.setText("Please Insert Time...");
					mytimer.start();
					mytimer.setRepeats(false);
				}
				else {
				int time=Integer.parseInt(insertBox.getText());
				track.getCaloriesBurnt(time, "Kick_Boxing");
				track.heartRateIncrease(time, "Kick_Boxing");
				insertBox.setText("Added Succesfully..");
				mytimer.start();
				mytimer.setRepeats(false);
			}
		}
			//To make an effect of changing background colour of button upon entry and exit		
			public void mouseEntered(MouseEvent e) {
				kickButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/kickdButton.png")));
			}
			public void mouseExited(MouseEvent e) {
				kickButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/kickButton.png")));
			}
		});
		kickButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/kickButton.png")));
		kickButton.setBounds(270, 169, 154, 40);
		contentPane.add(kickButton);
		
		final JLabel calcButton = new JLabel("");
		calcButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Show toDisplay = new Show(track);
				//toDisplay.setTrack(track);
				toDisplay.setVisible(true);
				toDisplay.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
			//To make an effect of changing background colour of button upon entry and exit
			public void mouseEntered(MouseEvent e) {
				calcButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/calcdButton.png")));
			}
			public void mouseExited(MouseEvent e) {
				calcButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/calcButton.png")));
			}
		});
		calcButton.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/calcButton.png")));
		calcButton.setBounds(160, 211, 142, 40);
		contentPane.add(calcButton);
		
		JLabel background = new JLabel("");
		background.setForeground(new Color(0, 0, 0));
		background.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/hrback.jpg")));
		background.setBounds(-40, -84, 720, 360);
		contentPane.add(background);
		
		
		
		
		
	}

}
//The new window showing the results
class Show extends JFrame{
	private JPanel contentPane;
//Object "Track" is passed to the function displaying the second window 
//to use the data in the object such as calories burned and heart rate increase per activity	
public Show(Track track) {
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(510, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	final JTextArea printingBox = new JTextArea(13,20);
	printingBox.setForeground(Color.BLACK);
	printingBox.setBackground(new Color(231,231,231));
	printingBox.setText("Total Calories Burnt:");
	printingBox.setEditable(false);
	printingBox.setLineWrap(true);
	printingBox.setWrapStyleWord(true);
	printingBox.setBounds(5, 5, 220, 260);
	contentPane.add(printingBox);
	
	JLabel background = new JLabel("");
	background.setForeground(new Color(0, 0, 0));
	background.setIcon(new ImageIcon(FitnessTrack.class.getResource("/tracker/2ndback.jpg")));
	background.setBounds(-40, 10, 300, 420);
	contentPane.add(background);
	
	//DecimalFormat is used to define the number of decimal places required in each field which in this case is 2 decimal places
	DecimalFormat df = new DecimalFormat("####.00");
	
	printingBox.append(String.valueOf(df.format(track.totalCalories))+" calories\n");
	printingBox.append("Total Heart Rate:"+df.format(track.heartRate)+" beats/min\n\n");
	
	int time,option=0,i=0,max=0,j,k=0,winner=0,flag=0;
	String exercise;float biggest=0,biggesthr;
	
	//this is used in the sorting to identify which information has been printed, so not to be displayed again
	int[] blacklist=new int[] {10,10,10,10}; 
	
	for(i=0;i<4;i++) {
		winner=0; biggest=0;biggesthr=0;flag=10;
		if(track.totalCal[i]==0) {
			continue;				//to be printed later in the next for loop
		}
		for(j=0;j<4;j++) {
			// if the value at index is bigger than biggest and has not been printed before
			
			if(track.totalCal[j]>biggest && 
					j!=blacklist[0] && j!=blacklist[1] && j!=blacklist[2] && j!=blacklist[3]) {
				winner=j;biggest=track.totalCal[j];flag=1;		
			}
			//if it is equal to previous biggest value then raise flag to compare heart rate increase
			
			if(track.totalCal[j]==biggest) {
				flag=0;option=j;			
			}
		}
		// option is compared with blacklist to make sure it is not a previously printed display
		if(flag==0 && track.hrIncrease[option]>track.hrIncrease[winner] &&
						option!=blacklist[0] && option!=blacklist[1] && option!=blacklist[2] && option!=blacklist[3]) {
					winner=option;
					}
		blacklist[k++]=winner;
		switch(winner) {
		case 0: printingBox.append("Swimming:\n");
			printingBox.append(track.getCalories(0)+"\n");
			printingBox.append(track.getHeartRate(0)+"\n");
			break;
		case 1: printingBox.append("Running:\n");
			printingBox.append(track.getCalories(1)+"\n");
			printingBox.append(track.getHeartRate(1)+"\n");
			break;
		case 2: printingBox.append("Kick Boxing:\n");
			printingBox.append(track.getCalories(2)+"\n");
			printingBox.append(track.getHeartRate(2)+"\n");
			break;
		case 3: printingBox.append("Strength Training:\n");
			printingBox.append(track.getCalories(3)+"\n");
			printingBox.append(track.getHeartRate(3)+"\n");
		}
}
//if the activity was not performed by the user then the heart rate increase and calories burned for that activity are placed as 0
	for(i=0;i<4;i++) {
		winner=10;
		if(i!=blacklist[0] && i!=blacklist[1] && i!=blacklist[2] && i!=blacklist[3]) {
			winner=i;
		}
		switch(winner) {
		case 0: printingBox.append("Swimming:\n");
			printingBox.append("Calories Burnt:0 calories\n");
			printingBox.append("Heart rate increase: 0 beats/minute\n");
			break;
		case 1: printingBox.append("Running:\n");
			printingBox.append("Calories Burnt:0 calories\n");
			printingBox.append("Heart rate increase: 0 beats/minute\n");
			break;
		case 2: printingBox.append("Kick Boxing:\n");
			printingBox.append("Calories Burnt:0 calories\n");
			printingBox.append("Heart rate increase: 0 beats/minute\n");
			break;
		case 3: printingBox.append("Strength Training:\n");
			printingBox.append("Calories Burnt:0 calories\n");
			printingBox.append("Heart rate increase: 0 beats/minute\n");
		}
	}
}

}
