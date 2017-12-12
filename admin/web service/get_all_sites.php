<?php
/*
 * ce script va permettre de r�cup�rerr la liste des sites
 */

$host='localhost';
$uname='root';
$pwd='';
$db="bd_coachz";

$con = mysqli_connect($host,$uname,$pwd,$db) or die("connection failed");

/* V�rification de la connexion */
if (mysqli_connect_errno()) {
    printf("�chec de la connexion : %s\n", mysqli_connect_error());
    // aucun todo
    $reponse["success"] = 0;
    $reponse["message"] = "connexion echouee";
 
    // envoyer json (aucun todo)
    echo json_encode($reponse);

    exit();
}

$reponse=array();

// recup�rer la liste

$resultat = mysqli_query($con,"SELECT * FROM tb_site" ) or die(mysql_error());
$num_rows = mysqli_num_rows($resultat);

if($num_rows>0){
    // boucler sur les lignes du resultat
    $reponse["site"]=array();
    $site=array();

    while ($row = mysqli_fetch_array($resultat)) {
        // un enregistrement en cours
		$site["ID_site"] = $row["ID_site"];
        $site["Titre_site"] = $row["Titre_site"];
		$site["URL"] = $row["URL"];
		$site["Categr_produit"] = $row["Categr_produit"];
        // mettre l'site cr�� dans le tableau
        array_push($reponse["site"], $site);
		
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
    $reponse["message"] = "aucune site";
 
    // envoyer json (aucune site)
    echo json_encode($reponse);
}
mysqli_close($con);
?>