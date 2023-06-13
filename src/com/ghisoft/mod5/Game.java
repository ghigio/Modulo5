package com.ghisoft.mod5;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Player red;
	private Player blue;

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
		red = new Player();
		blue = new Player();

		activePlayer = PLAYER_BLUE;
	}

	public void move(int move) {
		Player active, opponent;
		if (activePlayer == PLAYER_BLUE) {
			active = blue;
			opponent = red;
			activePlayer = PLAYER_RED;
		} else {
			active = red;
			opponent = blue;
			activePlayer = PLAYER_BLUE;
		}

		if (move == MOVE_LL) {
			opponent.left = (opponent.left + active.left) % 5;
		} else if (move == MOVE_LR) {
			opponent.right = (opponent.right + active.left) % 5;
		} else if (move == MOVE_RL) {
			opponent.left = (opponent.left + active.right) % 5;
		} else if (move == MOVE_RR) {
			opponent.right = (opponent.right + active.right) % 5;
		} else if (move == MOVE_SPLIT) {
			if (active.right == 0) {
				active.left = active.left / 2;
				active.right = active.left;
			} else {
				active.right = active.right / 2;
				active.left = active.right;
			}
		}

	}

	public boolean checkVictory() {
		if (blue.left == 0 && blue.right == 0) {
			return true;
		}
		if (red.left == 0 && red.right == 0) {
			return true;
		}

		return false;
	}

	public List<Integer> getAvailableMoves() {
		Player active, opponent;
		if (activePlayer == PLAYER_BLUE) {
			active = blue;
			opponent = red;
		} else {
			active = red;
			opponent = blue;
		}

		List<Integer> moves = new ArrayList<Integer>();

		if (active.left != 0) {
			if (opponent.left != 0) {
				moves.add(MOVE_LL);
			}
			if (opponent.right != 0) {
				moves.add(MOVE_LR);
			}

		}
		if (active.right != 0) {
			if (opponent.left != 0) {
				moves.add(MOVE_RL);
			}
			if (opponent.right != 0) {
				moves.add(MOVE_RR);
			}

		}
		if ((active.left == 0 && active.right % 2 == 0) || (active.left % 2 == 0 && active.right == 0)) {
			moves.add(MOVE_SPLIT);
		}

		return moves;
	}

	public int getRedLeft() {
		return red.left;
	}

	public int getRedRight() {
		return red.right;
	}

	public int getBlueLeft() {
		return blue.left;
	}

	public int getBlueRight() {
		return blue.right;
	}

	public int getActivePlayer() {
		return activePlayer;
	}

}
