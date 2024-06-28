package com.whim.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Jince
 * date: 2024/6/28 下午11:38
 * description: 文件工具类
 */
public class FileUtils {
    public final static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-|.\\u4e00-\\u9fa5]+";

    /**
     * MultipartFile转换File
     *
     * @param multipartFile multipart file
     * @return File
     * @throws IOException 异常
     */
    public static File multipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        }
        return file;
    }

    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename) {
        return filename.matches(FILENAME_PATTERN);
    }
}
