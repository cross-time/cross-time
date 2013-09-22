package fr.EngineLWJGL.Engine.Game.Render;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import fr.EngineLWJGL.Engine.Tools.Vertex;

public class LoaderOBJ
{
	
	private List<Vertex> v = new ArrayList<Vertex>();
	private List<Integer[]> f = new ArrayList<Integer[]>();
	private String fileLink;
	private Vertex[][] vertex;
	
	
	public LoaderOBJ(String file)
	{
		fileLink = file;
	}
	
	public void readFile()
	{
		String line;
		
		File file = new File("ressources", fileLink);
		
		
		InputStream ips = null;
		BufferedReader br = null;
		
		try
		{
			ips = new FileInputStream(file);
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} 
		
		InputStreamReader ipsr = new InputStreamReader(ips);
		br = new BufferedReader(ipsr);
		
		try
		{
			while ((line=br.readLine())!=null)
			{
				
                
                
				if(line.startsWith("v "))
				{
					String[] vertexStr = line.substring(line.indexOf(" ") + 1).split(" ");
                    
					v.add(new Vertex(Float.parseFloat(vertexStr[0]), Float.parseFloat(vertexStr[1]),
                    		Float.parseFloat(vertexStr[2])));
				}
				else if(line.startsWith("f "))
				{
					String[] vertexStr = line.substring(line.indexOf(" ") + 1).split(" " );
					f.add(new Integer[]{Integer.parseInt(vertexStr[0]), Integer.parseInt(vertexStr[1]), Integer.parseInt(vertexStr[2])});
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			br.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Is load");
		organize();
	}
	
	public Vertex[][] organize()
	{
		vertex = new Vertex[f.size()][3];
		
		for(int i=0; i< f.size(); i++)
		{
			vertex[i][0] = v.get(f.get(i)[0]-1);
			vertex[i][1] = v.get(f.get(i)[1]-1);
			vertex[i][2] = v.get(f.get(i)[2]-1);
		}
		
		return vertex;
	}
	
	public void model()
	{
		for(int i=0; i<vertex.length; i++)
		{	        
			GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glVertex3f(vertex[i][0].getX(), vertex[i][0].getY(), vertex[i][0].getZ());
				GL11.glVertex3f(vertex[i][1].getX(), vertex[i][1].getY(), vertex[i][1].getZ());
				GL11.glVertex3f(vertex[i][2].getX(), vertex[i][2].getY(), vertex[i][2].getZ());
			GL11.glEnd();
		}
	}
}
