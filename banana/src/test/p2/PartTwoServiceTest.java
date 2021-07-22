package p2;

import com.boom.Controller.IndexController;
import com.boom.Service.PartTwoService;
import com.boom.Utils.BananaUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.BaseJunit4Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PartTwoServiceTest extends BaseJunit4Test {

    @Autowired
    private PartTwoService partTwoService;
    @Autowired
    private IndexController controller;
//    @Test
//    public void p2Test(){
//        final int WORK_WORD_NUM=30;
//        final int TRUNK_WORD_NUM=15;
//        final int METCH_WORD_NUM=5;
//        Map<String,List<String>> subMap =  new HashMap<String, List<String> >();
//
//
//        String path = this.getClass().getClassLoader().getResource("part.txt").getPath();//获取文件路径
//        List<String> list= BananaUtils.readSrcWord(path);
//        System.out.println(" ");
//        System.out.println("---------------getWorkWord----------------");
//
//        List<String> workWordList  = partTwoService.getWorkWord(list,WORK_WORD_NUM);
//        for (int j=0;j<workWordList.size();j++) {
//            if (j!=0 && j%8==0){
//                System.out.println(workWordList.get(j));
//            }else {
//                System.out.print(workWordList.get(j)+" ");
//            }
//        }
//        System.out.println(" ");
//        System.out.println("---------------getTrunkWord----------------");
//        List<String> trunkWordList  = partTwoService.getWorkWord(workWordList,TRUNK_WORD_NUM);
//        for (int j=0;j<trunkWordList.size();j++) {
//            if (j!=0 && j%8==0){
//                System.out.println(trunkWordList.get(j));
//            }else {
//                System.out.print(trunkWordList.get(j)+" ");
//            }
//        }
//        System.out.println(" ");
//        System.out.println("---------------getMetchWord----------------");
//        List<String> metchWordList ;
//        for (int cnt=1;cnt<=10;cnt++){
//            metchWordList  = partTwoService.getWorkWord(workWordList,METCH_WORD_NUM);
//            subMap.put("sub"+cnt,metchWordList);
//        }
//
//    }

}
