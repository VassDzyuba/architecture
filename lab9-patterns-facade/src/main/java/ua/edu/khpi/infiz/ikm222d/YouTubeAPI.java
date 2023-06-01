package ua.edu.khpi.infiz.ikm222d;

public class YouTubeAPI {

  private final String apiKey;

  public YouTubeAPI(final String apiKey) {
    this.apiKey = apiKey;
  }

  public void authenticate() {
    System.out.println("YouTubeAPI::authenticate, apiKey:" + apiKey);
  }

  public void uploadVideo(final String videoPath) {
    System.out.println("YouTubeAPI::uploadVideo, videoPath:" + videoPath);
  }

}
