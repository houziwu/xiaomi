<?php
	session_start();
	$name=$_SESSION['customer_user'];
?>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/insert_information.css" />
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
		<form name="form1" method="post" action="insert_stuinformation1.php">
			<div class="sh1">
				<td>
					<table class="tab1">
						<div class="tr1">
							<tr>
								<tr>
									<td class="td1"><strong>学号</strong>：</td>
									<td colspan="2">
										<label><input type="text" name="Id" /></label>
									</td>
								</tr>
								<tr>
									 <td class="td1"><strong>姓名</strong>：</td>
									 <td colspan="2">
										 <label><!-- <input type="text" name="name"  /> --><font face="楷体" class="f1" color="#000000"><?php echo $name; ?></font></label>
									 </td>
								</tr>
								<tr>
									 <td class="td1"><strong>专业</strong>：</td>
									 <td colspan="2">
										 <label><input type="text" name="major"  /></label>
									 </td>
								</tr>
								<tr>
									 <td class="td1"><strong>班级</strong>：</td>
									 <td colspan="2">
										 <label><input type="text" name="classes"  /></label>
									 </td>
								</tr>
								<tr>
									<td><input name="submit" type="submit" value="提 交" class="td2" /></td>
									<td><input name="submit2" type="reset" value="重 置" class="td2" /></td>
								</tr>
							</tr>
						</div>
					</table>
				</td>
			</div>
		</form>
	</div>
</body>
</html>