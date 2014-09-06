package utils.pane;

import javax.swing.JPanel;


public abstract class RunnableTest implements Runnable {
	
	public JPanel pi;
	public RunnableTest(JPanel pi)
	{
		this.pi=pi;
	}

}
