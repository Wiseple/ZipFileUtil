package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class ZipFileUtil {


    static public String unzipEntryToString( String zipfilepath, String extractFilePath) throws IOException {

        String content = null;
        InputStream is =  new FileInputStream( new File(zipfilepath) );

        ZipArchiveInputStream zis ;
        ZipArchiveEntry entry = null;
        String name ;

        byte [] buf = new byte[1024 * 8];
        zis = new ZipArchiveInputStream(is);

        File file = new File(zipfilepath);
        int fileSize = (int) file.length();

        System.out.println("fileSize : " + fileSize);

        while ( (entry = zis.getNextZipEntry()) != null ){
            name = entry.getName();
            System.out.println("entry name : " + name);
            if( StringUtils.equals(name, extractFilePath)) {
                buf = zis.readAllBytes();
                content = new String(buf, 0, buf.length);
                break;
            }
        }
        return content;
    }

    static public String unzipEntryToStringUtf( String zipfilepath, String extractFilePath) throws IOException {

        String content = null;
        InputStream is =  new FileInputStream( new File(zipfilepath) );

        ZipArchiveInputStream zis ;
        ZipArchiveEntry entry = null;
        String name ;
        File target ;
        int nWritten = 0;
        BufferedOutputStream bos ;
        byte [] buf = new byte[1024 * 8];
        zis = new ZipArchiveInputStream(is, StandardCharsets.UTF_8.toString());

        File file = new File(zipfilepath);
        int fileSize = (int) file.length();

        System.out.println("fileSize : " + fileSize);

        while ( (entry = zis.getNextZipEntry()) != null ){
            name = entry.getName();
            System.out.println("entry name : " + name);
            if( StringUtils.equals(name, extractFilePath)) {
                buf = zis.readAllBytes();
                content = new String(buf, 0, buf.length, StandardCharsets.UTF_8);
                break;
            }
        }
        return content;
    }

    static public String unzipEntry( String zipfilepath, String extractFilePath) throws IOException {
        String content = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

//        InputStream is =  new FileInputStream( new
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipfilepath));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            System.out.println( "zipEntry.getName() : " + zipEntry.getName() );
            if( StringUtils.contains( zipEntry.getName(), extractFilePath)) {
                byte[] buf = zis.readAllBytes();
                bos.write(buf, 0, buf.length);
                byte[] zipFileBytes = bos.toByteArray();

                content = new String(zipFileBytes, 0, zipFileBytes.length,StandardCharsets.UTF_8);
                System.out.println( content );
            }
            zipEntry = zis.getNextEntry();
        }
        return content;
    }



    static public String checkEncoding( byte[] contentBuffer ) {
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData( contentBuffer, 0, contentBuffer.length);
        detector.dataEnd();

        String encoding = detector.getDetectedCharset();
        detector.reset();
        return encoding;
    }


}
