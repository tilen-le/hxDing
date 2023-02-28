package com.hexing.common.utils;


import com.hexing.common.exception.base.BaseException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.rmi.ServerException;
import java.util.*;

/**
 * @author 80010641
 */
@Component
public class SensitiveWordFilter implements ApplicationRunner {

    private static final String filePath = "/dic/sensitive.txt";

    private static Map<String, String> sensitiveWordsMap;

    //最小匹配规则
    private static Integer minMatchType = 1;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Set<String> wordList = readSensitiveWordsFile();
        addSensitiveWordsToHashMap(wordList);
    }


    private static Set<String> readSensitiveWordsFile() {
        Resource file = new ClassPathResource(filePath);
        Set<String> result = new HashSet<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file.getFile()));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.add(s);
            }
            br.close();
        } catch (Exception e) {
           throw new BaseException("敏感词文件解析异常" + e.getMessage());
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch ( Exception e){
                }
            }
        }
        return result;

    }

    /** * 将敏感词加入HashMap */
    private static void addSensitiveWordsToHashMap(Set<String> sensitiveWords) {
        sensitiveWordsMap = new HashMap(sensitiveWords.size());
        String word = null;
        Map childMap = null;
        Map<String,String> newWordMap = null;
        Iterator<String> iterator = sensitiveWords.iterator();
        while (iterator.hasNext()){
            //关键字
            word = iterator.next();
            childMap = sensitiveWordsMap;
            //遍历该关键字
            for (int i = 0; i < word.length();i++){
                char key = word.charAt(i);
                Object wordMap = childMap.get(key);
                if(wordMap != null){
                    childMap = (Map)wordMap;
                } else {
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd", "0");
                    childMap.put(key, newWordMap);
                    //指向当前map,继续遍历
                    childMap = newWordMap;
                }
                if(i == word.length() - 1){
                    //最后一个
                    childMap.put("isEnd", "1");
                }
            }
        }
    }


    /**
     * 判断文本是否包含关键字
     * @param txt 待判断文本
     * @param matchType 匹配类型 1 最小匹配原则；2 最大匹配原则
     * @return true 包含；false 不包含
     */
    public static Boolean isContainsSensitiveWords(String txt, Integer matchType){
        if(txt == null || "".equals(txt)){
            return false;
        }
        txt = txt.replace(" ","");
        for(int i = 0; i < txt.length();i++){
            Integer matchFlag = checkSensitiveWords(txt, i , matchType);
            if(matchFlag > 0){
                return true;
            }
        }
        return false;
    }

    /**
     * 校验是否包含敏感词
     * @param txt 待判断文本
     * @param start 起始位置
     * @param matchType 匹配类型： 1 最小匹配原则；2 最大匹配原则
     * @return 大于0表示包含敏感词且表示敏感词匹配长度，否则不包含
     */
    private static Integer checkSensitiveWords(String txt, Integer start, Integer matchType) {
        //敏感词结束标志
        Boolean flag = false;
        char word;
        //匹配标识数默认为0
        Integer matchFlag = 0;
        Map childMap = sensitiveWordsMap;
        txt = txt.replace(" ","");
        for(int i = start;i < txt.length();i++){
            word = txt.charAt(i);
            childMap = (Map)childMap.get(word);
            if(childMap == null){
                //不存在该字打头的敏感词
                break;
            } else {
                //匹配标识+1
                matchFlag++;
                if("1".equals(childMap.get("isEnd"))){
                    flag = true;
                    if(minMatchType.equals(matchType)){
                        //最小匹配规则则跳出，否则继续匹配
                        break;
                    }
                }
            }
        }
        if(matchFlag < 2 || !flag){
            //匹配长度需大于2才为词，并且敏感词已结束
            matchFlag = 0;
        }
        return matchFlag;
    }

    /**
     * 获取所有敏感词
     * @param txt 待判断文本
     * @param matchType 匹配类型： 1 最小匹配原则；2 最大匹配原则
     * @return
     */
    public static Set<String> getSensitiveWords(String txt,Integer matchType) {
        txt = txt.replace(" ","");
        Set<String> sensitiveWords = new HashSet<>();
        for(int i = 0;i < txt.length();i++) {
            Integer length = checkSensitiveWords(txt, i, matchType);
            if(length > 0) {
                sensitiveWords.add(txt.substring(i, i + length));
                //循环i会+1，所以需-1
                i = i + length - 1;
            }
        }
        return sensitiveWords;
    }

    /**
     * 替换敏感词
     * @param txt 文本
     * @param matchType 匹配类型： 1 最小匹配原则；2 最大匹配原则
     * @param replaceStr 替换字符
     * @return 处理后的文本
     */
    public static String replaceSensitiveWords(String txt, Integer matchType, String replaceStr){
        if(txt == null || "".equals(txt)){
            return txt;
        }
        //获取所有敏感词
        Set<String> sensitiveWords = getSensitiveWords(txt, matchType);
        Iterator<String> iterator = sensitiveWords.iterator();
        String replaceString = "";
        while (iterator.hasNext()){
            String sWord = iterator.next();
            replaceString = getReplaceString(replaceStr, sWord.length());
            txt = txt.replaceAll(sWord, replaceString);
        }
        return txt;
    }

    private static String getReplaceString(String replaceStr, Integer length) {
        if(replaceStr == null){
            replaceStr = "*";
        }
        StringBuffer replaceString = new StringBuffer();
        for(int i = 0;i < length;i++){
            replaceString.append(replaceStr);
        }
        return replaceString.toString();
    }


    public static void main(String[] args) {
        //获取敏感词
        Long beginTime = System.currentTimeMillis();
        Set<String> wordList = readSensitiveWordsFile();
        addSensitiveWordsToHashMap(wordList);
        String txt = " s 是一个sb    ";
        Boolean containsSensitiveWords = isContainsSensitiveWords(txt, 1);
        System.out.println("是否包含: " + containsSensitiveWords);
        Set<String> sensitiveWords = getSensitiveWords(txt, 1);
        System.out.println("包含的词: " + sensitiveWords);
//        System.out.println("替换后的词语: " + replaceSensitiveWords(txt, 1, null));
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时 : " + (endTime - beginTime));
    }







}
