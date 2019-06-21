package com.boom.Controller;

import com.boom.Service.PartOneService;
import com.boom.Service.PartThreeService;
import com.boom.Service.PartTwoService;
import com.boom.Utils.ReadWordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

//    @Autowired
//    private PartOneService partOneService;
    @Autowired
    private PartTwoService partTwoService;
    @Autowired
    private PartThreeService partThreeService;

    public void doTest() {
//        Map<String,List<String>>part2QuesMap =  getPart2Ques();
//        Map<String,String>part2AnswMap = getPart2Answ(part2QuesMap);
//        System.out.println("题目1："+part2QuesMap.get("trunk").toString());


    }


    //part1
    public Map<String,List<String>> getPart1Ques(){

        final int WORK_WORD_NUM=30;
        final int TRUNK_WORD_NUM=15;
        final int METCH_WORD_NUM=5;
        Map<String,List<String>> quesMap =  new HashMap<String, List<String> >();

        String path = this.getClass().getClassLoader().getResource("part1.txt").getPath();//获取文件路径
        List<String> list= ReadWordUtils.readSrcWord(path);//得到所有词库
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
        List<String> list= ReadWordUtils.readSrcWord(path);//得到所有词库
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

