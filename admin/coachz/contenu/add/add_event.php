  	 <?php 
if ($_POST["f"]==1) { 

  $formtitre = $test->secure($_POST["titre"]);
  $test->stringtest($formtitre,"titre");
  
  $formdescription = $test->secure($_POST["description"]);
  $test->stringtest($formdescription,"description");
  
  $formadresse = $test->secure($_POST["adresse"]);
  $test->stringtest($formadresse,"adresse");
  
  $formorganiseur = $test->secure($_POST["organiseur"]);
  $test->stringtest($formorganiseur,"organiseur");
  

  
 
  if ($test->Count==0) {
    //Traitement lorsque tous les tests sont passés avec succès
	$date=$_POST["ann"]."-".$_POST["mois"]."-".$_POST["jour"];
	$heure=$_POST["heure"].":".$_POST["minute"].":00";
	$titre=$_POST["titre"];
	$description=$_POST["description"];
	$adresse=$_POST["adresse"];
	$organiseur=$_POST["organiseur"];
	


		$cree=$evenement->ajouter_evenement($titre,$date,$heure,$description,$adresse,$organiseur);
		if($cree=="1"){ 
			
			echo' <meta http-equiv="refresh" content="0;URL=acceuil.php?p=evt&add">';
		}
		else { echo $message="<center><strong>Erreur : Ajout non &eacute;tablie!</strong></center>";}
}	}
	
?>
	<div class="row-fluid">
					<div class="span12">
					
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Ajouter Un Ev&eacute;nement
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
                                        <input type="text" id="titre" name="titre" value="<?php echo $formtitre ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label ">Date</label>
                                    <div class="controls">
									
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
                                </div>
								
								<div class="control-group">
                                    <label class="control-label ">Heure</label>
									
                         <select name="heure" id="heure"> <?php 
						for ($x=0;$x<24;$x++){?>
                      <option value="<?php echo $x;?>"><?php echo $x;?></option>
                      <?php }?>
                    </select>
					
					<select name="minute" id="miute"> <?php 
						for ($j=0;$j<60;$j++){?>
                      <option value="<?php echo $j;?>"><?php echo $j;?></option>
                      <?php }?>
                    </select>
                                </div>
                               
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("description","fieldreq");?>" >Description</label>
                                    <div class="controls">
                           <textarea id="description" name="description" class="span12 wysihtml5" rows="6"></textarea>
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("adresse","fieldreq");?>" >Adresse</label>
                                    <div class="controls">
                                        <input type="text" id="adresse" name="adresse"   value="<?php echo $formadresse ;  ?>" class="input-xlarge" />
                                    </div>
                                </div>
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("organiseur","fieldreq");?>" >Organiseur</label>
                                    <div class="controls">
                                        <input type="text" id="organiseur" name="organiseur"   value="<?php echo $formorganiseur ;  ?>" class="input-xlarge" />
                                    </div>
                                </div>
								 <div class="form-actions">
                                    <button type="submit" class="btn blue"><i class="icon-ok"></i> Enregitrer</button>
									<a href="?p=annuler_evt">
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


           