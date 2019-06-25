<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/a.css" type="text/css">
<body>
<div style="height: 100px; padding: 20px 0px 10px 30px">
    <form id="queryForm" method="post" action="/index/doJob">
        <table  style="width: 60%; height: 70%; border: 0px; font-size: 12px">
            <tr id="answerCnt">
                <td><label for="part1AnswerCnt">第一题需要几个匹配答案</label></td>
                <td><input id="part1AnswerCnt" name="part1AnswerCnt" style="width: 155px;" data-option="required:true"/></td>
                <td><label for="part2AnswerCnt">第二题需要几个匹配答案</label></td>
                <td><input id="part2AnswerCnt" name="part2AnswerCnt" style="width: 155px;" data-option="required:true"/></td>
                <td><label for="part3AnswerCnt">第三题需要几个匹配答案</label></td>
                <td><input id="part3AnswerCnt" name="part3AnswerCnt" style="width: 155px;" data-option="required:true"/></td>
            </tr>
            <tr id="rank1">
                <td><label for="rank1_1">范围组一:</label></td>
                <td><input id="rank1_1" name="rank1_1" style="width: 155px;" data-option="required:true" value="1"/></td>
                <td><label for="rank1_2">至:</label></td>
                <td><input id="rank1_2" name="rank1_2" style="width: 155px;" data-option="required:true" value="10"/></td>
                <td><label for="rank1_3">和</label></td>
                <td><input id="rank1_3" name="rank1_3" style="width: 155px;" data-option="required:true" value="13"/></td>
                <td><label for="rank1_4">至:</label></td>
                <td><input id="rank1_4" name="rank1_4" style="width: 155px;" data-option="required:true" value="24"/></td>
            </tr>
            <tr id="rank2">
                <td><label for="rank2_1">范围组二:</label></td>
                <td><input id="rank2_1" name="rank2_1" style="width: 155px;" data-option="required:true" value="35"/></td>
                <td><label for="rank2_2">至:</label></td>
                <td><input id="rank2_2" name="rank2_2" style="width: 155px;" data-option="required:true" value="46"/></td>
                <td><label for="rank2_3">和</label></td>
                <td><input id="rank2_3" name="rank2_3" style="width: 155px;" data-option="required:true" value="57"/></td>
                <td><label for="rank2_4">至:</label></td>
                <td><input id="rank2_4" name="rank2_4" style="width: 155px;" data-option="required:true" value="68"/></td>
            </tr>
            <tr id="rank3">
                <td><label for="rank3_1">范围组三:</label></td>
                <td><input id="rank3_1" name="rank3_1" style="width: 155px;" data-option="required:true" value="79"/></td>
                <td><label for="rank3_2">至:</label></td>
                <td><input id="rank3_2" name="rank3_2" style="width: 155px;" data-option="required:true" value="81"/></td>
                <td><label for="rank3_3">和</label></td>
                <td><input id="rank3_3" name="rank3_3" style="width: 155px;" data-option="required:true" value="91"/></td>
                <td><label for="rank3_4">至:</label></td>
                <td><input id="rank3_4" name="rank3_4" style="width: 155px;" data-option="required:true" value="101"/></td>
            </tr>
            <tr id="rank4">
                <td><label for="rank4_1">范围组四:</label></td>
                <td><input id="rank4_1" name="rank4_1" style="width: 155px;" data-option="required:true" value="121"/></td>
                <td><label for="rank4_2">至:</label></td>
                <td><input id="rank4_2" name="rank4_2" style="width: 155px;" data-option="required:true" value="151"/></td>
                <td><label for="rank4_3">和</label></td>
                <td><input id="rank4_3" name="rank4_3" style="width: 155px;" data-option="required:true" value="211"/></td>
                <td><label for="rank4_4">至:</label></td>
                <td><input id="rank4_4" name="rank4_4" style="width: 155px;" data-option="required:true" value="301"/></td>
        </tr>
            <tr id="rank5">
                <td><label for="rank5_1">范围组五:</label></td>
                <td><input id="rank5_1" name="rank5_1" style="width: 155px;" data-option="required:true" value="501"/></td>
                <td><label for="rank5_2">至:</label></td>
                <td><input id="rank5_2" name="rank5_2" style="width: 155px;" data-option="required:true" value="601"/></td>
                <td><label for="rank5_3">和</label></td>
                <td><input id="rank5_3" name="rank5_3" style="width: 155px;" data-option="required:true" value="701"/></td>
                <td><label for="rank5_4">至:</label></td>
                <td><input id="rank5_4" name="rank5_4" style="width: 155px;" data-option="required:true" value="801"/></td>

            </tr>
        </table>
        <%--<label>第二题输入框，单词之间务必用逗号隔开</label>--%>
        <input id="q2Trunk" name="q2Trunk" type="text" value="第二题输入框，单词之间务必用逗号隔开" style="width: 40%;height: 60px">

        <table  style="border: 0px; font-size: 12px">

            <tr id="word">
                <td><input id="word0" name="word0" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word1" name="word1" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word2" name="word2" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word3" name="word3" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word4" name="word4" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word5" name="word5" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word6" name="word6" style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="word7" name="word7" style="width: 60px;height: 30px" data-option="required:true" /></td>
            </tr>
            <tr id="str">
                <td><input id="str0"  name="str0"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str1"  name="str1"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str2"  name="str2"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str3"  name="str3"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str4"  name="str4"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str5"  name="str5"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str6"  name="str6"  style="width: 60px;height: 30px" data-option="required:true" /></td>
                <td><input id="str7"  name="str7"  style="width: 60px;height: 30px" data-option="required:true" /></td>
            </tr>

        </table>
        <input type="button" class="a" value="提交" onclick="document.getElementById('queryForm').submit();"/>
    </form>
</div>
</body>
</html>
