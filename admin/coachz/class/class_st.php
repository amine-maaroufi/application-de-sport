<?php

class Site {
	

	/**constructeur**/
	function Site(){
		
	}
	/**fin constructeur */
	/*** Ajout Site **/
	function ajouter_site($titre,$url,$entreprise,$categr){
		$ajoutSt = "insert into tb_site values('',
		                                          '".$titre."',
		                                          '".$url."',
												  '".$entreprise."',
												  '".$categr."' 
		                                          )";
		
		(mysql_query($ajoutSt)) ? $retour_ajout=1 : NULL ;	
		return $retour_ajout;
	}
	
	
	
	
	/*** Modification d un site Selon ID **/
	function modifier_site($id_site,$titre,$url,$entreprise,$categorie){
		
		$update_St = "update tb_site set Titre_site ='".$titre."',
		                                  URL ='".$url."',
										  Entreprise ='".$entreprise."',
										  Categr_produit ='".$categorie."'
		                                  where
		                                  ID_site ='".$id_site."'  ";
		
		(mysql_query($update_St)) ? $retour_modif=1 : NULL ;	
		return $retour_modif;
	}
	
	/*** Liste des sites **/
	function afficher_sites(){
		$aff_Sts= "SELECT * FROM tb_site";
		$req_aff_Sts=mysql_query($aff_Sts);
		$somme=mysql_num_rows($req_aff_Sts);
		
		$id_site=array();
		$titre=array();
		$url=array(); 
		$entreprise=array();
		$categorie=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_aff_Sts)){
			$id_site[$i]=$data->ID_site;
			$titre[$i]=$data->Titre_site;
			$url[$i]=$data->URL;
			$entreprise[$i]=$data->Entreprise;
			$categorie[$i]=$data->Categr_produit;
			$i++;
		}
		 
		return $liste_sites=array($id_site,$titre,$url,$entreprise,$categorie,$somme);		
	}
		/***detail d un seul site selon ID  **/
	function afficher_site($idSt){
		
		$aff_St = "select * from tb_site where ID_site='".$idSt."'"; 
		$req_St=mysql_query($aff_St);
		$somme=mysql_num_rows($req_St);
		
		$id_site=array();
		$titre=array();
		$url=array();
		$entreprise=array();
		$categr=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_St)){
		$id_site[$i]=$data->ID_site;
			$titre[$i]=$data->Titre_site;
			$url[$i]=$data->URL;
			$entreprise[$i]=$data->Entreprise;
			$categr[$i]=$data->Categr_produit;
			$i++;
		}
		 
		return $liste_sites=array($id_site,$titre,$url,$entreprise,$categr);		
	}
	
	/*** Suppression d un site selon ID **/
	function supprimer_site($idSt){
		$supSt = "delete from tb_site where ID_site='".$idSt."' ";
		(mysql_query($supSt)) ? $retour_sup=1 : NULL ;	
		return $retour_sup;		
	}
	
}

?>