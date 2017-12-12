<?php
class testTools {
  var $errTab; //Tableau contenant les erreurs détectées
  var $Count; //Variable contenant le nombre d'erreurs détectées
  var $fstyle; //Nom du style CSS par défaut quand il y a une erreur.

  //Constructeur de la classe ici on passe en paramêtre le nom du style d'erreur par defaut.
  function testTools($fstyle)
  {
    $this->Count=0;
    $this->fstyle=$fstyle;
  }

  //Fonction qui permet de securiser un champ texte de manière à pouvoir être stocké dans une base de données.
  //Si vous voulez autoriser les tag HTML alors il faut mettre la ligne du strip_tags en commentaire.
  function secure($var)
  {
    $vars=$var;
    if (!is_numeric($var))
    {
      $vars=htmlentities($vars,ENT_QUOTES);  //utile pour éviter une grande partie des SQL injections
      $vars=strip_tags($vars);
    }
    return $vars;
  }

  //Fonction principale de la classe qui ajoute un nom de style CSS à un nom de champ de formulaire.
  function add($title,$style)
  {
    $this->errTab[0][$this->Count]=$title;
    $this->errTab[1][$this->Count++]=$style;
  }

  //Fonction qui permet d'effectuer un test sur un champ de type EMAIL.
  function mailtest($var,$name)
  {
    if (!eregi("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@([0-9a-z](-?[0-9a-z])*\\.)+[a-z]{2}([zmuvtg]|fo|me)?$",$var))
      $this->add($name,$this->fstyle);
  }

  //Fonction qui permet d'effectuer un test sur un champ de type INT.
  function inttest($var,$name)
  {
    if (($var==0)||(!is_numeric($var)))
      $this->add($name,$this->fstyle);
  }

  //Fonction qui permet d'effectuer un test sur un champ de type TIME.
  function timetest($varh,$varm,$vars,$name)
  {
    if ((($varh>24)||($varm>59)||($vars>59))||(($varh<0)||($varm<0)||($vars<0)))
      $this->add($name,$this->fstyle);
  }

  //Fonction qui permet d'effectuer un test sur un champ de type URL.
  function urltest($var,$name)
  {
    if ((substr($var,0,7)!="http://"))
      $this->add($name,$this->fstyle);    
  }

  //Fonction qui permet d'effectuer un test sur un champ de type STRING.
  function stringtest($var,$name)
  {
    if (strlen(trim($var))==0)
      $this->add($name,$this->fstyle);    
  }
    
  //Fonction qui permet d'effectuer un test sur un champ de type DATE.
  function datetest($var1,$var2,$var3,$name)
  {
    if (!checkdate($var2,$var1,$var3))
      $this->add($name,$this->fstyle);    
  }

  //Fonction qui recherche un style CSS associé à un champ donné.
  function fieldError($name,$default)
  {
    if (is_array($this->errTab[0]))
      foreach($this->errTab[0] as $key => $value)
      {
        if ($value==$name)
          return $this->errTab[1][$key];
      }
    return $default;
  }

}
?> 