package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Generally, when we want to build a GUI, we will need to build an instance of frame.
//If we extend JFrame, the TryClickMe class becomes it's own unique frame with it's own unique
//contents.
public class TryTextArea extends JFrame{
	
	//The text area used for inputting more than a single line of text
	private JTextArea textArea;
	//Used to clear the contents in the text area
	private JButton buttonClear;
	//The text field
	private JTextField fieldMessage;
	//The submit button for the message
	private JButton buttonSubmit;
	
	
	/**
	 * Constructor for the TryTextArea class
	 */
	public TryTextArea() {
		createView();
		//Set title of frame
		setTitle("Text Area Test");
		//Make window exit application on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//
		setSize(400,200);
		//Center the frame to middle of screen
		setLocationRelativeTo(null);
		//Disable resize
		setResizable(false);
	}
	
	public static void main(String[] args) {
		//This will register this frame into a GUI thread
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TryTextArea().setVisible(true);;
			}
		});
		
	}

	private void createView() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Enter some text: ");
		panel.add(label);
		
		fieldMessage = new JTextField(12); //Text field is set to 12 cols wide
		panel.add(fieldMessage);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = fieldMessage.getText();
				if(!message.isEmpty())
				{
					textArea.append(message + "\n");
					fieldMessage.setText("");
				}
				
			}
		});
		panel.add(buttonSubmit);
		
		textArea = new JTextArea();
		//Don't allow user to directly input text into text area as it not for this purpose
		textArea.setEditable(false);
		//When typing in text area and your word hits edge of text area, the program will
		//automatically go to new line for you
		textArea.setLineWrap(true);
		//If you hit the end of the text area, the ENTIRE WORD will move to the next line,
		//not just the letters
		textArea.setWrapStyleWord(true);
		
		//The text area doesn't come with a scroll bar so we need to add it manually,
		//passing it the textArea as an argument to it's constructor
		JScrollPane scrollPane = new JScrollPane(textArea);
		//Set size of text area as it is connected to scroll pane
		scrollPane.setPreferredSize(new Dimension(350, 90));
		//Add scrollPane instead of textArea to get the scroll text area
		panel.add(scrollPane);
		
		buttonClear = new JButton("Clear Text Area");
		buttonClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				
			}
		});
		panel.add(buttonClear);

	}




}
