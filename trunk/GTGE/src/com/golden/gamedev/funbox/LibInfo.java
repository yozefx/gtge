/*
 * Copyright (c) 2008 Golden T Studios.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.golden.gamedev.funbox;

// JFC
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.GameFont;


/**
 * Class to inform beginner GTGE users that GTGE is a library, thus it can't be
 * run by double clicking it like a normal application, GTGE does not have
 * any GUI/form/frame.
 */
public class LibInfo extends Game {


	private GameFont font1, font2, font3, font4;


	/**
	 * <code>LibInfo</code> class constructor, do nothing.
	 */
	public LibInfo() {
	}

	public void initResources() {
		setFPS(10);
		showCursor();

		font1 = fontManager.getFont(new Font("Verdana", Font.BOLD, 32));
		font2 = fontManager.getFont(new Font("Verdana", Font.BOLD, 18));
		font3 = fontManager.getFont(new Font("Verdana", Font.BOLD, 15));
		font4 = fontManager.getFont(new Font("Verdana", Font.PLAIN, 15));
	}

	public void update(long elapsedTime) {
		if ((keyPressed(KeyEvent.VK_ENTER)) ||
			(keyPressed(KeyEvent.VK_ESCAPE)) ||
			(keyDown(KeyEvent.VK_ALT) && keyPressed(KeyEvent.VK_F4))) {
			finish();
		}
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.WHITE);

		// use anti-alias, for smoothh text
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						   RenderingHints.VALUE_ANTIALIAS_ON);

		int y = 20, lineHeight = font1.getHeight();
		font1.drawString(g, "GOLDEN T GAME ENGINE", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 5;
		font1.drawString(g, "[ G T G E ]", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 8;

		lineHeight = font2.getHeight();
		font2.drawString(g, "is", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 12;
		font2.drawString(g, "A Java Game Library / Game SDK", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 28;

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						   RenderingHints.VALUE_ANTIALIAS_OFF);

		lineHeight = font3.getHeight();
		font3.drawString(g, "Thus, you need to code the game", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 4;
		font3.drawString(g, "in order to make a game with GTGE", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 18;

		font3.drawString(g, "Please read GTGE tutorials for", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 4;
		font3.drawString(g, "installation and how to use this library", GameFont.CENTER, 0, y, getWidth());
		y += lineHeight + 32;

		lineHeight = font4.getHeight();
		font4.drawString(g, "Regards,", 95, y);
		y += lineHeight + 18;
		font4.drawString(g, "Paulus Tuerah", 95, y);
		y += lineHeight + 2;
		font4.drawString(g, "Golden T Game Engine Developer", 95, y);
		y += lineHeight + 2;
		font4.drawString(g, "http://www.goldenstudios.or.id/", 95, y);
	}


 /****************************************************************************/
 /***************************** CONSTRUCTOR **********************************/
 /****************************************************************************/

	/**
	 * Main method to run this info frame.
	 * @param args Application arguments.
	 */
	public static void main(String[] args) {
		GameLoader game = new GameLoader();
		game.setup(new LibInfo(), new Dimension(600,450), false);
		game.start();
	}

	{ distribute = true; }

}