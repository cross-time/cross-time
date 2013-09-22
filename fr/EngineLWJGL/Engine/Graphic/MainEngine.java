package fr.EngineLWJGL.Engine.Graphic;

import org.lwjgl.opengl.Display;

import fr.EngineLWJGL.Engine.Game.Game;

public class MainEngine 
{
	private boolean isRunning;
	private long lastTime;
	private static int FRAME_PER_SECOND = 60;
	private Game game;
	int width;
	
	public MainEngine()
	{
		isRunning = false;
		game = new Game();
		width = Display.getWidth();
	}
	
	public void start()
	{
		if(isRunning)
			return;
		
		run();
	}
	
	public void stop()
	{
		isRunning = false;
	}
	
	private void run()
	{
		isRunning = true;
		
		Time time = new Time();
		lastTime = Time.getTime();
		
		time.start();
		
		while(isRunning)
		{
			
			if(Window.isClosedRequested())
				stop();
			
			if(Display.wasResized())
			{
				Game.func();
				width = Display.getWidth();
			}
			
			Input.update();
			game.input();
			game.update();
			game.render();
			render();
			
			
			/****************************************
			 * FPS
			 ****************************************/
			while(((1000/FRAME_PER_SECOND)-(Time.getTime()-lastTime))>0)
			{
				
			}
			
			if(Time.getTime()-lastTime > 1000)
			{
				Window.setFPS(time.fps());
				lastTime = Time.getTime();
			}
			time.start();
			/***********************************/
		}
		clear();
	}
	
	private void render()
	{
		Window.render();
	}
	
	private void clear()
	{
		Window.delete();
	}
}