package com.boom.Controller;

import com.boom.Service.PartThreeService;
import com.boom.Service.PartTwoService;
import com.boom.Utils.BananaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boom.Domain.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/index")
@Controller
public class IndexController {

//    @Autowired
//    private PartOneService partOneService;
    @Autowired
    private PartTwoService partTwoService;
    @Autowired
    private PartThreeService partThreeService;

    @RequestMapping("/doJob")
    public void doJob(HttpServletRequest request){

       Interval[] a = initIntervalArr(request);
       boolean flag = BananaUtils.judgeOverlap(a);
       System.out.println("是有合法："+flag);

    }


    public Interval[] initIntervalArr(HttpServletRequest request){
        final String KEY ="rank";
        List<Integer> tempList = new ArrayList<Integer>();
        Interval[] intervals = new Interval[10];
        int cnt = 0;

        for (int x=1;x<=5;x++){
            for (int y=1;y<=4;y++){
                int val = Integer.parseInt(request.getParameter(KEY+x+"_"+y));
                tempList.add(val);
            }
            Interval interval1 = new Interval(tempList.get(0),tempList.get(1));
            intervals [cnt] = interval1;
            cnt++;
            Interval interval2 = new Interval(tempList.get(2),tempList.get(3));
            intervals [cnt] = interval2;
            cnt++;
            tempList.clear();
        }
        return intervals;
    }


    //part1
    public Map<String,List<String>> getPart1Ques(){

        final int WORK_WORD_NUM=30;
        final int TRUNK_WORD_NUM=15;
        final int METCH_WORD_NUM=5;
        Map<String,List<String>> quesMap =  new HashMap<String, List<String> >();

        String path = this.getClass().getClassLoader().getResource("part1.txt").getPath();//获取文件路径
        List<String> list= BananaUtils.readSrcWord(path);//得到所有词库
        System.out.println(" ");
        System.out.println("---------------getWorkWord----------------");

        List<String> workWordList  = partTwoService.getWorkWord(list,WORK_WORD_NUM);
        for (int j=0;j<workWordList.size();j++) {
            if (j!=0 && j%8==0){
                System.out.println(workWordList.get(j));
            }else {
                System.out.print(workWordList.get(j)+" ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getTrunkWord----------------");
        List<String> trunkWordList  = partTwoService.getWorkWord(workWordList,TRUNK_WORD_NUM);//得到题干词库
        quesMap.put("trunk",trunkWordList);
        for (int j=0;j<trunkWordList.size();j++) {
            if (j!=0 && j%8==0){
                System.out.println(trunkWordList.get(j));
            }else {
                System.out.print(trunkWordList.get(j)+" ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getMetchWord----------------");
        List<String> metchWordList ;
        for (int cnt=1;cnt<=10;cnt++){
            metchWordList  = partTwoService.getWorkWord(workWordList,METCH_WORD_NUM);//得到单体题目词库
            quesMap.put("ques"+cnt,metchWordList);
        }

        return quesMap;
    }
    public Map<String,String> getPart1Answ(Map<String,List<String>> map){
        Map<String, String> answerMap = new HashMap<> ();
        List<String> trunkWordList = map.get("trunk");//得到题干词库
        for (int cnt = 1;cnt<=map.size()-1; cnt++){
            int wordCnt=0;
            List<String>matchList = map.get("ques"+cnt);
            for (String word:matchList) {
                if (trunkWordList.contains(word)){
                    wordCnt++;
                }
            }
            answerMap.put("answ"+cnt,transferAnsw(wordCnt));
        }
        return answerMap;
    }

    //part2
    public Map<String,List<String>> getPart2Ques(){

        final int WORK_WORD_NUM=30;
        final int TRUNK_WORD_NUM=15;
        final int METCH_WORD_NUM=5;
        Map<String,List<String>> quesMap =  new HashMap<String, List<String> >();

        String path = this.getClass().getClassLoader().getResource("part1.txt").getPath();//获取文件路径
        List<String> list= BananaUtils.readSrcWord(path);//得到所有词库
        System.out.println(" ");
        System.out.println("---------------getWorkWord----------------");

        List<String> workWordList  = partTwoService.getWorkWord(list,WORK_WORD_NUM);
        for (int j=0;j<workWordList.size();j++) {
            if (j!=0 && j%8==0){
                System.out.println(workWordList.get(j));
            }else {
                System.out.print(workWordList.get(j)+" ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getTrunkWord----------------");
        List<String> trunkWordList  = partTwoService.getWorkWord(workWordList,TRUNK_WORD_NUM);//得到题干词库
        quesMap.put("trunk",trunkWordList);
        for (int j=0;j<trunkWordList.size();j++) {
            if (j!=0 && j%8==0){
                System.out.println(trunkWordList.get(j));
            }else {
                System.out.print(trunkWordList.get(j)+" ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getMetchWord----------------");
        List<String> metchWordList ;
        for (int cnt=1;cnt<=10;cnt++){
            metchWordList  = partTwoService.getWorkWord(workWordList,METCH_WORD_NUM);//得到单体题目词库
            quesMap.put("ques"+cnt,metchWordList);
        }

        return quesMap;
    }
    public Map<String,String> getPart2Answ(Map<String,List<String>> map){
        Map<String, String> answerMap = new HashMap<> ();
        List<String> trunkWordList = map.get("trunk");//得到题干词库
        for (int cnt = 1;cnt<=map.size()-1; cnt++){
            int wordCnt=0;
            List<String>matchList = map.get("ques"+cnt);
            for (String word:matchList) {
                if (trunkWordList.contains(word)){
                    wordCnt++;
                }
            }
            answerMap.put("answ"+cnt,transferAnsw(wordCnt));
        }
        return answerMap;
    }
    //part2
    public Map<String,List<String>> getPart3Ques(){
        String[] keyArr = {"人","生","若","只","如","初","见"};
        String[] valArr = {"r","s","r2","z","r3","c","j"};

        return null;
    }
    public Map<String,String> getPart3Answ(Map<String,List<String>> map){
        Map<String, String> answerMap = new HashMap<> ();
        List<String> trunkWordList = map.get("trunk");//得到题干词库
        for (int cnt = 1;cnt<=map.size()-1; cnt++){
            int wordCnt=0;
            List<String>matchList = map.get("ques"+cnt);
            for (String word:matchList) {
                if (trunkWordList.contains(word)){
                    wordCnt++;
                }
            }
            answerMap.put("answ"+cnt,transferAnsw(wordCnt));
        }
        return answerMap;
    }
    private String transferAnsw(int cnt){
        String answer ="";
        switch (cnt){
            case 0 : answer = "A";
                break;
            case 1 : answer = "B";
                break;
            case 2 : answer = "C";
                break;
            case 3 : answer = "D";
                break;
            case 4 : answer = "E";
                break;
            case 5 : answer = "F";
                break;
        }
        return answer;
    }


}

