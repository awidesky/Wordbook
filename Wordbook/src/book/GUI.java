package book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	private JPanel SourcePanel, OptionPanel, SavePanel, LaunchPanel;
	private JButton btn_kor, btn_eng, btn_launch, btn_save;
	private JLabel tlb_kor, tlb_eng, tlb_save;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	private JFileChooser jfc, jfcs;
	private File input_kor, input_eng, output_path;
	
	public GUI() {
		
		setTitle("랜덤 영단어장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setLayout(new GridLayout(4, 1));
		setResizable(false);
		

		jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
		FileNameExtensionFilter ff = new FileNameExtensionFilter("txt 파일", "txt");
	    jfc.setFileFilter(ff);
	    
	    jfcs = new JFileChooser();
		jfcs.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
		jfcs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		SourcePanel = new JPanel(); 
		OptionPanel = new JPanel();
		LaunchPanel = new JPanel(); 
		SavePanel = new JPanel();
		
		SourcePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		OptionPanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		LaunchPanel.setLayout(new FlowLayout());
		SavePanel.setLayout(new FlowLayout(NORMAL, 5, 15));
		
		btn_kor = new JButton("찾아보기");
		btn_eng = new JButton("찾아보기");
		btn_launch = new JButton("단어장 제작!");
		btn_save = new JButton("찾아보기");
		
		btn_kor.setPreferredSize(new Dimension(100, 30));
		btn_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(130, 30));
		btn_save.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(150, 60));
		btn_launch.setBackground(new Color(0xff00ff));	//set color to hot pink
		
		btn_kor.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_kor.setText("한글 단어 : " + jfc.getSelectedFile().getAbsolutePath());
			input_kor = jfc.getSelectedFile();
			
		});
		
		
		btn_eng.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_eng.setText("영어 단어 : " + jfc.getSelectedFile().getAbsolutePath());
			input_eng = jfc.getSelectedFile();
			
		});
		
		
		btn_save.addActionListener((e) -> {
			
			if (jfcs.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다!","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_save.setText("단어장 저장경로 : " + jfcs.getSelectedFile().getAbsolutePath());
			output_path = jfcs.getSelectedFile();
			
		});
		
		btn_launch.addActionListener((e) -> {
			
			if (tlb_kor.getText().equals("한글 단어 : ")) {
				
				JOptionPane.showMessageDialog(null, "한글 단어 파일의 경로를 입력하지 않았습니다!" ,"경고",JOptionPane.WARNING_MESSAGE);
				
				return;
				
			}  else if (tlb_eng.getText().equals("영어 단어 : ")) {
				
				JOptionPane.showMessageDialog(null, "영어 단어 파일의 경로를 입력하지 않았습니다!" ,"경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			} else if (!cbx_eng.isSelected() && !cbx_kor.isSelected() && !cbx_ran.isSelected()) {
				
				JOptionPane.showMessageDialog(null, "제작할 단어장이 정해져 있지 않습니다!" ,"경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			} else if (tlb_save.getText().equals("단어장 저장경로 : ")) {
				
				JOptionPane.showMessageDialog(null, "단어장의 저장경로를 입력하지 않았습니다!" ,"경고",JOptionPane.WARNING_MESSAGE); 
				return;
				
			} 
			
			Object[] obj = {input_eng, input_kor, output_path, cbx_eng.isSelected(), cbx_kor.isSelected(), cbx_ran.isSelected()};
			
			Thread worker = new Thread(() -> {
				
				try {
					
					Wordbook.launch(obj);
					
				} catch (Exception e1) {
					
					System.err.println(e1.getMessage());
					
				}
				
			});
			
			worker.setDaemon(true);
			worker.start();
			
		});
		
		tlb_kor = new JLabel("한글 단어 : ");
		tlb_eng = new JLabel("영어 단어 : ");
		tlb_save = new JLabel("단어장 저장경로 : ");
		
		tlb_kor.setPreferredSize(new Dimension(360, 30));
		tlb_eng.setPreferredSize(new Dimension(360, 30));
		tlb_save.setPreferredSize(new Dimension(360, 30));
		
		cbx_kor = new JCheckBox("한글 단어장 생성");
		cbx_eng = new JCheckBox("영어 단어장 생성");
		cbx_ran = new JCheckBox("한글&영어 랜덤 영어장 생성");
		
		SourcePanel.add(tlb_kor);
		SourcePanel.add(btn_kor);
		SourcePanel.add(tlb_eng);
		SourcePanel.add(btn_eng);
		
		OptionPanel.add(cbx_kor);
		OptionPanel.add(cbx_eng);
		OptionPanel.add(cbx_ran);
		
		LaunchPanel.add(btn_launch, BorderLayout.CENTER);
		
		SavePanel.add(tlb_save);
		SavePanel.add(btn_save);
		
		add(SourcePanel);
		add(OptionPanel);
		add(SavePanel);
		add(LaunchPanel);
		
		setVisible(true);
		
	} //constructor end
	
	
}
