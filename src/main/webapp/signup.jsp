<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 페이지</title>
    <style>
        body {
            background-color: #f8f9fa; /* 배경색 변경 */
            font-family: Arial, sans-serif; /* 폰트 변경 */
            color: #333; /* 글자색 변경 */
            text-align: center;
            padding-top: 50px;
        }
        .signup-container {
            width: 350px; /* 컨테이너 너비 조정 */
            margin: auto;
            background-color: #fff; /* 백그라운드 색상 변경 */
            padding: 30px; 
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            margin-top: 50px; /* 위쪽 여백 조정 */
        }
        .form-control {
            border: none;
            border-radius: 25px;
            background-color: #f8f9fa; /* 백그라운드 색상 변경 */
            color: #333; /* 글자색 변경 */
            padding: 10px 20px; 
            margin-bottom: 15px; 
            width: calc(100% - 40px); /* 너비 조정 */
            box-sizing: border-box;
        }
        .btn-signup {
            border-radius: 25px;
            padding: 10px 20px; 
            background-color: #007bff; /* 버튼 배경색 변경 */
            color: #fff; /* 버튼 글자색 변경 */
            font-weight: bold;
            width: calc(100% - 40px); 
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-signup:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }
        .login-link {
            font-size: 12px;
            color: #333;
            text-decoration: none;
            transition: color 0.3s; /* hover 효과 추가 */
        }
        .login-link:hover {
            text-decoration: underline;
            color: #007bff; /* hover 시 글자색 변경 */
        }
        .terms-checkbox {
            text-align: left;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>회원가입</h2>
        <form class="signup-form" action="signup.do" method="post">
            <input type="text" class="form-control" name="username" placeholder="아이디" required>
            <br>
            <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
            <br>
            <input type="checkbox" id="show-password">
            <label for="show-password">비밀번호 보기</label>
            <br>
            <input type="email" class="form-control" name="email" placeholder="이메일주소 (비밀번호 찾기 등 본인 확인용)">
            <br>
            <input type="text" class="form-control" name="name" placeholder="이름">
            <br>
            <input type="text" class="form-control" name="birthdate" placeholder="생년월일 8자리">
            <br>
          
            
            <input type="radio" id="male" name="gender" value="male">
            <label for="male">남자</label>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">여자</label>
            <br>
            <input type="text" class="form-control" name="phone" placeholder="휴대전화번호">
            <br>
            <div class="terms-checkbox">
                <input type="checkbox" id="terms-checkbox" required>
                <label for="terms-checkbox">[필수] 인증 약관 전체동의</label>
            </div>
            <button type="submit" class="btn btn-signup">가입하기</button>
        </form>
        <p>이미 계정이 있으신가요? <a href="#" class="login-link">로그인하기</a></p>
    </div>
    <script>
        document.querySelector('.login-link').addEventListener('click', function() {
            window.location.href = 'loginform.jsp';
        });

        // 비밀번호 보기 기능
        document.getElementById('show-password').addEventListener('change', function() {
            var passwordField = document.querySelector('input[name="password"]');
            if (this.checked) {
                passwordField.type = 'text';
            } else {
                passwordField.type = 'password';
            }
        });
    </script>
</body>
</html>