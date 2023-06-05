package com.ghisoft.mod5;

public class Game {
	private int redLeft;
	private int redRight;
	private int blueLeft;
	private int blueRight;

	private int activePlayer;

	final static int PLAYER_BLUE = 0;
	final static int PLAYER_RED = 1;

	// list of move
	final static int MOVE_LL = 0;
	final static int MOVE_LR = 1;
	final static int MOVE_RL = 2;
	final static int MOVE_RR = 3;
	final static int MOVE_SPLIT = 4;

	public Game() {
		redLeft = 1;
		redRight = 1;
		blueLeft = 1;
		blueRight = 1;

		activePlayer = PLAYER_BLUE;
	}

	public void move(int move) {
		if (activePlayer == PLAYER_BLUE) {
			if (move == MOVE_LL) {
				redLeft = (redLeft + blueLeft) % 5;
			} else if (move == MOVE_LR) {
				redRight = (redRight + blueLeft) % 5;
			} else if (move == MOVE_RL) {
				redLeft = (redLeft + blueRight) % 5;
			} else if (move == MOVE_RR) {
				redRight = (redRight + blueRight) % 5;
			} else if (move == MOVE_SPLIT) {
				if (blueRight == 0) {
					blueLeft = blueLeft / 2;
					blueRight = blueLeft;
				} else {
					blueRight = blueRight / 2;
					blueLeft = blueRight;
				}
			}

			activePlayer = PLAYER_RED;
		} else if (activePlayer == PLAYER_RED) {
			if (move == MOVE_LL) {
				blueLeft = (blueLeft + redLeft) % 5;
			} else if (move == MOVE_LR) {
				blueRight = (blueRight + redLeft) % 5;
			} else if (move == MOVE_RL) {
				blueLeft = (blueLeft + redRight) % 5;
			} else if (move == MOVE_RR) {
				blueRight = (blueRight + redRight) % 5;
			} else if (move == MOVE_SPLIT) {
				if (redRight == 0) {
					redLeft = redLeft / 2;
					redRight = redLeft;
				} else {
					redRight = redRight / 2;
					redLeft = redRight;
				}
			}

			activePlayer = PLAYER_BLUE;

		}
	}

	public boolean checkVictory() {
		if (blueLeft == 0 && blueRight == 0) {
			return true;
		}
		if (redLeft == 0 && redRight == 0) {
			return true;
		}

		return false;
	}

	public int getRedLeft() {
		return redLeft;
	}

	public int getRedRight() {
		return redRight;
	}

	public int getBlueLeft() {
		return blueLeft;
	}

	public int getBlueRight() {
		return blueRight;
	}

	public int getActivePlayer() {
		return activePlayer;
	}

}
