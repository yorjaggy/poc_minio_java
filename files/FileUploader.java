// Documentation https://docs.min.io/docs/java-client-api-reference.html
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class FileUploader {
  public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
    try {
      // Create a minioClient with the MinIO Server name, Port, Access key and Secret key.
      MinioClient minioClient = new MinioClient("*.icesi.edu.co",9992, "<>", "<>", false);

      // Check if the bucket already exists.
      boolean isExist = minioClient.bucketExists("guaralrpc");
      if(isExist) {
        System.out.println("Bucket already exists.");
      } else {
        // Make a new bucket called asiatrip to hold a zip file of photos.
        minioClient.makeBucket("guaralrpc");
      }

      // Upload the zip file to the bucket with putObject
      minioClient.putObject("guaralrpc","testfile.csv", "testfile.csv");
      System.out.println("testfile.csv is successfully uploaded as testfile.csv to `guaralrpc` bucket.");
    } catch(MinioException e) {
      System.out.println("Error occurred: " + e);
    }
  }
}