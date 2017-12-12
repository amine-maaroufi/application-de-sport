<!DOCTYPE html>
<!--
Template Name: Admin Lab Dashboard build with Bootstrap v2.3.1
Template Version: 1.3
Author: Mosaddek Hossain
Website: http://thevectorlab.net/
-->

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->

<!-- Mirrored from thevectorlab.net/adminlab/login.html by HTTrack Website Copier/3.x [XR&CO'2010], Sun, 28 Feb 2016 20:53:47 GMT -->
<head>
  <meta charset="utf-8" />
  <title>Login page</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport" />
  <meta content="" name="description" />
  <meta content="" name="author" />
  <link href="coachz/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="coachz/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link href="coachz/css/style.css" rel="stylesheet" />
  <link href="coachz/css/style_responsive.css" rel="stylesheet" />
  <link href="coachz/css/style_default.css" rel="stylesheet" id="style_color" />
  
  <link rel="stylesheet" href="login/login.css">
		<script src="login/login.js" type="text/javascript" language="javascript"></script>
		<script language="javascript">
$(document).ready(function()
{
	$("#login_form").submit(function()
	{
		//remove all the class add the messagebox classes and start fading
		$("#msgbox").removeClass().addClass('messagebox').text('Validation....').fadeIn(1000);
		//check the username exists or not from ajax
		$.post("login/login.php",{ login:$('#input-username').val(),password:$('#input-password').val(),rand:Math.random() } ,function(data)
        {
		  if(data!='no') //if correct login detail
		  {
		  	$("#msgbox").fadeTo(200,0.1,function()  //start fading the messagebox
			{ 
			  //add message and change the class of the box and start fading
			  
			  $(this).html('Bienvenu.....').addClass('messageboxok').fadeTo(900,1,
              function()
			  { 
			  	 //redirect to secure page
				 document.location=data;
			  });
			  
			});
		  }
		  else 
		  {
		  	$("#msgbox").fadeTo(200,0.1,function() //start fading the messagebox
			{ 
			  //add message and change the class of the box and start fading
			  $(this).html('Erreur d`authentification...').addClass('messageboxerror').fadeTo(900,1);
			});		
          }
				
        });
 		return false; //not to post the  form physically
	});
	//now call the ajax also focus move from 
	$("#password").blur(function()
	{
		$("#login_form").trigger('submit');
	});
});
</script>

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body id="login-body">
  <div class="login-header">
      <!-- BEGIN LOGO -->
      <div id="logo" class="center">
          <img src="coachz/img/logo.png" alt="logo" class="center" />
      </div>
      <!-- END LOGO -->
  </div>

  <!-- BEGIN LOGIN -->
  <div id="login">
    <!-- BEGIN LOGIN FORM -->
    <form method="post" id="login_form" class="form-vertical no-padding no-margin" action="">
      <div class="lock">
          <i class="icon-lock"></i>
      </div>
      <div class="control-wrap">
          <h4>Authentification</h4>
		   <div class="partie_erreur" id="rep"><span id="msgbox" style="display:none"></span></div>
          <div class="control-group">
		 
              <div class="controls">
                  <div class="input-prepend">
                      <span class="add-on"><i class="icon-user"></i></span><input id="input-username" type="text" placeholder="Pseudo" />
                  </div>
              </div>
          </div>
          <div class="control-group">
              <div class="controls">
                  <div class="input-prepend">
                      <span class="add-on"><i class="icon-key"></i></span><input id="input-password" type="password" placeholder="Mot de passe" />
                  </div>
                  

                  <div class="clearfix space5"></div>
              </div>

          </div>
      </div>

      <input type="submit" id="login-btn" class="btn btn-block login-btn" value="Connexion" />
    </form>
    <!-- END LOGIN FORM -->        
    <!-- BEGIN FORGOT PASSWORD FORM -->
    
    <!-- END FORGOT PASSWORD FORM -->
  </div>
  <!-- END LOGIN -->
  <!-- BEGIN COPYRIGHT -->
  <div id="login-copyright">
     CorpsIdeaL &copy; 2016
  </div>
  <!-- END COPYRIGHT -->
  <!-- BEGIN JAVASCRIPTS -->
  <script src="coachz/js/jquery-1.8.3.min.js"></script>
  <script src="coachz/assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="coachz/js/jquery.blockui.js"></script>
  <script src="coachz/js/scripts.js"></script>
  <script>
    jQuery(document).ready(function() {     
      App.initLogin();
    });
  </script>
  <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->

<!-- Mirrored from thevectorlab.net/adminlab/login.html by HTTrack Website Copier/3.x [XR&CO'2010], Sun, 28 Feb 2016 20:53:47 GMT -->
</html>