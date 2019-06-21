<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div style="height: 100px; padding: 20px 0px 10px 30px">
    <form id="queryForm" method="post" action="/index/doJob">
        <table  style="width: 60%; height: 70%; border: 0px; font-size: 12px">
            <tr id="rank1">
                <td><label for="rank1_1">范围组一:</label></td>
                <td><input id="rank1_1" name="rank1_1" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank1_2">至:</label></td>
                <td><input id="rank1_2" name="rank1_2" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank1_3">和</label></td>
                <td><input id="rank1_3" name="rank1_3" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank1_4">至:</label></td>
                <td><input id="rank1_4" name="rank1_4" style="width: 155px;" data-option="required:true" /></td>
            </tr>
            <tr id="rank2">
                <td><label for="rank2_1">范围组二:</label></td>
                <td><input id="rank2_1" name="rank2_1" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank2_2">至:</label></td>
                <td><input id="rank2_2" name="rank2_2" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank2_3">和</label></td>
                <td><input id="rank2_3" name="rank2_3" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank2_4">至:</label></td>
                <td><input id="rank2_4" name="rank2_4" style="width: 155px;" data-option="required:true" /></td>
            </tr>
            <tr id="rank3">
                <td><label for="rank3_1">范围组三:</label></td>
                <td><input id="rank3_1" name="rank3_1" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank3_2">至:</label></td>
                <td><input id="rank3_2" name="rank3_2" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank3_3">和</label></td>
                <td><input id="rank3_3" name="rank3_3" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank3_4">至:</label></td>
                <td><input id="rank3_4" name="rank3_4" style="width: 155px;" data-option="required:true" /></td>
            </tr>
            <tr id="rank4">
                <td><label for="rank4_1">范围组四:</label></td>
                <td><input id="rank4_1" name="rank4_1" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank4_2">至:</label></td>
                <td><input id="rank4_2" name="rank4_2" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank4_3">和</label></td>
                <td><input id="rank4_3" name="rank4_3" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank4_4">至:</label></td>
                <td><input id="rank4_4" name="rank4_4" style="width: 155px;" data-option="required:true" /></td>
        </tr>
            <tr id="rank5">
                <td><label for="rank5_1">范围组五:</label></td>
                <td><input id="rank5_1" name="rank5_1" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank5_2">至:</label></td>
                <td><input id="rank5_2" name="rank5_2" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank5_3">和</label></td>
                <td><input id="rank5_3" name="rank5_3" style="width: 155px;" data-option="required:true" /></td>
                <td><label for="rank5_4">至:</label></td>
                <td><input id="rank5_4" name="rank5_4" style="width: 155px;" data-option="required:true" /></td>

            </tr>
        </table>
        <input type="button" value="提交" onclick="document.getElementById('queryForm').submit();">
    </form>
</div>
</body>
</html>
