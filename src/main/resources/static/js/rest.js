var buttonOptionAll = document.getElementById("option-all");
var buttonOptionToday = document.getElementById("option-today");
var buttonOptionThisWeek = document.getElementById("option-this-week");
var xmlhttp = new XMLHttpRequest();

window.onload = function(){
	
}


buttonOptionAll.onclick = function(){
	var postObj = getAll();
	modifyArticle(postObj);
}

buttonOptionToday.onclick = function(){
	
}

buttonOptionThisWeek.onclick = function(){
	
}

function modifyArticle(post){
	var articleObj = document.getElementsByTagName("article")[0];
	articleObj.innerHTML += post;
	
}


function getAll(){
	xmlhttp.open("GET", "http://localhost:8080/api/get_all")
	xmlhttp.send();
}

xmlhttp.onreadystatechange = function(){
	if(this.readyState == 4 && this.status == 200){
		var resultObj = JSON.parse(this.responseText);
		return resultObj;
	}
}