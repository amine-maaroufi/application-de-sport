<?php

class Salle {
	

	/**constructeur**/
	function Salle(){
		
	}
	/**fin constructeur */
	/*** Ajout salle **/
	function ajouter_salle($titre,$adresse,$tel,$latitude,$longitude){
		$ajoutSll = "insert into tb_salle values('',
		                                          '$titre',
		                                          '$adresse',
		                                          '$tel',
		                                          '$latitude',
												  '$longitude' 
		                                          )";
		
		(mysql_query($ajoutSll)) ? $retour_ajout=1 : NULL ;	
		return $retour_ajout;
	}
	
	
	
	
	/*** Modification d une salle Selon ID **/
	function modifier_salle($idSll,$titre,$adresse,$tel,$latitude,$longitude){
		
		$update_Sll = "update tb_salle set Titre ='".$titre."',
		                                  Adresse ='".$adresse."',
										  Tel ='".$tel."',
		                                  Latitude ='".$latitude."',
		                                  Longitude ='".$longitude."'
		                                 
		                                  where
		                                  ID_salle ='".$idSll."'  ";
		
		(mysql_query($update_Sll)) ? $retour_modif=1 : NULL ;	
		return $retour_modif;
	}
	
	/*** Liste des salles **/
	function afficher_salles(){
		$aff_Slls= "SELECT * FROM tb_salle";
		$req_aff_Slls=mysql_query($aff_Slls);
		$somme=mysql_num_rows($req_aff_Slls);
		
		$id_salle=array();
		$titre=array();
		$adresse=array();
		$tel=array();
		$latitude=array();
		$longitude=array(); 
		$i=0;
		
		while($data=mysql_fetch_object($req_aff_Slls)){
			$id_salle[$i]=$data->ID_salle;
			$titre[$i]=$data->Titre;
			$adresse[$i]=$data->Adresse;
			$tel[$i]=$data->Tel;
			$latitude[$i]=$data->Latitude;
			$longitude[$i]=$data->Longitude;
			$i++;
		}
		 
		return $liste_salles=array($id_salle,$titre,$adresse,$tel,$latitude,$longitude,$somme);		
	}
		/***detail d une seule salle selon ID  **/
	function afficher_salle($idSll){
		
		$aff_Sll = "select * from tb_salle where ID_salle='".$idSll."'"; 
		$req_Sll=mysql_query($aff_Sll);
		$somme=mysql_num_rows($req_Sll);
		
		$id_salle=array();
		$titre=array();
		$adresse=array();
		$tel=array();
		$latitude=array();
		$longitude=array(); 
		$i=0;
		
		while($data=mysql_fetch_object($req_Sll)){
			$id_salle[$i]=$data->ID_salle;
			$titre[$i]=$data->Titre;
			$adresse[$i]=$data->Adresse;
			$tel[$i]=$data->Tel;
			$latitude[$i]=$data->Latitude;
			$longitude[$i]=$data->Longitude;
			$i++;
		}
		 
		return $liste_salles=array($idSll,$titre,$adresse,$tel,$latitude,$longitude);		
	}
	
	/*** Suppression d une salle selon ID **/
	function supprimer_salle($idSll){
		$supSll = "delete from tb_salle where ID_salle='".$idSll."' ";
		(mysql_query($supSll)) ? $retour_sup=1 : NULL ;	
		return $retour_sup;		
	}
	
}

?>