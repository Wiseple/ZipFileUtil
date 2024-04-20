package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class ZipFileUtilTest {


    @Test
    void    testUnzipEntryToString() throws IOException {
        // given
        String zipfilepath = "src/main/resources/egovframe-web-sample-main.zip";
        String extractFilePath = "egovframe-web-sample-main/src/main/java/egovframework/example/sample/web/EgovSampleController.java";

        // when
        String content = ZipFileUtil.unzipEntryToString(zipfilepath, extractFilePath);

        // then
        System.out.println(content);
    }

    @Test
    void    testUnzipEntryToString2() throws IOException {
        // given
        String zipfilepath = "src/main/resources/ZipFileUtil.zip";
        String extractFilePath = "egovframe-web-sample-main/src/main/java/egovframework/example/sample/web/EgovSampleController.java";

        // when
        String content = ZipFileUtil.unzipEntryToString(zipfilepath, extractFilePath);

        // then
        System.out.println(content);
    }

}