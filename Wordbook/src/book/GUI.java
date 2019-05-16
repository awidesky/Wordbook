   package book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	private JLabel tlb_kor, tlb_eng, tlb_save, tlb_state;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	private JFileChooser jfc, jfcs;
	private File input_kor, input_eng, output_path;
	
	public GUI() {
		
		setTitle("���� ���ܾ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setLayout(new GridLayout(4, 1));
		setResizable(false);
		

		jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
		FileNameExtensionFilter ff = new FileNameExtensionFilter("txt ����", "txt");
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
		
		btn_kor = new JButton("ã�ƺ���");
		btn_eng = new JButton("ã�ƺ���");
		btn_launch = new JButton("�ܾ��� ����!");
		btn_save = new JButton("ã�ƺ���");
		
		btn_kor.setPreferredSize(new Dimension(100, 30));
		btn_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(130, 30));
		btn_save.setPreferredSize(new Dimension(100, 30));
		btn_launch.setBackground(Color.ORANGE);
		
		btn_kor.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�!","���",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_kor.setText(tlb_kor.getText() + jfc.getSelectedFile().getAbsolutePath());
			input_kor = jfc.getSelectedFile();
			
		});
		
		
		btn_eng.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�!","���",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_eng.setText(tlb_eng.getText() + jfc.getSelectedFile().getAbsolutePath());
			input_eng = jfc.getSelectedFile();
			
		});
		
		
		btn_save.addActionListener((e) -> {
			
			if (jfcs.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�!","���",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_save.setText(tlb_save.getText() + jfcs.getSelectedFile().getAbsolutePath());
			output_path = jfcs.getSelectedFile();
			
		});
		
		btn_launch.addActionListener((e) -> {
			
			if (tlb_kor.getText().equals("�ѱ� �ܾ� : ")) {
				
				Wordbook.state = "�ѱ� �ܾ� ������ ��θ� �Է����� �ʾҽ��ϴ�!";
				return;
				
			}  else if (tlb_eng.getText().equals("���� �ܾ� : ")) {
				
				Wordbook.state = "���� �ܾ� ������ ��θ� �Է����� �ʾҽ��ϴ�!";
				return;
				
			} else if (!cbx_eng.isSelected() && !cbx_kor.isSelected() && !cbx_ran.isSelected()) {
				
				Wordbook.state = "������ �ܾ����� ������ ���� �ʽ��ϴ�!";
				return;
				
			} else if (tlb_save.getText().equals("�ܾ��� ������... : ")) {
				
				Wordbook.state = "�ܾ����� �����θ� �Է����� �ʾҽ��ϴ�!";
				return;
				
			} 
			
			Object[] obj = {input_eng, input_kor, output_path, cbx_eng.isSelected(), cbx_kor.isSelected(), cbx_ran.isSelected()};
			Wordbook.launch(obj);
			
		});
		
		tlb_kor = new JLabel("�ѱ� �ܾ� : ");
		tlb_eng = new JLabel("���� �ܾ� : ");
		tlb_save = new JLabel("�ܾ��� ������ : ");
		tlb_state = new JLabel("");
		
		tlb_kor.setPreferredSize(new Dimension(360, 30));
		tlb_eng.setPreferredSize(new Dimension(360, 30));
		tlb_save.setPreferredSize(new Dimension(360, 30));
		tlb_state.setPreferredSize(new Dimension(500, 30));
		
		tlb_state.setHorizontalAlignment(JLabel.CENTER);
		tlb_state.setFont(new Font(tlb_state.getFont().getFontName(), Font.ITALIC, tlb_state.getFont().getSize() + 10));
		
		cbx_kor = new JCheckBox("�ѱ� �ܾ��� ����");
		cbx_eng = new JCheckBox("���� �ܾ��� ����");
		cbx_ran = new JCheckBox("�ѱ�&���� ���� ������ ����");
		
		SourcePanel.add(tlb_kor);
		SourcePanel.add(btn_kor);
		SourcePanel.add(tlb_eng);
		SourcePanel.add(btn_eng);
		
		OptionPanel.add(cbx_kor);
		OptionPanel.add(cbx_eng);
		OptionPanel.add(cbx_ran);
		
		LaunchPanel.add(btn_launch, BorderLayout.CENTER);
		LaunchPanel.add(tlb_state, BorderLayout.CENTER);
		
		SavePanel.add(tlb_save);
		SavePanel.add(btn_save);
		
		add(SourcePanel);
		add(OptionPanel);
		add(SavePanel);
		add(LaunchPanel);
		
		setVisible(true);
		
		Thread setstate = new Thread(() -> {
			
			while (true) {
				
				tlb_state.setText(Wordbook.state);
				
			}
			
		});
		
		setstate.setDaemon(true);
		setstate.start();
		
	} //constructor end
	
	
}
