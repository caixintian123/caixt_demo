package com.boom.Controller;

import com.boom.Service.PartThreeService;
import com.boom.Service.PartTwoService;
import com.boom.Utils.BananaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boom.Domain.*;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RequestMapping("/index")
@Controller
public class IndexController {

//    @Autowired
//    private PartOneService partOneService;
    @Autowired
    private PartTwoService partTwoService;
    @Autowired
    private PartThreeService partThreeService;

    @RequestMapping(value="/doJob",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    public void doJob(HttpServletRequest request) throws UnsupportedEncodingException {
        int part1AnswerCnt = Integer.parseInt(request.getParameter("part1AnswerCnt"));
        int part2AnswerCnt = Integer.parseInt(request.getParameter("part2AnswerCnt"));
        int part3AnswerCnt = Integer.parseInt(request.getParameter("part3AnswerCnt"));
        //1
//        Interval[] intervals = initIntervalArr(request);
//        getPart1Answ(intervals,part1AnswerCnt);
//        List<String> trunkWordList= new ArrayList<>();
        //2
//        String q2trunk = null;
//        try {
//            q2trunk = new String(request.getParameter("q2Trunk").getBytes("iso-8859-1"),"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            System.out.println("你输了什么玩意，怎么转换还乱码了呢？");
//        }
//        List<String> part2Trunk = Arrays.asList(q2trunk.split("\\s"));
//        Map<String,String> part2Answ = getPart2Answ(part2Trunk,part2AnswerCnt);
//        System.out.println("end");
        //3
        Map<String,List<String>> map = initWordStrArr(request);
        Map<String,String> p3q = getPart3Answ(map,part3AnswerCnt);
        Iterator<Map.Entry<String, String>> it = p3q.entrySet().iterator();
        String[] p3m = new String[5];
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            String val= entry.getValue();
            int intKey = (int)(Math.random()*5);
            String p3answer = transferAnsw(intKey);
            p3q.put(entry.getKey(),p3answer);
            for (int k=0;k<5;k++){
                if (k!=intKey){
                    p3m[k] = sortString(val);
                    while (p3m[k].equals(val)){
                        p3m[k] = sortString(val);
                    }
                }
                if (k==intKey){
                    p3m[k] = val;
                }
            }
        }

    }

    public Map<String,String> initQues(Interval[] a,int num){
        Map<String,String> map = new HashMap<>();

        for (int i=0;i<num;i++){
            int answerIndex = (int) (Math.random() * 5);
            int quesIndex = (int) (Math.random() * 2);
            Interval interval = a[(2*answerIndex)+quesIndex];
            int result =  new Random().nextInt(interval.getEnd())%(interval.getEnd()-interval.getStart()+1)+interval.getStart();
            String answer = transferAnsw(answerIndex);
            map.put(String.valueOf(result),answer);
        }
        return map;
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

    public Map<String,List<String>> initWordStrArr(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String,List<String>> wordStrMap = new HashMap<>();
        final String WORD_KEY ="word";
        final String STR_KEY ="str";
        List<String> wordList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        String word,str;
       int cnt =8;
       for (int i=0;i<cnt;i++){
           word = new String(request.getParameter(WORD_KEY+i).getBytes("iso-8859-1"),"utf-8");
           str = new String(request.getParameter(STR_KEY+i).getBytes("iso-8859-1"),"utf-8");
           wordList.add(word);
           strList.add(str);
       }
       wordStrMap.put("word",wordList);
       wordStrMap.put("str",strList);
       return wordStrMap;
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
    public Map<String,String> getPart1Answ(Interval[] intervals,int quesNum){
        //        int quesNum  = Integer.parseInt(request.getParameter("part1QuesNum"));
        quesNum  = 5;
//        Interval[] intervals = initIntervalArr(request);
        boolean flag = BananaUtils.judgeOverlap(intervals);
        System.out.println("是有合法："+flag);
        return initQues(intervals,quesNum);
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
    public Map<String,String> getPart2Answ(List<String> trunkWordList,int num){
        String mistakePath = this.getClass().getClassLoader().getResource("part1.txt").getPath();//获取文件路径
        Map<String, String> answerMap = new HashMap<> ();
        List<String>  misStringList= BananaUtils.readSrcWord(mistakePath);

        for (int i=0;i<num;i++){
            StringBuffer sb = new StringBuffer();

           int index = (int) (Math.random()*5)+1;

           for (String word :partTwoService.getWorkWord(misStringList,5-index)){
                sb.append(word+" ");
           }
           for (String word :partTwoService.getWorkWord(trunkWordList,index)){
               sb.append(word+" ");
           }
           String choose = transferAnsw(index);
           answerMap.put(sb.toString(),choose);
       }
        return answerMap;
    }
    //part2
    public Map<String,List<String>> getPart3Ques(){
        String[] keyArr = {"人","生","若","只","如","初","见"};
        String[] valArr = {"r","s","r2","z","r3","c","j"};

        return null;
    }
    public Map<String,String> getPart3Answ(Map<String,List<String>> map,int num){
        List<String> wordList= map.get("word");
        List<String> strList= map.get("str");
        List<Integer> ints = new ArrayList<>();
        Map<String,String> qMap = new HashMap<>();

        for (int cnt=0;;cnt++){
            for (int i=0;;i++){
                int intKey = (int)(Math.random()*8);
                if (ints.size()<4){
                    if (ints.contains(intKey)){
                        continue;
                    }
                    ints.add(intKey);
                }else {
                    break;
                }

            }
            StringBuffer matchStr = new StringBuffer();
            StringBuffer metchWord = new StringBuffer();
            for(int i:ints) {
                matchStr.append(strList.get(i));
                metchWord.append(wordList.get(i));
            }
            ints.clear();
            if (qMap.containsKey(metchWord.toString())){
                continue;
            }
            qMap.put(metchWord.toString(),matchStr.toString());
            if (qMap.size()==num){
                break;
            }
        }
        return qMap;
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

    private String sortString(String k){

        List<String> list=Arrays.asList(k.split(""));
            Collections.shuffle(list);
            String out=new String();
            for(String s:list){
                out+=s;
            }
        return  out;
    }
}

