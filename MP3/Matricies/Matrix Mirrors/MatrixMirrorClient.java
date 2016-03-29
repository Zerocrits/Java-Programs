// Mr. A
// Matrix Mirrors Client
// Spec: Simple client to test

public class MatrixMirrorClient
{
	public static void main(String[] args)
	{
		MatrixMirror mm = new MatrixMirror(5,4);

		mm.mirrorVerticalLeftToRight();
		System.out.println(mm);

		mm.populateMatrixSequentially();
		mm.mirrorHorizontalTopToBottom();
		System.out.println(mm);

		/***** Uncomment if you have implemented the extra diagonal mirrors
		mm = new MatrixMirror(4,4);
		mm.mirrorMajorDiagonalLeftToRight();
		System.out.println(mm);

		mm = new MatrixMirror(4,4);
		mm.mirrorMinorDiagonalLeftToRight();
		System.out.println(mm);
		******/
	}
}
