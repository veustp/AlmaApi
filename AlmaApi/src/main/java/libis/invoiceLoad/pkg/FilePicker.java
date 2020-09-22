package libis.invoiceLoad.pkg;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FilePicker extends JFrame implements ActionListener {
	private static final String NEWLINE = "\n";
	private static final long serialVersionUID = 1L;
	private JButton b1;
	private JButton b2;
	private JButton bGo;
	private JButton bExit;
	private JLabel l1;
	private JLabel l2;
	private JFileChooser fc1;
	private JFileChooser fc2;
	private File f1;
	private File f2;
	
	public FilePicker() {
		fc1 = new JFileChooser();
		fc2 = new JFileChooser();
		this.setFileChooserOptions(fc1);
		this.setFileChooserOptions(fc2);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		JPanel pa1 = new JPanel();
		pa1.setLayout(new GridLayout(2,2));
		l1 = new JLabel("Choose File m");
		l2 = new JLabel("Choose File f");
		b1 = new JButton("File 1");
		b1.addActionListener(this);
		b2 = new JButton("File 2");
		b2.addActionListener(this);
		pa1.add(l1);
		pa1.add(b1);
		pa1.add(l2);
		pa1.add(b2);
		this.add(pa1,BorderLayout.CENTER);
		
		JPanel pa2 = new JPanel();
		pa2.setLayout(new BorderLayout());
		bGo = new JButton("Go");
		bGo.addActionListener(this);
		bExit = new JButton("Exit");
		bExit.addActionListener(this);
		pa2.add(bGo,BorderLayout.WEST);
		pa2.add(bExit,BorderLayout.EAST);
		this.add(pa2,BorderLayout.SOUTH);
				
		this.pack();
		this.setVisible(true);
	}
	private void setFileChooserOptions (JFileChooser fc) {
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    FileNameExtensionFilter filtExts = new FileNameExtensionFilter("Excel File", "xlsx", "XLSX");
	    fc.addChoosableFileFilter(filtExts);
	    fc.setFileFilter(filtExts);	
	    fc.setCurrentDirectory(new File("C:\\temp\\sapinvoices"));
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			//
			int returnVal = this.fc1.showOpenDialog(FilePicker.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            this.f1 = this.fc1.getSelectedFile();
	            //System.out.println("File1 Chosen = "+file.getName());
	            //This is where a real application would open the file.
			    this.l1.setText(this.f1.getName());       
	        } else {
	            System.out.println("Open command cancelled by user." + NEWLINE);
	        }
		} else if (ae.getSource() == b2) {
			//
			int returnVal = this.fc2.showOpenDialog(FilePicker.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            this.f2 = this.fc2.getSelectedFile();
	            System.out.println("File2 Chosen = "+this.f2.getName());
	            //This is where a real application would open the file.
	            this.l2.setText(this.f2.getName());
	        } else {
	            System.out.println("Open command cancelled by user." + NEWLINE);
	        }
			
		} else if (ae.getSource() == bGo) {
			try {
				@SuppressWarnings("unused")
				HandleFiles hFiles = new HandleFiles(this.f1,this.f2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (ae.getSource() == bExit) {
			//
			System.exit(0);
		}
	}

	
	/*	FileChooser fileChooser = new FileChooser();
	 fileChooser.setTitle("Open Resource File");
	 fileChooser.getExtensionFilters().addAll(
	         new ExtensionFilter("Text Files", "*.txt"),
	         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
	         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
	         new ExtensionFilter("All Files", "*.*"));
	 File selectedFile = fileChooser.showOpenDialog(mainStage);
	 if (selectedFile != null) {
	    mainStage.display(selectedFile);
	 }
*/
}
