function redirect(){
   document.location.href = '/Practica1_DT_FP/IndexController?id=1';
};

function sendpage(){
	console.log("Entro a js");
	var e = document.getElementById("items").value;
	console.log("Var e= "+e);
	document.location.href = '/Practica1_DT_FP/IndexController?id='+e;
	
}