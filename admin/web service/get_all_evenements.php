<?php
/*
 * ce script va permettre de récupérerr la liste des événements
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

$resultat = mysqli_query($con,"SELECT * FROM tb_evenement" ) or die(mysql_error());
$num_rows = mysqli_num_rows($resultat);

if($num_rows>0){
    // boucler sur les lignes du resultat
    $reponse["evenement"]=array();
    $evenement=array();

    while ($row = mysqli_fetch_array($resultat)) {
        // un enregistrement en cours
		$evenement["ID_evenement"] = $row["ID_evenement"];
        $evenement["Titre_evenement"] = $row["Titre_evenement"];
		$evenement["Date_evenement"] = $row["Date_evenement"];
		$evenement["Heure_evenement"] = $row["Heure_evenement"];
		$evenement["Description_evenement"] = $row["Description_evenement"];
		$evenement["Adresse_evenement"] = $row["Adresse_evenement"];
		$evenement["Organiseur"] = $row["Organiseur"];

        // mettre l'evenement créé dans le tableau
        array_push($reponse["evenement"], $evenement);
		
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
    $reponse["message"] = "aucune evenement";
 
    // envoyer json (aucune evenement)
    echo json_encode($reponse);
}
mysqli_close($con);
?>