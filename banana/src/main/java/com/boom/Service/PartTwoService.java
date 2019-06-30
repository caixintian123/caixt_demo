package com.boom.Service;




import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PartTwoService {

    /*
     * 获取所有词库
     */
//    public List<String> readSrcWord(String path) {
//        List<String> allWord = new ArrayList<>();
//        try {
//            //InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.
//            InputStreamReader in=null;
//            try {
//                in = new InputStreamReader(new FileInputStream(path),"UTF-8");
//            } catch (UnsupportedEncodingException e1) {
//                // TODO Auto-generated catch block
//                e1.printStackTrace();
//            }
//            //BufferedReader 由Reader类扩展而来，提供通用的缓冲方式文本读取,将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
//                    BufferedReader read=new BufferedReader(in);
//            String tmp;
//            try {
//                while((tmp=read.readLine())!=null){
//                    System.out.println(tmp);
//                    List<String> tempList = Arrays.asList(tmp.split("\\s+"));
//                    allWord.addAll(tempList);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return allWord;
//    }

    public List<String> getWorkWord(List<String> wordList,int num){
        List<String> workWordList = new ArrayList<>();
        for (int i=1;i<=num;i++){
           int index = (int) (Math.random() * wordList.size());
           String word=wordList.get(index);
           if(workWordList.contains(word)){
               i--;
               continue;
           }
           workWordList.add(word);
        }
        return workWordList;
    }


}
