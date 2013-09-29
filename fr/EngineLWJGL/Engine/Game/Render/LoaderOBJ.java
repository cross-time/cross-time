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
import fr.EngineLWJGL.Engine.Tools.Vertex2f;

public class LoaderOBJ
{
	
	private List<Vertex> v = new ArrayList<Vertex>();
	private List<Vertex2f> vt = new ArrayList<Vertex2f>();
	//private List<Integer[]> f = new ArrayList<Integer[]>();
	private List<Integer[]> ft = new ArrayList<Integer[]>();
	private String fileLink;
	private Vertex[][] vertex;
	private Vertex2f[][] texture;
	private List<String[]> li = new ArrayList<String[]>();
	private String[] texStr;
	
	
	public LoaderOBJ(String file)
	{
		fileLink = file;
	}
	
	public void readFile()
	{
		String line;
		String texTmp = null;
		
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
				else if(line.startsWith("vt "))
				{
					String[] tmp = line.substring(line.indexOf(" ") + 1).split(" ");
					
					vt.add(new Vertex2f(Float.parseFloat(tmp[0]), Float.parseFloat(tmp[1])));
				}
				else if(line.startsWith("mtllib "))
				{
					String[] tmp = line.substring(line.indexOf(" ") + 1).split(" ");
					
					mat("ressources/" + tmp[0]);
				}
				else if(line.startsWith("usemtl ")){
					String[] tmp = line.substring(line.indexOf(" ") + 1).split(" ");
					texTmp = tmp[0];
				}
				else if(line.startsWith("f "))
				{
					String[] vertexStr = line.substring(line.indexOf(" ") + 1).split(" ");
					
					if(vertexStr[0].indexOf("/") >= 0)
					{
						String[] tmp = vertexStr[0].substring(vertexStr[0].indexOf(" ") + 1).split("/");
						String[] tmp1 = vertexStr[1].substring(vertexStr[1].indexOf(" ") + 1).split("/");
						String[] tmp2 = vertexStr[2].substring(vertexStr[2].indexOf(" ") + 1).split("/");
						String[] tmp3 = vertexStr[3].substring(vertexStr[3].indexOf(" ") + 1).split("/");
						ft.add(new Integer[]{Integer.parseInt(tmp[0]), Integer.parseInt(tmp1[0]), Integer.parseInt(tmp2[0]), Integer.parseInt(tmp3[0]), 
								Integer.parseInt(tmp[1]), Integer.parseInt(tmp1[1]), Integer.parseInt(tmp2[1]), Integer.parseInt(tmp3[1]), indexOfList(li, texTmp)});
						
					}
					else
						ft.add(new Integer[]{Integer.parseInt(vertexStr[0]), Integer.parseInt(vertexStr[1]), Integer.parseInt(vertexStr[2]), Integer.parseInt(vertexStr[3]), 
								-1, -1, -1, -1, -1});
					
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
	
	public void mat(String par1File){
		
		InputStream ips = null;
		BufferedReader br = null;
		String line = null;
		String tmpStr = null;
		
		try
		{
			ips = new FileInputStream(par1File);
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} 
		
		InputStreamReader ipsr = new InputStreamReader(ips);
		br = new BufferedReader(ipsr);
		
		try
		{
			while ((line=br.readLine())!=null){
				if(line.startsWith("newmtl ")){
					String[] tmp = line.substring(line.indexOf(" ") + 1).split(" ");
					
					tmpStr = tmp[0];
					
				}
				else if(line.startsWith("map_Kd ")){
					String[] tmp = line.substring(line.indexOf(" ") + 1).split(" ");
					
					li.add(new String[]{tmpStr, tmp[0]});
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
	}
	
	private int indexOfList(List<String[]> par1List, String par2Str){
		for(int i=0; i<par1List.size(); i++){
			if(par1List.get(i)[0].equalsIgnoreCase(par2Str))
				return i;
		}
		
		return -1;
	}
	
	public Vertex[][] organize()
	{
		vertex = new Vertex[ft.size()][4];
		texture = new Vertex2f[ft.size()][4];
		texStr = new String[ft.size()];
		
		for(int i=0; i< ft.size(); i++)
		{
			vertex[i][0] = v.get(ft.get(i)[0]-1);
			vertex[i][1] = v.get(ft.get(i)[1]-1);
			vertex[i][2] = v.get(ft.get(i)[2]-1);
			vertex[i][3] = v.get(ft.get(i)[3]-1);
			
				
			
			if(ft.get(i)[8]>-1)
				texStr[i] = li.get(ft.get(i)[8])[1];
			else
				texStr[i] = null;
			
			if(ft.get(i)[4] > 0)
			{
				texture[i][0] = vt.get(ft.get(i)[4]-1);
				texture[i][1] = vt.get(ft.get(i)[5]-1);
				texture[i][2] = vt.get(ft.get(i)[6]-1);
				texture[i][3] = vt.get(ft.get(i)[7]-1);
			}
			else
			{
				texture[i][0] = null;
				texture[i][1] = null;
				texture[i][2] = null;
				texture[i][3] = null;
			}
		}
		
		return vertex;
	}
	
	public void model()
	{
		int tex = 0;
		String last = "";
		
		System.out.println(tex);
		
		for(int i=0; i<vertex.length; i++)
		{
			
			if(texStr[i] != null){
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				if(texStr[i] != last){
					tex = LoaderBMP.load(texStr[i]);
					last = texStr[i];
				}
				
			}
			
			if(texture[i][0] != null)
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex);
			GL11.glBegin(GL11.GL_QUADS);
				if(texture[i][0] != null)
					GL11.glTexCoord2f(texture[i][0].getX(), texture[i][0].getY());
				GL11.glVertex3f(vertex[i][0].getX(), vertex[i][0].getY(), vertex[i][0].getZ());
				if(texture[i][0] != null)
					GL11.glTexCoord2f(texture[i][1].getX(), texture[i][1].getY());
				GL11.glVertex3f(vertex[i][1].getX(), vertex[i][1].getY(), vertex[i][1].getZ());
				if(texture[i][0] != null)
					GL11.glTexCoord2f(texture[i][2].getX(), texture[i][2].getY());
				GL11.glVertex3f(vertex[i][2].getX(), vertex[i][2].getY(), vertex[i][2].getZ());
				if(texture[i][0] != null)
					GL11.glTexCoord2f(texture[i][3].getX(), texture[i][3].getY());
				GL11.glVertex3f(vertex[i][3].getX(), vertex[i][3].getY(), vertex[i][3].getZ());
			GL11.glEnd();
			
			GL11.glDisable(GL11.GL_TEXTURE_2D);
		}
	}
}

