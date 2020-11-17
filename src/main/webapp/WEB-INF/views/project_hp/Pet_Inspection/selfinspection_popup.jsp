<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자가진단</title>
<style>

</style>
<link rel="stylesheet" href="./css/main.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>

<body  class="selfinsBack">
	<h1>검사</h1>
	<ol class="selfinsOl">
		<li>
			<div class="q1">Q1.식사를 먹일 때 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">먹기 싫어해요(1점) <input
					type="checkbox" class="ckbox" value="2">가끔 잘 먹어요(2점) <input
					type="checkbox" class="ckbox" value="3">아주 잘 먹어요(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q2.애견의 털 상태는 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">푸석푸석하고 윤기가
				없어요(1점) <input type="checkbox" class="ckbox" value="2">보통이에요(2점)
				<input type="checkbox" class="ckbox" value="3">멋지게 윤기나요(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q3.애견의 피부상태는 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">자주 긁고 각질이
				벗겨져요(1점) <input type="checkbox" class="ckbox" value="2">보통이에요(2점)
				<input type="checkbox" class="ckbox" value="3">아주 건강해요(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q4.애견의 활동량은 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">잘 안 움직여요(1점)
				<input type="checkbox" class="ckbox" value="2">어느정도 좋아요(2점)
				<input type="checkbox" class="ckbox" value="3">아주 활발해요(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q5.애견의 눈은 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">눈이 흐릿하고 눈곱이 잘
				껴요(1점) <input type="checkbox" class="ckbox" value="2">보통이에요(2점)
				<input type="checkbox" class="ckbox" value="3">맑고 반짝여요(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q6.애견의 변상태는 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">무르고 지저분해요(1점)
				<input type="checkbox" class="ckbox" value="2">단단해요(2점)
			</div>
		</li>
		<li>
			<div class="q1">Q7.하루에 몇번 변을 보나요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">하루 세 번 이상(1점)
				<input type="checkbox" class="ckbox" value="2">하루 두 번(2점) <input
					type="checkbox" class="ckbox" value="3">하루 한 번(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q8.애견의 치아상태는 어떤가요?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">치석이 많이 끼고 냄새가
				납니다(1점) <input type="checkbox" class="ckbox" value="2">보통이에요(2점)
				<input type="checkbox" class="ckbox" value="3">치석없이 치아가
				깨끗해요(3점)
			</div>
		</li>
		<li>
			<div class="q1">Q9.전체적인 애견 상태는?</div>
			<div class="check1">
				<input type="checkbox" class="ckbox" value="1">건강하지 못해요(1점)
				<input type="checkbox" class="ckbox" value="2">건강해요(2점) <input
					type="checkbox" class="ckbox" value="3">아주 건강해요(3점)
			</div>
		</li>
		<!-- <li>
            <div class="q1">질문10 </div>
            <div class="check1"><input type="checkbox" class="ckbox" value="10">O<input type="checkbox" value="0">X</div>
        </li> -->
	</ol>
	<div style="float:right;padding-right:40px;">
		<legend>합계</legend>
		<input type="text" id="total" name="total" class="point" readonly>
	</div>

	<script>
		var point = 0;

		var checkpoint = document.querySelectorAll(".ckbox");
		var total = document.querySelector("#total");
		total.value = point + "점";

		for (i = 0; i < checkpoint.length; i++) {
			checkpoint[i].onclick = function() {
				if (this.checked == true) {
					point += parseInt(this.value);
				} else {
					point -= parseInt(this.value);
				}
				total.value = point + "점";
			}
		}
	</script>
	<script src="./javascript/main.js">
		
	</script>
</body>
</html>