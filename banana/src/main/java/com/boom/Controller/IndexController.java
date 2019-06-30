package com.boom.Controller;

import com.boom.Service.PartThreeService;
import com.boom.Service.PartTwoService;
import com.boom.Utils.BananaUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boom.Domain.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@RequestMapping("/index")
@Controller
public class IndexController {


    @Autowired
    private PartTwoService partTwoService;


    @RequestMapping(value="/doJob",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    public ModelAndView doJob(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String msg="你成功导出文档了，牛逼！";
        int part1AnswerCnt = 0;
        int part2AnswerCnt = 0;
        int part3AnswerCnt = 0;
        try {
            part1AnswerCnt = Integer.parseInt(request.getParameter("part1AnswerCnt"));
            part2AnswerCnt = Integer.parseInt(request.getParameter("part2AnswerCnt"));
            part3AnswerCnt = Integer.parseInt(request.getParameter("part3AnswerCnt"));
        }catch (Exception e){
            msg="小题数量输入有误";
            modelAndView.addObject("msg",msg);
            modelAndView.setViewName("advice");
            return modelAndView;
        }
        //1
        List<PartOneResult> part1Results = initIntervalArr(request);
        part1Results= getPart1Answ(part1Results,part1AnswerCnt);
        String path = String.valueOf(this.getClass().getClassLoader().getResource(""));//获取文件路径
        Map<String,Object> dataMap = new HashMap<>();
        String doc = "D:/wuxie/example.doc";
        dataMap.put("part1Results",part1Results);

        //2
        List<PartTwoResult> part2Result = initP2Result(request,part2AnswerCnt);
        dataMap.put("part2Result",part2Result);

        //3
        List<PartThreeResult> resultList = initWordStrArr(request);
        getPart3Answ(resultList,part3AnswerCnt);

        for (PartThreeResult result:resultList){
            List<Part3Print> part3PrintList = result.getPart3PrintList();
            for (Part3Print print:part3PrintList){
                String[] p3m = new String[5];
                System.out.println("key= " + print.getQuesTrunk() + " and value= " + print.getAnswer());
                int intKey = (int)(Math.random()*5);
                String p3answer = transferAnsw(intKey);
                for (int k=0;k<5;k++){
                    if (k!=intKey){
                        p3m[k] = sortString(print.getAnswer());
                        while (p3m[k].equals(print.getAnswer())){
                            p3m[k] = sortString(print.getAnswer());
                        }
                    }
                    if (k==intKey){
                        p3m[k] = print.getAnswer();
                    }
                }
                print.setChooseA(p3m[0]);
                print.setChooseB(p3m[1]);
                print.setChooseC(p3m[2]);
                print.setChooseD(p3m[3]);
                print.setChooseE(p3m[4]);
                print.setAnswer(p3answer);
            }
        }

        dataMap.put("p3resultList",resultList);
        createDoc(dataMap,doc,path);
        return modelAndView;
    }

    public void initQues(PartOneResult result, int num){
        Interval[] a = result.getWordTrunk();
        List<Answer> answers = new ArrayList<>();
        List<Map<String, Object>> answerList = new ArrayList<>();
        for (int i=0;i<num;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            Answer answerPojo = new Answer();
            int answerIndex = (int) (Math.random() * 5);
            int quesIndex = (int) (Math.random() * 2);
            Interval interval = a[(2*answerIndex)+quesIndex];
            int val =  new Random().nextInt(interval.getEnd())%(interval.getEnd()-interval.getStart()+1)+interval.getStart();
            String answer = transferAnsw(answerIndex);
            answerPojo.setMatchNum(String.valueOf(val));
            answerPojo.setChoose(answer);
            answers.add(answerPojo);
        }
        result.setAnswers(answers);
    }

    public  List<PartOneResult> initIntervalArr(HttpServletRequest request){
        final String KEY ="rank";
        List<PartOneResult> partTwoResults = new ArrayList<>();
        List<Interval[]> intervalList = new ArrayList<>();
        int p2trunkNum=2;
        List<Integer> tempList = new ArrayList<Integer>();
        for(int num = 1;num<=p2trunkNum;num++){
        PartOneResult result = new PartOneResult();

        Interval[] intervals = new Interval[10];
        int cnt = 0;
        for (int x=1;x<=5;x++){
            for (int y=1;y<=4;y++){
                int val = Integer.parseInt(request.getParameter(KEY+num+x+"_"+y));
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
        intervalList.add(intervals);
        result.setWordTrunk(intervals);
        partTwoResults.add(result);
        }
        return partTwoResults;
    }

    public List<PartThreeResult> initWordStrArr(HttpServletRequest request) throws UnsupportedEncodingException {

        List<PartThreeResult> resultList = new ArrayList<>();
        final String WORD_KEY ="word";
        final String STR_KEY ="str";
//        int p3TrunkNum = Integer.parseInt(request.getParameter("p2TrunkNum"));
        int p3TrunkNum = 2;

        for(int index=1;index<=p3TrunkNum;index++){
            PartThreeResult result = new PartThreeResult();
            String[] wordArr = new String[8];
            String[] strArr = new String[8];
            String word,str;
            int cnt =8;
            for (int i=0;i<cnt;i++){
                word = new String(request.getParameter(WORD_KEY+index+"_"+i).getBytes("iso-8859-1"),"utf-8");
                str = new String(request.getParameter(STR_KEY+index+"_"+i).getBytes("iso-8859-1"),"utf-8");
                wordArr[i] = word;
                strArr[i] = str;
                result.setWordTrunk(wordArr);
                result.setStrTrunk(strArr);
            }
            resultList.add(result);
        }
       return resultList;
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
    public List<PartOneResult> getPart1Answ(List<PartOneResult> partTwoResults, int quesNum){
        for (PartOneResult result:partTwoResults){
                boolean flag = BananaUtils.judgeOverlap(result.getWordTrunk());
                System.out.println("是有合法："+flag);
                initQues(result,quesNum);
            }
        return partTwoResults;
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
    public void getPart2Answ(PartTwoResult result,int num){
        List<String> trunkWordList = Arrays.asList(result.getWordTrunk());
        String mistakePath = this.getClass().getClassLoader().getResource("part1.txt").getPath();//获取文件路径
        Map<String, String> answerMap = new HashMap<> ();
        List<String>  misStringList= BananaUtils.readSrcWord(mistakePath);
        List<Answer> answers= new ArrayList<>();
        for (int i=0;i<num;i++){
            StringBuffer sb = new StringBuffer();

           int index = (int) (Math.random()*5);

           for (String word :partTwoService.getWorkWord(misStringList,5-index)){
                sb.append(word+" ");
           }
           for (String word :partTwoService.getWorkWord(trunkWordList,index)){
               sb.append(word+" ");
           }

           Answer answer = new Answer();
           String choose = transferAnsw(index);
           answer.setChoose(choose);
           answer.setMatchNum(sb.toString());
           answers.add(answer);
       }
       result.setAnswers(answers);
    }
    //part2
    public Map<String,List<String>> getPart3Ques(){
        String[] keyArr = {"人","生","若","只","如","初","见"};
        String[] valArr = {"r","s","r2","z","r3","c","j"};

        return null;
    }
    public void getPart3Answ(List<PartThreeResult> resultList,int num){
        for (PartThreeResult result:resultList){
        List<String> wordList= Arrays.asList(result.getWordTrunk());
        List<String> strList= Arrays.asList(result.getStrTrunk());
        List<Integer> ints = new ArrayList<>();
        Map<String,String> qMap = new HashMap<>();
        List<Part3Print> part3PrintList= new ArrayList<>();
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
            Part3Print part3Print = new Part3Print();
            part3Print.setQuesTrunk(metchWord.toString());
            part3Print.setAnswer(matchStr.toString());
            part3PrintList.add(part3Print);
            if (qMap.size()==num){
                break;
            }
        }
        result.setPart3PrintList(part3PrintList);
        }
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

    public  void createDoc(Map<String,Object> dataMap,String fileName,String path) throws IOException {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
        //这里我们的模板是放在template包下面
        /** 加载文件 **/
//        configuration.setClassForTemplateLoading(this.getClass(), "/template");

        String templateFolder = this.getClass().getClassLoader().getResource("part1.txt").getPath();
        configuration.setDirectoryForTemplateLoading(new File(templateFolder.substring(0,templateFolder.length()-9)));

        Template t=null;
        try {
            //test.ftl为要装载的模板
            t = configuration.getTemplate("temp2.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出文档路径及名称
        File outFile = new File(fileName);
        Writer out = null;
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(outFile);
            OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");
            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
            //out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            out = new BufferedWriter(oWriter);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out);
            out.close();
            fos.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("---------------------------");
    }

    private List<PartTwoResult> initP2Result(HttpServletRequest request,int part2AnswerCnt){
        List<PartTwoResult> resultList = new ArrayList<>();
        try {
        for (int i=1;i<=2;i++){
            PartTwoResult result = new PartTwoResult();
            String q2trunk =  new String(request.getParameter("q2Trunk_"+i).getBytes("iso-8859-1"),"utf-8");
            String[] q2trunks = q2trunk.split("\\s");
            if (q2trunk.length()!=15){
                String msg = "好好数数你输了几个单词，要15个！";
            }
            result.setWordTrunk(q2trunks);
            getPart2Answ(result,part2AnswerCnt);
            resultList.add(result);
        }
        } catch (UnsupportedEncodingException e) {
            System.out.println("你输了什么玩意，怎么转换还乱码了呢？");
        }
        return resultList;
    }
}

