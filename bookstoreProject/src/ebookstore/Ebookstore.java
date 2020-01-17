package ebookstore;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


class Ebookstore {
	JFrame f;
	JPanel EnterBook,UpdateBook,DeleteBook,SearchBooks;
	JTabbedPane tp;
	ImageIcon btnimg1,btnimg2;
	JLabel lbl_Add_ID, lbl_Add_Title, lbl_Add_Author, lbl_Add_Qty,lbl_Del_ID,l6,lbl_Edit_ID,lbl_Edit_Title,lbl_Edit_Author,lbl_Edit_Qty,lbl_Search_ID;
	JTextField tf_Add_ID,tf_Add_Title,tf_Add_Author,tf_Add_Qty,tf_Del_ID,tf6,tf_Edit_ID,tf_Edit_Title,tf_Edit_Author,tf_Edit_Qty,tf_Search_ID;
	JScrollPane sp1;
	JButton savebtn,resetbtn,editbtn1,editbtn2,deletebtn,btnSearch ;
	private JTable SearchTable;

	// The creation of the GUI
	Ebookstore(){
		f=new JFrame("Form");
		EnterBook=new JPanel();
		UpdateBook=new JPanel();
		DeleteBook=new JPanel();
		SearchBooks = new JPanel();
		tp=new JTabbedPane();
		lbl_Add_ID=new JLabel("ID:");
		lbl_Add_ID.setBounds(0, 1, 214, 22);
		lbl_Add_Title=new JLabel("Title:");
		lbl_Add_Title.setBounds(0, 23, 214, 22);
		lbl_Add_Author=new JLabel("Author:");
		lbl_Add_Author.setBounds(0, 45, 214, 22);
		lbl_Add_Qty=new JLabel("Qty:");
		lbl_Add_Qty.setBounds(0, 67, 214, 22);
		lbl_Del_ID=new JLabel("Enter ID to delete record:");
		lbl_Del_ID.setBounds(0, 0, 214, 56);
		lbl_Edit_ID=new JLabel("ID:");
		lbl_Edit_ID.setBounds(0, 1, 214, 22);
		lbl_Edit_Title=new JLabel("Title:");
		lbl_Edit_Title.setBounds(0, 23, 214, 22);
		lbl_Edit_Author=new JLabel("Author:");
		lbl_Edit_Author.setBounds(0, 45, 214, 22);
		lbl_Edit_Qty=new JLabel("Qty:");
		lbl_Edit_Qty.setBounds(0, 67, 214, 22);
		lbl_Search_ID = new JLabel("Enter the book ID:");
		lbl_Search_ID.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Search_ID.setBounds(81, 9, 89, 14);
		tf_Add_ID=new JTextField(12);
		tf_Add_ID.setBounds(214, 1, 214, 22);
		tf_Add_ID.setBackground(new Color(255, 255, 255));
		tf_Add_Title=new JTextField(12);
		tf_Add_Title.setBounds(214, 23, 214, 22);
		tf_Add_Author=new JTextField(12);
		tf_Add_Author.setBounds(214, 45, 214, 22);
		tf_Add_Qty=new JTextField(12);
		tf_Add_Qty.setBounds(214, 67, 214, 22);
		tf_Del_ID=new JTextField(12);
		tf_Del_ID.setBounds(214, 0, 214, 56);
		tf6=new JTextField(12);
		tf_Edit_ID=new JTextField(12);
		tf_Edit_ID.setBounds(214, 1, 214, 22);
		tf_Edit_Title=new JTextField(12);
		tf_Edit_Title.setBounds(214, 23, 214, 22);
		tf_Edit_Author=new JTextField(12);
		tf_Edit_Author.setBounds(214, 45, 214, 22);
		tf_Edit_Qty=new JTextField(12);
		tf_Edit_Qty.setBounds(214, 67, 214, 22);
		tf_Search_ID = new JTextField(12);
		tf_Search_ID.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Search_ID.setBackground(Color.WHITE);
		tf_Search_ID.setBounds(175, 6, 102, 20);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(282, 5, 83, 23);
		savebtn=new JButton(" Add ");
		savebtn.setBounds(0, 89, 214, 22);
		resetbtn=new JButton(" Reset");
		resetbtn.setBounds(214, 89, 214, 22);
		editbtn1=new JButton(" Edit ");
		editbtn1.setBounds(0, 89, 214, 22);
		editbtn2=new JButton(" Save");
		editbtn2.setBounds(214, 89, 214, 22);
		deletebtn=new JButton("Delete");
		deletebtn.setBounds(0, 56, 214, 56);


		EnterBook.add(lbl_Add_ID);
		EnterBook.add(tf_Add_ID);
		EnterBook.add(lbl_Add_Title);
		EnterBook.add(tf_Add_Title);
		EnterBook.add(lbl_Add_Author);
		EnterBook.add(tf_Add_Author);
		EnterBook.add(lbl_Add_Qty);
		EnterBook.add(tf_Add_Qty);
		EnterBook.add(savebtn);
		EnterBook.add(resetbtn);

		UpdateBook.add(lbl_Edit_ID);
		UpdateBook.add(tf_Edit_ID);
		UpdateBook.add(lbl_Edit_Title);
		UpdateBook.add(tf_Edit_Title);
		UpdateBook.add(lbl_Edit_Author);
		UpdateBook.add(tf_Edit_Author);
		UpdateBook.add(lbl_Edit_Qty);
		UpdateBook.add(tf_Edit_Qty);
		UpdateBook.add(editbtn1);
		UpdateBook.add(editbtn2);

		EnterBook.setLayout(null);
		UpdateBook.setLayout(null);
		DeleteBook.setLayout(null);
		SearchBooks.setLayout(null);

		DeleteBook.add(lbl_Del_ID);
		DeleteBook.add(tf_Del_ID);
		DeleteBook.add(deletebtn);


		SearchBooks.add(lbl_Search_ID);
		SearchBooks.add(tf_Search_ID);
		SearchBooks.add(btnSearch);

		SearchTable = new JTable();
		SearchTable.setBounds(0, 34, 429, 78);
		SearchBooks.add(SearchTable);

		//The Reset button & code
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				tf_Add_ID.setText("");
				tf_Add_Title.setText("");
				tf_Add_Author.setText("");
				tf_Add_Qty.setText("");
			}
		});

		//The save button & code to save the data entered into the MySQL database
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				String value1=tf_Add_ID.getText();
				String value2=tf_Add_Title.getText();
				String value3=tf_Add_Author.getText();
				String value4=tf_Add_Qty.getText();
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/ebookstore_db";
				String driver = "com.mysql.jdbc.Driver";
				String user = "Hannes";
				String pass = "63542189";
				System.out.println(value1+value2+value3+value4);
				try{
					Class.forName(driver);
					con = DriverManager.getConnection(url, user, pass);
					PreparedStatement st=con.prepareStatement("insert into ebookstore (id,title,author,qty) values(?,?,?,?)");
					st.setString(1,value1);
					st.setString(2,value2);
					st.setString(3,value3);
					st.setString(4,value4);
					st.executeUpdate();
					JOptionPane.showMessageDialog(EnterBook,"Data is successfully inserted into database.");
					con.close();
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(EnterBook,"Error in submitting data!");
				}
			}
		});

		//Delete button & code to delete the records linked to the book ID entered
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){

				String value1	=tf_Del_ID.getText();
				Connection con 	= null;
				String url 		= "jdbc:mysql://localhost:3306/ebookstore_db";
				String driver	= "com.mysql.jdbc.Driver";
				String user 	= "Hannes";
				String pass 	= "63542189";
				try{
					Class.forName(driver);
					con = DriverManager.getConnection(url, user, pass);
					PreparedStatement st=con.prepareStatement("DELETE FROM ebookstore WHERE id = ?");
					st.setString(1,value1);
					st.executeUpdate();

					JOptionPane.showMessageDialog(DeleteBook,"Record is deleted successfully.");
					con.close();
				}
				catch(Exception exp3)
				{
					JOptionPane.showMessageDialog(DeleteBook,"Error in deleting record.");
				}
			}
		});

		//The edit button & code to edit records linked to the book ID entered
		editbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){

				String value=tf_Edit_ID.getText();
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/ebookstore_db";
				String driver = "com.mysql.jdbc.Driver";
				String user = "Hannes";
				String pass = "63542189";
				try{
					Class.forName(driver);
					con = DriverManager.getConnection(url, user, pass);
					PreparedStatement st=con.prepareStatement("select * from ebookstore where id=?");

					st.setString(1,value);
					ResultSet res=st.executeQuery();
					res.next();
					tf_Edit_ID.setText(Integer.toString(res.getInt(1)));
					tf_Edit_Title.setText(res.getString(2));
					tf_Edit_Author.setText(res.getString(3));
					tf_Edit_Qty.setText(Integer.toString(res.getInt(4)));
					con.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(UpdateBook,"Can not edit data");
				}
			}
		});
		//Button & code to confirm the edit of records linked to the book ID entered
		editbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/ebookstore_db";
				String driver = "com.mysql.jdbc.Driver";
				String user = "Hannes";
				String pass = "63542189";
				try
				{
					int x=JOptionPane.showConfirmDialog(UpdateBook,"Confirm edit? All data will be replaced");
					if(x==0){
						try{
							String value1=tf_Edit_ID.getText();
							String value2=tf_Edit_Title.getText();
							String value3=tf_Edit_Author.getText();
							String value4=tf_Edit_Qty.getText();

							Class.forName(driver);
							con = DriverManager.getConnection(url, user, pass);;
							Statement st=con.createStatement();
							st.executeUpdate("update ebookstore set title='"+value2+"', author='"+value3+"', qty='"+value4+"' where id='"+value1+"'");
							JOptionPane.showMessageDialog(UpdateBook,"Updated successfully");
							con.close();
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(UpdateBook,"Error in updating edit fields");
						}
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(UpdateBook,"Error");
				}
			}
		}
				);

		//The search button & code to search for records linked to the book ID entered
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnSearch = (JButton)ae.getSource();
				System.out.println("Showing Table Data.....");
				showTableData();
			}
			public void showTableData()	{
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/ebookstore_db";
				String driver = "com.mysql.jdbc.Driver";
				String user = "Hannes";
				String pass = "63542189";
				String[] columnNames = {"id", "title", "author", "qty"};
				f = new JFrame("Database Search Result");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.getContentPane().setLayout(new BorderLayout());		
				//TableModel tm = new TableModel();
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnIdentifiers(columnNames);
				//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());		
				//table = new JTable(model);
				SearchTable = new JTable();
				SearchTable.setModel(model);		
				SearchTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				SearchTable.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(SearchTable);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
				String textvalue = tf_Search_ID.getText();
				String id= "";
				String title= "";
				String author = "";
				String qty = "";

				try
				{			
					Class.forName(driver);		
					con = DriverManager.getConnection(url, user, pass);

					PreparedStatement st=con.prepareStatement("select * from ebookstore WHERE id = ?");
					st.setString(1,textvalue);
					//st.executeUpdate();

					ResultSet rs = st.executeQuery();
					int i =0;
					if(rs.next())
					{
						id = rs.getString("id");
						title = rs.getString("title");
						author = rs.getString("author");
						qty = rs.getString("qty");					
						model.addRow(new Object[]{id, title, author, qty});
						i++;				
					}
					if(i <1)
					{
						JOptionPane.showMessageDialog(null, "No Record Found","Error", JOptionPane.ERROR_MESSAGE);
					}
					if(i ==1)
					{
						System.out.println(i+" Record Found");
					}
					else
					{
						System.out.println(i+" Records Found");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
				f.getContentPane().add(scroll);
				f.setVisible(true);
				f.setSize(400,300);	

			}
		});
	};	

	//Add the tabs to the frame for the GUI
	void dis()
	{
		f.getContentPane().add(tp);
		tp.addTab("Add Record",EnterBook);
		tp.addTab("Edit Record",UpdateBook);
		tp.addTab("Delete Record",DeleteBook);
		tp.addTab("Search Records",SearchBooks);

		f.setSize(450,179);
		f.setVisible(true);
		f.setResizable(true);


	}

	public static void main(String z[]){
		Ebookstore pro=new Ebookstore();
		pro.dis();

	}
}