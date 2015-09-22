$(document).ready(
	function(){
		console.log("ready");
		
		var myData = {name:"testName"}
		
		$.ajax({
			url: "http://localhost:8080/new_article",
			method: "POST",
			data: myData,
			dataType: "json",
			success: function(data){
				console.log(data);
			}
		});
	}
);