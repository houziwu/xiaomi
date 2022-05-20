<?php
	header("content-type:text/html;charset=utf-8"); //解决乱码问题
	$link=@mysqli_connect('localhost','root','root','student');
	$name = $_POST['name'];
	$password= $_POST['password'];
	$sql1="select * from `stu` where `name` = '".$name."'";
	
	if($name==""||$password==""){
		echo "<script> alert('姓名或密码不能为空！');</script>";
		echo "<script> window.location='update_stupwd.html';</script>";
		return;
	}
	
	$s2=preg_match('/^\w+$/',$password); //新密码只能是数字或字母
	if($s2==0){
		echo '<script>alert(\'新密码不能出现特殊字符\');location="update_stupwd.html"</script>';
		return;
	}
	
	if(!$name || !$password){
		echo "<script> alert('请输入完整！');</script>";
		echo "<script> window.location='update_stupwd.html';</script>";
	}else{
		$result1=mysqli_query($link,$sql1);
		$date1=mysqli_fetch_all($result1,MYSQLI_ASSOC);
		$num1=count($date1);
		if($num1!=1){
			echo '<script>alert(\'此人不存在！\');location="update_stupwd.html"</script>';
		}else{
			$sql = "update `user` set `password`='".$password."' where `name`='".$name."'";
			$result=mysqli_query($link,$sql);
			if($result){
				echo "<script> alert('修改成功！');</script>";
				echo "<script> window.location='update_stupwd.html';</script>";
			}else{
				echo "<script> alert('修改失败！');</script>";
				echo "<script> window.location='update_stupwd.html';</script>";
			}
		}
	}
?>