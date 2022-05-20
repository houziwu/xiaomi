<?php
	session_start();
	header("content-type:text/html;charset=utf-8"); //解决乱码问题
	$link=@mysqli_connect('localhost','root','root','student');
	$name = $_POST['name'];   //定义用户名
	$password = $_POST['password']; //定义密码
	$sql = "select * from `user` where `name` = '".$name."' and `password` = '".$password."'";
	$sql1 = "select * from `stu` where `name` = '".$name."'";
	
	if($name==""||$password==""){
		echo '<script>alert(\'用户名和密码不能为空\');location="index.html"</script>';
	}
	
	$r=preg_match('/\s/',$name);
	$r2=preg_match('/\s/',$password);
	if($r>0 || $r2>0){
		echo '<script>alert(\'用户名和密码不能出现空格\');location="index.html"</script>';
		return;
	}
	// $s1=preg_match('/^\w+$/',$name);
	$s1=preg_match('/^[a-zA-Z|\x{4e00}-\x{9fa5}]+$/u',$name); //用户名只能是汉字或字母
	$s2=preg_match('/^\w+$/',$password); //密码只能是数字或字母
	// echo $s2;
	// return;
	if($s1<0||$s2==0){
		echo '<script>alert(\'用户名和密码不能出现特殊字符\');location="index.html"</script>';
		return;
		// echo '<script>alert(\'"'.$s1.'"\');</script>';
	}
	
	if((!isset($name)) || (!isset($password))) 
	{
		echo $name;
	}else{
		$result=mysqli_query($link,$sql);
		$date=mysqli_fetch_all($result,MYSQLI_ASSOC);
		$num=count($date);
		if($num!=1){
			echo '<script>alert(\'查无此人\');location="index.html"</script>';
		}else{
			if($date[0]['type']=="admin"){
				$url = "select_all.php";
				$_SESSION['admin_user'] = $name;
				echo "<script type='text/javascript'>"."location.href='".$url."'"."</script>";
			}else{
				$result1=mysqli_query($link,$sql1);
				$date1=mysqli_fetch_all($result1,MYSQLI_ASSOC);
				$num1=count($date1);
				if($num1!=1){
					$_SESSION['customer_user'] = $name;
					echo '<script>alert(\'请录入学生信息！\');location="insert_stuinformation.php"</script>';
				}else{
					$url = "student_result.php";
					$_SESSION['customer_user'] = $name;
					echo "<script type='text/javascript'>"."location.href='".$url."'"."</script>";
				}
			}
			// echo $date[0]['type'];
		}
	}
?>