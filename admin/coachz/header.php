<?php
if(isset($_GET['logout']))
{
	session_destroy();
	echo' <meta http-equiv="refresh" content="0;URL=../index.php">';
} ?>
	<!-- BEGIN HEADER -->
	<div id="header" class="navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<DIV class="brand" >
				    <img src="img/logo.png" />
				</DIV>
				<!-- END LOGO -->
				<!-- BEGIN RESPONSIVE MENU TOGGLER -->
				<a class="btn btn-navbar collapsed" id="main_menu_trigger" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="arrow"></span>
				</a>
				<!-- END RESPONSIVE MENU TOGGLER -->
			<div class="top-nav ">
                    <ul class="nav pull-right top-menu" >
                
						<!-- BEGIN USER LOGIN DROPDOWN -->
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="img/avatar1_small.jpg" alt="">
                                <span class="username"><?php echo $_SESSION['nom']; ?></span>
							<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="icon-user"></i> Mon Profile</a></li>
								<li><a href="#"><i class="icon-tasks"></i> Mes Taches</a></li>
								<li><a href="#"><i class="icon-calendar"></i> Calendrier</a></li>
								<li class="divider"></li>
								<li><a href="?logout"><i class="icon-key"></i> D&eacute;connexion</a></li>
							</ul>
						</li>
						<!-- END USER LOGIN DROPDOWN -->
					</ul>
					<!-- END TOP NAVIGATION MENU -->
				</div>
			</div>
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	