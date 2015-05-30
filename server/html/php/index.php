<?php
	include 'functions.php';
	$municipio = $_POST['Municipio'];	
	$distancia = $_POST['Distancia'];	
	$dificultad = $_POST['Dificultad'];	
	$valoracion = $_POST['Valoracion'];	

	
	
	$result = buscar($municipio, $distancia, $dificultad, $valoracion );
	$dev["consulta"] = $result;

	/* output in necessary format */
    	header('Content-type: application/json');	
	echo json_encode($dev);
  

?>
