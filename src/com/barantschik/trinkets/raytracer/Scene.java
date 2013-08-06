package com.barantschik.trinkets.raytracer;

import java.util.Arrays;

public class Scene
{
	private Camera c;
	private Light[] lights = new Light[0];
	private Renderable[] renderable = new Renderable[0];

	private ScenePreferences sp;

	public Scene(ScenePreferences sp, boolean chooseDefault) //Makes empty scene if not default scene
	{
		this.setSP(sp);

		if(!chooseDefault)
		{
			setC(new Camera(new double[]{0, 0, 0}, new double[]{0, 0, 1}, new double[]{0, 1, 0}));
		}
		else
		{
			c = new Camera(new double[]{-3, 2.2, 1.9}, new double[]{0, 0, 10}, new double[]{0, 1, 0});

			lights = new Light[1];
			renderable = new Renderable[7];

			lights[0] = new PointLight(new double[]{0, 0, 6}, new float[]{0.5f, 0.5f, 0.5f});

			renderable[0] = new Sphere(new double[]{0, 0, 4}, 1.5, new float[]{0.7f, 0, 0});
			renderable[1] = new Sphere(new double[]{3.5, 0, 4}, 1.5, new float[]{0, 0.7f, 0});
			renderable[2] = new Sphere(new double[]{-3.5, 0, 4}, 1.5, new float[]{0, 0, 0.7f});
			renderable[3] = new Sphere(new double[]{0, 3.5, 4}, 1.5, new float[]{0.7f, 0, 0.7f});
			renderable[4] = new Sphere(new double[]{0, -3.5, 4}, 1.5, new float[]{0, 0.7f, 0.7f});
			
			renderable[5] = new Triangle(new double[]{20, 20, 7}, new double[]{-20, 20, 7}, new double[]{-20, -20, 7}, new float[]{0, 0.3f, 0.7f});
			renderable[6] = new Triangle(new double[]{-20, -20, 7}, new double[]{20, -20, 7}, new double[]{20, 20, 7}, new float[]{0, 0.3f, 0.7f});
			
			double[][] values = {{1, 0, 0, 0},
								 {0, 5, 0, 0},
								 {0, 0, 1, 0},
								 {0, 0, 0, 1}};
			
//			renderable[1].transform(new M4x4(values));
//			renderable[2].transform(new M4x4(values));
		}
	}

	public Camera getC()
	{
		return c;
	}

	public void setC(Camera c)
	{
		this.c = c;
	}

	public Light[] getLights()
	{
		return lights;
	}

	public void setLights(Light[] lights)
	{
		this.lights = lights;
	}

	public void removeLights()
	{
		lights = new Light[0];
	}

	public void addLight(Light l)
	{
		lights = Arrays.copyOf(lights, lights.length + 1);
		lights[lights.length - 1] = l;
	}

	public Renderable[] getRenderable()
	{
		return renderable;
	}

	public void setRenderable(Renderable[] renderable)
	{
		this.renderable = renderable;
	}

	public void removeRenderable()
	{
		renderable = new Renderable[0];
	}

	public void addRenderable(Renderable r)
	{
		renderable = Arrays.copyOf(renderable, renderable.length + 1);
		renderable[renderable.length - 1] = r;
	}

	public ScenePreferences getSP()
	{
		return sp;
	}
	
	public void setSP(ScenePreferences sp)
	{
		this.sp = sp;
	}
}