// Mr. A
// Simple Show
// Spec: A seat could / should have more information (be it's own object), but here it is either taken or not taken only.
//		 Default hall is a small 50 seat venue.
//		 The first 5 rows go for $40 each... yes cheap by today's standards... but I remember prices like that :)
//		 subsequent rows are just $20 each

public class SimpleShow
{
	private boolean[][] seat;

	/** Creates a concert hall with 10 rows and 5 seats in each row
	*/
	public SimpleShow()
	{

	}

	/** Creates a concert hall with the size specified by rows and cols
	*/
	public SimpleShow(int rows, int cols)
	{

	}

	/** If the seat is not already occupied then it makes it occupied and returns true
	/*  If it is already occupied the method will return false
	*/
	public boolean reserveSeat(int row, int col)
	{
		return true;
	}

	/** Makes the seat at row, col empty
	*/
	public void clearSeat(int row, int col)
	{

	}

	/**	Resets all seats to available.
	*/
	public void clearAllSeats()
	{

	}

	/** @return the number of seats still available in the hall
	*/
	public int numSeatsAvailable()
	{
		return 0;
	}

	/** @return the total revenue for the show based upon tickets sold
	/*  The first 5 rows go for $40 each
	/*  The next 5 rows are just $20 each
	*/
	public int getTotalRevenue()
	{
		int total = 0;


		return total;
	}

	/** Reserve the first 2 adjacent seats and return true if successful
	/*	If two adjacent seats could not be found, leave the state of the show unchanged
	/*  and return false.
	/*  return true if two adjacent seats were found, false otherwise
	*/
	public boolean getTwoTogether()
	{
		return false;
	}

	/** Return the lowest seat number in the specified row for a block
	/*  of adjacent seats.  If no such block exists, return -1.
	/*  @param row the row number to check
	/*  @param seatsNeeded the number of adjacent empty seats needed
	/*  @return lowest seat number for a block of contiguous adjacent seats of the given size
	/*  or -1 if no such block exists
	*/
	public int findAdjacent(int row, int seatsNeeded)
	{
		int index = 0, count = 0, lowIndex = 0;


		return -1;
	}

	/** If a seat is available show a 'O', if occumpied show an 'X'
	/* 	return a String with one row per line
	*/
	public String toString()
	{
		String result = "AP Concert Hall - Simplified\n";

		return result;
	}
}



