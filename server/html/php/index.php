<?php
	include 'functions.php';
	
	$tag = $_POST['tag'];

	switch($tag){
		case: "consultaRuta"
			
			$municipio = $_POST['Municipio'];	
			$distancia = $_POST['Distancia'];	
			$dificultad = $_POST['Dificultad'];	
			$valoracion = $_POST['Valoracion'];	

	
	
			$result = buscar($municipio, $distancia, $dificultad, $valoracion );
			$dev["consulta"] = $result;

			/* output in necessary format */
		   header('Content-type: application/json');	
			echo json_encode($dev);
			break;
	case: "reportarIndicencia"
			$idsendero = $_POST['IdSendero'];				
			$titulo = $_POST['Titulo'];	
			$descripcion = $_POST['Descripcion'];	
			$foto = $_POST['Foto'];	
	
			reportarIncidencia($idsendero, $titulo, $descripcion, $imagen);
			break;

	case: "mostrarIncidencia"
			
			$idsendero = $_POST['IdSendero'];		
	
			$result = listarIncidencias($idsendero);
			$dev["consulta"] = $result;

			/* output in necessary format */
		   header('Content-type: application/json');	
			echo json_encode($dev);
			break;
	case: "valoracion"
			
			$idsendero = $_POST['IdSendero'];	
			$puntuacion = $_POST['Puntuacion'];	
	
			puntuar($idsendero, $puntuacion);
			break;
	default:
  			$dev["consulta"] = "Te has equivocado marica";
}
?>
