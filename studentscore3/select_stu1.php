<?php
	header("content-type:text/html;charset=utf-8"); //解决乱码问题
	$link=@mysqli_connect('localhost','root','root','student');
	$Id = $_POST['Id'];
	$name = $_POST['name'];
	$sql = "select * from `stu` where `Id` = '".$Id."' and `name` = '".$name."'";
	
	if($Id=="" || $name==""){
		echo "<script> alert('学号或姓名不能为空！');</script>";
		echo "<script> window.location='select_stu.php';</script>";
		return;
	}
	
	if(!$name || !$Id ){
		echo "<script> alert('请输入完整！');</script>";
		echo "<script> window.location='select_stu.php';</script>";
		return;
	}
	
	$r=preg_match('/\s/',$name);
	$r2=preg_match('/\s/',$Id);
	if($r>0 || $r2>0){
		echo '<script>alert(\'学号和姓名不能出现空格\');location="select_stu.php"</script>';
		return;
	}
	
	$n1=preg_match('/[^0-9]/',$Id);
	if($n1>0){
		echo '<script>alert(\'学号只能是数字\');location="select_stu.php"</script>';
		return;
	}
	
	$s1=preg_match('/^[\x{4e00}-\x{9fa5}]+$/u',$name);
	if($s1!=1){
		echo '<script>alert(\'姓名只能是汉字\');location="select_stu.php"</script>';
		return;
	}
	// echo $s1;
	// return;
	
	$result=mysqli_query($link,$sql);
	$date=mysqli_fetch_all($result,MYSQLI_ASSOC);
	$num=count($date);
	if($num!=1){
		echo '<script>alert(\'查无此人\');location="select_stu.php"</script>';
		return;
	}
?>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>学生成绩管理系统</title>
	<link rel="stylesheet" href="css/select_stu1.css" />
</head>
<body>
	<div class="header its">
		<div class="title"><h2>学生成绩管理系统</h2></div>
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
				</tr>
				<?php
					$result1=mysqli_query($link,$sql);
					while($row=mysqli_fetch_assoc($result1)){
						echo '<tr  class="tr2"><td>'.$row['Id'].'</td>';
						echo '<td>'.$row['name'].'</td>';
						echo '<td>'.$row['major'].'</td>';
						echo '<td>'.$row['classes'].'</td>';
						echo '<td>'.$row['Java'].'</td>';
						echo '<td>'.$row['PHP'].'</td>';
						echo '<td>'.$row['JavaWeb'].'</td>';
					}
				?>
			</table>
		</form>
	</div>
</body>
</html>