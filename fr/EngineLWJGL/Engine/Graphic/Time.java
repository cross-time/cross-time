package fr.EngineLWJGL.Engine.Graphic;



public class Time 
{
	private static long lastTime;
	
	public Time()
	{
		lastTime = 0;
	}
	
	public static long getTime()
	{
		return System.nanoTime() / 1000000;
	}
	
	public void start()
	{
		lastTime = getTime();
	}
	
	public int fps()
	{
		int var = (int) (1000/(getTime()-lastTime));	
		//System.out.println(1000/(getTime()-lastTime));
		
		start();
		
		return var;
	}
	
	public void sleep(int fps)
	{
		while(((1000/fps)-(getTime()-lastTime))>0);
	}
	
}
