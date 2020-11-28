package com.alex.project.builder.lib;

import java.io.File;

public class SystemUtil {

    //Разделитель пути к файлам
    public static final String fileSeparator = File.separator;

    //Откуда запущена команда
    public static String getCurrentDir() {
        return System.getProperty("user.dir");
    }

}
