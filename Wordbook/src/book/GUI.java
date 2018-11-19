package book;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener{
	
	private JPanel SourcePanel, OptionPanel, LaunchPanel;
	private JButton btn_kor, btn_eng, btn_launch;
	private JTextField tfd_kor, tfd_eng;
	private JCheckBox cbx_kor, cbx_eng, cbx_ran;
	
	
	public GUI() {
		
		setTitle("���� ���ܾ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(335,330);
		setLayout(new GridLayout(3, 1));
		setResizable(false);
		
		SourcePanel = new JPanel(); //new GridLayout(2, 2, 5, 15)
		OptionPanel = new JPanel();
		LaunchPanel = new JPanel(); //new BorderLayout()
		
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
			
			
			
		});
		
		tfd_kor = new JTextField();
		tfd_eng = new JTextField();
		tfd_kor.setPreferredSize(new Dimension(190, 30));
		tfd_eng.setPreferredSize(new Dimension(190, 30));
		
		cbx_kor = new JCheckBox("�ѱ� �ܾ��� ����");
		cbx_eng = new JCheckBox("���� �ܾ��� ����");
		cbx_ran = new JCheckBox("�ѱ�&���� ���� ������ ����");
		
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
