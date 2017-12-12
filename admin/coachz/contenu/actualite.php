<?php
$liste=$actualite->afficher_actualites();
	
?>
	<div class="row-fluid">
					<div class="span12">
					
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Les Actualit&eacute;s
							<small> les nouveaut&eacute;s du sport </small>
							<?php

							if (isset($_GET['sup'])){

								$supprimer=$actualite->supprimer_Actualite($_GET['sup']);
								if ($supprimer=1){
								echo $message="<center><strong>Message : Suppression avec succ&eacute;e!</strong></center>";	
								echo' <meta http-equiv="refresh" content="2;URL=acceuil.php?p=act">';
								}
								}
							
							
							if (isset($_GET['add'])){
								echo $message="<center><strong>Message : Ajout avec succ&eacute;e!</strong></center>";	
								echo' <meta http-equiv="refresh" content="2;URL=acceuil.php?p=act">';
								}
	
							if (isset($_GET['modif'])){
								echo $message="<center><strong>Message : Modification avec succ&eacute;e!</strong></center>";	
								echo' <meta http-equiv="refresh" content="2;URL=acceuil.php?p=act">';
								}
	
							?>
						</h3>
						
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
	</div>
				          
		<div class="row-fluid">
		
                <div class="span12">
                    <!-- BEGIN EXAMPLE TABLE widget-->
                    <div class="widget">
                        <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Consulter les actualit&eacute;s </h4>
							
                            <span class="tools">
                                <i><b> Total &nbsp; &nbsp;<?php echo count($liste[0]); ?> </b></i>
                            </span>
                        </div>
                        <div class="widget-body">
                            <div class="portlet-body">
                                <div class="clearfix">
                                    <div class="btn-group">
                                       <a href="?p=add_act" class="">
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
                                        <th>Date</th>
                                        <th>Description</th>
                                        <th>R&eacute;f&eacute;rence</th>
                                        <th>Action</th>
                                        
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <?php for ($i=0;$i<count($liste[0]);$i++){   ?>
                                <tr class="odd gradeX">
                                   
                                    <td><?php echo $liste[1][$i];?></td>
                                    <td ><?php echo $liste[2][$i];?></a></td>
                                    <td ><?php echo $liste[3][$i];?></td>
                                    <td ><?php echo $liste[4][$i];?></td>
									<td>
									<span><a class="icon-edit"  href="?p=edit_act&id=<?php echo $liste[0][$i];?>"></a></span>
									<span> <a class="icon-trash"  href='?p=act&sup=<?php echo $liste[0][$i];?>'  onclick="confirm('Vous etes sures de vouloir supprimer?')" title="Delete"></a></span>
									</td>
                                </tr>
                               <?php } ?> 
							
                                   </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE widget-->
                </div>
            </div>
	
           