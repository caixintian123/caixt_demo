package com.boom.Service;

import com.boom.Domain.PartThreeResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PartThreeService {

    public List<PartThreeResult> initWordStrArr(int p3TrunkNum ) throws UnsupportedEncodingException {
        List<PartThreeResult> resultList = new ArrayList<>();
        for (int index = 1; index <= p3TrunkNum; index++) {
            PartThreeResult result = new PartThreeResult();
            String[] wordArr =  getWordArr();
            String[] strArr = getStrArr();
            result.setWordTrunk(wordArr);
            result.setStrTrunk(strArr);
            resultList.add(result);
        }
        return resultList;
    }

    private String[] getStrArr() {
        String str ="QAZWSXEDCRFVTGBYHNUJMIKOLP1234567890";
        String[] strArr = str.split("");
        String[] returnArr = str.split("");
        List<Integer> nums = new ArrayList<>();
        int cnt =8;
        for (int i=0;i<cnt;i++){
            int a= (int) Math.floor(Math.random()*str.length());
            if (!nums.contains(a)){
                nums.add(a);
                returnArr[i] = strArr[a];
            }else {
                i--;
                continue;
            }
        }
        return returnArr;
    }

    private String[] getWordArr() {
        String path = this.getClass().getClassLoader().getResource("/part3.txt").getPath();//获取文件路径
        List<String> words = readSrcWord(path);
        List<String> s = getWorkWord(words,8);
        return list2array(s);
    }

    public List<String> readSrcWord(String path) {
        List<String> allWord = new ArrayList<>();
        try {
            //InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.
            InputStreamReader in=null;
            try {
                in = new InputStreamReader(new FileInputStream(path),"UTF-8");
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            //BufferedReader 由Reader类扩展而来，提供通用的缓冲方式文本读取,将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
            BufferedReader read=new BufferedReader(in);
            String tmp;
            try {
                while((tmp=read.readLine())!=null){
                    System.out.println(tmp);
                    List<String> tempList = Arrays.asList(tmp.split(""));
                    allWord.addAll(tempList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allWord;
    }

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

    public String[] list2array(List<String> list){
        if(list==null || list.size()==0){
            return null;
        }
        String[] array = new String[list.size()];
        for(int i=0;i<list.size();i++){
            array[i]= list.get(i);
        }
        return array;
    }
}
