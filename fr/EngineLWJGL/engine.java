package fr.EngineLWJGL;
import fr.EngineLWJGL.Engine.Graphic.MainEngine;
import fr.EngineLWJGL.Engine.Graphic.Window;

public class engine 
{

	public static void main(String[] args) 
	{
		Window win = new Window();
		win.createWindow(800, 600, 32, "Engine LWJGL", true);
		
		MainEngine engine = new MainEngine();
		engine.start();
	}
}
