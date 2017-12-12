<?php session_start();

include '../cx_bd.php';
//get the posted values
$log=htmlspecialchars($_POST['login'],ENT_QUOTES);
$pass=$_POST['password'];

//now validating the login and password
$sql="SELECT * FROM tb_admin WHERE Login='".$log."'";
$result=mysql_query($sql);
$row=mysql_fetch_array($result);

//if username exists
if(mysql_num_rows($result)>0)
{
	//compare the password
	if(strcmp($row['Password'],$pass)==0)
	{			//now set the session from here if needed

		                     $_SESSION['login']=$log;; 
							 $_SESSION['nom']=$row['P_Nom'];
							
							echo "coachz/acceuil.php";
						
					 		
		
		
	}
	else
		echo "no"; //Invalid pass
}
else
	echo "no"; //Invalid Login


?>