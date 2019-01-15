import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ActionEvent occurred!!!");
			}
		});
	}
}
