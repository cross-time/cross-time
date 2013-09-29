package fr.EngineLWJGL.Engine.Game.Render;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class LoaderBMP{

	//private static String texture;
	
	public LoaderBMP(String texture){
		//this.texture = texture;
	}
	
	public static int load(String texture){
		//texture = texture;
		try {
			BufferedImage img = ImageIO.read(new File("ressources", texture));
			
			byte[] src = ((DataBufferByte)img.getRaster().getDataBuffer()).getData();
			
			bgrToRgb(src);
			
			ByteBuffer pixels = (ByteBuffer)BufferUtils.createByteBuffer(src.length).put(src, 0x00000000, src.length).flip();
			IntBuffer textures = BufferUtils.createIntBuffer(0x00000001);
			
			GL11.glGenTextures(textures);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, textures.get(0x00000000));
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
			GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0x00000000, GL11.GL_RGB, img.getWidth(), img.getHeight(), 0x00000000, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, pixels);
			
			return textures.get(0x00000000);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	private static void bgrToRgb(byte[] par){
		byte tmp;
		
		for(int i=0x00000000; i<par.length; i+=0x00000003) {
			tmp = par[i];
			
			par[i] = par[i+0x00000002];
			par[i+0x00000002] = tmp;
		}
	}

}
