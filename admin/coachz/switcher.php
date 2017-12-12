<?php
Switch ($_GET["p"])
	{
	/********************************Show****************************************/
					
		case "salle": include "contenu/salle.php";
			
					break;
					
					
		case "evt": include "contenu/event.php";
			
					break;	
					
		case "act": include "contenu/actualite.php";
			
					break;	
					
		case "rct": include "contenu/recette.php";
			
					break;	
		
		case "st": include "contenu/site.php";
			
					break;	
					
		case "annuler_act": include "contenu/actualite.php";
			
					break;	
					
		case "annuler_evt": include "contenu/event.php";
			
					break;
					
		case "annuler_rct": include "contenu/recette.php";
			
					break;
					
		case "annuler_st": include "contenu/site.php";
			
					break;
		case "annuler_sl": include "contenu/salle.php";
			
					break;
	
		/********************************Add****************************************/

		case "add_evt": include "contenu/add/add_event.php";
			
					break;		
		
		case "add_act": include "contenu/add/add_actualite.php";
			
					break;	

		case "add_rct": include "contenu/add/add_recette.php";
			
					break;	
					
		case "add_st": include "contenu/add/add_site.php";
			
					break;	
		
		case "add_salle": include "contenu/add/add_salle.php";
			
					break;
		/********************************Edit****************************************/

		case "edit_evt": include "contenu/edit/edit_event.php";
			
					break;		
		
		case "edit_act": include "contenu/edit/edit_actualite.php";
			
					break;	
					
		case "edit_rct": include "contenu/edit/edit_recette.php";
			
					break;	
					
		case "edit_st": include "contenu/edit/edit_site.php";
			
					break;	
		case "edit_sl": include "contenu/edit/edit_salle.php";
			
					break;
		/********************************Default****************************************/			
		default: include "contenu/salle.php";
		
	
	}

?>
