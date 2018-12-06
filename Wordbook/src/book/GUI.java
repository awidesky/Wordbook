package book;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	private JPanel SourcePanel, OptionPanel, SavePanel, LaunchPanel;
	private JButton btn_kor, btn_eng, btn_launch, btn_save_kor, btn_save_eng;
	private JLabel tlb_kor, tlb_eng, tlb_save_kor, tlb_save_eng, tlb_state;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	private JFileChooser jfc;
	private File input_kor, input_eng;
	
	public GUI() {
		
		setTitle("���� ���ܾ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setLayout(new GridLayout(4, 1));
		setResizable(false);
		
		jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
	    jfc.addChoosableFileFilter(new FileNameExtensionFilter("txt ����", "txt"));
		
		SourcePanel = new JPanel(); 
		OptionPanel = new JPanel();
		LaunchPanel = new JPanel(); 
		SavePanel = new JPanel();
		
		SourcePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		OptionPanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		LaunchPanel.setLayout(new FlowLayout());
		SavePanel.setLayout(new FlowLayout(NORMAL, 10, 15));
		
		btn_kor = new JButton("ã�ƺ���");
		btn_eng = new JButton("ã�ƺ���");
		btn_launch = new JButton("�ܾ��� ����!");
		btn_save_kor = new JButton("ã�ƺ���");
		btn_save_eng = new JButton("ã�ƺ���");
		btn_kor.setPreferredSize(new Dimension(100, 30));
		btn_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setPreferredSize(new Dimension(130, 30));
		btn_save_kor.setPreferredSize(new Dimension(100, 30));
		btn_save_eng.setPreferredSize(new Dimension(100, 30));
		btn_launch.setBackground(Color.ORANGE);
		
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
		tlb_save_kor = new JLabel("�ѱ� �ܾ��� ������...");
		tlb_save_eng = new JLabel("���� �ܾ��� ������...");
		tlb_state = new JLabel();
		tlb_kor.setPreferredSize(new Dimension(360, 30));
		tlb_eng.setPreferredSize(new Dimension(360, 30));
		tlb_save_kor.setPreferredSize(new Dimension(360, 30));
		tlb_save_eng.setPreferredSize(new Dimension(360, 30));
		
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
			
			while (true)
				
				tlb_state.setText(Wordbook.state);
			
		}).run();
		
	}

	public static void main(String[] args) {

		new GUI();
	}

}
