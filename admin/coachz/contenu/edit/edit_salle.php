	
	<?php 
if ($_POST["f"]==1) { 

   $formtitre = $test->secure($_POST["titre"]);
  $test->stringtest($formtitre,"titre");
  
  
  $formadr = $test->secure($_POST["adr"]);
  $test->stringtest($formadr,"adr");
  
  $formtel = $test->secure($_POST["tel"]);
  $test->inttest($formtel,"tel");
  
  $formlat = $test->secure($_POST["lat"]);
  $test->stringtest($formlat,"lat");
  
  $formlong = $test->secure($_POST["long"]);
	$test->stringtest($formlat,"long");

 if ($test->Count==0) {
    //Traitement lorsque tous les tests sont passés avec succès
	
	$titre=$_POST["titre"];
	$adresse=$_POST["adr"];
	$tel=$_POST["tel"];
	$latitude=$_POST["lat"];
	$longitude=$_POST["long"];
	$id_salle=$_GET['id'];
	
		$edit=$salle->modifier_salle($idSll,$titre,$adresse,$tel,$latitude,$longitude);
		if($edit=="1"){ 
				
			echo' <meta http-equiv="refresh" content="0;URL=acceuil.php?p=salle&modif">';
		}
		else { echo $message="<center><strong>Erreur : Ajout non &eacute;tablie!</strong></center>";}
}	}
$liste=$salle->afficher_salle($_GET['id']);	
?>

				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
                        <!-- BEGIN THEME CUSTOMIZER-->
                        <div id="theme-change" class="hidden-phone">
                            <i class="icon-cogs"></i>
                            <span class="settings">
                                <span class="text">Theme:</span>
                                <span class="colors">
                                    <span class="color-default" data-style="default"></span>
                                    <span class="color-gray" data-style="gray"></span>
                                    <span class="color-purple" data-style="purple"></span>
                                    <span class="color-navy-blue" data-style="navy-blue"></span>
                                </span>
                            </span>
                        </div>
                        <!-- END THEME CUSTOMIZER-->
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->	    			
						<h3 class="page-title">
							Google Maps
							<small>interactive google map samples</small>
						</h3>
                     
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
			
				<div class="row-fluid">
                <div class="span12 ">
				 
                    <!-- BEGIN SAMPLE FORMPORTLET-->
                    <div class="widget">
                        <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Modifier la positionnement de votre salle de sport </h4>
                        </div>
	
                      <head>
					  
			  
					  
    <style>
        #mapa{
            width: 400px;
            height: 400px;
            float:left;
            background: green;
        }
        #infor{
            width: 400px;
            height: 400px;
            float:left;
        }
    </style>
<!--IMPORTANTE RESPETAR EL ORDEN -->
<!--ESTILOS DE BOOSTRAP -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js" ></script>
<!--ARCHIVOS JAVASCRIPT DE BOOTSTRAP -->
<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<script>
    //VARIABLES GENERALES
		//declaras fuera del ready de jquery
    var nuevos_marcadores = [];
    
    //FUNCION PARA QUITAR MARCADORES DE MAPA
    function limpiar_marcadores(lista)
    {
        for(i in lista)
        {
            //QUITAR MARCADOR DEL MAPA
            lista[i].setMap(null);
        }
    }
    $(document).on("ready", function(){
        
        //VARIABLE DE FORMULARIO
        var form = $("#form");
        
        var punto = new google.maps.LatLng(36.5072263,8.775655599999936);
        var config = {
            zoom:16,
            center:punto,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var mapa = new google.maps.Map( $("#mapa")[0], config );

        google.maps.event.addListener(mapa, "click", function(event){
           var coordenadas = event.latLng.toString();
           
           coordenadas = coordenadas.replace("(", "");
           coordenadas = coordenadas.replace(")", "");
           
           var lista = coordenadas.split(",");
           
           var direccion = new google.maps.LatLng(lista[0], lista[1]);
           //PASAR LA INFORMACIÓN AL FORMULARIO
           form.find("input[name='titre']").focus();
           form.find("input[name='lat']").val(lista[0]);
           form.find("input[name='long']").val(lista[1]);
           
           
           var marcador = new google.maps.Marker({
               //titulo:prompt("Titulo del marcador?"),
               position:direccion,
               map: mapa, 
               animation:google.maps.Animation.DROP,
               draggable:false
           });
           //ALMACENAR UN MARCADOR EN EL ARRAY nuevos_marcadores
           nuevos_marcadores.push(marcador);
           
           google.maps.event.addListener(marcador, "click", function(){

           });
           
           //BORRAR MARCADORES NUEVOS
           limpiar_marcadores(nuevos_marcadores);
           marcador.setMap(mapa);
        });
        $("#btn_grabar").on("click", function(){
            //INSTANCIAR EL FORMULARIO
            var f = $("#form");
           $.ajax({
               type:"POST",
               url:"iajax.php",
               dataType:"JSON",
               data:f.serialize()+"&tipo=grabar",
               success:function(data){
                   alert(data.mensaje);
               },
               beforeSend:function(){
                   
               },
               complete:function(){
                   
               }
           });
           return false;
        });
        
    });
</script>




</head>
<body>

    <div id="mapa">
        <h2>Geocalisation des salle de sport</h2>
    </div>
    <div id="infor">
        <div class="accordion" id="accordion2">
            
             
                <div class="accordion-inner">
                   <form id="form" method="post" action="" class="form-horizontal">
                        
                            
				
                                  <div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("titre","fieldreq");?> ">Titre</label>
                                    <div class="controls">
                                        <input type="text" id="titre" name="titre" value="<?php  echo $liste[1][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("adr","fieldreq");?> ">Adresse</label>
                                    <div class="controls">
                                        <input id="adr" name="adr"  type="text"  value="<?php  echo $liste[2][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("tel","fieldreq");?> ">Tel</label>
                                    <div class="controls">
                                        <input id="tel" name="tel"  type="text"  value="<?php  echo $liste[3][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("lat","fieldreq");?> ">Latitude</label>
                                    <div class="controls">
                                        <input id="lat" name="lat"  type="text" readonly value="<?php  echo $liste[4][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								<div class="control-group">
                                    <label class="control-label <?php echo $test-> fieldError("long","fieldreq");?> ">Longitude</label>
                                    <div class="controls">
                                        <input id="long" name="long"  type="text"  readonly value="<?php  echo $liste[5][0] ; ?>" class="input-xlarge"  />
                                    </div>
                                </div>
								
								 <div >
								 <table>
                                   <td> <button type="submit" class="btn blue"><i class="icon-ok"></i> Enregitrer</button></td>
									<td><a href="?p=annuler_sl">
                                    <button type="button" class="btn"><i class=" icon-remove"></i> Annuler</button>
									</a></td>
								</table>
                                </div>
								
								<input type="hidden" name="f" value="1">
                            </form>
                         
                       
                   
                </div>
              </div>
            </div>
        

    </div>
</body>
</html>
						
						
					</div>
                

                        </div>

				<!-- END PAGE CONTENT-->	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.blockui.js"></script>
			<script type="text/javascript" src="assets/uniform/jquery.uniform.min.js"></script>
	<script src="assets/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>	
	<script src="assets/fancybox/source/jquery.fancybox.pack.js"></script>	
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&language=fr">
</script>
	<script src="js/scripts.js"></script>
		<script src="js/gmaps.js"></script>
	<script src="js/demo.gmaps.js"></script>
	