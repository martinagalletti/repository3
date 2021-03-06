package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import imageloader.ImageLoader;
import map.Map;

/**
 * @author Faustine & Martina
 * 
 *         The Assets class is used to load the images just once and not for
 *         each new NotMovings created. Make sure to do Project > Properties >
 *         Java build path > Libraries > Add class folder and tick "resources".
 *         Also press F5 to refresh the textures folder if needed.
 * 
 */

public class Assets {
	// Constants
	private static final int WIDTH = GameApplication.WIDTH / Map.SIZE_MAP; /**< image width */
	private static final int HEIGHT = GameApplication.WIDTH / Map.SIZE_MAP; /**< image height (square = same as width) */

	// Images
	public static BufferedImage TARZAN_JANE; /**< image for start panel */
	public static BufferedImage TARZAN_NORMAL; /**< image Tarzan */
	public static BufferedImage KAVURUS; /**< image Kavurus */
	public static BufferedImage KNIFE; /**< image knife */ 
	public static BufferedImage BANANA; /**< image Banana */
	public static BufferedImage JAGUAR; /**< image Jaguar */
	public static BufferedImage JANE; /**< image Jane */

	/**
	 * Load images from files and resize it to tile size.
	 */
	public static void init() {
		BufferedImage TARZAN_NORMAL0 = ImageLoader.loadImage("/textures/tarzan_normal.gif");
		TARZAN_NORMAL = resize(TARZAN_NORMAL0);

		BufferedImage JAGUAR0 = ImageLoader.loadImage("/textures/jaguar.gif");
		JAGUAR = resize(JAGUAR0);

		BufferedImage BANANA0 = ImageLoader.loadImage("/textures/banana.gif");
		BANANA = resize(BANANA0);

		BufferedImage KAVURUS0 = ImageLoader.loadImage("/textures/pill.gif");
		KAVURUS = resize(KAVURUS0);

		BufferedImage KNIFE0 = ImageLoader.loadImage("/textures/knife.gif");
		KNIFE = resize(KNIFE0);

		BufferedImage JANE0 = ImageLoader.loadImage("/textures/jane.gif");
		JANE = resize(JANE0);
	}

	/**
	 * Resize images to the size of a tile.
	 * @return BufferedImage
	 */
	private static BufferedImage resize(BufferedImage img) {
		Image tmp = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return dimg;
	}

	/**
	 * Called in render in World to get the image corresponding to the desired NonMoving.
	 * @return BufferedImage
	 */
	public static BufferedImage getImageFromString(String s) {
		switch (s) {
		case "JAGUAR":
			return Assets.JAGUAR;
		case "KAVURUS":
			return Assets.KAVURUS;
		case "BANANA":
			return Assets.BANANA;
		case "KNIFE":
			return Assets.KNIFE;
		case "JANE":
			return Assets.JANE;
		default:
			throw new RuntimeException("Unknown image");
		}
	}
}
