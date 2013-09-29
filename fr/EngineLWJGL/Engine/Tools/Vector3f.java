package fr.EngineLWJGL.Engine.Tools;

public class Vector3f 
{
	private float x, y, z;
	
	public Vector3f(float par1X, float par2Y, float par3Z)
	{
		x = par1X;
		y = par2Y;
		z = par3Z;
	}
	
	public float length()
	{
		return (float) Math.sqrt(x*x+y*y+z*z);
	}
	
	public float dot(Vector3f vec)
	{
		return x*vec.getX() + y*vec.getY() + z*vec.getZ();
	}
	
	public Vector3f add(Vector3f vec)
	{
		return new Vector3f(x+vec.getX(), y+vec.getY(), z +vec.getZ());
	}
	
	public void add(float par1X, float par2Y, float par3Z)
	{
		x += par1X;
		y += par2Y;
		z += par3Z;
	}
	
	public Vector3f normal()
	{
		return new Vector3f(x/length(), y/length(), z/length());
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getZ()
	{
		return z;
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public void setZ(float z)
	{
		this.z = z;
	}
}
