package com.boom.Controller;

import com.boom.Service.PartOneService;
import com.boom.Service.PartThreeService;
import com.boom.Service.PartTwoService;
import com.boom.Utils.BananaUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boom.Domain.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@RequestMapping("/index")
@Controller
public class IndexController {
    private static Log logger = LogFactory.getLog(IndexController.class);

    @Autowired
    private PartTwoService partTwoService;

    @Autowired
    private PartOneService partOneService;

    @Autowired
    private PartThreeService partThreeService;


    @RequestMapping(value = "/doJob", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public ModelAndView doJob(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String doc = request.getParameter("savePath");
        String msg = "";
        if (StringUtils.isEmpty(doc)) {
            msg = "请检查保存路径";
            modelAndView.addObject("msg", msg);
            modelAndView.setViewName("advice");
            return modelAndView;
        }

        int part1AnswerCnt = 0;
        int part2AnswerCnt = 0;
        int part3AnswerCnt = 0;
        int isAuto = 0;//默认是手动
        try {
            isAuto = Integer.parseInt(request.getParameter("isAuto"));
            part1AnswerCnt = Integer.parseInt(request.getParameter("part1AnswerCnt"));
            part2AnswerCnt = Integer.parseInt(request.getParameter("part2AnswerCnt"));
            part3AnswerCnt = Integer.parseInt(request.getParameter("part3AnswerCnt"));
        } catch (Exception e) {
            msg = "小题数量输入有误";
            modelAndView.addObject("msg", msg);
            modelAndView.setViewName("advice");
            return modelAndView;
        }
        //1
        Map<String, Object> dataMap = new HashMap<>();
        List<PartOneResult> part1Results = new ArrayList<>();
        try {
            System.out.println("check part1");
            //手动生成数据
            part1Results = new ArrayList<PartOneResult>();
            if (isAuto==0){
                part1Results = initIntervalArr(request);
                if (!checkArrIllage(part1Results)) {
                    msg = "请检查第一题赋值";
                    modelAndView.addObject("msg", msg);
                    modelAndView.setViewName("advice");
                    return modelAndView;
                }
            }else {
                part1Results =  partOneService.getAutoPart1(part1AnswerCnt);
            }
            part1Results = getPart1Answ(part1Results);
            dataMap.put("part1Results", part1Results);
        } catch (Exception e) {
            msg = "请检查第一题赋值";
            modelAndView.addObject("msg", msg);
            modelAndView.setViewName("advice");
            return modelAndView;
        }
        //2
        List<PartTwoResult> part2Result = new ArrayList<>();
        if (isAuto==0) {
            part2Result = initP2Result(request, part2AnswerCnt);
        }else {
            part2Result = getPart2Ques(part2AnswerCnt);
        }
        boolean flag = checkp2Illage(part2Result);
        if (!flag) {
            msg = "请检查第二题赋值";
            modelAndView.addObject("msg", msg);
            modelAndView.setViewName("advice");
            return modelAndView;
        }
        dataMap.put("part2Result", part2Result);
        //3O

        try {
            logger.info("coming part3");
            List<PartThreeResult> resultList = new ArrayList<>();
            if (isAuto==0){
                boolean isRepeat = cheakIsRepeat(request);
                if (isRepeat) {
                    msg = "请检查第三题赋值";
                    modelAndView.addObject("msg", msg);
                    modelAndView.setViewName("advice");
                    return modelAndView;
                }
                resultList = initWordStrArr(request);
            }else {
                resultList = partThreeService.initWordStrArr(part3AnswerCnt);
            }

            getPart3Answ(resultList, 20 / part3AnswerCnt);

            for (PartThreeResult result : resultList) {
                StringBuffer sb = new StringBuffer();
                for (String str : result.getStrTrunk()) {
                    sb.append(str);
                }
                List<Part3Print> part3PrintList = result.getPart3PrintList();
                for (Part3Print print : part3PrintList) {
                    String[] p3m = new String[5];
                    logger.info("key= " + print.getQuesTrunk() + " and value= " + print.getAnswer());
                    int intKey = (int) (Math.random() * 5);
                    String p3answer = transferAnsw(intKey);
                    for (int k = 0; k < 5; k++) {
                        if (k != intKey) {
                            for (; ; ) {
                                String a = sortString(sb.toString()).substring(0, 4);
                                if (a.equals(print.getAnswer()) || Arrays.asList(p3m).contains(a)) {
                                    continue;
                                } else {
                                    p3m[k] = a;
                                    break;
                                }
                            }

                        }
                        if (k == intKey) {
                            p3m[k] = print.getAnswer();
                        }
                    }
                    print.setChooseA(p3m[0]);
                    print.setChooseB(p3m[1]);
                    print.setChooseC(p3m[2]);
                    print.setChooseD(p3m[3]);
                    print.setChooseE(p3m[4]);
                    print.setAnswerCode(print.getAnswer());
                    print.setAnswer(p3answer);
                    logger.info("print :" + print.toString());
                }
            }

            dataMap.put("p3resultList", resultList);
        } catch (Exception e) {
            msg = "请检查第三题赋值";
            modelAndView.addObject("msg", msg);
            modelAndView.setViewName("advice");
            return modelAndView;
        }


        logger.info("createdDoc start");
        createDoc(dataMap, doc, response);
        logger.info("createdDoc end");

        msg = "成功导出文档，路径为:" + doc;
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("advice");
        return modelAndView;
    }

    private boolean checkArrIllage(List<PartOneResult> part1Results) {
        for (PartOneResult result : part1Results) {

            for (Interval interval : result.getWordTrunk()) {
                int cnt = 0;
                if (interval.getStart() >= interval.getEnd()) {
                    return false;
                }
                for (Interval compareInterval : result.getWordTrunk()) {
                    if (!iscomplax(interval, compareInterval)) {
                        cnt++;
                    }
                    if (cnt == 2) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    @RequestMapping(value = "/toIndex", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public void toIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp");
    }

    public void initQues(PartOneResult result, int num) {
        Interval[] a = result.getWordTrunk();
        List<Answer> answers = new ArrayList<>();
        List<Map<String, Object>> answerList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            Answer answerPojo = new Answer();
            int answerIndex = (int) (Math.random() * 5);
            int quesIndex = (int) (Math.random() * 2);
            Interval interval = a[(2 * answerIndex) + quesIndex];
            int val = new Random().nextInt(interval.getEnd()) % (interval.getEnd() - interval.getStart() + 1) + interval.getStart();
            String answerRank = interval.getStart() + "~" + interval.getEnd();
            String answer = transferAnsw(answerIndex);
            answerPojo.setMatchNum(String.valueOf(val));
            answerPojo.setChoose(answer);
            answerPojo.setAnswerRank(answerRank);
            answerPojo.setNumCode(transferCode(answerIndex));
            answers.add(answerPojo);
        }
        result.setAnswers(answers);
    }

    public List<PartOneResult> initIntervalArr(HttpServletRequest request) {
        final String KEY = "rank";
        List<PartOneResult> partTwoResults = new ArrayList<>();
        List<Interval[]> intervalList = new ArrayList<>();
        int p1TrunkNum = Integer.parseInt(request.getParameter("part1AnswerCnt"));
        List<Integer> tempList = new ArrayList<Integer>();
        for (int num = 1; num <= p1TrunkNum; num++) {
            PartOneResult result = new PartOneResult();

            Interval[] intervals = new Interval[10];
            int cnt = 0;
            for (int x = 1; x <= 5; x++) {
                for (int y = 1; y <= 4; y++) {
                    int val = Integer.parseInt(request.getParameter(KEY + num + x + "_" + y));
                    tempList.add(val);
                }
                Interval interval1 = new Interval(tempList.get(0), tempList.get(1));
                intervals[cnt] = interval1;
                cnt++;
                Interval interval2 = new Interval(tempList.get(2), tempList.get(3));
                intervals[cnt] = interval2;
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
        final String WORD_KEY = "word";
        final String STR_KEY = "str";
        int p3TrunkNum = Integer.parseInt(request.getParameter("part3AnswerCnt"));


        for (int index = 1; index <= p3TrunkNum; index++) {
            PartThreeResult result = new PartThreeResult();
            String[] wordArr = new String[8];
            String[] strArr = new String[8];
            String word, str;
            int cnt = 8;
            for (int i = 0; i < cnt; i++) {
                word = new String(request.getParameter(WORD_KEY + index + "_" + i).getBytes("iso-8859-1"), "utf-8");
                str = new String(request.getParameter(STR_KEY + index + "_" + i).getBytes("iso-8859-1"), "utf-8");
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
    public Map<String, List<String>> getPart1Ques() {

        final int WORK_WORD_NUM = 30;
        final int TRUNK_WORD_NUM = 15;
        final int METCH_WORD_NUM = 5;
        Map<String, List<String>> quesMap = new HashMap<String, List<String>>();

        String path = this.getClass().getClassLoader().getResource("/part2.txt").getPath();//获取文件路径
        List<String> list = BananaUtils.readSrcWord(path);//得到所有词库
        System.out.println(" ");
        System.out.println("---------------getWorkWord----------------");

        List<String> workWordList = partTwoService.getWorkWord(list, WORK_WORD_NUM);
        for (int j = 0; j < workWordList.size(); j++) {
            if (j != 0 && j % 8 == 0) {
                System.out.println(workWordList.get(j));
            } else {
                System.out.print(workWordList.get(j) + " ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getTrunkWord----------------");
        List<String> trunkWordList = partTwoService.getWorkWord(workWordList, TRUNK_WORD_NUM);//得到题干词库
        quesMap.put("trunk", trunkWordList);
        for (int j = 0; j < trunkWordList.size(); j++) {
            if (j != 0 && j % 8 == 0) {
                System.out.println(trunkWordList.get(j));
            } else {
                System.out.print(trunkWordList.get(j) + " ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getMetchWord----------------");
        List<String> metchWordList;
        for (int cnt = 1; cnt <= 10; cnt++) {
            metchWordList = partTwoService.getWorkWord(workWordList, METCH_WORD_NUM);//得到单体题目词库
            quesMap.put("ques" + cnt, metchWordList);
        }

        return quesMap;
    }

    public List<PartOneResult> getPart1Answ(List<PartOneResult> partTwoResults) {

        int quesNum = 20 / partTwoResults.size();
        for (PartOneResult result : partTwoResults) {
            boolean flag = BananaUtils.judgeOverlap(result.getWordTrunk());
            System.out.println("是有合法：" + flag);
            initQues(result, quesNum);
        }

        return partTwoResults;
    }

    //part2
    public List<PartTwoResult> getPart2Ques(int part2AnswerCnt) {
        List<PartTwoResult> resultList = new ArrayList<>();
        for (int i = 1; i <= part2AnswerCnt; i++) {
            PartTwoResult result = new PartTwoResult();
            List<String> trunks = partTwoService.autoInitP2();
            String[] trunkArr = list2array(trunks);
            result.setWordTrunk(trunkArr);
            getPart2Answ(result, 20 / part2AnswerCnt, false);
            resultList.add(result);
        }
        return resultList;
    }

    public void getPart2Answ(PartTwoResult result, int num, boolean isMis) {
        logger.info("coming in getPart2Answ ====");
        List<String> trunkWordList = Arrays.asList(result.getWordTrunk());
        List<String> misStringList = new ArrayList<>();
        if (isMis) {
            misStringList = Arrays.asList(result.getMisordTrunk());
        } else {
            logger.info("the dirPath of part2.txt:" + this.getClass().getClassLoader().getResource("part2.txt").getPath());
            String mistakePath = this.getClass().getClassLoader().getResource("part2.txt").getPath();//获取文件路径
            logger.info("获取part2路径成功:" + mistakePath);
            misStringList = BananaUtils.readSrcWord(mistakePath);
        }

        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer();
            StringBuffer rsb = new StringBuffer();
            int index = (int) (Math.random() * 5);
            List<String> sblist = new ArrayList<>();
            List<String> rsblist = new ArrayList<>();

            for (String word : partTwoService.getWorkWord(misStringList, 5 - index)) {
                sblist.add(word);
            }
            for (String word : partTwoService.getWorkWord(trunkWordList, index)) {
                sblist.add(word);
                rsblist.add(word);
                rsb.append(word + " ");
            }
            if (rsb.toString().equals("")){
                rsb.append("没有词");
            }

            while (sblist.size()!=0){
                Random random = new Random();
                int n = random.nextInt(sblist.size());
                sb.append(sblist.get(n)+" ");
                sblist.remove(n);
            }

            Answer answer = new Answer();
            String choose = transferAnsw(index);
            answer.setChoose(choose);
            answer.setTureWords(rsb.toString());
            answer.setMatchNum(sb.toString());
            answer.setTureWordCnt(String.valueOf(index));
            answers.add(answer);
        }
        result.setAnswers(answers);
    }

    //part2
    public Map<String, List<String>> getPart3Ques() {
        String[] keyArr = {"人", "生", "若", "只", "如", "初", "见"};
        String[] valArr = {"r", "s", "r2", "z", "r3", "c", "j"};

        return null;
    }

    public void getPart3Answ(List<PartThreeResult> resultList, int num) {
        for (PartThreeResult result : resultList) {
            List<String> wordList = Arrays.asList(result.getWordTrunk());
            List<String> strList = Arrays.asList(result.getStrTrunk());
            List<Integer> ints = new ArrayList<>();
            Map<String, String> qMap = new HashMap<>();
            List<Part3Print> part3PrintList = new ArrayList<>();
            for (int cnt = 0; ; cnt++) {
                for (int i = 0; ; i++) {
                    int intKey = (int) (Math.random() * 8);
                    if (ints.size() < 4) {
                        if (ints.contains(intKey)) {
                            continue;
                        }
                        ints.add(intKey);
                    } else {
                        break;
                    }

                }
                StringBuffer matchStr = new StringBuffer();
                StringBuffer metchWord = new StringBuffer();
                for (int i : ints) {
                    matchStr.append(strList.get(i));
                    metchWord.append(wordList.get(i));
                }
                ints.clear();
                if (qMap.containsKey(metchWord.toString())) {
                    continue;
                }
                qMap.put(metchWord.toString(), matchStr.toString());
                Part3Print part3Print = new Part3Print();
                part3Print.setQuesTrunk(metchWord.toString());
                part3Print.setAnswer(matchStr.toString());
                part3PrintList.add(part3Print);
                if (qMap.size() == num) {
                    break;
                }
            }
            result.setPart3PrintList(part3PrintList);
        }
    }

    private String transferAnsw(int cnt) {
        String answer = "";
        switch (cnt) {
            case 0:
                answer = "A";
                break;
            case 1:
                answer = "B";
                break;
            case 2:
                answer = "C";
                break;
            case 3:
                answer = "D";
                break;
            case 4:
                answer = "E";
                break;
            case 5:
                answer = "F";
                break;
        }
        return answer;
    }

    private String transferCode(int cnt) {
        String answer = "";
        switch (cnt) {
            case 0:
                answer = "①";
                break;
            case 1:
                answer = "②";
                break;
            case 2:
                answer = "③";
                break;
            case 3:
                answer = "④";
                break;
            case 4:
                answer = "⑤";
                break;
        }
        return answer;
    }

    /**
     * 根据字符随机生成字符串
     * @param k
     * @return
     */
    private String sortString(String k) {

        List<String> list = Arrays.asList(k.split(""));
        Collections.shuffle(list);
        String out = new String();
        for (String s : list) {
            out += s;
        }
        return out;
    }

    /**
     * 导出文档
     * @param dataMap
     * @param savaPath
     * @param response
     * @throws IOException
     */
    public void createDoc(Map<String, Object> dataMap, String savaPath, HttpServletResponse response) throws IOException {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
        //这里我们的模板是放在template包下面
        /** 加载文件 **/

        String filename = savaPath.substring(savaPath.lastIndexOf("/") + 1);
        response.setCharacterEncoding("utf-8");
//        response.setHeader("Content-Disposition", "attachment;" + " filename=" + filename);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename + ".doc", "UTF-8"));
        String templateFolder = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
        configuration.setDirectoryForTemplateLoading(new File(templateFolder));

        Template t = null;
        try {
            //test.ftl为要装载的模板
            t = configuration.getTemplate("template.ftl", "UTF-8");
            //输出文档路径及名称
            Writer out = response.getWriter();
            t.process(dataMap, out);
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("---------------------------");
    }

    /**
     * 手动获取第二题
     * @param request
     * @param part2AnswerCnt
     * @return
     */
    private List<PartTwoResult> initP2Result(HttpServletRequest request, int part2AnswerCnt) {
        logger.info("进入init2resule方法");
        List<PartTwoResult> resultList = new ArrayList<>();
        try {
            for (int i = 1; i <= part2AnswerCnt; i++) {
                PartTwoResult result = new PartTwoResult();
                String q2trunk = new String(request.getParameter("q2Trunk_" + i).getBytes("iso-8859-1"), "utf-8");
                boolean isMis = true;
                try {
                    new String(request.getParameter("q2Mis_" + i).getBytes("iso-8859-1"), "utf-8");
                } catch (NullPointerException e) {
                    isMis = false;
                }
                if (isMis) {
                    String q2Mis = new String(request.getParameter("q2MisWord_" + i).getBytes("iso-8859-1"), "utf-8");
                    String[] q2Miss = q2Mis.split("\\s");
                    result.setMisordTrunk(q2Miss);
                }

                String[] q2trunks = q2trunk.split("\\s");
                result.setWordTrunk(q2trunks);

                getPart2Answ(result, 20 / part2AnswerCnt, isMis);
                resultList.add(result);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("你输了什么玩意，怎么转换还乱码了呢？");
        }
        return resultList;
    }

    /**
     * 检查是否有交集
     * @param a
     * @param b
     * @return
     */
    private boolean iscomplax(Interval a, Interval b) {
        int numA = a.getStart() > b.getStart() ? a.getStart() : b.getStart();
        int numB = a.getEnd() < b.getEnd() ? a.getEnd() : b.getEnd();
        if (numA <= numB) {
            return false;
        }
        return true;
    }

    /**
     * 检查第二题是否合法
     * @param part2Result
     * @return
     */
    private boolean checkp2Illage(List<PartTwoResult> part2Result) {
        for (PartTwoResult result : part2Result) {
            if (result.getWordTrunk().length != 15) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查第三题是否有重复
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public static boolean cheakIsRepeat(HttpServletRequest request) throws UnsupportedEncodingException {
        final String WORD_KEY = "word";
        final String STR_KEY = "str";
        int p3TrunkNum = Integer.parseInt(request.getParameter("part3AnswerCnt"));


        for (int index = 1; index <= p3TrunkNum; index++) {
            PartThreeResult result = new PartThreeResult();
            String[] wordArr = new String[8];
            String[] strArr = new String[8];
            String word, str;
            int cnt = 8;
            for (int i = 0; i < cnt; i++) {
                word = new String(request.getParameter(WORD_KEY + index + "_" + i).getBytes("iso-8859-1"), "utf-8");
                str = new String(request.getParameter(STR_KEY + index + "_" + i).getBytes("iso-8859-1"), "utf-8");
                wordArr[i] = word;
                strArr[i] = str;
                result.setWordTrunk(wordArr);
                result.setStrTrunk(strArr);
            }
            HashSet<String> whashSet = new HashSet<String>();
            HashSet<String> shashSet = new HashSet<String>();
            String[] warray = result.getWordTrunk();
            String[] sarray = result.getStrTrunk();
            for (int i = 0; i < warray.length; i++) {
                whashSet.add(warray[i]);
            }
            if (whashSet.size() != warray.length) {
                return true;
            }

            for (int i = 0; i < sarray.length; i++) {
                shashSet.add(sarray[i]);
            }
            if (shashSet.size() != sarray.length) {
                return true;
            }

        }
        return false;
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

