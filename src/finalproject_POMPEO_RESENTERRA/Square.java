package finalproject_POMPEO_RESENTERRA;

public class Square {

	private SquareState state;
	private int i, j;
	private Player player;
	private int check=0;
	
	public Square(int i, int j, SquareState state) {
		this.i = i;
		this.j = j;
		this.state  = state; 
	}
	

	public SquareState getState() {
		
		return this.state;
	}

	public void setState(SquareState state2) {
		this.state = state2;
		
	}
	
	public int getCheck() {
		
		return this.check;
	}
	
	public void setCheck(int check) {
		this.check = check;
		
	}
	
	public Player getPlayer() {
		
		return this.player;
	}
	
	public void setPlayer(Player player2) {
		this.player = player2;
	}


	}
