package com.bloglaptrinh.app.common.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class Config {
    private final static URL classPathUrl = Config.class.getResource("/");
    private final static String classPath = new File(classPathUrl.getFile()).getPath();
    private static String configPath = "/conf/";
    private static Map<String, String> configMap = new HashMap<String, String>();

    static {
        setConfigMap();
    }

    /**
     *
     * @param key
     * @return
     */
    public static String getStr(String key) {
        if (configMap.size() < 0) {
            return null;
        }
        return configMap.get(key);
    }

    /**
     *
     * @param key
     * @return
     */
    public static int getToInt(String key) {
        String val = getStr(key);
        return NumberUtils.parseInt(val);
    }

    /**
     *
     * @param key
     * @return
     */
    public static long getToLong(String key) {
        String val = getStr(key);
        return NumberUtils.parseLong(val);
    }

    /**
     *
     * @param key
     * @return
     */
    public static double getToDbl(String key) {
        String val = getStr(key);
        return NumberUtils.parseDbl(val);
    }

    /**
     *
     * @param key
     * @return
     */
    public static boolean getToBoolean(String key) {
        String val = getStr(key);
        try {
            return Boolean.valueOf(val);
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * @param configPath
     */
    public static void rebuild(String configPath) {
        Config.configPath = configPath;
        rebuild();
    }

    public static void rebuild() {
        setConfigMap();
    }

    public static void test() {
        for (String key : configMap.keySet()) {
            System.out.println(key + "=" + configMap.get(key));
        }
    }

    private static void setConfigMap() {
        String filePath = classPath + configPath;
        filePath = PathUtils.rebuild(filePath);
        List<String> list = findFiles(filePath);

        Map<String, String> tmpConfigMap = new HashMap<String, String>();
        for (String configName : list) {
            Properties props = getProperties(filePath + configName);
            Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
            while (it.hasNext()) {
                Entry<Object, Object> entry = it.next();
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                if (!tmpConfigMap.containsKey(key)) {
                    tmpConfigMap.put(key, value);
                } else {
                    System.err.println("CONFIG EEOR:key(" + key + ") is exist;");
                }
            }
        }

        Config.configMap = tmpConfigMap;
    }

    /**
     *
     * @param fileName
     * @return
     */
    private static Properties getProperties(String fileName) {
        Properties props = new Properties();
        try {
            java.io.InputStream propFile = new FileInputStream(fileName);
            props.load(propFile);
        } catch (IOException e) {
            System.err.println("file read fail:" + fileName);
            e.printStackTrace();
        }
        return props;
    }

    /**
     *
     * @param baseDirName
     * @return
     */
    private static List<String> findFiles(String baseDirName) {
        List<String> configFiles = new ArrayList<String>();
        // 判断目录是否存在
        File baseDir = new File(baseDirName);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            System.err.println("search error：" + baseDirName + " is not a dir！");
        } else {
            String[] filelist = baseDir.list();
            for (String fileName : filelist) {
                if (fileName.endsWith("properties")) {
                    configFiles.add(fileName);
                }
            }
        }
        return configFiles;
    }

}
