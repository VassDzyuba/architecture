package ua.edu.khpi.infiz.ikm222d;

public class YouTubeUploaderFacade {

  private final AviToYouTubeConvertor aviToYouTubeConvertor = new AviToYouTubeConvertor();
  private final Mp4ToYouTubeConvertor mp4ToYouTubeConvertor = new Mp4ToYouTubeConvertor();
  private final String apiKey;

  public YouTubeUploaderFacade(final String apiKey) {
    this.apiKey = apiKey;
  }

  public void upload(final String filename) {
    final String converted = convert(filename);
    final YouTubeAPI api = new YouTubeAPI(apiKey);
    api.authenticate();
    api.uploadVideo(converted);
  }

  private String convert(final String filename) {
    final String extension = filename.substring(filename.lastIndexOf(".") + 1);
    switch (extension) {
      case "avi":
        return aviToYouTubeConvertor.convert(filename);
      case "mp4":
        return mp4ToYouTubeConvertor.convert(filename);
      default:
        break;
    }
    return filename;
  }

}
