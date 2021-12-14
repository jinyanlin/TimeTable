import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Table extends JFrame implements ActionListener {
	String titleName;
	String[] columnNames = {"", "星期一", "星期二", "星期三",  "星期四", "星期五"};
	Object[][] data = { 
			{"1", "", "", "",  "", ""}, 
			{"2", "", "", "",  "", ""}, 
			{"3", "", "", "",  "", ""}, 
			{"4", "", "", "",  "", ""}, 
			{"5", "", "", "",  "", ""},
			{"6", "", "", "",  "", ""},
			{"7", "", "", "",  "", ""},
			{"8", "", "", "",  "", ""}
	};
	
	private DefaultTableModel tableModel; 
	private JTable table;  
	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;
	private JTextField dTextField;
	private JTextField eTextField;
	private JTextField fTextField;
	
	private JButton add = new JButton("ADD");
	private JButton delete = new JButton("DELETE");
	private JButton fix = new JButton("FIX");
	private JButton notice = new JButton("NOTICE");
	
	Table(String titleName) {
		//Table 
		super(titleName); //this.setTitle(titleName);
		
		tableModel = new DefaultTableModel(data , columnNames );
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setRowHeight(50);
	    TableColumn firstColumn = table.getColumnModel().getColumn(0);
	    firstColumn.setPreferredWidth(30);
		table.setFillsViewportHeight(false); //是否要填滿整個panel
		
		Container c = getContentPane();
		JScrollPane tscroll = new JScrollPane(table); //加捲軸
		c.add(tscroll, BorderLayout.CENTER);
		
		//滑鼠事件
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedColumnCount();
				Object of = tableModel.getValueAt(selectRow, 0);
				Object oa = tableModel.getValueAt(selectRow, 1);
				Object ob = tableModel.getValueAt(selectRow, 2);
				Object oc = tableModel.getValueAt(selectRow, 3);
				Object od = tableModel.getValueAt(selectRow, 4);
				Object oe = tableModel.getValueAt(selectRow, 5);
				fTextField.setText(of.toString());
				aTextField.setText(oa.toString()); 
				bTextField.setText(ob.toString()); 
				cTextField.setText(oc.toString());  
				dTextField.setText(od.toString()); 
				eTextField.setText(oe.toString());  
			}
		});
		
		tscroll.setViewportView(table);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(new JLabel("節數:")); 
		fTextField = new JTextField("1",10);
		panel.add(fTextField);
  
		panel.add(new JLabel("禮拜一:")); 
		aTextField = new JTextField("",10);
		panel.add(aTextField);
	 
		panel.add(new JLabel("禮拜二:"));
		bTextField = new JTextField("",10);
		panel.add(bTextField);
		  
		panel.add(new JLabel("禮拜三："));
		cTextField = new JTextField("",10);
		panel.add(cTextField);
	 
		panel.add(new JLabel("禮拜四:"));
		dTextField = new JTextField("",10);
		panel.add(dTextField);
		  
		panel.add(new JLabel("禮拜五:"));
		eTextField = new JTextField("",10);
		panel.add(eTextField);
		
		//Button
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = {
						fTextField.getText(), 
						aTextField.getText(),
						bTextField.getText(),
						cTextField.getText(),
						dTextField.getText(),
						eTextField.getText()
				};
				tableModel.addRow(rowValues);
				fTextField.setText("" + (table.getRowCount() + 1));
			}
		});
		add(add);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedColumn(); //被選中索引值.
					if(selectedRow != -1) 
						tableModel.removeRow(selectedRow);
			}
		});
		add(delete);
		fix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1) {
					tableModel.setValueAt(aTextField.getText(), selectedRow, 1);
					tableModel.setValueAt(bTextField.getText(), selectedRow, 2);
					tableModel.setValueAt(cTextField.getText(), selectedRow, 3);
					tableModel.setValueAt(dTextField.getText(), selectedRow, 4);
					tableModel.setValueAt(eTextField.getText(), selectedRow, 5);
				}
			}
		});
		add(fix);
		notice.addActionListener(this);
		add(notice);
		
		this.setSize(490, 510);
		if(titleName == "FcuTable")
			this.setLocation(0,0);
		else
			this.setLocation(480,400);
		this.setIconImage(this.getToolkit().getImage("src/異域神劍2.png"));
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(titleName == "FcuTable") {
			if (arg0.getActionCommand() == "NOTICE"){
				NotificationCenter notificationCenter;
				notificationCenter = new NotificationCenter(new TimelyNotice());
				notificationCenter.doNotice();
			}
		}else {
			if (arg0.getActionCommand() == "NOTICE"){
				NotificationCenter notificationCenter;
				notificationCenter = new NotificationCenter(new ClickedNotice());
				notificationCenter.doNotice();
			}
		}
	}
}