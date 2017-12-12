  	  	 <?php 
if ($_POST["f"]==1) { 

  $formtitre = $test->secure($_POST["titre"]);
  $test->stringtest($formtitre,"titre");
  
  $formurl = $test->secure($_POST["url"]);
  $test->urltest($formurl,"url");
  
  $formaentreprise = $test->secure($_POST["entreprise"]);
  $test->stringtest($formaentreprise,"entreprise");
  
  $formcategorie = $test->secure($_POST["categorie"]);
  $test->stringtest($formcategorie,"categorie");
  


  if ($test->Count==0) {
    //Traitement lorsque tous les tests sont passés avec succès
	
	$titre=$_POST["titre"];
	$url=$_POST["url"];
	$entreprise=$_POST["entreprise"];
	$categorie=$_POST["categorie"];
	
		$cree=$site->ajouter_site($titre,$url,$entreprise,$categorie);
		if($cree=="1"){ 
				
			echo' <meta http-equiv="refresh" content="0;URL=acceuil.php?p=st&add">';
		}
		else { echo $message="<center><strong>Erreur : Ajout non &eacute;tablie!</strong></center>";}
}	}
	
?>

<div class="row-fluid">
					<div class="span12">
					
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Ajouter Un Site
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
                            <h4><i class="icon-reorder"></i>Formulaire d'ajout</h4>
                    </div>              
                        <div class="widget-body">
						        	
                            <!-- BEGIN FORM-->
                             <form method="post" action="" class="form-horizontal">
                                 <div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("titre","fieldreq");?> ">Titre</label>
                                    <div class="controls">
                                        <input type="text" id="titre" name="titre" value="<?php echo $formtitre ;  ?>" class="input-xlarge" />
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("url","fieldreq");?> ">URL</label>
                                    <div class="controls">
                                        <input type="text" id="url" name="url" value="<?php echo $formurl ; ?>" class="input-xlarge" />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("entreprise","fieldreq");?> ">	Entreprise</label>
                                  <div class="controls">
                                        <input type="text" id="entreprise" name="entreprise" value="<?php echo $formaentreprise ;  ?>" class="input-xlarge" />
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("categorie","fieldreq");?> ">Cat&eacute;gorie de produit</label>
                                    <div class="controls">
                                        <input type="text" id="categorie" name="categorie" value="<?php echo $formcategorie ;  ?>" class="input-xlarge" />
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


           