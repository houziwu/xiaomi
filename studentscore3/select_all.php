<?php
	session_start();
	header("content-type:text/html;charset=utf-8"); //解决乱码问题
	$link=@mysqli_connect('localhost','root','root','student');
	$name = $_SESSION['admin_user'];
	// if(!isset($name)){
	// 	echo '<script>alert(\'请重新登陆!\');location="index.html"</script>';
	// }
	// $sql = "select * from `stu` where `name` = '".$name."'";
?>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>学生成绩管理系统</title>
	<link rel="stylesheet" href="css/select_all.css" />
</head>
<body>
	<div class="header its">
		<div class="title">
			<h3>学生成绩管理系统</h3>
		</div>
		<div class="nav">
			<div class="nav_item nav_item-it1"><a href="insert_stuser.html" class="a1">注册账号</a></div>
			<div class="nav_item nav_item-it2"><a href="update_adpwd.html" class="a1">修改密码</a></div>
			<div class="nav_item nav_item-it3"><a href="index.html" class="a1">退出登录</a></div>
			<!-- <div class="nav_item nav_item-it4"><a href="login.html" class="a1">退出</a></div> -->
		</div>
	</div>
	<div class="menu its">
		<!-- <div class="nav_item1 nav_item-it4"><img src="img/123.jpg"></div> -->
		<div class="nav_item1 nav_item-it4"><a href="select_all.php" class="a2">查询所有成绩</a></div>
		<div class="nav_item1 nav_item-it5"><a href="search_sco.php" class="a2">查询单科成绩</a></div>
		<div class="nav_item1 nav_item-it6"><a href="select_stu.php" class="a2">查询学生成绩</a></div>
		<div class="nav_item1 nav_item-it7"><a href="select_insert.php" class="a2">录入学生成绩</a></div>
		<div class="nav_item1 nav_item-it8"><a href="insert_information.html" class="a2">注册学生信息</a></div>
		<div class="nav_item1 nav_item-it9"><a href="update_stupwd.html" class="a2">修改学生密码</a></div>
		<!-- <div class="nav_item1 nav_item-it9">45</div> -->
	</div>
	<div class="tel its">
		<div class="div2">
			<span class="c4">欢迎你!管理员:</span><font class="fo1"><?php
			echo $name;
			// $result = mysqli_query($link,$sql);
			// while($row=mysqli_fetch_assoc($result)){
			// 	echo $row['name'];
			// }
			?></font>
		</div>
		<form name="form1" method="post">
			<table class="tab1">
				<tr class="tr1">
					<td>学号</td>
					<td>姓名</td>
					<td>专业</td>
					<td>班级</td>
					<td>Java成绩</td>
					<td>PHP成绩</td>
					<td>JavaWeb成绩</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<?php
					$result=mysqli_query($link,'SELECT * FROM `stu` WHERE `Java` IS NOT NULL AND `PHP` IS NOT NULL AND `JavaWeb` IS NOT NULL');
					while($row=mysqli_fetch_assoc($result)){
					echo '<tr  class="tr2"><td>'.$row['Id'].'</td>';
					echo '<td>'.$row['name'].'</td>';
					echo '<td>'.$row['major'].'</td>';
					echo '<td>'.$row['classes'].'</td>';
					echo '<td>'.$row['Java'].'</td>';
					echo '<td>'.$row['PHP'].'</td>';
					echo '<td>'.$row['JavaWeb'].'</td>';
					echo '<td><a href="delete_grade.php?Id='.$row['Id'].'" class="a3">删除</a></td>';
					echo '<td><a href="change_score.php?Id='.$row['Id'].'&name='.$row['name'].'&major='.$row['major'].'&classes='.$row['classes'].'" class="a3">修改</a></td></tr>';
					}
				?>
			</table>
		</form>
	</div>
</body>
</html>