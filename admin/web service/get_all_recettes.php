<?php
/*
 * ce script va permettre de récupérerr la liste des recettes
 */

$host='localhost';
$uname='root';
$pwd='';
$db="bd_coachz";

$con = mysqli_connect($host,$uname,$pwd,$db) or die("connection failed");

/* Vérification de la connexion */
if (mysqli_connect_errno()) {
    printf("Échec de la connexion : %s\n", mysqli_connect_error());
    // aucun todo
    $reponse["success"] = 0;
    $reponse["message"] = "connexion echouee";
 
    // envoyer json (aucun todo)
    echo json_encode($reponse);

    exit();
}

$reponse=array();

// recupérer la liste

$resultat = mysqli_query($con,"SELECT * FROM tb_recette" ) or die(mysql_error());
$num_rows = mysqli_num_rows($resultat);

if($num_rows>0){
    // boucler sur les lignes du resultat
    $reponse["recette"]=array();
    $recette=array();

    while ($row = mysqli_fetch_array($resultat)) {
        // un enregistrement en cours
		$recette["ID_recette"] = $row["ID_recette"];
        $recette["Titre_recette"] = $row["Titre_recette"];
		$recette["Type_recette"] = $row["Type_recette"];
		$recette["Delai_recette"] = $row["Delai_recette"];
		$recette["Frequence"] = $row["Frequence"];
		$recette["Description_recette"] = $row["Description_recette"];

        // mettre l'recette créé dans le tableau
        array_push($reponse["recette"], $recette);
		
    }
    // success
    $reponse["success"] = 1;
    $reponse["message"] = "success";
	
		$current_charset = 'ISO-8859-15';//or what it is now
array_walk_recursive($reponse,function(&$value) use ($current_charset){
     $value = iconv('UTF-8//TRANSLIT',$current_charset,$value);
	 

});	


    // envoyer JSON response
    echo json_encode($reponse);
} else {
    // aucun
    $reponse["success"] = 0;
    $reponse["message"] = "aucune recette";
	
 
    // envoyer json (aucune recette)
    echo json_encode($reponse);
}
mysqli_close($con);
?>