package com.multiple.common.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import com.multiple.common.model.ImageMaster;
import com.multiple.common.model.User;
import com.multiple.common.service.ImageService;

public class ImageCropUtil {
	
	static Rectangle clip;
	public static byte [] cropImage(ImageService imgService,ImageMaster image, int x,int y, int w, int h) throws Exception{
		String filePath = User.class.getResource("User.class").getPath();
		filePath = filePath.substring(1, filePath.lastIndexOf("/WEB-INF"));
		filePath = filePath+image.getImagePath();
		filePath = filePath.substring(filePath.indexOf("/")+1);
		BufferedImage originalImage = ImageIO.read(new File(filePath));
		BufferedImage processedImage = cropMyImage(originalImage, w,h,x,y);
		String ext = filePath.substring(filePath.lastIndexOf(".")+1);
		filePath = filePath.substring(0,filePath.lastIndexOf("."));
		filePath = filePath+"_cropped."+ext;
		File outputfile = new File(filePath);
		ImageIO.write(processedImage, ext, outputfile);
		imgService.delete(image.getImageId());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( processedImage, ext, baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}
	
	public static BufferedImage cropMyImage(BufferedImage img, int cropWidth,
			int cropHeight, int cropStartX, int cropStartY) throws Exception {
		BufferedImage clipped = null;
		Dimension size = new Dimension(cropWidth, cropHeight);

		createClip(img, size, cropStartX, cropStartY);

		try {
			int w = clip.width;
			int h = clip.height;
			
			System.out.println("Crop Width " + w);
			System.out.println("Crop Height " + h);
			System.out.println("Crop Location " + "(" + clip.x + "," + clip.y
					+ ")");

			clipped = img.getSubimage(clip.x, clip.y, w, h);

			System.out.println("Image Cropped. New Image Dimension: "
					+ clipped.getWidth() + "w X " + clipped.getHeight() + "h");
		} catch (RasterFormatException rfe) {
			System.out.println("Raster format error: " + rfe.getMessage());
			return null;
		}
		return clipped;
	}
	
	private static void createClip(BufferedImage img, Dimension size,
			int clipX, int clipY) throws Exception {
		/**
		 * Some times clip area might lie outside the original image, fully or
		 * partially. In such cases, this program will adjust the crop area to
		 * fit within the original image.
		 * 
		 * isClipAreaAdjusted flas is usded to denote if there was any
		 * adjustment made.
		 */
		boolean isClipAreaAdjusted = false;

		/** Checking for negative X Co-ordinate **/
		if (clipX < 0) {
			clipX = 0;
			isClipAreaAdjusted = true;
		}
		/** Checking for negative Y Co-ordinate **/
		if (clipY < 0) {
			clipY = 0;
			isClipAreaAdjusted = true;
		}

		/** Checking if the clip area lies outside the rectangle **/
		if ((size.width + clipX) <= img.getWidth()
				&& (size.height + clipY) <= img.getHeight()) {

			/**
			 * Setting up a clip rectangle when clip area lies within the image.
			 */

			clip = new Rectangle(size);
			clip.x = clipX;
			clip.y = clipY;
		} else {

			/**
			 * Checking if the width of the clip area lies outside the image. If
			 * so, making the image width boundary as the clip width.
			 */
			if ((size.width + clipX) > img.getWidth())
				size.width = img.getWidth() - clipX;

			/**
			 * Checking if the height of the clip area lies outside the image.
			 * If so, making the image height boundary as the clip height.
			 */
			if ((size.height + clipY) > img.getHeight())
				size.height = img.getHeight() - clipY;

			/** Setting up the clip are based on our clip area size adjustment **/
			clip = new Rectangle(size);
			clip.x = clipX;
			clip.y = clipY;

			isClipAreaAdjusted = true;

		}
		if (isClipAreaAdjusted)
			System.out.println("Crop Area Lied Outside The Image."
					+ " Adjusted The Clip Rectangle\n");
	}
}

