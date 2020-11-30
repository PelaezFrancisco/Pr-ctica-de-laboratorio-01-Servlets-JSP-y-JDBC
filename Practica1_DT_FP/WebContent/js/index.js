function redirect(){
   document.location.href = '/Practica1_DT_FP/IndexController?id=1';
};

function sendpage(){
	var e = document.getElementById("items");
	document.location.href = '/IndexController?id='+e;
	console.log("Entro a js");
}