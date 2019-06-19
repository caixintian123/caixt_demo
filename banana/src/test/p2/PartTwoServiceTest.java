package p2;

import com.boom.Service.PartTwoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.BaseJunit4Test;

import java.util.List;


public class PartTwoServiceTest extends BaseJunit4Test {

    @Autowired
    private PartTwoService partTwoService;

    @Test
    public void p2Test(){
        final int WORK_WORD_NUM=30;
        final int TRUNK_WORD_NUM=15;
        final int METCH_WORD_NUM=5;
        String path = this.getClass().getClassLoader().getResource("part.txt").getPath();//获取文件路径
        List<String> list= partTwoService.readSrcWord(path);
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
        List<String> trunkWordList  = partTwoService.getWorkWord(workWordList,TRUNK_WORD_NUM);
        for (int j=0;j<trunkWordList.size();j++) {
            if (j!=0 && j%8==0){
                System.out.println(trunkWordList.get(j));
            }else {
                System.out.print(trunkWordList.get(j)+" ");
            }
        }
        System.out.println(" ");
        System.out.println("---------------getMetchWord----------------");
        for (int cnt=1;cnt<=10;cnt++){

        }
        List<String> metchWordList  = partTwoService.getWorkWord(workWordList,METCH_WORD_NUM);
        for (int j=0;j<metchWordList.size();j++) {
            if (j!=0 && j%8==0){
                System.out.println(metchWordList.get(j));
            }else {
                System.out.print(metchWordList.get(j)+" ");
            }
        }
        System.out.println(" ");
    }
}
