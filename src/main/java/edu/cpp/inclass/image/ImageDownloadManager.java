package edu.cpp.inclass.image;

public class ImageDownloadManager {

	private byte[] buffer; // = new byte[1024];

	private int counter;

	public void downloadImage(Image image) {
		try {
			byte[] downloadedData = image.getImageData();
			if (downloadedData != null) {
				buffer = new byte[Math.min(1024, downloadedData.length)];
				for(int i = 0; i < Math.min(1024, downloadedData.length); i++) {
					buffer[i] = downloadedData[i];
				}		
				counter++;
			} else {
				throw new RuntimeException("The image was not downloaded correctly.");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Failed to download the image data.");
		}

	}
	
	private boolean verifyImageData(Image image) {
		return image.getImageData() == null ? false : true;
	}
	
	public void logImageMetaDataInfo(Image image) {				
		if (!verifyImageData(image)) {
			System.out.println("Logging the meta data info for the image");
			System.out.println(image.getImageMetaData());		
		}
	}

	public byte[] getLatestDownloadedImageData() {		
		return buffer;
	}

	public int getCounter() {
		return counter;
	}	

}
