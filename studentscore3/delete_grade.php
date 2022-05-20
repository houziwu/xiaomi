<?php
	header("content-type:text/html;charset=utf-8");
	$link=mysqli_connect('localhost','root','root','student');
	// mysqli_set_charset($link,charset:'');
	$li=$_GET['Id'];
	$sql="delete from `stu` where `Id`='".$li."'";
	$sql1="select `name` from `stu` where `Id`='".$li."'";
	$result1=mysqli_query($link,$sql1);
	$row=mysqli_fetch_assoc($result1);
	$sql2="delete from `user` where `name`='".$row['name']."'";
	$result2=mysqli_query($link,$sql2);
	$result=mysqli_query($link,$sql);
	if($result&&mysqli_affected_rows($link)>0){
		echo '<script>alert(\'删除成功\');location="select_all.php"</script>';
	}else{
		echo '<script>alert(\'删除失败\');location="select_all.php</script>';
	}
?>