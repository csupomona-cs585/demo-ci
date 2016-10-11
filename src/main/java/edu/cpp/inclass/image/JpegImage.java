package edu.cpp.inclass.image;

public class JpegImage implements Image {

	private String url;
		
	public JpegImage(String url) {
		super();
		this.url = url;
	}

	public byte[] getImageData() {
		// download the data from the url
		
		// form a jpeg image
		byte[] res = null;
		return res;
	}

	public String getImageMetaData() {
		// TODO Auto-generated method stub
		return null;
	}

}
