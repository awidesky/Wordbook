package book;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	
	private JPanel SourcePanel, OptionPanel, LaunchPanel;
	private JButton btn_kor, btn_eng, btn_launch;
	private JTextField tfd_kor, tfd_eng;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	private JFileChooser jfc;
	private File input_kor, input_eng;
	
	public GUI() {
		
		setTitle("랜덤 영단어장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(335,330);
		setLayout(new GridLayout(3, 1));
		setResizable(false);
		
		jfc = new JFileChooser();
		
		SourcePanel = new JPanel(); 
		OptionPanel = new JPanel();
		LaunchPanel = new JPanel(); 
		
		SourcePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		OptionPanel.setLayout(new FlowLayout());
		LaunchPanel.setLayout(new FlowLayout());
		
		btn_kor = new JButton("찾아보기");
		btn_eng = new JButton("찾아보기");
		btn_launch = new JButton("단어장 제작!");
		
		btn_kor.setPreferredSize(new Dimension(100, 30));
		btn_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(130, 30));
		
		btn_kor.addActionListener((e) -> {
			
		    jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
	        jfc.addChoosableFileFilter(new FileNameExtensionFilter("txt 파일", "txt"));
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			input_kor = jfc.getSelectedFile();
			
		});
		btn_eng.addActionListener((e) -> {
			
		    jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
	        jfc.addChoosableFileFilter(new FileNameExtensionFilter("txt 파일", "txt"));
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			input_kor = jfc.getSelectedFile();
			
		});
		
		tfd_kor = new JTextField();
		tfd_eng = new JTextField();
		tfd_kor.setPreferredSize(new Dimension(190, 30));
		tfd_eng.setPreferredSize(new Dimension(190, 30));
		
		cbx_kor = new JCheckBox("한글 단어장 생성");
		cbx_eng = new JCheckBox("영어 단어장 생성");
		cbx_ran = new JCheckBox("한글&영어 랜덤 영어장 생성");
		
		SourcePanel.add(tfd_kor);
		SourcePanel.add(btn_kor);
		SourcePanel.add(tfd_eng);
		SourcePanel.add(btn_eng);
		
		OptionPanel.add(cbx_kor);
		OptionPanel.add(cbx_eng);
		OptionPanel.add(cbx_ran);
		
		LaunchPanel.add(btn_launch, BorderLayout.CENTER);
		
		add(SourcePanel);
		add(OptionPanel);
		add(LaunchPanel);
		
		setVisible(true);
	}
	
	
	

	public static void main(String[] args) {

		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
