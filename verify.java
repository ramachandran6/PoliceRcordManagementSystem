package PoliceRecordManagementSystem;
import java.util.regex.*;

import javax.swing.JOptionPane;
public class verify {
	public String name;
	private void checkName(String name) {
		String pattern="[a-zA-Z]{5-30}$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match=patt.matcher(name);
		if(!match.matches()) {
			JOptionPane.showMessageDialog(null, "Enter a Valid name a-z A-Z");
		}
	}
}
