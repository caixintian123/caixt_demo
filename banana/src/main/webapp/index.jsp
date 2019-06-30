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
<div style="height: 100px; padding: 20px 0px 10px 30px">
    <form id="queryForm" method="post" action="/index/doJob">
        <%--<table  style="width: 60%; height: 70%; border: 0px; font-size: 12px;padding-bottom: 30px">--%>
        <table class="table">
            <tr id="answerCnt">
                <td><label for="part1AnswerCnt">第一题需要几个匹配答案</label></td>
                <td><input id="part1AnswerCnt" name="part1AnswerCnt" style="width: 155px;" data-option="required:true"/></td>
                <td><label for="part2AnswerCnt">第二题需要几个匹配答案</label></td>
                <td><input id="part2AnswerCnt" name="part2AnswerCnt" style="width: 155px;" data-option="required:true"/></td>
                <td><label for="part3AnswerCnt">第三题需要几个匹配答案</label></td>
                <td><input id="part3AnswerCnt" name="part3AnswerCnt" style="width: 155px;" data-option="required:true"/></td>
            </tr>
        </table>
            <div style="text-align:center; vertical-align:middle;height: 50px"></div>

        <table class="table">
            <tr id="rank11">
                <td><label for="rank11_1">范围组一:</label></td>
                <td><input id="rank11_1" name="rank11_1" style="width: 155px;" data-option="required:true" value="1"/></td>
                <td><label for="rank11_2">至:</label></td>
                <td><input id="rank11_2" name="rank11_2" style="width: 155px;" data-option="required:true" value="10"/></td>
                <td><label for="rank11_3">和</label></td>
                <td><input id="rank11_3" name="rank11_3" style="width: 155px;" data-option="required:true" value="13"/></td>
                <td><label for="rank11_4">至:</label></td>
                <td><input id="rank11_4" name="rank11_4" style="width: 155px;" data-option="required:true" value="24"/></td>
            </tr>
            <tr id="rank2">
                <td><label for="rank12_1">范围组二:</label></td>
                <td><input id="rank12_1" name="rank12_1" style="width: 155px;" data-option="required:true" value="35"/></td>
                <td><label for="rank12_2">至:</label></td>
                <td><input id="rank12_2" name="rank12_2" style="width: 155px;" data-option="required:true" value="46"/></td>
                <td><label for="rank12_3">和</label></td>
                <td><input id="rank12_3" name="rank12_3" style="width: 155px;" data-option="required:true" value="57"/></td>
                <td><label for="rank12_4">至:</label></td>
                <td><input id="rank12_4" name="rank12_4" style="width: 155px;" data-option="required:true" value="68"/></td>
            </tr>
            <tr id="rank3">
                <td><label for="rank13_1">范围组三:</label></td>
                <td><input id="rank13_1" name="rank13_1" style="width: 155px;" data-option="required:true" value="79"/></td>
                <td><label for="rank13_2">至:</label></td>
                <td><input id="rank13_2" name="rank13_2" style="width: 155px;" data-option="required:true" value="81"/></td>
                <td><label for="rank13_3">和</label></td>
                <td><input id="rank13_3" name="rank13_3" style="width: 155px;" data-option="required:true" value="91"/></td>
                <td><label for="rank13_4">至:</label></td>
                <td><input id="rank13_4" name="rank13_4" style="width: 155px;" data-option="required:true" value="101"/></td>
            </tr>
            <tr id="rank4">
                <td><label for="rank14_1">范围组四:</label></td>
                <td><input id="rank14_1" name="rank14_1" style="width: 155px;" data-option="required:true" value="121"/></td>
                <td><label for="rank14_2">至:</label></td>
                <td><input id="rank14_2" name="rank14_2" style="width: 155px;" data-option="required:true" value="151"/></td>
                <td><label for="rank14_3">和</label></td>
                <td><input id="rank14_3" name="rank14_3" style="width: 155px;" data-option="required:true" value="211"/></td>
                <td><label for="rank14_4">至:</label></td>
                <td><input id="rank14_4" name="rank14_4" style="width: 155px;" data-option="required:true" value="301"/></td>
        </tr>
            <tr id="rank5">
                <td><label for="rank15_1">范围组五:</label></td>
                <td><input id="rank15_1" name="rank15_1" style="width: 155px;" data-option="required:true" value="501"/></td>
                <td><label for="rank15_2">至:</label></td>
                <td><input id="rank15_2" name="rank15_2" style="width: 155px;" data-option="required:true" value="601"/></td>
                <td><label for="rank15_3">和</label></td>
                <td><input id="rank15_3" name="rank15_3" style="width: 155px;" data-option="required:true" value="701"/></td>
                <td><label for="rank15_4">至:</label></td>
                <td><input id="rank15_4" name="rank15_4" style="width: 155px;" data-option="required:true" value="801"/></td>

            </tr>
        </table>

        <table class="table">
                <tr id="rank6">
                    <td><label for="rank21_1">范围组一:</label></td>
                    <td><input id="rank21_1" name="rank21_1" style="width: 155px;" data-option="required:true" value="1"/></td>
                    <td><label for="rank21_2">至:</label></td>
                    <td><input id="rank21_2" name="rank21_2" style="width: 155px;" data-option="required:true" value="10"/></td>
                    <td><label for="rank21_3">和</label></td>
                    <td><input id="rank21_3" name="rank21_3" style="width: 155px;" data-option="required:true" value="13"/></td>
                    <td><label for="rank21_4">至:</label></td>
                    <td><input id="rank21_4" name="rank21_4" style="width: 155px;" data-option="required:true" value="24"/></td>
                </tr>
                <tr id="rank7">
                    <td><label for="rank22_1">范围组二:</label></td>
                    <td><input id="rank22_1" name="rank22_1" style="width: 155px;" data-option="required:true" value="35"/></td>
                    <td><label for="rank22_2">至:</label></td>
                    <td><input id="rank22_2" name="rank22_2" style="width: 155px;" data-option="required:true" value="46"/></td>
                    <td><label for="rank22_3">和</label></td>
                    <td><input id="rank22_3" name="rank22_3" style="width: 155px;" data-option="required:true" value="57"/></td>
                    <td><label for="rank22_4">至:</label></td>
                    <td><input id="rank22_4" name="rank22_4" style="width: 155px;" data-option="required:true" value="68"/></td>
                </tr>
                <tr id="rank8">
                    <td><label for="rank23_1">范围组三:</label></td>
                    <td><input id="rank23_1" name="rank23_1" style="width: 155px;" data-option="required:true" value="79"/></td>
                    <td><label for="rank23_2">至:</label></td>
                    <td><input id="rank23_2" name="rank23_2" style="width: 155px;" data-option="required:true" value="81"/></td>
                    <td><label for="rank23_3">和</label></td>
                    <td><input id="rank23_3" name="rank23_3" style="width: 155px;" data-option="required:true" value="91"/></td>
                    <td><label for="rank23_4">至:</label></td>
                    <td><input id="rank23_4" name="rank23_4" style="width: 155px;" data-option="required:true" value="101"/></td>
                </tr>
                <tr id="rank9">
                    <td><label for="rank24_1">范围组四:</label></td>
                    <td><input id="rank24_1" name="rank24_1" style="width: 155px;" data-option="required:true" value="121"/></td>
                    <td><label for="rank24_2">至:</label></td>
                    <td><input id="rank24_2" name="rank24_2" style="width: 155px;" data-option="required:true" value="151"/></td>
                    <td><label for="rank24_3">和</label></td>
                    <td><input id="rank24_3" name="rank24_3" style="width: 155px;" data-option="required:true" value="211"/></td>
                    <td><label for="rank24_4">至:</label></td>
                    <td><input id="rank24_4" name="rank24_4" style="width: 155px;" data-option="required:true" value="301"/></td>
                </tr>
                <tr id="rank10">
                    <td><label for="rank25_1">范围组五:</label></td>
                    <td><input id="rank25_1" name="rank25_1" style="width: 155px;" data-option="required:true" value="501"/></td>
                    <td><label for="rank25_2">至:</label></td>
                    <td><input id="rank25_2" name="rank25_2" style="width: 155px;" data-option="required:true" value="601"/></td>
                    <td><label for="rank25_3">和</label></td>
                    <td><input id="rank25_3" name="rank25_3" style="width: 155px;" data-option="required:true" value="701"/></td>
                    <td><label for="rank25_4">至:</label></td>
                    <td><input id="rank25_4" name="rank25_4" style="width: 155px;" data-option="required:true" value="801"/></td>
                </tr>
            </table>



            <div style="text-align:center; vertical-align:middle;">
                <div style="height: 50px;padding-top: 50px"><label>第二题输入框，单词之间务必用逗号隔开</label></div>
                <input id="q2Trunk_1" name="q2Trunk_1" type="text" value="" style="width: 40%;height: 60px;padding-bottom: 30px">
            </div>
            <div style="text-align:center; vertical-align:middle;">
                <div style="height: 50px;padding-top: 50px"><label>第二题输入框，单词之间务必用逗号隔开</label></div>
                <input id="q2Trunk_2" name="q2Trunk_2" type="text" value="" style="width: 40%;height: 60px;padding-bottom: 30px">
            </div>
            <div style="text-align:center; vertical-align:middle;">
            <button id="addP2Btn" name="addP2Btn">新增</button>
            </div>
            <div style="text-align:center; vertical-align:middle;">

        <h5 style="align-content: center">第二题输入框，单词之间务必用逗号隔开</h5>

        <table  style="border: 0px; font-size: 12px;padding-bottom: 30px">
            <tr id="word1">
                <td><input id="word1_0" name="word1_0" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_1" name="word1_1" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_2" name="word1_2" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_3" name="word1_3" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_4" name="word1_4" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_5" name="word1_5" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_6" name="word1_6" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1_7" name="word1_7" style="width: 60px;height: 30px" data-option="required:true" /></td>
            </tr>
            <tr id="str1">
                <td><input id="str1_0"  name="str1_0"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_1"  name="str1_1"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_2"  name="str1_2"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_3"  name="str1_3"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_4"  name="str1_4"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_5"  name="str1_5"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_6"  name="str1_6"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1_7"  name="str1_7"  style="width: 60px;height: 30px" data-option="required:true" /></td>
            </tr>
        </table>
        <p >第二题输入框，单词之间务必用逗号隔开</p>
        <table  style="border: 0px; font-size: 12px;padding-bottom: 30px">
            <tr id="word2">
                <td><input id="word2_0" name="word2_0" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_1" name="word2_1" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_2" name="word2_2" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_3" name="word2_3" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_4" name="word2_4" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_5" name="word2_5" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_6" name="word2_6" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2_7" name="word2_7" style="width: 60px;height: 30px" data-option="required:true" /></td>
            </tr>
            <tr id="str2">
                <td><input id="str2_0"  name="str2_0"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_1"  name="str2_1"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_2"  name="str2_2"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_3"  name="str2_3"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_4"  name="str2_4"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_5"  name="str2_5"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_6"  name="str2_6"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2_7"  name="str2_7"  style="width: 60px;height: 30px" data-option="required:true" /></td>
            </tr>
        </table>
                </div>

        <input type="button" class="a" value="提交" onclick="document.getElementById('queryForm').submit();"/>
    </form>
</div>
</body>
</html>

