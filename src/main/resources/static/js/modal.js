/**
 * 
 */

var modal = document.getElementById("login-modal");
var closeButton = document.getElementById("close-modal");


//typerror after login since the button wont exist
function displayLoginModal(){
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





