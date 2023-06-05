package com.ghisoft.mod5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			System.out.println("Move: 1 - Right Right");
			System.out.println("Move: 2 - Right Left");
			System.out.println("Move: 3 - Left Right");
			System.out.println("Move: 4 - Left Left");
			System.out.println("Move: 5 - Split");

			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buff = new BufferedReader(in);

			String command = buff.readLine();
			if (command.equals("1")) {
				g.move(Game.MOVE_RR);
			} else if (command.equals("2")) {
				g.move(Game.MOVE_RL);
			} else if (command.equals("3")) {
				g.move(Game.MOVE_LR);
			} else if (command.equals("4")) {
				g.move(Game.MOVE_LL);
			} else if (command.equals("5")) {
				g.move(Game.MOVE_SPLIT);
			}
		}
		if (g.getActivePlayer() == Game.PLAYER_BLUE) {
			System.out.println("RED won");
		} else {
			System.out.println("BLUE won");
		}

	}

}
