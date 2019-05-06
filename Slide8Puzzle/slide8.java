import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.util.*;

public class slide8 {

	private JFrame frmpuzzleSolveIt;
	private JTextField in_node;

	private CheckAnswer chk = new CheckAnswer();
	private Compare cmpr = new Compare();
	private SwapLaw sw = new SwapLaw();

	private int node = 1000;
	Mem[] mem = new Mem[0];

	private int[] nxt = new int[1000];
	private int far;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					slide8 window = new slide8();
					window.frmpuzzleSolveIt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public slide8() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmpuzzleSolveIt = new JFrame();
		frmpuzzleSolveIt.setTitle("8 Slide Puzzle");
		frmpuzzleSolveIt.setBounds(100, 100, 740, 465);
		frmpuzzleSolveIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmpuzzleSolveIt.getContentPane().setLayout(null);

		JButton btn_0 = new JButton("");
		JButton btn_1 = new JButton("1");
		JButton btn_2 = new JButton("2");
		JButton btn_3 = new JButton("3");
		JButton btn_4 = new JButton("4");
		JButton btn_5 = new JButton("5");
		JButton btn_6 = new JButton("6");
		JButton btn_7 = new JButton("7");
		JButton btn_8 = new JButton("8");
		JButton btn_reset = new JButton("Reset");
		JLabel finish_dis = new JLabel("");
		JButton btn_roll = new JButton("Solve");
		JRadioButton dot_astar = new JRadioButton("A*");
		JRadioButton dot_bfs = new JRadioButton("BFS");
		Timer timer = new Timer();

		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String temp = btn_0.getText();

				if (btn_1.getText().equals("")) {
					btn_0.setText(btn_1.getText());
					btn_1.setText(temp);
				} else if (btn_3.getText().equals("")) {
					btn_0.setText(btn_3.getText());
					btn_3.setText(temp);
				}
			}
		});
		btn_0.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_0.setBounds(12, 13, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_0);

		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = btn_1.getText();

				if (btn_0.getText().equals("")) {
					btn_1.setText(btn_0.getText());
					btn_0.setText(temp);
				} else if (btn_2.getText().equals("")) {
					btn_1.setText(btn_2.getText());
					btn_2.setText(temp);
				} else if (btn_4.getText().equals("")) {
					btn_1.setText(btn_4.getText());
					btn_4.setText(temp);
				}
			}
		});
		btn_1.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_1.setBounds(124, 13, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_1);

		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String temp = btn_2.getText();

				if (btn_1.getText().equals("")) {
					btn_2.setText(btn_1.getText());
					btn_1.setText(temp);
				} else if (btn_5.getText().equals("")) {
					btn_2.setText(btn_5.getText());
					btn_5.setText(temp);
				}
			}
		});
		btn_2.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_2.setBounds(236, 13, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_2);

		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = btn_3.getText();

				if (btn_0.getText().equals("")) {
					btn_3.setText(btn_0.getText());
					btn_0.setText(temp);
				} else if (btn_6.getText().equals("")) {
					btn_3.setText(btn_6.getText());
					btn_6.setText(temp);
				} else if (btn_4.getText().equals("")) {
					btn_3.setText(btn_4.getText());
					btn_4.setText(temp);
				}
			}
		});
		btn_3.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_3.setBounds(12, 126, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_3);

		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = btn_4.getText();

				if (btn_1.getText().equals("")) {
					btn_4.setText(btn_1.getText());
					btn_1.setText(temp);
				} else if (btn_3.getText().equals("")) {
					btn_4.setText(btn_3.getText());
					btn_3.setText(temp);
				} else if (btn_5.getText().equals("")) {
					btn_4.setText(btn_5.getText());
					btn_5.setText(temp);
				} else if (btn_7.getText().equals("")) {
					btn_4.setText(btn_7.getText());
					btn_7.setText(temp);
				}
			}
		});
		btn_4.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_4.setBounds(124, 126, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_4);

		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = btn_5.getText();

				if (btn_8.getText().equals("")) {
					btn_5.setText(btn_8.getText());
					btn_8.setText(temp);
				} else if (btn_2.getText().equals("")) {
					btn_5.setText(btn_2.getText());
					btn_2.setText(temp);
				} else if (btn_4.getText().equals("")) {
					btn_5.setText(btn_4.getText());
					btn_4.setText(temp);
				}
			}
		});
		btn_5.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_5.setBounds(236, 126, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_5);

		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = btn_6.getText();

				if (btn_3.getText().equals("")) {
					btn_6.setText(btn_3.getText());
					btn_3.setText(temp);
				} else if (btn_7.getText().equals("")) {
					btn_6.setText(btn_7.getText());
					btn_7.setText(temp);
				}
			}
		});
		btn_6.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_6.setBounds(12, 239, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_6);

		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String temp = btn_7.getText();

				if (btn_8.getText().equals("")) {
					btn_7.setText(btn_8.getText());
					btn_8.setText(temp);
				} else if (btn_6.getText().equals("")) {
					btn_7.setText(btn_6.getText());
					btn_6.setText(temp);
				} else if (btn_4.getText().equals("")) {
					btn_7.setText(btn_4.getText());
					btn_4.setText(temp);
				}
			}
		});
		btn_7.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_7.setBounds(124, 239, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_7);

		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = btn_8.getText();

				if (btn_5.getText().equals("")) {
					btn_8.setText(btn_5.getText());
					btn_5.setText(temp);
				} else if (btn_7.getText().equals("")) {
					btn_8.setText(btn_7.getText());
					btn_7.setText(temp);
				}
			}
		});
		btn_8.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_8.setBounds(236, 239, 100, 100);
		frmpuzzleSolveIt.getContentPane().add(btn_8);

		JLabel lblMaxNodes = new JLabel("Max Nodes");
		lblMaxNodes.setForeground(Color.RED);
		lblMaxNodes.setFont(new Font("Rockwell", Font.PLAIN, 25));
		lblMaxNodes.setBounds(348, 13, 182, 50);
		frmpuzzleSolveIt.getContentPane().add(lblMaxNodes);

		in_node = new JTextField();
		in_node.setFont(new Font("Rockwell", Font.PLAIN, 25));
		in_node.setForeground(Color.RED);
		in_node.setText("1000");
		in_node.setHorizontalAlignment(SwingConstants.RIGHT);
		in_node.setBounds(348, 63, 182, 50);
		frmpuzzleSolveIt.getContentPane().add(in_node);
		in_node.setColumns(10);

		JLabel lblSpreadedNodes = new JLabel("Spreaded Nodes");
		lblSpreadedNodes.setForeground(Color.DARK_GRAY);
		lblSpreadedNodes.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblSpreadedNodes.setBounds(348, 126, 182, 50);
		frmpuzzleSolveIt.getContentPane().add(lblSpreadedNodes);

		JLabel sprd_node = new JLabel("0");
		sprd_node.setHorizontalAlignment(SwingConstants.RIGHT);
		sprd_node.setForeground(Color.DARK_GRAY);
		sprd_node.setFont(new Font("Rockwell", Font.PLAIN, 25));
		sprd_node.setBounds(348, 176, 182, 50);
		frmpuzzleSolveIt.getContentPane().add(sprd_node);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(542, 13, 182, 326);
		frmpuzzleSolveIt.getContentPane().add(scrollPane);

		JTextPane text_dis = new JTextPane();
		text_dis.setFont(new Font("Rockwell", Font.PLAIN, 25));
		text_dis.setText("test");
		text_dis.setEditable(false);
		text_dis.setText("");
		scrollPane.setViewportView(text_dis);

		dot_bfs.setSelected(true);
		dot_bfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dot_astar.setSelected(false);
			}
		});
		dot_bfs.setFont(new Font("Rockwell", Font.BOLD, 30));
		dot_bfs.setBounds(429, 239, 101, 48);
		// frmpuzzleSolveIt.getContentPane().add(dot_bfs);

		dot_astar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dot_bfs.setSelected(false);
			}
		});
		// dot_astar.setFont(new Font("Rockwell", Font.BOLD, 30));
		// dot_astar.setBounds(429, 292, 100, 47);
		// frmpuzzleSolveIt.getContentPane().add(dot_astar);

		// buttons for customizing the goal state

		JButton button = new JButton("");
		JButton button_1 = new JButton("1");
		JButton button_2 = new JButton("2");
		JButton button_3 = new JButton("3");
		JButton button_4 = new JButton("4");
		JButton button_5 = new JButton("5");
		JButton button_6 = new JButton("6");
		JButton button_7 = new JButton("7");
		JButton button_8 = new JButton("8");

		JButton abutton = new JButton("");
		JButton abutton_1 = new JButton("1");
		JButton abutton_2 = new JButton("2");
		JButton abutton_3 = new JButton("3");
		JButton abutton_4 = new JButton("4");
		JButton abutton_5 = new JButton("5");
		JButton abutton_6 = new JButton("6");
		JButton abutton_7 = new JButton("7");
		JButton abutton_8 = new JButton("8");

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String temp = button.getText();

				if (button_1.getText().equals("")) {
					button.setText(button_1.getText());
					button_1.setText(temp);
				} else if (button_3.getText().equals("")) {
					button.setText(button_3.getText());
					button_3.setText(temp);
				}
			}
		});
		button.setFont(new Font("Rockwell", Font.BOLD, 50));
		button.setBounds(736, 13, 100, 100);
		button.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button);

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = button_1.getText();

				if (button.getText().equals("")) {
					button_1.setText(button.getText());
					button.setText(temp);
				} else if (button_2.getText().equals("")) {
					button_1.setText(button_2.getText());
					button_2.setText(temp);
				} else if (button_4.getText().equals("")) {
					button_1.setText(button_4.getText());
					button_4.setText(temp);
				}
			}
		});
		button_1.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_1.setBounds(848, 13, 100, 100);
		button_1.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_1);

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String temp = button_2.getText();

				if (button_1.getText().equals("")) {
					button_2.setText(button_1.getText());
					button_1.setText(temp);
				} else if (button_5.getText().equals("")) {
					button_2.setText(button_5.getText());
					button_5.setText(temp);
				}
			}
		});
		button_2.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_2.setBounds(960, 13, 100, 100);
		button_2.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_2);

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = button_3.getText();

				if (button.getText().equals("")) {
					button_3.setText(button.getText());
					button.setText(temp);
				} else if (button_6.getText().equals("")) {
					button_3.setText(button_6.getText());
					button_6.setText(temp);
				} else if (button_4.getText().equals("")) {
					button_3.setText(button_4.getText());
					button_4.setText(temp);
				}
			}
		});
		button_3.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_3.setBounds(736, 126, 100, 100);
		button_3.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_3);

		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = button_4.getText();

				if (button_1.getText().equals("")) {
					button_4.setText(button_1.getText());
					button_1.setText(temp);
				} else if (button_3.getText().equals("")) {
					button_4.setText(button_3.getText());
					button_3.setText(temp);
				} else if (button_5.getText().equals("")) {
					button_4.setText(button_5.getText());
					button_5.setText(temp);
				} else if (button_7.getText().equals("")) {
					button_4.setText(button_7.getText());
					button_7.setText(temp);
				}
			}
		});
		button_4.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_4.setBounds(848, 126, 100, 100);
		button_4.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_4);

		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = button_5.getText();

				if (button_8.getText().equals("")) {
					button_5.setText(button_8.getText());
					button_8.setText(temp);
				} else if (button_2.getText().equals("")) {
					button_5.setText(button_2.getText());
					button_2.setText(temp);
				} else if (button_4.getText().equals("")) {
					button_5.setText(button_4.getText());
					button_4.setText(temp);
				}
			}
		});
		button_5.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_5.setBounds(960, 126, 100, 100);
		button_5.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_5);

		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = button_6.getText();

				if (button_3.getText().equals("")) {
					button_6.setText(button_3.getText());
					button_3.setText(temp);
				} else if (button_7.getText().equals("")) {
					button_6.setText(button_7.getText());
					button_7.setText(temp);
				}
			}
		});
		button_6.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_6.setBounds(736, 239, 100, 100);
		button_6.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_6);

		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String temp = button_7.getText();

				if (button_8.getText().equals("")) {
					button_7.setText(button_8.getText());
					button_8.setText(temp);
				} else if (button_6.getText().equals("")) {
					button_7.setText(button_6.getText());
					button_6.setText(temp);
				} else if (button_4.getText().equals("")) {
					button_7.setText(button_4.getText());
					button_4.setText(temp);
				}
			}
		});
		button_7.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_7.setBounds(848, 239, 100, 100);
		button_7.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_7);

		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = button_8.getText();

				if (button_5.getText().equals("")) {
					button_8.setText(button_5.getText());
					button_5.setText(temp);
				} else if (button_7.getText().equals("")) {
					button_8.setText(button_7.getText());
					button_7.setText(temp);
				}
			}
		});
		button_8.setFont(new Font("Rockwell", Font.BOLD, 50));
		button_8.setBounds(960, 239, 100, 100);
		button_8.setVisible(false);
		frmpuzzleSolveIt.getContentPane().add(button_8);

		JButton btn_start = new JButton("Start");// ----------------------------------------------------------------------------------------------------------START
		JButton btn_shuffle = new JButton("Shuffle");

		btn_shuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// random initial state
				ArrayList<String> mylist = new ArrayList<String>();
				mylist.add("");
				mylist.add("1");
				mylist.add("2");
				mylist.add("3");
				mylist.add("4");
				mylist.add("5");
				mylist.add("6");
				mylist.add("7");
				mylist.add("8");

				Collections.shuffle(mylist);

				btn_0.setText(mylist.get(0));
				btn_1.setText(mylist.get(1));
				btn_2.setText(mylist.get(2));
				btn_3.setText(mylist.get(3));
				btn_4.setText(mylist.get(4));
				btn_5.setText(mylist.get(5));
				btn_6.setText(mylist.get(6));
				btn_7.setText(mylist.get(7));
				btn_8.setText(mylist.get(8));

			}
		});

		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dot_bfs.setEnabled(false);
				dot_astar.setEnabled(false);

				far = 0;

				Scanner scan = new Scanner(System.in);

				try {
					node = Integer.valueOf((in_node.getText()));
				} catch (Exception e) {
					in_node.setText("1000");
				}
				if (node < 1000) {
					node = 1000;
					in_node.setText("1000");
				}

				mem = new Mem[node];

				String[] a_pre = { button.getText(), button_1.getText(), button_2.getText(), button_3.getText(),
						button_4.getText(), button_5.getText(), button_6.getText(), button_7.getText(),
						button_8.getText() };
				int[] answer = new int[a_pre.length];
				for (int i = 0; i < answer.length; i++) {
					if (a_pre[i].equals("")) {
						answer[i] = 0;
					} else
						answer[i] = Integer.valueOf(a_pre[i]);
				}

				String[] q_pre = { btn_0.getText(), btn_1.getText(), btn_2.getText(), btn_3.getText(), btn_4.getText(),
						btn_5.getText(), btn_6.getText(), btn_7.getText(), btn_8.getText() };
				int[] quest = new int[q_pre.length];
				for (int i = 0; i < quest.length; i++) {
					if (q_pre[i].equals("")) {
						quest[i] = 0;
					} else
						quest[i] = Integer.valueOf(q_pre[i]);
				}

				int lst_mem = 0;
				mem[lst_mem] = new Mem();
				mem[lst_mem].save(quest, 0);
				int to_sprd = lst_mem;

				while (!chk.isCorrect(answer, mem[to_sprd].getMem()) && lst_mem < node) {
					for (int j = 0; j < 4; j++)// ---------------------------------------------------------------------------------------------------------------Spread
					{
						int[] m_temp = new int[mem[to_sprd].getMem().length];
						for (int i = 0; i < m_temp.length; i++) {
							m_temp[i] = mem[to_sprd].getMem()[i];
						}
						int[] q_temp = sw.spread(m_temp, j);

						if (!cmpr.isSame(q_temp, mem, lst_mem)) {
							lst_mem++;
							try {
								mem[lst_mem] = new Mem();
								sprd_node.setText("" + (lst_mem + 1));
							} catch (Exception e) {
								System.out.println(e.toString());
								break;
							}
							mem[lst_mem].save(q_temp, to_sprd);
						}
					} // ------------------------------------------------------------------------------------------------------------------------------------------
					mem[to_sprd].setOld(true);

					if (dot_bfs.isSelected())
						to_sprd = chk.choosePath_BFS(answer, mem, lst_mem);
					else
						to_sprd = chk.choosePath_Astar(answer, mem, lst_mem);
				}

				dot_bfs.setEnabled(true);
				dot_astar.setEnabled(true);

				int c_node = to_sprd;
				int c = 0;
				String str = "";

				while (to_sprd != 0) {
					nxt[far] = to_sprd;

					str += "\n" + mem[to_sprd].toString() + "\n";
					to_sprd = mem[to_sprd].getCameFrom();

					far++;
				}
				str += "\n" + mem[0].toString() + "\n";

				if (chk.isCorrect(answer, mem[c_node].getMem())) {
					str += "\nCorrect at\nNode : " + c_node + "\n" + "Moves :" + far + "\n";
					finish_dis.setText("");
					finish_dis.setForeground(Color.green);

					timer.schedule(new TimerTask() {
						public void run() {
							btn_roll.doClick();
						}
					}, 500);

				} else {
					str += "\nFail\n";
					finish_dis.setText("");
					finish_dis.setForeground(Color.RED);
				}

				text_dis.setText(str);

				btn_roll.setEnabled(true);

			}
		});

		Color myColor = new Color(66, 244, 78);
		btn_start.setForeground(myColor);
		btn_start.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_start.setBounds(348, 352, 182, 69);
		frmpuzzleSolveIt.getContentPane().add(btn_start);

		btn_shuffle.setForeground(Color.DARK_GRAY);
		btn_shuffle.setFont(new Font("Rockwell", Font.BOLD, 40));
		btn_shuffle.setBounds(13, 352, 323, 69);
		frmpuzzleSolveIt.getContentPane().add(btn_shuffle);

		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				far = 0;
				node = 1000;
				in_node.setText("1000");
				sprd_node.setText("0");

				text_dis.setText("");

				btn_0.setText("");
				btn_1.setText("1");
				btn_2.setText("2");
				btn_3.setText("3");
				btn_4.setText("4");
				btn_5.setText("5");
				btn_6.setText("6");
				btn_7.setText("7");
				btn_8.setText("8");
			}
		});
		btn_reset.setForeground(Color.RED);
		btn_reset.setFont(new Font("Rockwell", Font.BOLD, 45));
		btn_reset.setBounds(545, 352, 175, 69);
		frmpuzzleSolveIt.getContentPane().add(btn_reset);

		finish_dis.setFont(new Font("Rockwell", Font.BOLD, 40));
		finish_dis.setHorizontalAlignment(SwingConstants.CENTER);
		finish_dis.setBounds(12, 352, 324, 69);
		frmpuzzleSolveIt.getContentPane().add(finish_dis);

		btn_roll.setEnabled(false);
		btn_roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				far--;

				if (far >= 0) {
					int[] m_temp = mem[nxt[far]].getMem();

					btn_0.setText("" + ((m_temp[0] == 0) ? "" : m_temp[0]));
					btn_1.setText("" + ((m_temp[1] == 0) ? "" : m_temp[1]));
					btn_2.setText("" + ((m_temp[2] == 0) ? "" : m_temp[2]));
					btn_3.setText("" + ((m_temp[3] == 0) ? "" : m_temp[3]));
					btn_4.setText("" + ((m_temp[4] == 0) ? "" : m_temp[4]));
					btn_5.setText("" + ((m_temp[5] == 0) ? "" : m_temp[5]));
					btn_6.setText("" + ((m_temp[6] == 0) ? "" : m_temp[6]));
					btn_7.setText("" + ((m_temp[7] == 0) ? "" : m_temp[7]));
					btn_8.setText("" + ((m_temp[8] == 0) ? "" : m_temp[8]));

					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							btn_roll.doClick();
						}
					}, 300);

				}

			}
		});
		// btn_roll.setHorizontalAlignment(SwingConstants.LEFT);
		btn_roll.setForeground(Color.ORANGE);
		btn_roll.setVisible(false);
		btn_roll.setFont(new Font("Rockwell", Font.BOLD, 50));
		btn_roll.setBounds(348, 268, 182, 69);
		frmpuzzleSolveIt.getContentPane().add(btn_roll);
	}
}
