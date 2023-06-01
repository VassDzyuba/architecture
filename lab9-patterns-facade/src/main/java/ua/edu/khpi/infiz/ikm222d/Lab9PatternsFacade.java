package ua.edu.khpi.infiz.ikm222d;

public class Lab9PatternsFacade {

  public static void main(final String[] args) {
    new Lab9PatternsFacade().demo();
  }

  private void demo() {
    final String filenameAvi = "video.avi";
    final String filenameMp4 = "video.mp4";
    final String apiKey = "apiKey123";
    YouTubeUploaderFacade uploader = new YouTubeUploaderFacade(apiKey);
    uploader.upload(filenameAvi);
    uploader.upload(filenameMp4);
  }

}
