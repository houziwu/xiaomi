<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/schangepwd.css" />
	<title>学生成绩管理系统</title>
</head>
<body>
	<div class="header its">
		<div class="title">
			<h3>学生成绩管理系统</h3>
		</div>
		<div class="nav">
			<!-- <div class="nav_item nav_item-it1"><a href="insert_stuser.html" class="a1">注册账号</a></div> -->
			<!-- <div class="nav_item nav_item-it2"><a href="schangepwd.php" class="a1">修改密码</a></div>
			<div class="nav_item nav_item-it3"><a href="index.html" class="a1">退出登录</a></div> -->
		</div>
	</div>
	<div class="menu its">
		<div class="nav_item1 nav_item-it4"><a href="schangepwd.php" class="a2">修改密码</a></div>
		<div class="nav_item1 nav_item-it5"><a href="student_result.php" class="a2">个人主页</a></div>
		<div class="nav_item1 nav_item-it6"><a href="index.html" class="a2">退出登录</a></div>
		<!-- <div class="nav_item1 nav_item-it4"><a href="select_all.php" class="a2">查询所有成绩</a></div>
		<div class="nav_item1 nav_item-it5"><a href="search_sco.php" class="a2">查询单科成绩</a></div>
		<div class="nav_item1 nav_item-it6"><a href="select_stu.php" class="a2">查询学生成绩</a></div>
		<div class="nav_item1 nav_item-it7"><a href="select_insert.php" class="a2">录入学生成绩</a></div>
		<div class="nav_item1 nav_item-it8"><a href="insert_information.html" class="a2">注册学生信息</a></div>
		<div class="nav_item1 nav_item-it9"><a href="update_stupwd.html" class="a2">修改学生密码</a></div> -->
	</div>
	<div class="tel its">
		<form name="form1" method="post" action="schangepwds.php">
			<div class="sh1">
				<td>
					<table class="tab1">
						<div class="tr1">
							<tr>
								<td class="td1">原密码：</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td class="td1">新密码：</td>
								<td><input name=txt_regpwd type=password id="txt_regpwd" size=20 maxlength=75 /></td>
							</tr>
							<tr>
								<td class="td1">再次输入新密码：</td>
								<td><input name='txt_regpwd2' type=password id="txt_regpwd2" size=20 maxlength=75 onblur="if(this.value!=this.form.txt_regpwd.value) {alert('您两次输入的密码不一致！');myform.txt_regpwd.focus();}" /></td>
							</tr>
							<tr>
								<td><input name="submit1" type="submit" value="提 交" class="td2" /></td>
								<td><input name="submit2" type="reset" value="重 置" class="td2" /></td>
							</tr>
						</div>
					</table>
				</td>
			</div>
		</form>
	</div>
</body>
</html>