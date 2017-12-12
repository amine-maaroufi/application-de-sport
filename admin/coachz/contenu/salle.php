	<?php
$liste=$salle->afficher_salles();
?>

				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
                        <!-- BEGIN THEME CUSTOMIZER-->
                        <div id="theme-change" class="hidden-phone">
                            <i class="icon-cogs"></i>
                            <span class="settings">
                                <span class="text">Theme:</span>
                                <span class="colors">
                                    <span class="color-default" data-style="default"></span>
                                    <span class="color-gray" data-style="gray"></span>
                                    <span class="color-purple" data-style="purple"></span>
                                    <span class="color-navy-blue" data-style="navy-blue"></span>
                                </span>
                            </span>
                        </div>
                        <!-- END THEME CUSTOMIZER-->
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->	    			
						<h3 class="page-title">
							Google Maps
							<small>interactive google map</small>
							
							<?php
							if (isset($_GET['sup'])){

								$supprimer=$salle->supprimer_salle($_GET['sup']);
								if ($supprimer=1){
								echo $message="<center>Message : Suppression avec succ&eacute;e!</center>";	
								echo' <meta http-equiv="refresh" content="2;URL=acceuil.php?p=salle">';
								}
							}

							if (isset($_GET['add'])){
								echo $message="<center>Message : Ajout avec succ&eacute;e!</center>";	
								echo' <meta http-equiv="refresh" content="2;URL=acceuil.php?p=salle">';
								}
	
							if (isset($_GET['modif'])){
								echo $message="<center>Message : Modification avec succ&eacute;e!</center>";	
								echo' <meta http-equiv="refresh" content="2;URL=acceuil.php?p=salle">';
								}
?>
							
						</h3>
                        
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div id="page">
				<div class="row-fluid">
                <div class="span12">
                    <!-- BEGIN EXAMPLE TABLE widget-->
                    <div class="widget">
                        <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Consulter les salles</h4>
										

                            <span class="tools">
                               <i><b>Total	&nbsp; &nbsp;<?php echo count($liste[0]); ?> </b></i>
                            </span>
                        </div>
                        <div class="widget-body">
                            <div class="portlet-body">
                                <div class="clearfix">
                                    <div class="btn-group">
									<a href="?p=add_salle" class="">
										<button class="btn green">
                                            Ajouter nouveau <i class="icon-plus"></i>
                                        </button>
									</a>
									
                                    </div>
                                   
                                </div>
                                <div class="space15"></div>
                                <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                                    <thead>
                                    <tr>
                                        <th>Titre</th>
										<th>Adresse</th>
										<th>Tel</th>
										<th>Coordonnees</th>
                                        <th>Action</th>
                                        
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="">
                                        <?php for ($i=0;$i<count($liste[0]);$i++){   ?>
                                <tr class="odd gradeX">
                                   
                                    <td ><?php echo $liste[1][$i];?></td>
                                    <td ><?php echo $liste[2][$i];?></td>
									<td ><?php echo $liste[3][$i];?></td>
									<td ><?php echo $liste[4][$i].', '.$liste[5][$i];?></td>
									<td>
									<span><a class="icon-edit" href="?p=edit_sl&id=<?php echo $liste[0][$i];?>" ></a></span>
									<span><a class="icon-trash"  href='?p=salle&sup=<?php echo $liste[0][$i];?>'  onclick="return(confirm('Vous etes sures de vouloir supprimer?'))" title="Delete"></a></span>
									</td>
								
										<?php } ?> 
                                    </tr>
									 
								
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE widget-->
                </div>
            </div>
			</div>
	
				<!-- END PAGE CONTENT-->	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.blockui.js"></script>
			<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	<script src="assets/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>	
	<script src="assets/fancybox/source/jquery.fancybox.pack.js"></script>	
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script src="js/scripts.js"></script>
		<script src="js/gmaps.js"></script>
	<script src="js/demo.gmaps.js"></script>
	<script>
		jQuery(document).ready(function() {			
			// initiate layout and plugins
			App.init();
			DemoGMaps.init();
		});
	</script>