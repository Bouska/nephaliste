package utils.pane;

import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLKeyframe;
import aurelienribon.slidinglayout.SLPanel;
import aurelienribon.slidinglayout.SLSide;
import aurelienribon.slidinglayout.SLTransition;



class ChoosingPanel extends JPanel{
	private ArrayList<ChosenPanel> p;
	final private ArrayList<Runnable> pAction;
	final private ArrayList<Runnable> pBackAction;
	private SLPanel panel = new SLPanel();
	private boolean full = false;
	private  SLConfig mainCfg;
	private ArrayList<SLConfig> pCfg;
	public ChoosingPanel(final int dimx,final int dimy)
	{
		p=new ArrayList<ChosenPanel>(dimx*dimy);
		pAction = new ArrayList<Runnable>(dimx*dimy);
		pBackAction = new ArrayList<Runnable>(dimx*dimy);
		pCfg = new ArrayList<SLConfig>();
		mainCfg = new SLConfig(panel)
		.gap(10, 10);
		for(int i=0;i<dimy;i++)
		{
			mainCfg.col(1f);
		}
		for(int i=0;i<dimx;i++)
		{
			mainCfg.row(1f);
		}
		
		
		

		for(int i=0;i<dimy;i++)
		{
			for(int i1=0;i1<dimx;i1++)
			{
				ChosenPanel pi =new ChosenPanel(i*dimx+dimy+1);
				p.add(pi);
				mainCfg.place(dimx, dimy, pi);
				SLConfig piCfg = new SLConfig(panel);
				piCfg.row(1f).col(1f).place(0, 0, pi);
				
			}		
			
			
			
			
		}
		for(int i =0;i<p.size();i++)
		{
			final int e = i;
			Runnable piAction = new Runnable(){
				
				@Override
				public void run() {
					disableActions();
				
				SLTransition transit = 	panel.createTransition();
				SLKeyframe frame = new SLKeyframe(pCfg.get(e), 0.45f);
				int iPlaceline = (e+1)/dimy;
				
				int beforeTop = (iPlaceline-1)*dimy;
				int beforeLeft = e;
				int afterRight = dimy*iPlaceline;
				
				for(int j =0;j<p.size();j++)
				{
					if(j<beforeTop)
					{
						frame.setEndSide(SLSide.TOP, p.get(j));
					}
					else if(j<beforeLeft)
					{
						frame.setEndSide(SLSide.LEFT, p.get(j));
					}
					else if(j<afterRight)
					{
						frame.setEndSide(SLSide.RIGHT, p.get(j));
					}
					else
					{
						frame.setEndSide(SLSide.BOTTOM, p.get(j));
					}
				}
						
				frame.setCallback(new SLKeyframe.Callback() { 
								public void done() {
								p.get(e).setAction(pBackAction.get(e));
								p.get(e).enableAction();
							}});
							
				transit.push(frame).play();
				
					
				}};
				pAction.add(piAction);
				
				Runnable piBackAction = new Runnable(){

					@Override
					public void run() {
						disableActions();

					SLTransition transit = 	panel.createTransition();
					SLKeyframe frame = new SLKeyframe(pCfg.get(e), 0.45f);
					int iPlaceline = (e+1)/dimy;
				
					int beforeTop = (iPlaceline-1)*dimy;
					int beforeLeft = e;
					int afterRight = dimy*iPlaceline;
					
					for(int j =0;j<p.size();j++)
					{
						if(j<beforeTop)
						{
							frame.setStartSide(SLSide.TOP, p.get(j));
						}
						else if(j<beforeLeft)
						{
							frame.setStartSide(SLSide.LEFT, p.get(j));
						}
						else if(j<afterRight)
						{
							frame.setStartSide(SLSide.RIGHT, p.get(j));
						}
						else
						{
							frame.setStartSide(SLSide.BOTTOM, p.get(j));
						}
					}
							
					frame.setCallback(new SLKeyframe.Callback() { 
									public void done() {
									p.get(e).setAction(pAction.get(e));
									p.get(e).enableAction();
								}});
								
					transit.push(frame).play();
					
						
					}};
					pBackAction.add(piBackAction);
				
				
				p.get(i).setAction(piAction);
		}
		setLayout(new MigLayout());
		
	
		
		this.add(panel,"w 100%,h 100%");
		panel.setVisible(true);
	
		

		

		

		

		panel.setTweenManager(SLAnimator.createTweenManager());
		panel.initialize(mainCfg);
	}
	private void disableActions() {

		for(ChosenPanel pi : p)
		{
			pi.disableAction();
		}
	
	}

	private void enableActions() {
		for(ChosenPanel pi : p)
		{
			pi.enableAction();
		}
		
	}
	public void addPanel(JPanel pane)
	{
		if(!full)
		{
		for(ChosenPanel pi : p)
		{
			if(pi.isEmpty())
			{
				pi.makePanel(pane);
				full=false;
				if(p.indexOf(pi)==p.size()-1)
				{
					full=true;
				}
			}
		}
		}
		
		
		
	}
	public boolean isFull()
	{
		return full;
	}
}
