package com.multiple.common.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.multiple.common.exception.FileNameException;
import com.multiple.common.exception.NoSuchImageException;
import com.multiple.common.model.ImageMaster;
import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.SystemException;


/**
 * Service interface for Image.
 * 
 * @author Priyanka,Debjyoti Nath
 */
public interface ImageService {
	
	/**
	 * Saves restaurant Image im imageMaster db and on disk location specified in the imageProperties.properties file
	 * 
	 * @param imageInByteArray :image in byte array
	 * @param fileFormat :format to save the image in
	 * @param fileName :the file is saved on disk with the specified name appended with the datetime to handle same file name problem
	 * @param saveDirStructure an array representing the directory structure where the file will be saved
	 * @return {@link ImageMaster} object that was saved is returned to be used with the restaurants  
	 * 
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 * @author Priyanka,Debjyoti Nath
	 */
	ImageMaster addInstitutionImage(byte[] imageInByteArray,String fileFormat,String fileName,boolean applyWaterMark,int...saveDirStructure) throws SystemException,BusinessException,IOException;
	
	/**
	 * Saves restaurant Image im imageMaster db and on disk location specified in the imageProperties.properties file
	 * 
	 * @param imageInByteArray :image in byte array
	 * @param fileFormat :format to save the image in
	 * @param fileName :the file is saved on disk with the specified name appended with the datetime to handle same file name problem
	 * @param saveDirStructure an array representing the directory structure where the file will be saved
	 * @return {@link ImageMaster} object that was saved is returned to be used with the restaurants  
	 * 
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 * @author Priyanka,Debjyoti Nath
	 */
	ImageMaster addInstitutionImage(byte[] imageInByteArray,String fileFormat,String fileName,boolean memberProfileImage,boolean applyWaterMark,String...saveDirStructure) throws SystemException,BusinessException,IOException;
	
	
	/**
	 * Saves Menu Image im imageMaster db and on disk location specified in the imageProperties.properties file
	 * 
	 * @param imageInByteArray :image in byte array
	 * @param fileFormat :format to save the image in
	 * @param fileName :the file is saved on disk with the specified name appended with the datetime to handle same file name problem
	 * @param saveDirStructure an array representing the directory structure where the file will be saved
	 * @return {@link ImageMaster} object that was saved is returned to be used with the restaurants  
	 * 
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 * @author Priyanka,Debjyoti Nath
	 */
	ImageMaster addMenuImage(byte[] imageInByteArray,String fileFormat,String fileName,int...saveDirStructure) throws SystemException,BusinessException,IOException;
	
	/**
	 * Saves Menu Image im imageMaster db and on disk location specified in the imageProperties.properties file
	 * 
	 * @param imageInByteArray :image in byte array
	 * @param fileFormat :format to save the image in
	 * @param fileName :the file is saved on disk with the specified name appended with the datetime to handle same file name problem
	 * @param saveDirStructure an array representing the directory structure where the file will be saved
	 * @return {@link ImageMaster} object that was saved is returned to be used with the restaurants  
	 * 
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 * @author Priyanka,Debjyoti Nath
	 */
	ImageMaster addMenuImage(byte[] imageInByteArray,String fileFormat,String fileName,String...saveDirStructure) throws SystemException,BusinessException,IOException;
	
	/**
	 * Saves Evite Image im imageMaster db and on disk location specified in the imageProperties.properties file
	 * 
	 * @param imageInByteArray :image in byte array
	 * @param fileFormat :format to save the image in
	 * @param fileName :the file is saved on disk with the specified name appended with the datetime to handle same file name problem
	 * @param saveDirStructure an array representing the directory structure where the file will be saved
	 * @return {@link ImageMaster} object that was saved is returned to be used with the restaurants  
	 * 
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 * @author Priyanka,Debjyoti Nath
	 */
	ImageMaster addEviteImage(byte[] imageInByteArray,String fileFormat,String fileName,int...saveDirStructure) throws SystemException,BusinessException,IOException;
	
	
	/**
	 * Deletes the image from its physical location as well as from the database
	 * 
	 * @param imageId
	 * @return String location of the file deleted
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchImageException
	 * 
	 * @author Debjyoti Nath
	 */
	String delete(long imageId) throws UnsupportedEncodingException, NoSuchImageException;
	
	ImageMaster restore(long imageId);
	
	/**
	 * This method updates the existing restaurant image to the new image and deletes the previous image saved 
	 * 
	 * @param oldImageId 
	 * @param imageInByteArray new image as byte array
	 * @param fileFormat
	 * @param fileName
	 * @return an object of {@link ImageMaster} containing the information of the updated file
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 *  @author Debjyoti Nath
	 */
	ImageMaster updateRestaurantImage(long oldImageId,byte[] imageInByteArray,String fileFormat,String fileName) throws SystemException,BusinessException,IOException;
	
	/**
	 * This method updates the existing Menu image to the new image and deletes the previous image saved 
	 * 
	 * @param oldImageId 
	 * @param imageInByteArray new image as byte array
	 * @param fileFormat
	 * @param fileName
	 * @return an object of {@link ImageMaster} containing the information of the updated file
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 *  @author Debjyoti Nath
	 */
	ImageMaster updateMenuImage(long oldImageId,byte[] imageInByteArray,String fileFormat,String fileName) throws SystemException,BusinessException, IOException;
	
	/**
	 * This method updates the existing evite image to the new image and deletes the previous image saved 
	 * 
	 * @param oldImageId 
	 * @param imageInByteArray new image as byte array
	 * @param fileFormat
	 * @param fileName
	 * @return an object of {@link ImageMaster} containing the information of the updated file
	 * @throws SystemException
	 * @throws BusinessException
	 * @throws IOException
	 * 
	 * @author Debjyoti Nath
	 */
	ImageMaster updateEviteImage(long oldImageId,byte[] imageInByteArray,String fileFormat,String fileName) throws SystemException,BusinessException, IOException;
	
	/**
	 * Gets the ImageMaster object,which contains the image information, with the specified id
	 * @param imageId
	 * @return the {@link ImageMaster} Object associated with the id
	 * @throws NoSuchImageException
	 * 
	 * @author Priyanka,Debjyoti Nath
	 */
	ImageMaster findById(long imageId) throws NoSuchImageException;

	ImageMaster addAdImage(byte[] imageInByteArray, String fileFormat,
			String fileName, String...saveDirStructure) throws SystemException,
			BusinessException, IOException;

	ImageMaster addInstructorImage(byte[] bytes, String ext, String fileName,
			boolean b, boolean applyWaterMark, String...saveDirStructure) throws FileNameException,BusinessException, IOException;

	ImageMaster updateInstructorImage(Long imageId, byte[] byteArray,
			String ext, String filename) throws  IOException,BusinessException, UnsupportedEncodingException;


	ImageMaster addInstitutionPdf(byte[] imageInByteArray,String fileFormat,String fileName,String... saveDirStructure) throws SystemException,BusinessException,IOException;
	
//	/**
//	 * This method returns the ImageMaster object with the specified id,but with its path appended with the host.Example if the file path is  
//	 * @param imageId
//	 * @return
//	 * @throws NoSuchImageException
//	 */
//	ImageMaster findByIdWithHost(long imageId) throws NoSuchImageException;
	
	
	
	
}
