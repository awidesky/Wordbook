package book;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	
	private JPanel SourcePanel, OptionPanel, LaunchPanel;
	private JButton btn_kor, btn_eng, btn_launch;
	private JLabel tlb_kor, tlb_eng;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	private JFileChooser jfc;
	private File input_kor, input_eng;
	
	public GUI() {
		
		setTitle("���� ���ܾ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,330);
		setLayout(new GridLayout(3, 1));
		setResizable(false);
		
		jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
	    jfc.addChoosableFileFilter(new FileNameExtensionFilter("txt ����", "txt"));
		
		SourcePanel = new JPanel(); 
		OptionPanel = new JPanel();
		LaunchPanel = new JPanel(); 
		
		SourcePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		OptionPanel.setLayout(new FlowLayout());
		LaunchPanel.setLayout(new FlowLayout());
		
		btn_kor = new JButton("ã�ƺ���");
		btn_eng = new JButton("ã�ƺ���");
		btn_launch = new JButton("�ܾ��� ����!");
		
		btn_kor.setPreferredSize(new Dimension(100, 30));
		btn_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(130, 30));
		
		btn_kor.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_kor.setText(tlb_kor.getText() + jfc.getSelectedFile().getAbsolutePath());
			input_kor = jfc.getSelectedFile();
			
		});
		btn_eng.addActionListener((e) -> {
			
			if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.","���",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			tlb_eng.setText(tlb_eng.getText() + jfc.getSelectedFile().getAbsolutePath());
			input_eng = jfc.getSelectedFile();
			
		});
		btn_launch.addActionListener((e) -> {
			
			Object[] obj = {input_eng, input_kor, cbx_eng.isSelected(), cbx_kor.isSelected(), cbx_ran.isSelected()};
			Wordbook.launch(obj);
			
		});
		
		tlb_kor = new JLabel("�ѱ� �ܾ� : ");
		tlb_eng = new JLabel("���� �ܾ� : ");
		tlb_kor.setPreferredSize(new Dimension(360, 30));
		tlb_eng.setPreferredSize(new Dimension(360, 30));
		
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
		
		add(SourcePanel);
		add(OptionPanel);
		add(LaunchPanel);
		
		setVisible(true);
	}
	
	
	

	public static void main(String[] args) {

		new GUI();
	}

}
