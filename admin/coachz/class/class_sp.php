<?php

class Sportif {
	

	/**constructeur**/
	function Sportif(){
		
	}
	/**fin constructeur */
	function ajouter_sportif($p_nom,$adresse,$email,$tel,$login,$password,$age,$sexe){
	/*** Ajout sportif **/
		$ajout_Sprt = "insert into tb_sportif values('',
		                                          '$P_Nom',
		                                          '$Adresse',
		                                          '$Email',
												  '$Tel',
												  '$Login',
												  '$Password',
												  '$Age',
												  '$Sexe'
		                                          )";
		
		(mysql_query($ajout_Sprt)) ? $retour_ajout=1 : NULL ;	
		return $retour_ajout;
	}
	
	
	
	
	/*** Modification d un sportif Selon ID **/
	function modifier_sportif($idSprt,$p_nom,$adresse,$email,$tel,$login,$password,$age,$sexe){
		
		$update_Sprt = "update tb_sportif set P_Nom ='".$p_nom."',
		                                  Adresse ='".$adresse."',
		                                  Email ='".$email."'
										  Tel ='".$tel."'
										  Login ='".$login."'
										  Password ='".$password."'
										  Age ='".$age."'
										  Sexe ='".$sexe."'
		                                  where
		                                  ID_sportif ='".$idSprt."'  ";
		
		(mysql_query($update_Sprt)) ? $retour_modif=1 : NULL ;	
		return $retour_modif;
	}
	
	/*** Liste des sportifs **/
	function afficher_sportifs(){
		$aff_Sprts= "SELECT * FROM tb_sportif";
		$req_aff_Sprts=mysql_query($aff_Sprts);
		$somme=mysql_num_rows($req_aff_Sprts);
		
		$id_sportif=array();
		$p_nom=array();
		$adresse=array();
		$email=array();
		$tel=array();
		$login=array();
		$password=array();
		$age=array();
		$sexe=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_aff_Sprts)){
			$id_sportif[$i]=$data->ID_sportif;
			$p_nom[$i]=$data->P_Nom;
			$adresse[$i]=$data->Adresse;
			$email[$i]=$data->Email;
			$tel[$i]=$data->Tel;
			$login[$i]=$data->Login;
			$password[$i]=$data->Password;
			$age[$i]=$data->Age;
			$sexe[$i]=$data->Sexe;
			$i++;
		}
		 
		return $liste_sportifs=array($id_sportif,$p_nom,$adresse,$email,$tel,$login,$password,$age,$sexe,$somme);		
	}
		/***detail d un seul sportif selon ID  **/
	function afficher_sportif($idSprt){
		
		$aff_Sprt = "select * from tb_sportif where ID_sportif='".$idSprt."'"; 
		$req_Sprt=mysql_query($aff_Sprt);
		$somme=mysql_num_rows($req_Sprt);
		
		$id_sportif=array();
		$p_nom=array();
		$adresse=array();
		$email=array();
		$tel=array();
		$login=array();
		$password=array();
		$age=array();
		$sexe=array();
		$i=0;
		
		while($data=mysql_fetch_object($req_Sprt)){
		$id_sportif[$i]=$data->ID_sportif;
			$p_nom[$i]=$data->P_Nom;
			$adresse[$i]=$data->Adresse;
			$email[$i]=$data->Email;
			$tel[$i]=$data->Tel;
			$login[$i]=$data->Login;
			$password[$i]=$data->Password;
			$age[$i]=$data->Age;
			$sexe[$i]=$data->Sexe;
			$i++;
		}
		 
		return $liste_sportifs=array($id_sportif,$p_nom,$adresse,$email,$tel,$login,$password,$age,$sexe);		
	}
	
	/*** Suppression d un sportif selon ID **/
	function supprimer_Sprt($idSprt){
		$supSprt = "delete from tb_sportif where ID_Sportif='".$idSprt."' ";
		(mysql_query($supSprt)) ? $retour_sup=1 : NULL ;	
		return $retour_sup;		
	}
	
}

?>