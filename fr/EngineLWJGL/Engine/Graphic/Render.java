package fr.EngineLWJGL.Engine.Graphic;

import fr.EngineLWJGL.Engine.Game.Render.RenderMap;

public class Render
{
	public static final Render[] render = new Render[50];
	
	public static final Render map = new RenderMap(1);
	
	private int id;
	
	public Render(int id)
	{
		this.id = id;
		render[id] = this;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void intput()
	{
	}
	
	public void update()
	{	
	}
	
	public void render()
	{	
	}
}
