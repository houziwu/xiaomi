<?php
	header("content-type:text/html;charset=utf-8"); //解决乱码问题
	$link=@mysqli_connect('localhost','root','root','student');
?>

<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/select_stu.css" />
	<title>学生成绩管理系统</title>
</head>
<body>
	<div class="header its">
		<div class="title"><h3>学生成绩管理系统</h3></div>
		<div class="nav">
			<div class="nav_item nav_item-it1"><a href="insert_stuser.html" class="a1">注册账号</a></div>
			<div class="nav_item nav_item-it2"><a href="update_adpwd.html" class="a1">修改密码</a></div>
			<div class="nav_item nav_item-it3"><a href="index.html" class="a1">退出登录</a></div>
		</div>
	</div>
	<div class="menu its">
		<div class="nav_item1 nav_item-it4"><a href="select_all.php" class="a2">查询所有成绩</a></div>
		<div class="nav_item1 nav_item-it5"><a href="search_sco.php" class="a2">查询单科成绩</a></div>
		<div class="nav_item1 nav_item-it6"><a href="select_stu.php" class="a2">查询学生成绩</a></div>
		<div class="nav_item1 nav_item-it7"><a href="select_insert.php" class="a2">录入学生成绩</a></div>
		<div class="nav_item1 nav_item-it8"><a href="insert_information.html" class="a2">注册学生信息</a></div>
		<div class="nav_item1 nav_item-it9"><a href="update_stupwd.html" class="a2">修改学生密码</a></div>
	</div>
	<div class="tel its">
		<form name="form1" method="post" action="select_stu1.php">
			<div class="sh1">
				<td colspan="7">
					<table class="tab1">
						<div class="trs">
							<tr>
								<td class="td1">学号：</td>
								<td>
									<input type="text" name="Id" />
								</td>
							</tr>
							<tr>
								<td class="td1">姓名：</td>
								<td>
									<input type="text" name="name" />
								</td>
							</tr>
							<tr>
								<td>
									<input name="submit1" type="submit" value="查 询" class="td2"/>
								</td>
								<td>
									<input name="submit2" type="reset" value="重 置" class="td2" />
								</td>
							</tr>
						</div>
					</table>
				</td>
			</div>
		</form>
	</div>
</body>
</html>
