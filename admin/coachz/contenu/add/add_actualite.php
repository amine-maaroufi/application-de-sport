  	 <?php 
if ($_POST["f"]==1) { 

  $formtitre = $test->secure($_POST["titre"]);
  $test->stringtest($formtitre,"titre");
  
  
  $formdescription = $test->secure($_POST["description"]);
  $test->stringtest($formdescription,"description");
  
  $formreference = $test->secure($_POST["reference"]);
  $test->urltest($formreference,"reference");


  if ($test->Count==0) {
    //Traitement lorsque tous les tests sont passés avec succès
	
	$titre=$_POST["titre"];
	$date=$_POST["ann"]."-".$_POST["mois"]."-".$_POST["jour"];
	$description=$_POST["description"];
	$reference=$_POST["reference"];
	
		$cree=$actualite->ajouter_actualite($titre,$date,$description,$reference);
		if($cree=="1"){ 
			
			echo' <meta http-equiv="refresh" content="0;URL=acceuil.php?p=act&add">';
		}
		else { echo $message="<center><strong>Erreur : Ajout non &eacute;tablie!</strong></center>";}
}	}
	
?>
	<div class="row-fluid">
					<div class="span12">
					
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Ajouter Un Actualit&eacute;
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
                                        <input id="titre" name="titre"  type="text" value="<?php echo $formtitre ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label ">Date</label>
                                    <select name="ann" id="ann"> <?php 
						for ($k=2016;$k<2050;$k++){?>
                      <option value="<?php echo $k;?>"><?php echo $k;?></option>
                      <?php }?>
                    </select>
					
					<select name="mois" id="mois"> <?php 
						for ($j=1;$j<13;$j++){?>
                      <option value="<?php echo $j;?>"><?php echo $j;?></option>
                      <?php }?>
                    </select>
					
						<select name="jour" id="jour"> <?php 
						for ($i=1;$i<32;$i++){?>
                      <option value="<?php echo $i;?>"><?php echo $i;?></option>
                      <?php }?>
                    </select>
                                </div>
								
                                <div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("description","fieldreq");?> ">Description</label>
                                  <div class="controls">
								   <textarea id="description" name="description" class="span12 wysihtml5" rows="6"><?php echo $formdescription ; ?></textarea>
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("reference","fieldreq");?> ">R&eacute;f&eacute;rence</label>
                                    <div class="controls">
                                        <input id="reference" name="reference" value="<?php echo $formreference ; ?>"  type="text" class="input-xlarge" />
                                    </div>
                                </div>
								 <div class="form-actions">
                                    <button type="submit" class="btn blue"><i class="icon-ok"></i> Enregitrer</button>
									<a href="?p=annuler_act">
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
           

           