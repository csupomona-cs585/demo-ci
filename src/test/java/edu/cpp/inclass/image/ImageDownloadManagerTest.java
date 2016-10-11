package edu.cpp.inclass.image;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Test;

public class ImageDownloadManagerTest {

	@Test
	public void testDownloadImageWithCounterUpdate() {
		ImageDownloadManager imageDownloadManager = new ImageDownloadManager();
	
		int prevCounterValue = imageDownloadManager.getCounter();
		//imageDownloadManager.downloadImage(new JpegImage("http://www.cpp.edu/logo.jpeg"));
		imageDownloadManager.downloadImage(new DummyImage());
		Assert.assertEquals(prevCounterValue + 1, imageDownloadManager.getCounter());
	}
	
	@Test
	public void testGetLatestDownloadedImageData() {
		ImageDownloadManager imageDownloadManager = new ImageDownloadManager();
		//imageDownloadManager.downloadImage(new JpegImage("http://www.cpp.edu/logo.jpeg"));
		imageDownloadManager.downloadImage(new JpegImageStub());
		byte[] imageData = imageDownloadManager.getLatestDownloadedImageData();
		Assert.assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 6}, imageData);
	}
	
	@Test
	public void testGetLatestDownloadedImageDataWithMockito() {
		ImageDownloadManager imageDownloadManager = new ImageDownloadManager();
		
		Image testJpegImage = mock(Image.class);
		when(testJpegImage.getImageData()).thenReturn(new byte[] {1, 2, 3, 4, 5, 6});
		
		imageDownloadManager.downloadImage(testJpegImage);
		byte[] imageData = imageDownloadManager.getLatestDownloadedImageData();
		Assert.assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 6}, imageData);
	}
	
	@Test
	public void testGetLatestDownloadedImageDataWithNullDownloadedImageData() {
		try {
			ImageDownloadManager imageDownloadManager = new ImageDownloadManager();
			imageDownloadManager.downloadImage(new NullJpegImage());
			Assert.fail("Expect to see the RuntimeException.");
		} catch (RuntimeException e) {
			
		}
	}
	
	@Test
	public void testLogImageMetaDataInfo() {
		Image testImage = mock(Image.class);
		when(testImage.getImageData()).thenReturn(new byte[]{12,3,4});
		ImageDownloadManager imageDownloadManager = new ImageDownloadManager();
		imageDownloadManager.logImageMetaDataInfo(testImage);
		//verify(testImage).getImageMetaData();
	}
	
	@Test
	public void testGetLatestDownloadedImageDataWithNullDownloadedImageDataWithMockito() {
		try {
			Image imageThrowException = mock(Image.class);
			when(imageThrowException.getImageData()).thenThrow(RuntimeException.class);
			
			ImageDownloadManager imageDownloadManager = new ImageDownloadManager();
			imageDownloadManager.downloadImage(imageThrowException);
			Assert.fail("Expect to see the RuntimeException.");
		} catch (RuntimeException e) {
			
		}
	}
}
