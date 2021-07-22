<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>调用结果通知</title>
</head>
<body>
${msg}
<form id="return" action="/index/toIndex" method="post"></form>
<div style="margin-top:30px;margin-bottom:50px;text-align:center; vertical-align:middle;">
    <input type="button" value="返回" style="width:200px; height:50px; border-top:1px solid green; border-left:1px solid green; background-color:#CCC; color:blue;"
           onclick="document.getElementById('return').submit();"/>
</div>
</body>
</html>