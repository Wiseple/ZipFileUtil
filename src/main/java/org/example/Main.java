package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        String fileContent = ZipFileUtil.unzipEntryToString( "src/main/resources/egovframe-simple-homepage-template-main.zip", "cop/com/service/EgovBBSUseInfoManageService.java");
//        String fileContent = ZipFileUtil.unzipSingleToString( "src/main/resources/sample-in-pc.zip", "cop/com/service/EgovBBSUseInfoManageService.java");
        System.out.println(fileContent);

        fileContent = ZipFileUtil.unzipEntry( "src/main/resources/egovframe-simple-homepage-template-main.zip", "cop/com/service/EgovBBSUseInfoManageService.java");
        fileContent = ZipFileUtil.unzipEntry( "src/main/resources/sample-in-pc.zip", "cop/com/service/EgovBBSUseInfoManageService.java");
        System.out.println(fileContent);

    }
}