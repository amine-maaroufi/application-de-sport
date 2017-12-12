<?php

class Recette {
	

	/**constructeur**/
	function Recette(){
		
	}
	/**fin constructeur */
	/*** Ajout Recette **/
	function ajouter_recette($titre,$type,$delai,$frequence,$description){
	
		$ajoutRct = "insert into tb_recette values('',
		                                          '".$titre."',
												  '".$type."',
		                                          '".$delai."',
												  '".$frequence."',
		                                          '".$description."'                                         
		                                          )";
		
		(mysql_query($ajoutRct)) ? $retour_ajout=1 : NULL ;	
		return $retour_ajout;
	}
	
	
	
	
	/*** Modification d une recette Selon ID **/

		function modifier_recette($id_recette,$titre,$type,$delai,$frequence,$description){
		
		$update_Rct = "update tb_recette set Titre_recette ='".$titre."',
										  Type_recette ='".$type."',
		                                  Delai_recette ='".$delai."',
										  Frequence ='".$frequence."',
		                                  Description_recette ='".$description."'
		                                  where
		                                  ID_recette ='".$id_recette."'  ";
		
		(mysql_query($update_Rct)) ? $retour_modif=1 : NULL ;	
		return $retour_modif;
	}
	
	/*** Liste des recettes **/
	function afficher_recettes(){
		$aff_rcts= "SELECT * FROM tb_recette";
		$req_aff_rcts=mysql_query($aff_rcts);
		$somme=mysql_num_rows($req_aff_rcts);
		
		$id_recette=array();
		$titre=array();
		$type=array();
		$delai=array();
		$frequence=array();
		$description=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_aff_rcts)){
			$id_recette[$i]=$data->ID_recette;
			$titre[$i]=$data->Titre_recette;
			$type[$i]=$data->Type_recette;
			$delai[$i]=$data->Delai_recette;
			$frequence[$i]=$data->Frequence;
			$description[$i]=$data->Description_recette;
			$i++;
		}
		 
		return $liste_recettes=array($id_recette,$titre,$type,$delai,$frequence,$description,$somme);		
	}
		/***detail d une seule recette selon ID  **/
	
	function afficher_recette($id_recette){
		
		$aff_Rct = "select * from tb_recette where ID_recette='".$id_recette."'"; 
		$req_Rct=mysql_query($aff_Rct);
		$somme=mysql_num_rows($req_Rct);
		
		$id_recette=array();
		$titre=array();
		$type=array();
		$delai=array();
		$frequence=array();
		$description=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_Rct)){
		    $id_recette[$i]=$data->ID_recette;
			$titre[$i]=$data->Titre_recette;
			$type[$i]=$data->Type_recette;
			$delai[$i]=$data->Delai_recette;
			$frequence[$i]=$data->Frequence;
			$description[$i]=$data->Description_recette;
			$i++;
		}
		 
		return $liste_recettes=array($id_recette,$titre,$type,$delai,$frequence,$description);		
	}
	
	
	/*** Suppression d une recette selon ID **/
	function supprimer_recette($idRct){
		$supRct = "delete from tb_recette where ID_recette='".$idRct."' ";
		(mysql_query($supRct)) ? $retour_sup=1 : NULL ;	
		return $retour_sup;		
	}
	
}

?>