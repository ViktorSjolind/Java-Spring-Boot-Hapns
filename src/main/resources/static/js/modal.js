/**
 * 
 */

var modal = document.getElementById("login-modal");
var loginButton = document.getElementById("open-login");
var closeButton = document.getElementById("close-modal");

loginButton.onclick = function(){
	modal.style.display = "block";
}

closeButton.onclick = function(){
	hideModal();
}

window.onclick = function(event){
	if(event.target == modal){
		hideModal();
	}
}


function hideModal(){
	modal.style.display = "none";
}





