<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/a.css" type="text/css">
<style type="text/css">
    body, table{font-size:16px;}
    table{
        table-layout:fixed;
        empty-cells:show;
        border-collapse: collapse;
        margin:0 auto;
    }
    td{height:30px;}
    h1, h2, h3{
        font-size:12px;
        margin:0;
        padding:0;
    }
    .table{
        border:1px solid #cad9ea;
        color:#666;
    }
    .table th{
        background-repeat:repeat-x;
        height:30px;
    }
    .table td, .table th{
        border:1px solid #cad9ea;
        padding:0 1em 0;
    }
    .table tr.alter{
        background-color:#f5fafe;
    }
</style>
<body>

    <form id="queryForm" method="post" action="/index/doJob">
        <%--<table  style="width: 60%; height: 70%; border: 0px; font-size: 12px;padding-bottom: 30px">--%>
        <div  style="height: 500px; padding: 20px 0px 10px 30px">
            <table class="table" >
                <tr id="answerCnt">
                    <td><label for="part1AnswerCnt">第一大题小题数</label></td>
                    <td><select id="part1AnswerCnt" name="part1AnswerCnt" onchange="showP1(this.value)" style="width: 155px;" data-option="required:true">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="4">4</option>
                    </select></td>
                    <td><label for="part2AnswerCnt">第二大题小题数</label></td>
                    <td><select id="part2AnswerCnt" name="part2AnswerCnt" onchange="showP2(this.value)" style="width: 155px;" data-option="required:true">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="4">4</option>
                    </select></td>
                    <td><label for="part3AnswerCnt">第三大题小题数</label></td>
                    <td><select id="part3AnswerCnt" name="part3AnswerCnt" onchange="showP3(this.value)" style="width: 155px;" data-option="required:true">
                        <option value="1" selected="selected">1</option>
                        <option value="2">2</option>
                        <option value="4">4</option>
                    </select></td>
                    <td><label for="isAuto">自动生成试卷</label></td>
                    <td><select id="isAuto" name="isAuto" onchange="isAuto(this.value)" style="width: 155px;" data-option="required:true">
                        <option value="0" selected="selected">NO</option>
                        <option value="1">YES</option>

                    </select></td>
                    <td><label for="savePath">保存路径(参考 D://data/xx.doc)</label></td>
                    <td><input id="savePath" name="savePath" style="width: 155px;" data-option="required:true"/></td>
                </tr>
            </table>
            <div style="text-align:center; vertical-align:middle;height: 50px"></div>
            <div style="height: 50px;padding-top: 50px;text-align:center; vertical-align:middle;" ><label>第一题输入框</label></div>

        <table class="table" id="p1t1">
            <tr>
                <td><label for="rank11_1">范围组一:</label></td>
                <td><input id="rank11_1" name="rank11_1" style="width: 155px;" data-option="required:true" value="2608"/></td>
                <td><label for="rank11_2">至:</label></td>
                <td><input id="rank11_2" name="rank11_2" style="width: 155px;" data-option="required:true" value="2977"/></td>
                <td><label for="rank11_3">和</label></td>
                <td><input id="rank11_3" name="rank11_3" style="width: 155px;" data-option="required:true" value="3838"/></td>
                <td><label for="rank11_4">至:</label></td>
                <td><input id="rank11_4" name="rank11_4" style="width: 155px;" data-option="required:true" value="4020"/></td>
            </tr>
            <tr>
                <td><label for="rank12_1">范围组二:</label></td>
                <td><input id="rank12_1" name="rank12_1" style="width: 155px;" data-option="required:true" value="2134"/></td>
                <td><label for="rank12_2">至:</label></td>
                <td><input id="rank12_2" name="rank12_2" style="width: 155px;" data-option="required:true" value="2607"/></td>
                <td><label for="rank12_3">和</label></td>
                <td><input id="rank12_3" name="rank12_3" style="width: 155px;" data-option="required:true" value="4956"/></td>
                <td><label for="rank12_4">至:</label></td>
                <td><input id="rank12_4" name="rank12_4" style="width: 155px;" data-option="required:true" value="5636"/></td>
            </tr>
            <tr>
                <td><label for="rank13_1">范围组三:</label></td>
                <td><input id="rank13_1" name="rank13_1" style="width: 155px;" data-option="required:true" value="5767"/></td>
                <td><label for="rank13_2">至:</label></td>
                <td><input id="rank13_2" name="rank13_2" style="width: 155px;" data-option="required:true" value="5889"/></td>
                <td><label for="rank13_3">和</label></td>
                <td><input id="rank13_3" name="rank13_3" style="width: 155px;" data-option="required:true" value="5901"/></td>
                <td><label for="rank13_4">至:</label></td>
                <td><input id="rank13_4" name="rank13_4" style="width: 155px;" data-option="required:true" value="6230"/></td>
            </tr>
            <tr>
                <td><label for="rank14_1">范围组四:</label></td>
                <td><input id="rank14_1" name="rank14_1" style="width: 155px;" data-option="required:true" value="8558"/></td>
                <td><label for="rank14_2">至:</label></td>
                <td><input id="rank14_2" name="rank14_2" style="width: 155px;" data-option="required:true" value="9801"/></td>
                <td><label for="rank14_3">和</label></td>
                <td><input id="rank14_3" name="rank14_3" style="width: 155px;" data-option="required:true" value="6780"/></td>
                <td><label for="rank14_4">至:</label></td>
                <td><input id="rank14_4" name="rank14_4" style="width: 155px;" data-option="required:true" value="7093"/></td>
        </tr>
            <tr>
                <td><label for="rank15_1">范围组五:</label></td>
                <td><input id="rank15_1" name="rank15_1" style="width: 155px;" data-option="required:true" value="0856"/></td>
                <td><label for="rank15_2">至:</label></td>
                <td><input id="rank15_2" name="rank15_2" style="width: 155px;" data-option="required:true" value="2133"/></td>
                <td><label for="rank15_3">和</label></td>
                <td><input id="rank15_3" name="rank15_3" style="width: 155px;" data-option="required:true" value="6328"/></td>
                <td><label for="rank15_4">至:</label></td>
                <td><input id="rank15_4" name="rank15_4" style="width: 155px;" data-option="required:true" value="6421"/></td>

            </tr>
        </table>

        <div id="la2"  style="height: 50px;padding-top: 50px;text-align:center; vertical-align:middle;display: none"><label>第一题输入框</label></div>
        <table class="table" id="p1t2" style="display: none">
                <tr id="rank6">
                    <td><label for="rank21_1">范围组一:</label></td>
                    <td><input id="rank21_1" name="rank21_1" style="width: 155px;" data-option="required:true" value="2608"/></td>
                    <td><label for="rank21_2">至:</label></td>
                    <td><input id="rank21_2" name="rank21_2" style="width: 155px;" data-option="required:true" value="2977"/></td>
                    <td><label for="rank21_3">和</label></td>
                    <td><input id="rank21_3" name="rank21_3" style="width: 155px;" data-option="required:true" value="3838"/></td>
                    <td><label for="rank21_4">至:</label></td>
                    <td><input id="rank21_4" name="rank21_4" style="width: 155px;" data-option="required:true" value="4020"/></td>
                </tr>
                <tr id="rank7">
                    <td><label for="rank22_1">范围组二:</label></td>
                    <td><input id="rank22_1" name="rank22_1" style="width: 155px;" data-option="required:true" value="2134"/></td>
                    <td><label for="rank22_2">至:</label></td>
                    <td><input id="rank22_2" name="rank22_2" style="width: 155px;" data-option="required:true" value="2607"/></td>
                    <td><label for="rank22_3">和</label></td>
                    <td><input id="rank22_3" name="rank22_3" style="width: 155px;" data-option="required:true" value="4956"/></td>
                    <td><label for="rank22_4">至:</label></td>
                    <td><input id="rank22_4" name="rank22_4" style="width: 155px;" data-option="required:true" value="5636"/></td>
                </tr>
                <tr id="rank8">
                    <td><label for="rank23_1">范围组三:</label></td>
                    <td><input id="rank23_1" name="rank23_1" style="width: 155px;" data-option="required:true" value="5767"/></td>
                    <td><label for="rank23_2">至:</label></td>
                    <td><input id="rank23_2" name="rank23_2" style="width: 155px;" data-option="required:true" value="5889"/></td>
                    <td><label for="rank23_3">和</label></td>
                    <td><input id="rank23_3" name="rank23_3" style="width: 155px;" data-option="required:true" value="5901"/></td>
                    <td><label for="rank23_4">至:</label></td>
                    <td><input id="rank23_4" name="rank23_4" style="width: 155px;" data-option="required:true" value="6230"/></td>
                </tr>
                <tr id="rank9">
                    <td><label for="rank24_1">范围组四:</label></td>
                    <td><input id="rank24_1" name="rank24_1" style="width: 155px;" data-option="required:true" value="8558"/></td>
                    <td><label for="rank24_2">至:</label></td>
                    <td><input id="rank24_2" name="rank24_2" style="width: 155px;" data-option="required:true" value="9801"/></td>
                    <td><label for="rank24_3">和</label></td>
                    <td><input id="rank24_3" name="rank24_3" style="width: 155px;" data-option="required:true" value="6780"/></td>
                    <td><label for="rank24_4">至:</label></td>
                    <td><input id="rank24_4" name="rank24_4" style="width: 155px;" data-option="required:true" value="7093"/></td>
                </tr>
                <tr id="rank10">
                    <td><label for="rank25_1">范围组五:</label></td>
                    <td><input id="rank25_1" name="rank25_1" style="width: 155px;" data-option="required:true" value="0856"/></td>
                    <td><label for="rank25_2">至:</label></td>
                    <td><input id="rank25_2" name="rank25_2" style="width: 155px;" data-option="required:true" value="2133"/></td>
                    <td><label for="rank25_3">和</label></td>
                    <td><input id="rank25_3" name="rank25_3" style="width: 155px;" data-option="required:true" value="6328"/></td>
                    <td><label for="rank25_4">至:</label></td>
                    <td><input id="rank25_4" name="rank25_4" style="width: 155px;" data-option="required:true" value="6421"/></td>
                </tr>
            </table>

        <div id="la3" style="height: 50px;padding-top: 50px;text-align:center; vertical-align:middle;display: none" ><label>第一题输入框</label></div>
        <table class="table" id="p1t3" style="display: none">

                <tr>
                    <td><label for="rank31_1">范围组一:</label></td>
                    <td><input id="rank31_1" name="rank31_1" style="width: 155px;" data-option="required:true" value="2608"/></td>
                    <td><label for="rank31_2">至:</label></td>
                    <td><input id="rank31_2" name="rank31_2" style="width: 155px;" data-option="required:true" value="2977"/></td>
                    <td><label for="rank31_3">和</label></td>
                    <td><input id="rank31_3" name="rank31_3" style="width: 155px;" data-option="required:true" value="3838"/></td>
                    <td><label for="rank31_4">至:</label></td>
                    <td><input id="rank31_4" name="rank31_4" style="width: 155px;" data-option="required:true" value="4020"/></td>
                </tr>
                <tr>
                    <td><label for="rank32_1">范围组二:</label></td>
                    <td><input id="rank32_1" name="rank32_1" style="width: 155px;" data-option="required:true" value="2134"/></td>
                    <td><label for="rank32_2">至:</label></td>
                    <td><input id="rank32_2" name="rank32_2" style="width: 155px;" data-option="required:true" value="2607"/></td>
                    <td><label for="rank32_3">和</label></td>
                    <td><input id="rank32_3" name="rank32_3" style="width: 155px;" data-option="required:true" value="4956"/></td>
                    <td><label for="rank32_4">至:</label></td>
                    <td><input id="rank32_4" name="rank32_4" style="width: 155px;" data-option="required:true" value="5636"/></td>
                </tr>
                <tr>
                    <td><label for="rank33_1">范围组三:</label></td>
                    <td><input id="rank33_1" name="rank33_1" style="width: 155px;" data-option="required:true" value="5767"/></td>
                    <td><label for="rank33_2">至:</label></td>
                    <td><input id="rank33_2" name="rank33_2" style="width: 155px;" data-option="required:true" value="5889"/></td>
                    <td><label for="rank33_3">和</label></td>
                    <td><input id="rank33_3" name="rank33_3" style="width: 155px;" data-option="required:true" value="5901"/></td>
                    <td><label for="rank33_4">至:</label></td>
                    <td><input id="rank33_4" name="rank33_4" style="width: 155px;" data-option="required:true" value="6230"/></td>
                </tr>
                <tr>
                    <td><label for="rank34_1">范围组四:</label></td>
                    <td><input id="rank34_1" name="rank34_1" style="width: 155px;" data-option="required:true" value="8558"/></td>
                    <td><label for="rank34_2">至:</label></td>
                    <td><input id="rank34_2" name="rank34_2" style="width: 155px;" data-option="required:true" value="9801"/></td>
                    <td><label for="rank34_3">和</label></td>
                    <td><input id="rank34_3" name="rank34_3" style="width: 155px;" data-option="required:true" value="6780"/></td>
                    <td><label for="rank34_4">至:</label></td>
                    <td><input id="rank34_4" name="rank34_4" style="width: 155px;" data-option="required:true" value="7093"/></td>
                </tr>
                <tr>
                    <td><label for="rank35_1">范围组五:</label></td>
                    <td><input id="rank35_1" name="rank35_1" style="width: 155px;" data-option="required:true" value="0856"/></td>
                    <td><label for="rank35_2">至:</label></td>
                    <td><input id="rank35_2" name="rank35_2" style="width: 155px;" data-option="required:true" value="2133"/></td>
                    <td><label for="rank35_3">和</label></td>
                    <td><input id="rank35_3" name="rank35_3" style="width: 155px;" data-option="required:true" value="6328"/></td>
                    <td><label for="rank35_4">至:</label></td>
                    <td><input id="rank35_4" name="rank35_4" style="width: 155px;" data-option="required:true" value="6421"/></td>
                </tr>
            </table>

        <div id="la4" style="height: 50px;padding-top: 50px;text-align:center; vertical-align:middle; display: none" ><label>第一题输入框</label></div>
        <table class="table" id="p1t4" style="display: none">
                <tr>
                    <td><label for="rank41_1">范围组一:</label></td>
                    <td><input id="rank41_1" name="rank41_1" style="width: 155px;" data-option="required:true" value="2608"/></td>
                    <td><label for="rank41_2">至:</label></td>
                    <td><input id="rank41_2" name="rank41_2" style="width: 155px;" data-option="required:true" value="2977"/></td>
                    <td><label for="rank41_3">和</label></td>
                    <td><input id="rank41_3" name="rank41_3" style="width: 155px;" data-option="required:true" value="3838"/></td>
                    <td><label for="rank41_4">至:</label></td>
                    <td><input id="rank41_4" name="rank41_4" style="width: 155px;" data-option="required:true" value="4020"/></td>
                </tr>
                <tr>
                    <td><label for="rank42_1">范围组二:</label></td>
                    <td><input id="rank42_1" name="rank42_1" style="width: 155px;" data-option="required:true" value="2134"/></td>
                    <td><label for="rank42_2">至:</label></td>
                    <td><input id="rank42_2" name="rank42_2" style="width: 155px;" data-option="required:true" value="2607"/></td>
                    <td><label for="rank42_3">和</label></td>
                    <td><input id="rank42_3" name="rank42_3" style="width: 155px;" data-option="required:true" value="4956"/></td>
                    <td><label for="rank42_4">至:</label></td>
                    <td><input id="rank42_4" name="rank42_4" style="width: 155px;" data-option="required:true" value="5636"/></td>
                </tr>
                <tr>
                    <td><label for="rank43_1">范围组三:</label></td>
                    <td><input id="rank43_1" name="rank43_1" style="width: 155px;" data-option="required:true" value="5767"/></td>
                    <td><label for="rank43_2">至:</label></td>
                    <td><input id="rank43_2" name="rank43_2" style="width: 155px;" data-option="required:true" value="5889"/></td>
                    <td><label for="rank43_3">和</label></td>
                    <td><input id="rank43_3" name="rank43_3" style="width: 155px;" data-option="required:true" value="5901"/></td>
                    <td><label for="rank43_4">至:</label></td>
                    <td><input id="rank43_4" name="rank43_4" style="width: 155px;" data-option="required:true" value="6230"/></td>
                </tr>
                <tr>
                    <td><label for="rank44_1">范围组四:</label></td>
                    <td><input id="rank44_1" name="rank44_1" style="width: 155px;" data-option="required:true" value="8558"/></td>
                    <td><label for="rank44_2">至:</label></td>
                    <td><input id="rank44_2" name="rank44_2" style="width: 155px;" data-option="required:true" value="9801"/></td>
                    <td><label for="rank44_3">和</label></td>
                    <td><input id="rank44_3" name="rank44_3" style="width: 155px;" data-option="required:true" value="6780"/></td>
                    <td><label for="rank44_4">至:</label></td>
                    <td><input id="rank44_4" name="rank44_4" style="width: 155px;" data-option="required:true" value="7093"/></td>
                </tr>
                <tr>
                    <td><label for="rank45_1">范围组五:</label></td>
                    <td><input id="rank45_1" name="rank45_1" style="width: 155px;" data-option="required:true" value="0856"/></td>
                    <td><label for="rank45_2">至:</label></td>
                    <td><input id="rank45_2" name="rank45_2" style="width: 155px;" data-option="required:true" value="2133"/></td>
                    <td><label for="rank45_3">和</label></td>
                    <td><input id="rank45_3" name="rank45_3" style="width: 155px;" data-option="required:true" value="6328"/></td>
                    <td><label for="rank45_4">至:</label></td>
                    <td><input id="rank45_4" name="rank45_4" style="width: 155px;" data-option="required:true" value="6421"/></td>
                </tr>
            </table>


            <div id="p2txt1" style="text-align:center; vertical-align:middle;">
                <div style="height: 50px;padding-top: 50px"><label>第二题输入框，单词之间务必用空格隔开,是否手动加入干扰词 ：<input id="q2Mis_1" name="q2Mis_1" type="checkbox"
                value="1" style="width: 16px;height: 16px;border: 1px solid #fd8845;" onchange="showM1(this.value)"></label></div>
                <input id="q2Trunk_1" name="q2Trunk_1" type="text" value="瑰丽 哈达 尸骸 引吭高歌 沆瀣一气 干涸 一丘之貉 上颌 负荷 蛮横 发横财 一哄而散 囫囵吞枣 怙恶不悛 无敌" style="width: 40%;height: 60px;padding-bottom: 30px">
                <input id="q2MisWord_1" name="q2MisWord_1" type="text" value="请输入15个干扰性单词，词与词之间用空格隔开" style="width: 40%;height: 60px;padding-bottom: 30px;display: none">

            </div>
            <div id="p2txt2" style="text-align:center; vertical-align:middle;display: none;">
                <div style="height: 50px;padding-top: 50px"><label>第二题输入框，单词之间务必用空格隔开,是否手动加入干扰词 ：<input id="q2Mis_2" name="q2Mis_2" type="checkbox" value="1"
                    style="width: 16px;height: 16px;border: 1px solid #fd8845;" onchange="showM2(this.value)"></label></div>
                <input id="q2Trunk_2" name="q2Trunk_2" type="text" value="瑰丽 哈达 尸骸 引吭高歌 沆瀣一气 干涸 一丘之貉 上颌 负荷 蛮横 发横财 一哄而散 囫囵吞枣 怙恶不悛 无敌" style="width: 40%;height: 60px;padding-bottom: 30px">
                <input id="q2MisWord_2" name="q2MisWord_2" type="text" value="请输入15个干扰性单词，词与词之间用空格隔开" style="width: 40%;height: 60px;padding-bottom: 30px;display: none">

            </div>
            <div id="p2txt3" style="text-align:center; vertical-align:middle;display: none;">
                <div style="height: 50px;padding-top: 50px"><label>第二题输入框，单词之间务必用空格隔开,是否手动加入干扰词 ：<input id="q2Mis_3" name="q2Mis_3" type="checkbox" value="1"
                     style="width: 16px;height: 16px;border: 1px solid #fd8845;" onchange="showM3(this.value)"></label></div>
                <input id="q2Trunk_3" name="q2Trunk_3" type="text" value="瑰丽 哈达 尸骸 引吭高歌 沆瀣一气 干涸 一丘之貉 上颌 负荷 蛮横 发横财 一哄而散 囫囵吞枣 怙恶不悛 无敌" style="width: 40%;height: 60px;padding-bottom: 30px">
                <input id="q2MisWord_3" name="q2MisWord_3" type="text" value="请输入15个干扰性单词，词与词之间用空格隔开" style="width: 40%;height: 60px;padding-bottom: 30px;display: none">

            </div>
            <div id="p2txt4" style="text-align:center; vertical-align:middle;display: none;">
                <div style="height: 50px;padding-top: 50px"><label>第二题输入框，单词之间务必用空格隔开,是否手动加入干扰词 ：<input id="q2Mis_4" name="q2Mis_4" type="checkbox" value="1"
                     style="width: 16px;height: 16px;border: 1px solid #fd8845;" onchange="showM4(this.value)"></label></div>
                <input id="q2Trunk_4" name="q2Trunk_4" type="text" value="瑰丽 哈达 尸骸 引吭高歌 沆瀣一气 干涸 一丘之貉 上颌 负荷 蛮横 发横财 一哄而散 囫囵吞枣 怙恶不悛 无敌" style="width: 40%;height: 60px;padding-bottom: 30px">
                <input id="q2MisWord_4" name="q2MisWord_4" type="text" value="请输入15个干扰性单词，词与词之间用空格隔开" style="width: 40%;height: 60px;padding-bottom: 30px;display: none">

            </div>
            <div style="text-align:center; vertical-align:middle;">
            <%--<button id="addP2Btn" name="addP2Btn">新增（暂未开放）</button>--%>
            </div>
            <div style="text-align:center; vertical-align:middle;">
        <div id="p3t1">
        <h5 style="align-content: center">第三题</h5>
        <table   style="border: 0px; font-size: 12px;padding-bottom: 30px">
            <tr id="word1">
                <td><input id="word1_0" name="word1_0" style="width: 60px;height: 30px" data-option="required:true" value="自"/></td>
                <td><input id="word1_1" name="word1_1" style="width: 60px;height: 30px" data-option="required:true" value="强"/></td>
                <td><input id="word1_2" name="word1_2" style="width: 60px;height: 30px" data-option="required:true" value="不"/></td>
                <td><input id="word1_3" name="word1_3" style="width: 60px;height: 30px" data-option="required:true" value="息"/></td>
                <td><input id="word1_4" name="word1_4" style="width: 60px;height: 30px" data-option="required:true" value="厚"/></td>
                <td><input id="word1_5" name="word1_5" style="width: 60px;height: 30px" data-option="required:true" value="德"/></td>
                <td><input id="word1_6" name="word1_6" style="width: 60px;height: 30px" data-option="required:true" value="载"/></td>
                <td><input id="word1_7" name="word1_7" style="width: 60px;height: 30px" data-option="required:true" value="物"/></td>
            </tr>
            <tr id="str1">
                <td><input id="str1_0"  name="str1_0"  style="width: 60px;height: 30px" data-option="required:true" value="N"/></td>
                <td><input id="str1_1"  name="str1_1"  style="width: 60px;height: 30px" data-option="required:true" value="H"/></td>
                <td><input id="str1_2"  name="str1_2"  style="width: 60px;height: 30px" data-option="required:true" value="4"/></td>
                <td><input id="str1_3"  name="str1_3"  style="width: 60px;height: 30px" data-option="required:true" value="8"/></td>
                <td><input id="str1_4"  name="str1_4"  style="width: 60px;height: 30px" data-option="required:true" value="P"/></td>
                <td><input id="str1_5"  name="str1_5"  style="width: 60px;height: 30px" data-option="required:true" value="M"/></td>
                <td><input id="str1_6"  name="str1_6"  style="width: 60px;height: 30px" data-option="required:true" value="5"/></td>
                <td><input id="str1_7"  name="str1_7"  style="width: 60px;height: 30px" data-option="required:true" value="6"/></td>
            </tr>
        </table>
        </div>
        <div id="p3t2" style="display: none">
        <h5 style="align-content: center">第三题</h5>
        <table  style="border: 0px; font-size: 12px;padding-bottom: 30px">
            <tr>
                <td><input id="word2_0" name="word2_0" style="width: 60px;height: 30px" data-option="required:true" value="自"/></td>
                <td><input id="word2_1" name="word2_1" style="width: 60px;height: 30px" data-option="required:true" value="强"/></td>
                <td><input id="word2_2" name="word2_2" style="width: 60px;height: 30px" data-option="required:true" value="不"/></td>
                <td><input id="word2_3" name="word2_3" style="width: 60px;height: 30px" data-option="required:true" value="息"/></td>
                <td><input id="word2_4" name="word2_4" style="width: 60px;height: 30px" data-option="required:true" value="厚"/></td>
                <td><input id="word2_5" name="word2_5" style="width: 60px;height: 30px" data-option="required:true" value="德"/></td>
                <td><input id="word2_6" name="word2_6" style="width: 60px;height: 30px" data-option="required:true" value="载"/></td>
                <td><input id="word2_7" name="word2_7" style="width: 60px;height: 30px" data-option="required:true" value="物"/></td>
            </tr>
            <tr id="str2">
                <td><input id="str2_0"  name="str2_0"  style="width: 60px;height: 30px" data-option="required:true" value="N"/></td>
                <td><input id="str2_1"  name="str2_1"  style="width: 60px;height: 30px" data-option="required:true" value="H"/></td>
                <td><input id="str2_2"  name="str2_2"  style="width: 60px;height: 30px" data-option="required:true" value="4"/></td>
                <td><input id="str2_3"  name="str2_3"  style="width: 60px;height: 30px" data-option="required:true" value="8"/></td>
                <td><input id="str2_4"  name="str2_4"  style="width: 60px;height: 30px" data-option="required:true" value="P"/></td>
                <td><input id="str2_5"  name="str2_5"  style="width: 60px;height: 30px" data-option="required:true" value="M"/></td>
                <td><input id="str2_6"  name="str2_6"  style="width: 60px;height: 30px" data-option="required:true" value="5"/></td>
                <td><input id="str2_7"  name="str2_7"  style="width: 60px;height: 30px" data-option="required:true" value="6"/></td>
            </tr>
        </table>
        </div>
                <div id="p3t3" style="display: none">
                    <h5 style="align-content: center">第三题</h5>
                    <table style="border: 0px; font-size: 12px;padding-bottom: 30px">
                        <tr>
                            <td><input id="word3_0" name="word3_0" style="width: 60px;height: 30px" data-option="required:true" value="自"/></td>
                            <td><input id="word3_1" name="word3_1" style="width: 60px;height: 30px" data-option="required:true" value="强"/></td>
                            <td><input id="word3_2" name="word3_2" style="width: 60px;height: 30px" data-option="required:true" value="不"/></td>
                            <td><input id="word3_3" name="word3_3" style="width: 60px;height: 30px" data-option="required:true" value="息"/></td>
                            <td><input id="word3_4" name="word3_4" style="width: 60px;height: 30px" data-option="required:true" value="厚"/></td>
                            <td><input id="word3_5" name="word3_5" style="width: 60px;height: 30px" data-option="required:true" value="德"/></td>
                            <td><input id="word3_6" name="word3_6" style="width: 60px;height: 30px" data-option="required:true" value="载"/></td>
                            <td><input id="word3_7" name="word3_7" style="width: 60px;height: 30px" data-option="required:true" value="物"/></td>
                        </tr>
                        <tr>
                            <td><input id="str3_0"  name="str3_0"  style="width: 60px;height: 30px" data-option="required:true" value="N"/></td>
                            <td><input id="str3_1"  name="str3_1"  style="width: 60px;height: 30px" data-option="required:true" value="H"/></td>
                            <td><input id="str3_2"  name="str3_2"  style="width: 60px;height: 30px" data-option="required:true" value="4"/></td>
                            <td><input id="str3_3"  name="str3_3"  style="width: 60px;height: 30px" data-option="required:true" value="8"/></td>
                            <td><input id="str3_4"  name="str3_4"  style="width: 60px;height: 30px" data-option="required:true" value="P"/></td>
                            <td><input id="str3_5"  name="str3_5"  style="width: 60px;height: 30px" data-option="required:true" value="M"/></td>
                            <td><input id="str3_6"  name="str3_6"  style="width: 60px;height: 30px" data-option="required:true" value="5"/></td>
                            <td><input id="str3_7"  name="str3_7"  style="width: 60px;height: 30px" data-option="required:true" value="6"/></td>
                        </tr>
                    </table>
                </div>
                <div id="p3t4" style="display: none">
                    <h5 style="align-content: center">第三题</h5>
                    <table style="border: 0px; font-size: 12px;padding-bottom: 30px">
                        <tr>
                            <td><input id="word4_0" name="word4_0" style="width: 60px;height: 30px" data-option="required:true" value="自"/></td>
                            <td><input id="word4_1" name="word4_1" style="width: 60px;height: 30px" data-option="required:true" value="强"/></td>
                            <td><input id="word4_2" name="word4_2" style="width: 60px;height: 30px" data-option="required:true" value="不"/></td>
                            <td><input id="word4_3" name="word4_3" style="width: 60px;height: 30px" data-option="required:true" value="息"/></td>
                            <td><input id="word4_4" name="word4_4" style="width: 60px;height: 30px" data-option="required:true" value="厚"/></td>
                            <td><input id="word4_5" name="word4_5" style="width: 60px;height: 30px" data-option="required:true" value="德"/></td>
                            <td><input id="word4_6" name="word4_6" style="width: 60px;height: 30px" data-option="required:true" value="载"/></td>
                            <td><input id="word4_7" name="word4_7" style="width: 60px;height: 30px" data-option="required:true" value="物"/></td>
                        </tr>
                        <tr>
                            <td><input id="str4_0"  name="str4_0"  style="width: 60px;height: 30px" data-option="required:true" value="N"/></td>
                            <td><input id="str4_1"  name="str4_1"  style="width: 60px;height: 30px" data-option="required:true" value="H"/></td>
                            <td><input id="str4_2"  name="str4_2"  style="width: 60px;height: 30px" data-option="required:true" value="4"/></td>
                            <td><input id="str4_3"  name="str4_3"  style="width: 60px;height: 30px" data-option="required:true" value="8"/></td>
                            <td><input id="str4_4"  name="str4_4"  style="width: 60px;height: 30px" data-option="required:true" value="P"/></td>
                            <td><input id="str4_5"  name="str4_5"  style="width: 60px;height: 30px" data-option="required:true" value="M"/></td>
                            <td><input id="str4_6"  name="str4_6"  style="width: 60px;height: 30px" data-option="required:true" value="5"/></td>
                            <td><input id="str4_7"  name="str4_7"  style="width: 60px;height: 30px" data-option="required:true" value="6"/></td>
                        </tr>
                    </table>
                </div>

                <div style="margin-top:30px;margin-bottom:50px;text-align:center; vertical-align:middle;">
                    <input type="button" value="生成" style="width:200px; height:50px; border-top:1px solid green; border-left:1px solid green; background-color:#CCC; color:blue;"
                           onclick="document.getElementById('queryForm').submit();"/>
                </div>
            </div>

    </form>
</div>
<script language="javascript" type="text/javascript">
    function showP1(val){
        if (val==1){
            document.getElementById("p1t2").style.display ="none";
            document.getElementById("p1t3").style.display ="none";
            document.getElementById("p1t4").style.display ="none";
            document.getElementById("la2").style.display ="none";
            document.getElementById("la3").style.display ="none";
            document.getElementById("la4").style.display ="none";
        }else if (val==2){
            document.getElementById("p1t2").style.display ="table";
            document.getElementById("p1t3").style.display ="none";
            document.getElementById("p1t4").style.display ="none";
            document.getElementById("la2").style.display ="block";
            document.getElementById("la3").style.display ="none";
            document.getElementById("la4").style.display ="none";
        }else if (val==4){
            document.getElementById("p1t2").style.display ="table";
            document.getElementById("p1t3").style.display ="table";
            document.getElementById("p1t4").style.display ="table";
            document.getElementById("la2").style.display ="block";
            document.getElementById("la3").style.display ="block";
            document.getElementById("la4").style.display ="block";
        }
    }
    function showP2(val){
        if (val==1){
            document.getElementById("p2txt2").style.display ="none";
            document.getElementById("p2txt3").style.display ="none";
            document.getElementById("p2txt4").style.display ="none";
        }else if (val==2){
            document.getElementById("p2txt2").style.display ="block";
            document.getElementById("p2txt3").style.display ="none";
            document.getElementById("p2txt4").style.display ="none";
        }else if (val==4){
            document.getElementById("p2txt2").style.display ="block";
            document.getElementById("p2txt3").style.display ="block";
            document.getElementById("p2txt4").style.display ="block";
        }
    }
    function showP3(val){
        if (val==1){
            document.getElementById("p3t2").style.display ="none";
            document.getElementById("p3t3").style.display ="none";
            document.getElementById("p3t4").style.display ="none";
        }else if (val==2){
            document.getElementById("p3t2").style.display ="block";
            document.getElementById("p3t3").style.display ="none";
            document.getElementById("p3t4").style.display ="none";
        }else if (val==4){
            document.getElementById("p3t2").style.display ="block";
            document.getElementById("p3t3").style.display ="block";
            document.getElementById("p3t4").style.display ="block";
        }
    }

    function showM1(){
        var stat = document.getElementById("q2MisWord_1").style.display;
        if (stat=="none"){
            document.getElementById("q2MisWord_1").style.display ="inline-block";
        }else {
            document.getElementById("q2MisWord_1").style.display ="none";
        }
    }
    function showM2(){
        var stat = document.getElementById("q2MisWord_2").style.display;
        if (stat=="none"){
            document.getElementById("q2MisWord_2").style.display ="inline-block";
        }else {
            document.getElementById("q2MisWord_2").style.display ="none";
        }
    }
    function showM3(){
        var stat = document.getElementById("q2MisWord_3").style.display;
        if (stat=="none"){
            document.getElementById("q2MisWord_3").style.display ="inline-block";
        }else {
            document.getElementById("q2MisWord_3").style.display ="none";
        }
    }
    function showM4(){
        var stat = document.getElementById("q2MisWord_4").style.display;
        if (stat=="none"){
            document.getElementById("q2MisWord_4").style.display ="inline-block";
        }else {
            document.getElementById("q2MisWord_4").style.display ="none";
        }
    }
</script>
</body>
</html>

