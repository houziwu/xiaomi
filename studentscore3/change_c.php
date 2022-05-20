<?php
	session_start();
	header("content-type:text/html;charset=utf-8");
	$link=mysqli_connect('localhost','root','root','student');
	$cor=$_SESSION['cor'];
	$Java=$_POST['Java'];
	$PHP=$_POST['PHP'];
	$JavaWeb=$_POST['JavaWeb'];
	
	$r=preg_match('/\s/',$Java);
	$r2=preg_match('/\s/',$PHP);
	$r3=preg_match('/\s/',$JavaWeb);
	if($r>0 || $r2>0||$r3>0){
		echo '<script>alert(\'成绩出现空格，修改失败\');location="select_all.php"</script>';
		return;
	}
	
	$n1=preg_match('/[^0-9]/',$Java);
	$n2=preg_match('/[^0-9]/',$PHP);
	$n3=preg_match('/[^0-9]/',$JavaWeb);
	// $n1=preg_match('/[^0-9]/',$Java);
	// $n2=preg_match('/[^0-9]/',$PHP);
	// $n3=preg_match('/[^0-9]/',$JavaWeb);
	
	if($n1>0 || $n2>0||$n3>0){
		echo '<script>alert(\'成绩不能出现特殊字符\');location="select_all.php"</script>';
		return;
	}
		
	
	
	if($Java==''){
		echo '<script>alert(\'Java成绩为空\');location="select_all.php"</script>';
		return;
	}
	
	if($PHP==''){
		echo '<script>alert(\'PHP成绩为空\');location="select_all.php"</script>';
		return;
	}
	
	if($JavaWeb==''){
		echo '<script>alert(\'JavaWeb成绩为空\');location="select_all.php"</script>';
		return;
	}
	
	// $Java=$_POST['Java'];
	// $PHP=$_POST['PHP'];
	// $JavaWeb=$_POST['JavaWeb'];
	
	
	if($Java<=0 || $Java>=100){
		echo '<script>alert(\'Java成绩超出范围\');location="select_all.php"</script>';
		return;
	}
	if($PHP<=0 || $PHP>=100){
		echo '<script>alert(\'PHP成绩超出范围\');location="select_all.php"</script>';
		return;
	}
	if($JavaWeb<=0 || $JavaWeb>=100){
		echo '<script>alert(\'JavaWeb成绩超出范围\');location="select_all.php"</script>';
		return;
	}
	
	
	$sql="update `stu` set `Java`='$Java',`PHP`='$PHP',`JavaWeb`='$JavaWeb' where `Id`='$cor'";
	$result=mysqli_query($link,$sql);
	if($result&&mysqli_affected_rows($link)>0){
		echo '<script>alert(\'修改成功\');location="select_all.php"</script>';
	}else{
		echo '<script>alert(\'修改失败\');;location="select_all.php"</script>';
	}
?>