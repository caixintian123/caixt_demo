package com.boom.Utils;

import com.boom.Domain.Interval;
import com.boom.Domain.Point;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;


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


    public static void output(String path, Interval[] intervals) throws Exception{


        /** 初始化配置文件 **/
        Configuration configuration = new Configuration();
        /** 设置编码 **/
        configuration.setDefaultEncoding("utf-8");
        /** 我的ftl文件是放在D盘的**/
//        String fileDirectory = "/Users/caixintian/Documents/doc";
        /** 加载文件 **/
        configuration.setDirectoryForTemplateLoading(new File(path));
        /** 加载模板 **/
        Template template = configuration.getTemplate("temp.ftl");
        /** 准备数据 **/
//        Map<String,List<Interval>> dataMap = new HashMap<>();
        Map<String,String> dataMap = new HashMap<>();

        /** 表格数据初始化 **/
//        List<Interval> intervalList = new ArrayList<>();
//        intervalList.add(new Interval("100424060","小毅","男","25"));
//        intervalList.add(new Interval("100424030","小兰","女","25"));
        List<Interval>intervalList = Arrays.asList(intervals);
        /** 表格数据 studentList和freemarker标签要对应**/
//        dataMap.put("IntervalList",intervalList);
        dataMap.put("apple","apple");
//        dataMap.put("oragle","apple");

        /** 指定输出word文件的路径 **/
        String outFilePath = "\\Users\\caixintian\\Documents\\doc\\myFreeMarker.doc";
        File docFile = new File(outFilePath);
        FileOutputStream fos = new FileOutputStream(docFile);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
//        dataMap.put("oragle","oragle");
//        out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        try{template.process(dataMap,out);}catch (Exception e){}


        if(out != null){
            out.close();
        }
    }


}
