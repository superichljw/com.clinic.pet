<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/web-project/project_hp/css/main.css">
<script type="text/javascript" src="/web-project/project_hp/javascript/main.js"></script>
    <style>
        * {
            font-family: 'NanumSquare';
        }

        body {
            background-image: url('/web-project/project_hp/image/loginback.png');
            background-repeat: no-repeat;
            background-position: center;
            width: 400px;
            height: 500px;
            margin: 0 auto;
        }

        table {
            font-size: 20px;
            text-align: left;
            margin-right: 0px;
        }

        

        td {
            padding-bottom: 15px;
        }

        
    </style>
</head>
<body>
<div id="logo">
        <div><img src="/web-project/project_hp/image/new_logo.png"></div>
    </div>
    <div>
        <form action="/web-project/vetclinicLogin.do" method="post" name="frm">
            <table>
                <tr>
                    <td style="padding-top: 30px;">아 이 디</td>
                </tr>
                <tr>
                    <td><input type="text" class="input1" name="userid"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                </tr>
                <tr>
                    <td><input type="password" class="input1" name="pwd" style="font-family:gulim"></td>
                </tr>
                <tr>
                    <td style="width: 150px; text-align: center; padding-top: 30px;">
                        <input type="submit" value="로그인" class="input2" onclick="return loginCheck()">
                        <input type="button" value="아이디/비밀번호 찾기" class="input2-sch" style="margin-left: 20px;"
                            onclick="location.href='#'">
                    </td>

                </tr>
                <tr>
                    <td style="text-align: center;padding-top: 30px;">아직 회원이 아니신가요?</td>

                </tr>
                <tr>
                    <td style="text-align: center;padding-top: 20px;">
                    <input type="button" value="회원가입" class="input3"
                            onclick="showPopupSignup()"></td>
                </tr>
            </table>
        </form>
    </div>
    <script >

        function showPopupSignup() { 
            window.open("signup.jsp", "signup", "width=630, height=830, left=400, top=50"); 
        window.open("signup.jsp", "signup", "width=630, height=830, left=400, top=50");}
    </script>
</body>
</html>