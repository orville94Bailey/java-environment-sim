package org.graphics;

import org.input.KeyInput;
import org.input.MouseInput;

import com.jogamp.nativewindow.WindowClosingProtocol.WindowClosingMode;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Renderer {

	private static GLWindow window = null;
	public static final float UnitsWide = 10;
	
	public static void init()
	{
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setResizable(false);
		
		window.addGLEventListener(new EventListener());
		window.addMouseListener(new MouseInput());
		window.addKeyListener(new KeyInput());
		window.requestFocus();
		window.setDefaultCloseOperation(WindowClosingMode.DISPOSE_ON_CLOSE);
		
		FPSAnimator animator = new FPSAnimator(window, 5);
		animator.start();
		window.setFullscreen(true);
		window.setVisible(true);
	}
	
	public static void Render() {
		window.display();
	}
	
	public static int GetWindowWidth()
	{
		return window.getWidth();
	}
	
	public static int GetWindowHeight()
	{
		return window.getHeight();
	}
}
