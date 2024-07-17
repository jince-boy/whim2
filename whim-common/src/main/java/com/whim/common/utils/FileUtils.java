package com.whim.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
     * 此转换会创建临时文件，请注意，可以配合try-with-resources来一起使用
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

    /**
     * 获取文件的扩展名
     *
     * @param filename 文件名
     * @return 扩展名（不包含点），如果没有扩展名则返回空字符串
     */
    public static String getExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "";
        }

        int lastDotIndex = filename.lastIndexOf('.');

        // 没有找到点，或者点在第一个字符，则认为没有扩展名
        if (lastDotIndex == -1 || lastDotIndex == 0 || lastDotIndex == filename.length() - 1) {
            return "";
        }

        return filename.substring(lastDotIndex + 1);
    }

    /**
     * 检查文件是否为空
     *
     * @param file 要检查的文件
     * @return 如果文件为空或不存在，则返回true，否则返回false
     */
    public static boolean isEmpty(File file) {
        // 检查文件是否存在，是否是文件，以及长度是否为0
        return file == null || !file.exists() || !file.isFile() || file.length() == 0;
    }

    /**
     * 检查文件是否安全，避免路径遍历等安全问题。
     */
    public static boolean isFileSafe(Resource resource) throws IOException {
        // 检查文件路径是否包含非法字符，实际项目中需要根据具体情况定义“安全”的文件路径
        String path = resource.getFile().getPath();
        return !path.contains("..") && !path.startsWith("/");
    }

    /**
     * 检测路径是否在windows系统下，并且是有效路径
     *
     * @param basePath 路径
     * @return true是windows系统下并且为有效路径, false不是windows系统
     */
    public static boolean isWindowsAndValidPath(String basePath) {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.contains("win") && basePath.matches("^[a-zA-Z]:.*");
    }
    /**
     * 根据操作系统和提供的 basePath 生成绝对路径。
     *
     * @param basePath 要转换为绝对路径的基础路径
     * @return 绝对路径
     */
    public static Path generateAbsolutePath(String basePath) {
        Path absoluteBasePath;
        if (isWindowsAndValidPath(basePath)) {
            // Windows 系统并且 basePath 是绝对路径
            absoluteBasePath = Paths.get(basePath).toAbsolutePath().normalize();
        } else {
            // 非 Windows 系统或者 basePath 不是绝对路径
            // 在 basePath 前加上 "/" 确保获取的是绝对路径
            absoluteBasePath = Paths.get(StringUtils.prependIfMissing(basePath, "/")).toAbsolutePath().normalize();
        }
        return absoluteBasePath;
    }
}
