<?php

class Evenement {
	

	/**constructeur**/
	function Evenement(){
		
	}
	/**fin constructeur */
	function ajouter_evenement($Titre_evenement,$Date_evenement,$Heure_evenement,$Description_evenement,$Adresse_evenement,$Organiseur){
	/*** Ajout Evenement **/
		$ajoutEvt = "insert into tb_evenement values('',
													'".$Titre_evenement."',
		                                          '".$Date_evenement."',
												  '".$Heure_evenement."',
												  '".$Description_evenement."',
												  '".$Adresse_evenement."',
		                                          '".$Organiseur."' 
		                                          )";
		
		(mysql_query($ajoutEvt)) ? $retour_ajout=1 : NULL ;	
		return $retour_ajout;
	}
	
	
	
	
	/*** Modification d un evenement Selon ID **/
	function modifier_evenement($id_evenement,$titre,$date,$heure,$description,$adresse,$organiseur){
		
		$update_evt = "update tb_evenement set Titre_evenement ='".$titre."',
		                                  Date_evenement ='".$date."',
										  Heure_evenement ='".$$heure."',
		                                  Description_evenement ='".$description."',
										  Adresse_evenement ='".$adresse."',
										  Organiseur ='".$organiseur."'
		                                  where
		                                  ID_evenement ='".$id_evenement."'  ";
		
		(mysql_query($update_evt)) ? $retour_modif=1 : NULL ;	
		return $retour_modif;
	}
	
	/*** Liste des evenements **/
	function afficher_evenements(){
		$aff_evts= "SELECT * FROM tb_evenement";
		$req_aff_evts=mysql_query($aff_evts);
		$somme=mysql_num_rows($req_aff_evts);
		
		$id_evenement=array();
		$titre=array();
		$date=array();
		$heure=array();
		$description=array();
		$adresse=array();
		$organiseur=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_aff_evts)){
			$id_evenement[$i]=$data->ID_evenement;
			$titre[$i]=$data->Titre_evenement;
			$date[$i]=$data->Date_evenement;
			$heure[$i]=$data->Heure_evenement;
			$description[$i]=$data->Description_evenement;
			$adresse[$i]=$data->Adresse_evenement;
			$organiseur[$i]=$data->Organiseur;
			$i++;
		}
		 
		return $liste_evenements=array($id_evenement,$titre,$date,$heure,$description,$adresse,$organiseur,$somme);		
	}
		/***detail d une seule evenement selon ID  **/
	function afficher_evenement($id_evenement){
		
		$aff_Evt = "select * from tb_evenement where ID_evenement='".$id_evenement."'"; 
		$req_Evt=mysql_query($aff_Evt);
		$somme=mysql_num_rows($req_Evt);
		
		$id_evenement=array();
		$titre=array();
		$date=array();
		$heure=array();
		$description=array();
		$adresse=array();
		$organiseur=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_Evt)){
		$id_evenement[$i]=$data->ID_evenement;
			$titre[$i]=$data->Titre_evenement;
			$date[$i]=$data->Date_evenement;
			$heure[$i]=$data->Heure_evenement;
			$description[$i]=$data->Description_evenement;
			$adresse[$i]=$data->Adresse_evenement;
			$organiseur[$i]=$data->Organiseur;
			$i++;
		}
		 
		return $liste_evenements=array($id_evenement,$titre,$date,$heure,$description,$adresse,$organiseur);		
	}
	
	/*** Suppression d un evenement selon ID **/
	function supprimer_evenement($idEvt){
		$supEvt = "delete from tb_evenement where ID_evenement='".$idEvt."' ";
		(mysql_query($supEvt)) ? $retour_sup=1 : NULL ;	
		return $retour_sup;		
	}
	
}

?>