package fr.EngineLWJGL.Engine.Graphic;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window 
{

	private static String title;
	
	public Window()
	{
		title = "";
	}
	
	public void createWindow(int width, int height, int depth, String title, boolean resizable)
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(width, height));			
			Window.title = title;
			Display.setTitle("EngineLWJGL");
			Display.setResizable(resizable);
			Display.create();
			
		}catch(Exception e)
		{
			System.out.println("Erreur lors de la création de l'affichage : "+e);
			return;
		}
	}
	
	public static void render()
	{
		Display.update();
	}

	public static boolean isClosedRequested()
	{
		return Display.isCloseRequested();
	}
	
	public static int getWidth()
	{
		return Display.getWidth();
	}
	
	public static int getHeight()
	{
		return Display.getHeight();
	}
	
	public static String getTitle()
	{
		return Display.getTitle();
	}
	
	public static void setFPS(int fps)
	{
		Display.setTitle(title+" "+fps+"FPS");
	}
	
	public static void sleep()
	{
		Display.sync(60);
	}
		
	public static void delete()
	{
		Display.destroy();
	}

	public static void resize()
	{

	}
}

