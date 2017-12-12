<?php
session_start();
if(empty($_SESSION["login"])){ 
echo' <meta http-equiv="refresh" content="0;URL=../index.php">';}
	
 include ("../cx_bd.php"); 
 include ("class/class_sp.php");  
 $sportif=new Sportif();
 include ("class/class_rct.php");  
 $recette=new Recette();
 include ("class/class_st.php");  
 $site=new Site();
 include ("class/class_act.php");  
 $actualite=new Actualite();
 include ("class/class_evt.php");  
 $evenement=new Evenement();
 include ("class/class_sl.php");  
 $salle=new Salle();

include ("Validateur.php");
$test = new testTools("fielderror");
?>

<!DOCTYPE html>
<!--
Template Name: Admin Lab Dashboard build with Bootstrap v2.3.1
Template Version: 1.3
Author: Maaroufi Med.Amine
Website: http://thevectorlab.net/
-->

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->

<!-- Mirrored from thevectorlab.net/adminlab/index.html by HTTrack Website Copier/3.x [XR&CO'2010], Sun, 28 Feb 2016 20:52:24 GMT -->
<head>
	<meta charset="utf-8" />
	<title> CoachZ</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
	<link href="css/style_responsive.css" rel="stylesheet" />
	<link href="css/style_default.css" rel="stylesheet" id="style_color" />

	<link href="assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="assets/uniform/css/uniform.default.css" />
	<link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
	<link href="assets/jqvmap/jqvmap/jqvmap.css" media="screen" rel="stylesheet" type="text/css" />
	
	
	<style type="text/css">
  .fielderror { color: red; }
  .fieldreq { color: black;}
</style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
	<!-- BEGIN HEADER -->
	<?php include "header.php"; ?>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div id="container" class="row-fluid">
		<!-- BEGIN SIDEBAR -->
		<?php include "menu.php"; ?>
		<!-- END SIDEBAR -->
		<!-- BEGIN PAGE -->
		<div id="main-content">
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
			<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<?php include "switcher.php"; ?>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<?php include "footer.php"; ?>
	<!-- END FOOTER -->
	<!-- BEGIN JAVASCRIPTS -->
	<!-- Load javascripts at bottom, this will reduce page load time -->
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="assets/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.blockui.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<!-- ie8 fixes -->
	<!--[if lt IE 9]>
	<script src="js/excanvas.js"></script>
	<script src="js/respond.js"></script>
	<![endif]-->
	<script src="assets/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
	<script src="assets/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
	<script src="assets/jquery-knob/js/jquery.knob.js"></script>
	<script src="assets/flot/jquery.flot.js"></script>
	<script src="assets/flot/jquery.flot.resize.js"></script>

    <script src="assets/flot/jquery.flot.pie.js"></script>
    <script src="assets/flot/jquery.flot.stack.js"></script>
    <script src="assets/flot/jquery.flot.crosshair.js"></script>

	<script src="js/jquery.peity.min.js"></script>
	<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	<script src="js/scripts.js"></script>
	<script>
		jQuery(document).ready(function() {
			// initiate layout and plugins
			App.setMainPage(true);
			App.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->

<!-- Mirrored from thevectorlab.net/adminlab/index.html by HTTrack Website Copier/3.x [XR&CO'2010], Sun, 28 Feb 2016 20:53:20 GMT -->
</html>