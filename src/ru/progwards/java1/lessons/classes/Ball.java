package ru.progwards.java1.lessons.classes;

public class Ball extends Figure3D {

	public Ball(Number segment)
	{
		super(segment);
	}
	
	@Override
	public Number volume()
	{
		return 	segment.div(
					segment.mul(
						segment.mul(
							segment.mul(
								segment.mul(segment, segment), 
								segment), 
							segment.newNumber(Math.PI + "")),
						segment.newNumber("4")),
					segment.newNumber("3"));
	}

}
