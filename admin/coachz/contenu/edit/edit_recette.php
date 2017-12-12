  	 <?php 
if ($_POST["f"]==1) { 

  $formtitre = $test->secure($_POST["titre"]);
  $test->stringtest($formtitre,"titre");
  
  $formtype = $test->secure($_POST["type"]);
  $test->stringtest($formtype,"type");
  
  $formdelai = $test->secure($_POST["delai"]);
  $test->stringtest($formdelai,"delai");
  
  $formfrequence = $test->secure($_POST["frequence"]);
  $test->stringtest($formfrequence,"frequence");
  
  
  $formdescription = $test->secure($_POST["description"]);
  $test->stringtest($formdescription,"description");
  
 
  if ($test->Count==0) {
    //Traitement lorsque tous les tests sont passés avec succès
	
	$titre=$_POST["titre"];
	$type=$_POST["type"];
	$delai=$_POST["delai"];
	$frequence=$_POST["frequence"];
	$description=$_POST["description"];
	$id_recette=$_GET['id'];

		$edit=$recette->modifier_recette($id_recette,$titre,$type,$delai,$frequence,$description);
		if($edit=="1"){ 	
			echo' <meta http-equiv="refresh" content="0;URL=acceuil.php?p=rct&modif">';
		}
		else { echo $message="<center><strong>Erreur : Ajout non &eacute;tablie!</strong></center>";}
}	}
$liste=$recette->afficher_recette($_GET['id']);		
?>
	
	<div class="row-fluid">
					<div class="span12">
					
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Modifier Une Recette
							
							<small>  </small>
						</h3>
						
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
	</div>
	<div class="row-fluid">
	
              <div class="span12 ">
			  <?php
if ($_POST["f"]==1)
  echo "<center style='background:#FFFFFF;color:red;font:bold 12px 'Arial'; border:0px;'><strong>Les champs en rouge doivent &ecirc;tre remplis correctement!</strong></center>";               
					?>
                    <!-- BEGIN SAMPLE FORMPORTLET-->
                <div class="widget">
                    <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Formulaire de modification</h4>
                    </div>              
                        <div class="widget-body">
					
                            <!-- BEGIN FORM-->
                            <form method="post" action="" class="form-horizontal">
                                 <div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("titre","fieldreq");?> ">Titre</label>
                                    <div class="controls">
                                        <input type="text" id="titre" name="titre" value="<?php  echo $liste[1][0] ;?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("type","fieldreq");?> ">Type</label>
                                    <div class="controls">
                                        <input type="text" id="type" name="type" value="<?php  echo $liste[2][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("delai","fieldreq");?> ">D&eacute;lai</label>
                                    <div class="controls">
                                        <input type="text" id="delai" name="delai" value="<?php  echo $liste[3][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("frequence","fieldreq");?> ">F&eacute;quence</label>
                                    <div class="controls">
                                        <input type="text" id="frequence" name="frequence" value="<?php  echo $liste[4][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("description","fieldreq");?> ">Description</label>
                                    <div class="controls">
                                        <input type="text" id="description" name="description" value="<?php echo $fordescription ; echo $liste[5][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								
								 <div class="form-actions">
                                    <button type="submit" class="btn blue"><i class="icon-ok"></i> Enregitrer</button>
									
									<a href="?p=annuler_rct">
                                    <button type="button" class="btn"><i class=" icon-remove"></i> Annuler</button>
									</a>
                                </div>
								 <input type="hidden" name="f" value="1">
                            </form>
                             <!-- END FORM-->
                        </div>
                    </div>
                    <!-- END SAMPLE FORM PORTLET-->
                </div>
	</div>


           