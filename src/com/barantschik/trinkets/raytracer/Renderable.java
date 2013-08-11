package com.barantschik.trinkets.raytracer;

public interface Renderable
{
	public IntersectionData giveIntersection(Ray r);
	public double[] getNormal(double[] point);
	public double getShininess();
	public float getReflectivity();
	public float[] getDiffuse(IntersectionData interData);
	public float[] getSpecular();
	public float[] getAmbient();
	public float[] getEmissive();
	public void move(double x, double y, double z);
	public void transform(M4x4 transform);
//	public void transformBefore(M4x4 transform);
}