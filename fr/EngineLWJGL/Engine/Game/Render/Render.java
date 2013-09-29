package fr.EngineLWJGL.Engine.Game.Render;

import org.lwjgl.opengl.GL11;


public class Render
{
	public static final Render[] render = new Render[50];
	/**
	 * Liste modelisation
	 */
	public static final Render map = new RenderMap(1);
	public static final Render cube = new RenderCube(2, "modaship2.obj");
	//public static final Render plan = new RenderCube(3, "plan.obj");
	
	
	private int id;
	private LoaderOBJ obj = null;
	
	public Render(int id)
	{
		this.id = id;
		render[id] = this;
	}
	
	public Render(int id, String file)
	{
		this.id = id;
		render[id] = this;
		obj = new LoaderOBJ(file);
			
		obj.readFile();
		GL11.glNewList(this.id, GL11.GL_COMPILE);
			obj.model();
		GL11.glEndList();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void model()
	{
		
	}
	
	public void input()
	{
		
	}
	
	public void update()
	{	
	}
	
	public void render()
	{			
		GL11.glCallList(this.id);
	}
}
