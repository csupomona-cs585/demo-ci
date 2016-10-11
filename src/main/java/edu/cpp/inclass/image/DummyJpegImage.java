package edu.cpp.inclass.image;

public class DummyJpegImage extends JpegImage {

	public DummyJpegImage() {
		super("");
	}
	
	public DummyJpegImage(String url) {
		super(url);
	}
	
	@Override
	public byte[] getImageData() {
		return new byte[] {1, 2, 3};
	}

}
