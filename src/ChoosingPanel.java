
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLKeyframe;
import aurelienribon.slidinglayout.SLPanel;
import aurelienribon.slidinglayout.SLSide;



class ChoosingPanel extends JPanel{
	private  ChosenPanel p1 = new ChosenPanel(1);
	private  ChosenPanel p2 = new ChosenPanel(2);
	private  ChosenPanel p3 = new ChosenPanel(3);
	private  ChosenPanel p4 = new ChosenPanel(4);
	private SLPanel panel = new SLPanel();
	private boolean full = false;
	private  SLConfig mainCfg, p1Cfg, p2Cfg, p3Cfg, p4Cfg;
	public ChoosingPanel()
	{
		setLayout(new MigLayout());
		this.add(panel,"w 100%,h 100%");
		panel.setVisible(true);
		p1.setAction(p1Action);
		p2.setAction(p2Action);
		p3.setAction(p3Action);
		p4.setAction(p4Action);
		

		mainCfg = new SLConfig(panel)
		.gap(10, 10)
		.row(1f).row(1f).col(1f).col(1f)
		.place(0, 0, p1)
		.place(0, 1, p2)
		.place(1, 0, p3)
		.place(1, 1, p4);

		p1Cfg = new SLConfig(panel)
		.gap(10, 10)
		.row(1f).col(1f)
		.place(0, 0, p1);

		p2Cfg = new SLConfig(panel)
		.gap(10, 10)
		.row(1f).col(1f)
		.place(0, 0, p2);

		p3Cfg = new SLConfig(panel)
		.gap(10, 10)
		.row(1f).col(1f)
		.place(0, 0, p3);

		p4Cfg = new SLConfig(panel)
		.gap(10, 10)
		.row(1f).col(1f)
		.place(0, 0, p4);

		

		panel.setTweenManager(SLAnimator.createTweenManager());
		panel.initialize(mainCfg);
	}
	private void disableActions() {
		p1.disableAction();
		p2.disableAction();
		p3.disableAction();
		p4.disableAction();
	
	}

	private void enableActions() {
		p1.enableAction();
		p2.enableAction();
		p3.enableAction();
		p4.enableAction();
		
	}
	private final Runnable p1Action = new Runnable() { 
		public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p1Cfg, 0.45f)
				.setEndSide(SLSide.BOTTOM, p3,p4)
				.setEndSide(SLSide.RIGHT, p2)
				.setCallback(new SLKeyframe.Callback() { 
					public void done() {
					p1.setAction(p1BackAction);
					p1.enableAction();
				}}))
			.play();
	}};

	private final Runnable p1BackAction = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.45f)
			.setStartSide(SLSide.BOTTOM, p3,p4)
			.setStartSide(SLSide.RIGHT, p2)
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p1.setAction(p1Action);
					enableActions();
				}}))
			.play();
	}};

	private final Runnable p2Action = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p2Cfg, 0.45f)
				.setEndSide(SLSide.BOTTOM, p4,p3)
				.setEndSide(SLSide.LEFT, p1)
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p2.setAction(p2BackAction);
					p2.enableAction();
				}}))
			.play();
	}};

	private final Runnable p2BackAction = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.45f)
				.setStartSide(SLSide.BOTTOM, p4,p3)
				.setStartSide(SLSide.LEFT, p1)
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p2.setAction(p2Action);
					enableActions();
				}}))
			.play();
	}};

	private final Runnable p3Action = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p3Cfg, 0.45f)
				.setEndSide(SLSide.TOP, p1, p2)
				.setEndSide(SLSide.RIGHT, p4)
			
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p3.setAction(p3BackAction);
					p3.enableAction();
				}}))
			.play();
	}};

	private final Runnable p3BackAction = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.45f)
				
				.setStartSide(SLSide.TOP, p1, p2)
				.setStartSide(SLSide.RIGHT, p4)
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p3.setAction(p3Action);
					enableActions();
				}}))
			.play();
	}};

	private final Runnable p4Action = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(p4Cfg, 0.45f)
				.setEndSide(SLSide.TOP, p1,p2)
				.setEndSide(SLSide.LEFT, p3)
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p4.setAction(p4BackAction);
					p4.enableAction();
				}}))
			.play();
	}};

	private final Runnable p4BackAction = new Runnable() { public void run() {
		disableActions();

		panel.createTransition()
			.push(new SLKeyframe(mainCfg, 0.45f)
				.setStartSide(SLSide.TOP, p1,p2)
				.setStartSide(SLSide.LEFT, p3)
				.setCallback(new SLKeyframe.Callback() { public void done() {
					p4.setAction(p4Action);
					enableActions();
				}}))
			.play();
	}};
	public void addPanel(JPanel pane)
	{
		if(p1.isEmpty())
		{
			p1.makePanel(pane);
			full=false;
		}
		else if(p2.isEmpty())
		{
			p2.makePanel(pane);
			full=false;
		}
		else if(p3.isEmpty())
		{
			p3.makePanel(pane);
			full=false;
		}
		else if(p4.isEmpty())
		{
			p4.makePanel(pane);
			full=true;
		}
		
		
	}
	public boolean isFull()
	{
		return full;
	}
}
