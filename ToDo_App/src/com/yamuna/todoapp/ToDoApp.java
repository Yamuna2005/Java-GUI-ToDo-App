package com.yamuna.todoapp;
import javax.swing.*;
import java.awt.*;


public class ToDoApp extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String>taskListModel;
	private JList<String>taskList;
	private JTextField taskField;
    public ToDoApp() {
    	setTitle("To-Do- List App ");
    	setSize(400,500);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	
    	//Layout
    	setLayout(new BorderLayout());
    	
    	//input field
    	taskField = new JTextField();
    	add(taskField,BorderLayout.NORTH);
    	;
    	//Task list
    	taskListModel= new DefaultListModel<>();
    	taskList = new 	JList<>(taskListModel);
    	add(new JScrollPane(taskList),BorderLayout.CENTER);
    	
    	//Buttons
    	JPanel buttonPanel = new JPanel();
    	JButton addButton = new JButton("Add");
    	JButton deleteButton = new JButton("Delete");
    	buttonPanel.add(addButton);
    	buttonPanel.add(deleteButton);
    	add(buttonPanel,BorderLayout.SOUTH);
    	
    	//Add button action
    	addButton.addActionListener(e->{
    		if(taskField !=null) {
    		String task = taskField.getText().trim();
    		if(!task.isEmpty()) {
    			taskListModel.addElement(task);
    			taskField.setText("");
    		}
    	}
    	});
    	
    	//Delete button action
    	deleteButton.addActionListener(e ->{
    		if(taskList !=null) {
    			int selectedIndex = taskList.getSelectedIndex();
    			if(selectedIndex != -1) {
    				taskListModel.remove(selectedIndex);
    			}else {
    				JOptionPane.showMessageDialog(this,"please select a task to delete");
    			}
    		}
    		
    	});
    	
   }
    
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new ToDoApp().setVisible(true);
			
		});

	}

}
