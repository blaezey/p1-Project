
public class coordinate {
	private char room;
	private int row, col;
	
	public coordinate(char room, int x, int y) {
		this.room = room;
		row = x;
		col = y;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public char getRoom() {
		return room;
	}
	
	public void setRoom(char room) {
		this.room = room;
	}
	
}
