<?php
	session_start();
	header("content-type:text/html;charset=utf-8");
	$link=@mysqli_connect('localhost','root','root','student');
	$name=$_POST['name'];
	$password=$_POST['password'];
	$typ=$_POST['typ'];
	$sql="select * from `user` where `name`='".$name."'";
	
	if($name==""||$password==""){
		echo '<script>alert(\'用户名和密码不能为空\');location="insert_stuser.html"</script>';
		return;
	}
	
	$result=mysqli_query($link,$sql);
	if(mysqli_affected_rows($link)>0){
		echo '<script>alert(\'该用户已存在！\');location="register.html"</script>';
		return;
	}
	
	$r=preg_match('/\s/',$name);
	$r2=preg_match('/\s/',$password);
	if($r>0 || $r2>0){
		echo '<script>alert(\'用户名和密码不能出现空格\');location="insert_stuser.html"</script>';
		return;
	}
	
	$s1=preg_match('/^[a-zA-Z|\x{4e00}-\x{9fa5}]+$/u',$name); //用户名只能是汉字或字母
	$s2=preg_match('/^\w+$/',$password); //密码只能是数字或字母
	if($s1==0||$s2==0){
		echo '<script>alert(\'用户名和密码不能出现特殊字符\');location="insert_stuser.html"</script>';
		return;
	}
	
		$result=mysqli_query($link,"insert into `user` (`name`,`password`,`type`) values('$name','$password','$typ');");
		if(mysqli_affected_rows($link)>0){
			echo "<script>alert('注册成功!');</script>";
			$url = "insert_stuser.html";
			// $_SESSION['admin_user'] = $name;
			// echo $_SESSION['admin_user'];
			echo "<script type='text/javascript'>"."location.href='".$url."'"."</script>";
		}else{
			echo "<script>alert('注册失败!');</script>";
			$url = "insert_stuser.html";
			echo "<script type='text/javascript'>"."location.href='".$url."'"."</script>";
		}
		
?>