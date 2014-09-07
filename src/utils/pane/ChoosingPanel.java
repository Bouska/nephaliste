package utils.pane;

import java.util.ArrayList;


import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import aurelienribon.slidinglayout.SLAnimator;
import aurelienribon.slidinglayout.SLConfig;
import aurelienribon.slidinglayout.SLKeyframe;
import aurelienribon.slidinglayout.SLPanel;
import aurelienribon.slidinglayout.SLSide;
import aurelienribon.slidinglayout.SLTransition;



public class ChoosingPanel extends JPanel{
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
		
		
		

		for(int i=0;i<dimx;i++)
		{
			for(int i1=0;i1<dimy;i1++)
			{
				p.add(new ChosenPanel(i1+dimy*i));
				
				mainCfg.place(i, i1,p.get(i1+dimy*i) );
				
				
				pCfg.add(new SLConfig(panel).row(1f).col(1f).place(0, 0, p.get(i1+dimy*i)));
				
			}		
			
			
			
			
			
		}
		for(int i =0;i<p.size();i++)
		{
			final int e = i;
			
				
				
			pBackAction.add(new Runnable(){
				private int i =e;
					@Override
					public void run() {
						disableActions();

					SLTransition transit = 	panel.createTransition();
					SLKeyframe frame = new SLKeyframe(mainCfg, 0.45f);
					int iPlaceline = (i)/dimy;
					
					int beforeTop = dimy*iPlaceline;
					int beforeLeft = i;
					int afterRight = dimy*(iPlaceline+1);
					
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
						else if(j==beforeLeft)
						{
							
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
									p.get(i).setAction(pAction.get(i));
									enableActions();
								}});
								
					transit.push(frame).play();
				
						
					}});
				
pAction.add( new Runnable(){
				private int i =e;
				@Override
				public void run() {
					disableActions();
				
				SLTransition transit = 	panel.createTransition();
				SLKeyframe frame = new SLKeyframe(pCfg.get(i), 0.45f);
				int iPlaceline = (i)/dimy;
				
				int beforeTop = dimy*iPlaceline;
				int beforeLeft = i;
				int afterRight = dimy*(iPlaceline+1);
				
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
					else if(j==beforeLeft)
					{
						
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
								p.get(i).setAction(pBackAction.get(i));
								p.get(i).enableAction();
							}});
							
				transit.push(frame).play();
				
				
					
				}});
				
				p.get(i).setAction(pAction.get(i));
		}
		setLayout(new MigLayout());
		
	
		
		this.add(panel,"w 100%,h 100%");
		panel.setVisible(true);
	
		

		

		

		

		panel.setTweenManager(SLAnimator.createTweenManager());
		panel.initialize(mainCfg);
		enableActions();
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
		for(int i =0;i<p.size();i++)
		{
			if(p.get(i).isEmpty())
			{
				p.get(i).makePanel(pane);
				full=false;
				if(p.indexOf(p.get(i))==p.size()-1)
				{
					full=true;
				}
				break;
			}
		}
		}
		
		
		
	}
	public boolean isFull()
	{
		return full;
	}
}
