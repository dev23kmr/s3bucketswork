package org.s3.buckets.utils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.io.File;
import java.util.List;

public class S3BucketUtil {


  static String accessKey = "AKIA6C3VAZ7PQFAO3RWF";
  static String secretKey = "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";

    public static AmazonS3 s3_connect(){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();

    }

    public static void createBucket(String bucketName){

          s3_connect().createBucket(bucketName);

    }

    public static void deleteBucket(String bucketName){

        s3_connect().deleteBucket(bucketName);

    }

    public static void listBuckets(){
        List<Bucket> bucketList = s3_connect().listBuckets();

        bucketList.forEach(bucket -> System.out.println(bucket.getName()));
    }


    public static void uploadFile(String bucket, File file){
        s3_connect().putObject(bucket,"",file);
    }
    public static void main(String[] args) {
     //   createBucket("s3-bucket-4-practice");
     //   createBucket("s3-bucket-5-practice");
        listBuckets();
        File file = new File("C:\\Users\\deykm\\Downloads\\people-100.csv");
        uploadFile("s3-bucket-4-practice", file );
       // deleteBucket("s3-bucket-4-practice");
    }



}
