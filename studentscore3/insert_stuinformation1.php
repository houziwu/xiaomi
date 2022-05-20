<?php
	session_start();
	header("content-type:text/html;charset=utf-8");
	$link=@mysqli_connect('localhost','root','root','student');
	$Id=$_POST['Id'];
	$name=$_SESSION['customer_user'];
	$major=$_POST['major'];
	$classes=$_POST['classes'];
	$sql="insert into `stu` (`Id`,`name`,`major`,`classes`) values('$Id','$name','$major','$classes')";
	$sql1="select * from `stu` where `Id`='".$Id."'";
	
	if($Id==""||$name==""||$major==""||$classes==""){
		echo '<script>alert(\'关键信息不能为空！\');location="insert_stuinformation.php"</script>';
		return;
	}
	
	$r=preg_match('/\s/',$Id);
	$r2=preg_match('/\s/',$name);
	$r3=preg_match('/\s/',$major);
	$r4=preg_match('/\s/',$classes);
	if($r>0 || $r2>0){
		echo '<script>alert(\'关键信息不能出现空格\');location="insert_stuinformation.php"</script>';
		return;
	}
	$n1=preg_match('/[^0-9]/',$Id);
	$n2=preg_match('/[^0-9]/',$classes);
	if($n1>0){
		echo '<script>alert(\'学号只能是数字\');location="insert_stuinformation.php"</script>';
		return;
	}
	
	if($n2>0){
		echo '<script>alert(\'班级只能是数字\');location="insert_stuinformation.php"</script>';
		return;
	}
	
	$s1=preg_match('/^[\x{4e00}-\x{9fa5}]+$/u',$name);
	$s2=preg_match('/^[\x{4e00}-\x{9fa5}]+$/u',$major);
	if($s1!=1){
		echo '<script>alert(\'姓名只能是汉字\');location="insert_stuinformation.php"</script>';
		return;
	}
	
	if($s2!=1){
		echo '<script>alert(\'专业只能是汉字\');location="insert_stuinformation.php"</script>';
		return;
	}
	
	$result1=mysqli_query($link,$sql1);
	$date1=mysqli_fetch_all($result1,MYSQLI_ASSOC);
	$num1=count($date1);
	// echo $num1;
	// return;
	if($num1==1){
		echo '<script>alert(\'此学号已被注册！\');location="insert_stuinformation.php"</script>';
		return;
	}
	
	$result=mysqli_query($link,$sql);
	if(mysqli_affected_rows($link)>0){
		echo "<script>alert('学生信息录入成功!');</script>";
		$url = "student_result.php";
		echo "<script type='text/javascript'>"."location.href='".$url."'"."</script>";
	}
?>