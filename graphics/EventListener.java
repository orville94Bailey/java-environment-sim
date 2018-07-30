package org.graphics;

import org.world.World;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener{

	public static GL2 gl = null;
	
	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		Graphics.SetFillMode(FillMode.Center);
		Graphics.SetColor(1, 0, 0, 1);
		Graphics.FillRect(200, 200, 10, 10);
		
		Graphics.SetFillMode(FillMode.Corner);
		Graphics.SetColor(1, 1, 1, 1);
		Graphics.FillCircle(200, 200, 3, 4);
		
//		World.Render();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();	
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, Renderer.GetWindowWidth(),
				Renderer.GetWindowHeight(), 0,
				-1, 1);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		
	}

}
