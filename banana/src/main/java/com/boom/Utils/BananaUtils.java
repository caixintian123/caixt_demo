package com.boom.Utils;

import com.boom.Domain.Interval;
import com.boom.Domain.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BananaUtils {

    public static List<String> readSrcWord(String path) {
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
                    List<String> tempList = Arrays.asList(tmp.split("\\s+"));
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


    public static int getOverlappingCount(Interval[] A){

        int max = 0,count = 1;

        if(A==null || A.length==0) return max;

        Point[] points = new Point[A.length*2];

        for(int i = 0;i < A.length;i++){

            points[2*i] = new Point(A[i].getStart(), 0);

            points[2*i+1] = new Point(A[i].getEnd(), 1);

        }

        //Collection.sort(points);

//        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) {

            if (points[i].getType()==0) {

                count++;

                max = Math.max(max, count);

            }else{

                count--;

            }

        }

        return max;

    }

    public static boolean judgeOverlap(Interval[] a){
        for (int i = 0;i<a.length; i++){
            Interval checkBean = a [i];
            for (int y =i+1;y<a.length; y++){
                Interval beCheckBean = a [y];
                if(beCheckBean.getStart()<= checkBean.getEnd() && beCheckBean.getEnd()>=checkBean.getStart()){
                    return false;
                }
            }

        }
        return true;
    }
}
