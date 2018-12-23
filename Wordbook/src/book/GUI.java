package book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	private JPanel SourcePanel, OptionPanel, SavePanel, LaunchPanel;
	private JButton btn_kor, btn_eng, btn_launch, btn_save_kor, btn_save_eng;
	private JLabel tlb_kor, tlb_eng, tlb_save_kor, tlb_save_eng, tlb_state;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	private JFileChooser jfc;
	private File input_kor, input_eng;
	
	public GUI() {
		
		setTitle("랜덤 영단어장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,470);
		setLayout(new GridLayout(4, 1));
		setResizable(false);
		
		jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
	    jfc.addChoosableFileFilter(new FileNameExtensionFilter("txt 파일", "txt"));
		
		SourcePanel = new JPanel(); 
		OptionPanel = new JPanel();
		LaunchPanel = new JPanel(); 
		SavePanel = new JPanel();
		
		SourcePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		OptionPanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		LaunchPanel.setLayout(new FlowLayout());
		SavePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		
		btn_kor = new JButton("찾아보기");
		btn_eng = new JButton("찾아보기");
		btn_launch = new JButton("단어장 제작!");
		btn_save_kor = new JButton("찾아보기");
		btn_save_eng = new JButton("찾아보기");
		btn_kor.setPreferredSize(new Dimension(100, 30));
		btn_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(130, 30));
		btn_save_kor.setPreferredSize(new Dimension(100, 30));
		btn_save_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setBackground(Color.ORANGE);
		
		btn_kor.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_kor.setText(tlb_kor.getText() + jfc.getSelectedFile().getAbsolutePath());
			input_kor = jfc.getSelectedFile();
			
		});
		
		btn_eng.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_eng.setText(tlb_eng.getText() + jfc.getSelectedFile().getAbsolutePath());
			input_eng = jfc.getSelectedFile();
			
		});
		
		btn_launch.addActionListener((e) -> {
			
			if (tlb_eng.getText().equals("영어 단어 : ")) {
				
				Wordbook.state = "영어 단어 파일의 경로를 입력하지 않았습니다!";
				return;
				
			} else if (tlb_eng.getText().equals("한글 단어 : ")) {
				
				Wordbook.state = "한글 단어 파일의 경로를 입력하지 않았습니다!";
				return;
				
			} else if (!cbx_eng.isSelected() && !cbx_kor.isSelected() && !cbx_ran.isSelected()) {
				
				Wordbook.state = "제작할 단어장이 정해져 있지 않습니다!";
				return;
				
			} 
			
			
			Object[] obj = {input_eng, input_kor, cbx_eng.isSelected(), cbx_kor.isSelected(), cbx_ran.isSelected()};
			Wordbook.launch(obj);
			
		});
		
		tlb_kor = new JLabel("한글 단어 : ");
		tlb_eng = new JLabel("영어 단어 : ");
		tlb_save_kor = new JLabel("한글 단어장 저장경로...");
		tlb_save_eng = new JLabel("영어 단어장 저장경로...");
		tlb_state = new JLabel("");
		tlb_kor.setPreferredSize(new Dimension(360, 30));
		tlb_eng.setPreferredSize(new Dimension(360, 30));
		tlb_save_kor.setPreferredSize(new Dimension(360, 30));
		tlb_save_eng.setPreferredSize(new Dimension(360, 30));
		tlb_state.setPreferredSize(new Dimension(500, 30));
		
		tlb_state.setHorizontalAlignment(JLabel.CENTER);
		tlb_state.setFont(new Font(tlb_state.getFont().getFontName(), Font.ITALIC, tlb_state.getFont().getSize() + 10));
		
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
		LaunchPanel.add(tlb_state, BorderLayout.CENTER);
		
		SavePanel.add(tlb_save_kor);
		SavePanel.add(btn_save_kor);
		SavePanel.add(tlb_save_eng);
		SavePanel.add(btn_save_eng);
		
		add(SourcePanel);
		add(OptionPanel);
		add(SavePanel);
		add(LaunchPanel);
		
		setVisible(true);
		
		new Thread(() -> {
			
			while (true) {
				tlb_state.setText(Wordbook.state);
			}
		}).run();
		
	}

	public static void main(String[] args) {

		new GUI();
	}

}
