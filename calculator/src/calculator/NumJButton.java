package calculator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class NumJButton  extends JButton{
	private String name;
	public NumJButton(String name) {
		super(name);
		this.name=name;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String[] s= {"0","1","2","3","4","5","6","7","8","9","+","‐"};
				for (int i = 0; i < s.length; i++) {
					if(s[i]==name) {
						Calculator.sb.append(name);
						Calculator.show.setText(Calculator.sb.toString());
					}
				}
				switch (name) {
				case "C":
				case "CE":
					Calculator.sb.delete(0, Calculator.sb.length());
					Calculator.show.setText(Calculator.sb.toString());
					break;
				
				case "DEL":
					try {
						//第一个字符不是=的时候才能删除字符，否则不动
						if(Calculator.sb.charAt(0)!='=') {
						Calculator.sb.delete(Calculator.sb.length()-1, Calculator.sb.length());
						}
					} catch (StringIndexOutOfBoundsException e2) {
						// TODO: handle exception
					}
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case ".":
					if(count('.')==0) {
						Calculator.sb.append(name);
						Calculator.show.setText(Calculator.sb.toString());
					}
					break;
				case "±":
					char r=Calculator.sb.charAt(0);
					if(r!='-') { 
						Calculator.sb.insert(0, '-');
						Calculator.show.setText(Calculator.sb.toString());
					}
					if(r=='-') {
						Calculator.sb.deleteCharAt(0);
						Calculator.show.setText(Calculator.sb.toString());
					}
					
					break;
				case "x²":
					//返回加上括号之后的字符串
					String add=addRadius(Calculator.sb).toString();
					Calculator.sb.append("×"+add);
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case "1/x":
					addRadius(Calculator.sb);
					Calculator.sb.insert(0, "1/");
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case "×":
					Calculator.sb.append("×");
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case "÷":
					Calculator.sb.append("/");
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case "%":
					addRadius(Calculator.sb);
					Calculator.sb.append("/100");
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case "√":
					addRadius(Calculator.sb);
					Calculator.sb.insert(0,"√");
					Calculator.show.setText(Calculator.sb.toString());
					break;
				case "=":
					double result=Calculate(Calculator.sb);
					Calculator.show.setText(Double.toString(result));
					break;
				default:
					break;
				}
			}

			private double Calculate(StringBuffer sb) {
				// TODO Auto-generated method stub
				return 3.154;
			}

			private String addRadius(StringBuffer sb) {
				//添加括号
				sb.insert(0, "(");
				sb.insert(sb.length(), ")");
				return sb.toString();
			}

			public int count(char ch) {
				// TODO Auto-generated method stub
				int i=0;
				for(int k=0;k<Calculator.sb.length();k++) {
					if(Calculator.sb.charAt(k)==ch) {
						i++;
					}
				}
				return i;
			}
		});
	}
}
