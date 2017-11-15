package tut20171101;

import java.awt.Point;

public class DebugEx {

	static Point point;
	
	public static void main(String[] args) {
		point = new Point(100, 50);
		printPoint(point);
	}
	
	private static void printPoint(final Point point) {
		System.out.println(point.x);
		point.x = 75;	
		System.out.println(", " + point.y);
	}
}
