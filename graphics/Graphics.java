package org.graphics;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

import javafx.util.Pair;

public class Graphics {
	
	//Color values
	private static float _red = 0;
	private static float _green = 0;
	private static float _blue = 0;
	private static float _alpha = 0;
	
	//Rotation in degrees
	private static float _rotation = 0;
	
	private static FillMode  _fillMode = FillMode.Corner;

	public static void FillRect(float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		gl.glPushMatrix();
		
		float xdif = 0;
		float ydif = 0;
		
		switch(_fillMode)
		{
		case Center:
			xdif = x;
			ydif = y;
			break;
		case Corner:
			xdif = x + width/2;
			ydif = y + height/2;
			break;
		default:
			break;
		}
		
		gl.glTranslatef(xdif, ydif, 0);
		gl.glRotatef(_rotation, 0, 0, 1);
		gl.glColor4f(_red, _green, _blue, _alpha);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(-(width/2), -(height/2));
		gl.glVertex2f((width/2), -(height/2));
		gl.glVertex2f((width/2), (height/2));
		gl.glVertex2f(-(width/2), (height/2));
		
		gl.glEnd();
		gl.glPopMatrix();
		ZeroColor();
		ZeroRotation();
	}
	
	public static void FillCircle(float x, float y, float radius, int num_segments){
		GL2 gl = EventListener.gl;
		gl.glPushMatrix();
		
		float xdif = 0;
		float ydif = 0;
		
		ArrayList<Pair<Double,Double>> vertexHolder = new ArrayList<Pair<Double,Double>>();
		
		switch(_fillMode)
		{
		case Center:
			xdif = x;
			ydif = y;
			break;
		case Corner:
			xdif = x + radius;
			ydif = y + radius;
			break;
		default:
			break;
		}
		
		gl.glTranslatef(xdif, ydif, 0);
		
		gl.glColor4f(_red, _green, _blue, _alpha);
		
		/*  Code taken from here:
		 * http://slabode.exofire.net/circle_draw.shtml
		 */
		float theta = (float) (2 * 3.1415926 / (float)num_segments); 
		double c = Math.cos(theta);//precalculate the sine and cosine
		double s = Math.sin(theta);
		double t;

		double _x = radius;//we start at angle = 0 
		double _y = 0; 
	     
		for(int ii = 0; ii < num_segments; ii++) 
		{ 
			vertexHolder.add(new Pair<Double,Double>(_x + c*_x, _y+c*_y));
	        
			//apply the rotation matrix
			t = _x;
			_x = c * _x - s * _y;
			_y = s * t + c * _y;
		}
		
		gl.glBegin(GL2.GL_TRIANGLES);
		for(int i = 0; i < vertexHolder.size(); i++)
		{
			gl.glVertex2f(0f,0f);
			gl.glVertex2d(vertexHolder.get(i).getKey(), vertexHolder.get(i).getValue());
			if(i + 1 < vertexHolder.size())
			{
				gl.glVertex2d(vertexHolder.get(i+1).getKey(), vertexHolder.get(i+1).getValue());
			}
			else
			{
				gl.glVertex2d(vertexHolder.get(0).getKey(), vertexHolder.get(0).getValue());
			}
		}
		
		gl.glEnd();
		gl.glPopMatrix();
		ZeroColor();
		ZeroRotation();
	}
	
	private static void ZeroColor(){
		_red = 0;
		_green = 0;
		_blue = 0;
		_alpha = 0;
	}
	
	public static void SetColor(float red, float green, float blue, float alpha){
		_red = Math.max(0, Math.min(1,red));
		_green = Math.max(0, Math.min(1,green));
		_blue = Math.max(0, Math.min(1,blue));
		_alpha = Math.max(0, Math.min(1,alpha));		
	}
	
	public static void SetFillMode(FillMode fillMode)
	{
		_fillMode = fillMode;
	}

	public static void SetRotation(float rotation)
	{
		_rotation = rotation;
	}
	
	private static void ZeroRotation()
	{
		_rotation = 0;
	}
}
