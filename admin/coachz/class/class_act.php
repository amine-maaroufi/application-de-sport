
<?php

class Actualite {
	

	/**constructeur**/
	function Actualite(){
		
	}
	/**fin constructeur */
	function ajouter_actualite($titre,$date,$description,$reference){
	/*** Ajout actualite **/
		$ajout_Actl = "insert into tb_actualite values('',
		                                          '".$titre."',
		                                          '".$date."',
												  '".$description."',
												  '".$reference."' 
		                                          )";
		
		(mysql_query($ajout_Actl)) ? $retour_ajout=1 : NULL ;	
		return $retour_ajout;
	}
	
	
	
	
	/*** Modification d un actualite Selon ID **/
	
	function modifier_actualite($id_actualite,$titre,$date,$description,$ref){
		
		$update_Actl = "update tb_actualite set Titre_actualite ='".$titre."',
		                                  Date_actualite ='".$date."',
		                                  Description_actualite ='".$description."',
										  Reference_actualite ='".$ref."'
		                                  where
		                                  ID_actualite ='".$id_actualite."'  ";
		
		(mysql_query($update_Actl)) ? $retour_modif=1 : NULL ;	
		return $retour_modif;
	}
	
	/*** Liste des actualites **/
	function afficher_actualites(){
		$aff_Actls= "SELECT * FROM tb_actualite";
		$req_aff_Actls=mysql_query($aff_Actls);
		$somme=mysql_num_rows($req_aff_Actls);
		
		$id_actualite=array();
		$titre=array();
		$date=array();
		$description=array();
		$ref=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_aff_Actls)){
			$id_actualite[$i]=$data->ID_actualite;
			$titre[$i]=$data->Titre_actualite;
			$date[$i]=$data->Date_actualite;
			$description[$i]=$data->Description_actualite;
			$ref[$i]=$data->Reference_actualite;
			$i++;
		}
		 
		return $liste_actualites=array($id_actualite,$titre,$date,$description,$ref,$somme);		
	}
		/***detail d un seul actualite selon ID  **/
	function afficher_actualite($id_actualite){
		
		$aff_Actl = "select * from tb_actualite where ID_actualite='".$id_actualite."'"; 
		$req_Actl=mysql_query($aff_Actl);
		$somme=mysql_num_rows($req_Actl);
		
		$id_actualite=array();
		$titre=array();
		$date=array();
		$description=array();
		$ref=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_Actl)){
		$id_actualite[$i]=$data->ID_actualite;
			$titre[$i]=$data->Titre_actualite;
			$date[$i]=$data->Date_actualite;
			$description[$i]=$data->Description_actualite;
			$ref[$i]=$data->Reference_actualite;
			$i++;
		}
		 
		return $liste_actualites=array($id_actualite,$titre,$date,$description,$ref);		
	}
	
	/*** Suppression d un actualite selon ID **/
	function supprimer_Actualite($id_actualite){
		$supActl = "delete from tb_actualite where ID_Actualite='".$id_actualite."' ";
		(mysql_query($supActl)) ? $retour_sup=1 : NULL ;	
		return $retour_sup;		
	}
	
}

?>