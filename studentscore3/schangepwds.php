<?php
	session_start(); 
	header("content-type:text/html;charset=utf-8"); //解决乱码问题
	$link=@mysqli_connect('localhost','root','root','student');
	$name = $_SESSION['customer_user'];
	$password= $_POST['password'];
	$newpassword = $_POST['txt_regpwd'];
	$newpassword2 = $_POST['txt_regpwd2'];
	
	if($password=="" || $newpassword=="" || $newpassword2==""){
		echo '<script>alert(\'密码不能为空\');location="schangepwd.html"</script>';
		return;
	}
	
	$s2=preg_match('/^\w+$/',$newpassword); //新密码只能是数字或字母
	if($s2==0){
		echo '<script>alert(\'新密码不能出现特殊字符\');location="schangepwd.html"</script>';
		return;
	}
	
	if(!$password || !$newpassword || !$newpassword2){
		echo "<script> alert('请输入完整！');</script>";
		echo "<script> window.location='schangepwd.html';</script>";
	}else{
		$sql = "select `password` from `user` where `name` = '".$name."'";
		$result=mysqli_query($link,$sql);
		$row=mysqli_fetch_array($result);
		if($row[0]!=$password){
			echo "<script> alert('原密码错误！');</script>";
			echo "<script> window.location='schangepwd.html';</script>";
		}else{
			$sql1 = "update `user` set `password`='".$newpassword."' where `name`='".$name."'";
			$result1=mysqli_query($link,$sql1);
			if($result1){
				echo "<script> alert('修改成功！');</script>";
				echo "<script> window.location='student_result.php';</script>";
			}else{
				echo "<script> alert('修改失败！');</script>";
			}
		}
	}
?>