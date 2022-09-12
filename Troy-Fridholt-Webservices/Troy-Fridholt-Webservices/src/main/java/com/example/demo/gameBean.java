package com.example.demo;

public class gameBean {

	//Flyttar rad 7-9 till rad 6 för förenklad läsning och mindre kod.
	private int games = 0 , win = 0 , loss = 0 , tie = 0
	/*private int win = 0;
	private int loss = 0;
	private int tie = 0;*/
	
	
	public void addResult(String matchResult)
	{
		games += 1;

		switch (matchResult)
		{
		case "win":
			win += 1;
			break;
		case "loss":
			loss += 1;
			break;
		case "tie":
			tie += 1;
			break;
		}
	}
	public String toJsonString() {
		String pattern = "{ \"Games Played\": \"%s\", \"Wins\": \"%s\", \"Losses\": \"%s\", \"Ties\": \"%s\" }";

		String out = String.format(pattern, Integer.toString(this.games), this.win, this.loss, this.tie);

		return out;
	}
}
