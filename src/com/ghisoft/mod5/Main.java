package com.ghisoft.mod5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Game g = new Game();

		while (!g.checkVictory()) {
			if (g.getActivePlayer() == g.PLAYER_BLUE) {
				System.out.println("BLUE ***");
			} else {
				System.out.println("BLUE");
			}

			System.out.println("Right: " + g.getBlueRight() + "\tLeft: " + g.getBlueLeft());

			System.out.println();
			System.out.println();

			System.out.println("Left: " + g.getRedLeft() + "\tRight: " + g.getRedRight());

			if (g.getActivePlayer() == Game.PLAYER_RED) {
				System.out.println("RED ***");
			} else {
				System.out.println("RED");
			}

			System.out.println();
			printAvailableMoves(g.getAvailableMoves());

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buff = new BufferedReader(in);

			String command = buff.readLine();
			if (command.equals("3")) {
				g.move(Game.MOVE_RR);
			} else if (command.equals("2")) {
				g.move(Game.MOVE_RL);
			} else if (command.equals("1")) {
				g.move(Game.MOVE_LR);
			} else if (command.equals("0")) {
				g.move(Game.MOVE_LL);
			} else if (command.equals("4")) {
				g.move(Game.MOVE_SPLIT);
			}
		}
		if (g.getActivePlayer() == Game.PLAYER_BLUE) {
			System.out.println("RED won");
		} else {
			System.out.println("BLUE won");
		}

	}

	public static void printAvailableMoves(List<Integer> moves) {
		for (int m : moves) {
			switch (m) {
			case Game.MOVE_RR:
				System.out.println("Move: " + Game.MOVE_RR + " - Right Right");
				break;
			case Game.MOVE_RL:
				System.out.println("Move: " + Game.MOVE_RL + " - Right Left");
				break;
			case Game.MOVE_LR:
				System.out.println("Move: " + Game.MOVE_LR + " - Left Right");
				break;
			case Game.MOVE_LL:
				System.out.println("Move: " + Game.MOVE_LL + " - Left Left");
				break;
			case Game.MOVE_SPLIT:
				System.out.println("Move: " + Game.MOVE_SPLIT + " - Split");
				break;
			}

		}
	}

}
